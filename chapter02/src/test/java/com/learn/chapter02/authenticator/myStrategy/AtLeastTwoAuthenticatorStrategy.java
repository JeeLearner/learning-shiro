package com.learn.chapter02.authenticator.myStrategy;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.AbstractAuthenticationStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;

import java.util.Collection;

/**
 * 自定义AuthenticatorStrategy
 *      至少有两个Realm验证成功,返回所有Realm身份验证成功的认证信息
 */
public class AtLeastTwoAuthenticatorStrategy extends AbstractAuthenticationStrategy{

    @Override
    public AuthenticationInfo beforeAllAttempts(Collection<? extends Realm> realms, AuthenticationToken token) throws AuthenticationException {
        return new SimpleAuthenticationInfo();//返回一个权限的认证信息
    }

    @Override
    public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo aggregate) throws AuthenticationException {
        return aggregate;//返回之前合并的
    }

    @Override
    public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo singleRealmInfo, AuthenticationInfo aggregateInfo, Throwable t) throws AuthenticationException {
        AuthenticationInfo info;
        if (singleRealmInfo == null) {
            info = aggregateInfo;
        } else {
            if (aggregateInfo == null) {
                info = singleRealmInfo;
            } else {
                info = this.merge(singleRealmInfo, aggregateInfo);
            }
        }
        return info;
    }

   @Override
    public AuthenticationInfo afterAllAttempts(AuthenticationToken token, AuthenticationInfo aggregate) throws AuthenticationException {
        //自定义代码
       if (aggregate == null || CollectionUtils.isEmpty(aggregate.getPrincipals()) || aggregate.getPrincipals().getRealmNames().size() < 2) {
           throw new AuthenticationException("Authentication token of type [" + token.getClass() + "] " +
                   "could not be authenticated by any configured realms.  Please ensure that at least two realm can " +
                   "authenticate these tokens.");
       }
        return aggregate;
    }

}
