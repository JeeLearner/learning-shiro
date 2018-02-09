package com.learn.chapter16;

import com.learn.chapter16.resource.dao.ResourceDao;
import com.learn.chapter16.resource.entity.Resource;
import com.learn.chapter16.resource.service.ResourceService;
import com.learn.chapter16.resource.web.controller.ResourceController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml", "classpath:spring-mvc.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class ResourceTest {
    
    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private ResourceService resourceService;
    
    @Test
    public void test(){
        List<Resource> resources = resourceDao.findAll();
        Assert.assertEquals(21, resources.size());

        Set<String> permissions = new HashSet<String>();
        permissions.add("organization:create");
        permissions.add("organization:*");
        List<Resource> menus = resourceService.findMenus(permissions);
        System.out.println(menus.size()); //1
    }

    @Autowired
    private ResourceController resourceController;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/resource")).andExpect(status().isOk()).andDo(print());
    }
}
