package com.learn.chapter05;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Test;

public class PasswordTest extends BaseTest {

    @Test
    public void testPasswordServiceWithMyRealm() {
        login("classpath:shiro-passwordservice.ini", "JeeLearner", "123");
    }

    @Test
    public void testPasswordServiceWithJdbcRealm() {
        login("classpath:shiro-jdbc-passwordservice.ini", "JeeLearner", "123");
    }

    @Test
    public void testGeneratePassword() {
        String algorithmName = "md5";
        String username = "JeeLearner";
        String password = "123";
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();//635bf861d82d4dd76a562f18482cd14e
        int hashIterations = 2;

        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations); //c0fc0daf2ac9958633a009d6b48e9be2
        String encodedPassword = hash.toHex();
        System.out.println(salt2);
        System.out.println(encodedPassword);
    }

    @Test
    public void testHashedCredentialsMatcherWithMyRealm2() {
        //使用testGeneratePassword生成的散列密码
        login("classpath:shiro-hashedCredentialsMatcher.ini", "JeeLearner", "123");
    }

    @Test
    public void testHashedCredentialsMatcherWithJdbcRealm() {
        BeanUtilsBean.getInstance().getConvertUtils().register(new com.learn.chapter05.EnumConverter(), JdbcRealm.SaltStyle.class);
        //使用testGeneratePassword生成的散列密码
        login("classpath:shiro-jdbc-hashedCredentialsMatcher.ini", "JeeLearner", "123");
    }

   @Test(expected = ExcessiveAttemptsException.class)
    public void testRetryLimitHashedCredentialsMatcherWithMyRealm() {
        for(int i = 1; i <= 5; i++) {
            try {
                login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "JeeLearner", "234");
            } catch (Exception e) {
                //ignore
            }
        }
        login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "JeeLearner", "234");
    }



}
