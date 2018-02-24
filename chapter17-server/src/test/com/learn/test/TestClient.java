package com.learn.test;

import com.learn.chapter17.client.dao.ClientDao;
import com.learn.chapter17.client.entity.Client;
import com.learn.chapter17.user.dao.UserDao;
import com.learn.chapter17.user.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml", "classpath:spring-mvc.xml"})
@Transactional
public class TestClient {

    @Autowired
    private ClientDao clientDao;

    @Test
    public void testFindAll() {
        List<Client> list = clientDao.findAll();
        Assert.assertEquals(1, list.size());
    }
}
