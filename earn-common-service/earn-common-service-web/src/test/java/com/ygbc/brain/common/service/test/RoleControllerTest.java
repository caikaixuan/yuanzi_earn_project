package com.ygbc.brain.common.service.test;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")


//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

@WebAppConfiguration


public class RoleControllerTest {

    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * 初始化SpringmvcController类测试环境
     */
    @Before
    public void setup() {
        //加载web容器上下文
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /*
     * 测试角色新增接口
     * */
    @Test
    public void testRoleAdd() throws Exception {

        System.out.println("============================================================================================");
        System.out.println("=================================角色新增接口 common/role/create==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("roleName", "test1");
            data.put("isAdmin", "0");
            data.put("roleDesc", "test1");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/role/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            System.out.println("response result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 测试角色修改接口
     * */
    @Test
    public void testRoleUpdate() {
        System.out.println("============================================================================================");
        System.out.println("=================================角色修改接口 common/role/update==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("roleName", "test1");
            data.put("isAdmin", "0");
            data.put("roleDesc", "test1");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/role/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            System.out.println("response result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 测试角色删除接口
     * */
    @Test
    public void testRoleDelete() {
        System.out.println("============================================================================================");
        System.out.println("=================================角色删除接口 common/role/delete==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("roleName", "a");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/role/delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            System.out.println("response result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 测试角色查询接口
     * */
    @Test
    public void testRoleList() {
        System.out.println("============================================================================================");
        System.out.println("=================================角色查询接口 common/role/list==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/role/list")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            System.out.println("response result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 测试角色详情接口
     * */
    @Test
    public void testRoleDetail() {
        System.out.println("============================================================================================");
        System.out.println("=================================角色详情接口 common/role/detail==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("roleName", "admin");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/role/detail")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            System.out.println("response result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

