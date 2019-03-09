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


public class UserControllerTest {

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
     * 测试用户新增接口
     * */
    @Test
    public void testUserAdd() throws Exception {
        System.out.println("============================================================================================");
        System.out.println("=================================用户新增接口 common/user/add==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("loginName", "test1");
            data.put("userName", "test1");
            data.put("password", "test1");
            data.put("identityCode", "48274389274289");
            data.put("mobile", "15034323456");
            data.put("telephone", "123456");
            data.put("mail", "test1@email.com");
            data.put("jobNo", "23");
            data.put("status", "0");
            data.put("type", "2");
            data.put("gender", "F");
            data.put("age", "12");
            data.put("leftOrRight", "L");
            data.put("eyesightBefore", "12");
            data.put("cylBefore", "12");
            data.put("hyperopiaDegreeBefore", "12");
//            data.put("eyesightAfter","");
//            data.put("cylAfter","");
//            data.put("hyperopiaDegreeAfter","");
//            data.put("optimalPathRankingVector","");
//            data.put("optimalChannel","");
//            data.put("optimalChannelNumber","");
//            data.put("classA","");
//            data.put("classB","");
//            data.put("classAPeek","");
//            data.put("classAPeekMinTime","");
//            data.put("classAPeekMaxTime","");
//            data.put("f5","");
//            data.put("f3","");
//            data.put("f1","");
//            data.put("fz","");
//            data.put("f2","");
//            data.put("f4","");
//            data.put("f6","");
//            data.put("fc3","");
//            data.put("fc1","");
//            data.put("fcz","");
//            data.put("fc2","");
//            data.put("fc4","");
//            data.put("c5","");
//            data.put("c3","");
//            data.put("c1","");
//            data.put("cz","");
//            data.put("c2","");
//            data.put("c4","");
//            data.put("c6","");
//            data.put("cp1","");
//            data.put("cpz","");
//            data.put("cp2","");
//            data.put("p5","");
//            data.put("p3","");
//            data.put("p1","");
//            data.put("pz","");
//            data.put("p2","");
//            data.put("p4","");
//            data.put("p6","");
//            data.put("oz","");
//            data.put("m1","");
//            data.put("m2","");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/user/create")
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
     * 测试用户修改接口
     * */
    @Test
    public void testUserUpdate() {
        System.out.println("============================================================================================");
        System.out.println("=================================用户修改接口 common/user/update==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("loginName", "admin");
            data.put("userName", "admin001");
            data.put("password", "b71f5ad57625d6990ef8497ee9b28fc65554321a3fc7a564");
            data.put("identityCode", "48274389274289");
            data.put("mobile", "15034323456");
            data.put("telephone", "123456");
            data.put("mail", "test1@email.com");
            data.put("jobNo", "23");
            data.put("status", "0");
//            data.put("type","2");
//            data.put("gender","F");
//            data.put("age","12");
//            data.put("leftOrRight","L");
//            data.put("eyesightBefore","12");
//            data.put("cylBefore","12");
//            data.put("hyperopiaDegreeBefore","12");
//            data.put("eyesightAfter","");
//            data.put("cylAfter","");
//            data.put("hyperopiaDegreeAfter","");
//            data.put("optimalPathRankingVector","");
//            data.put("optimalChannel","");
//            data.put("optimalChannelNumber","");
//            data.put("classA","");
//            data.put("classB","");
//            data.put("classAPeek","");
//            data.put("classAPeekMinTime","");
//            data.put("classAPeekMaxTime","");
//            data.put("f5","");
//            data.put("f3","");
//            data.put("f1","");
//            data.put("fz","");
//            data.put("f2","");
//            data.put("f4","");
//            data.put("f6","");
//            data.put("fc3","");
//            data.put("fc1","");
//            data.put("fcz","");
//            data.put("fc2","");
//            data.put("fc4","");
//            data.put("c5","");
//            data.put("c3","");
//            data.put("c1","");
//            data.put("cz","");
//            data.put("c2","");
//            data.put("c4","");
//            data.put("c6","");
//            data.put("cp1","");
//            data.put("cpz","");
//            data.put("cp2","");
//            data.put("p5","");
//            data.put("p3","");
//            data.put("p1","");
//            data.put("pz","");
//            data.put("p2","");
//            data.put("p4","");
//            data.put("p6","");
//            data.put("oz","");
//            data.put("m1","");
//            data.put("m2","");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/user/update")
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
     * 测试用户删除接口
     * */
    @Test
    public void testUserDelete() {
        System.out.println("============================================================================================");
        System.out.println("=================================用户删除接口 common/user/delete==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("loginName", "admin");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/user/delete")
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
     * 测试用户查询接口
     * */
    @Test
    public void testUserList() {
        System.out.println("============================================================================================");
        System.out.println("=================================用户查询接口 common/user/list==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/user/list")
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
     * 测试用户详情接口
     * */
    @Test
    public void testUserDetail() {
        System.out.println("============================================================================================");
        System.out.println("=================================用户详情接口 common/user/detail==============================");
        System.out.println("============================================================================================");
        try {
            Map data = new HashMap();
            data.put("loginName", "admin");
            Map requestMap = new HashMap();
            requestMap.put("data", data);
            requestMap.put("loginName", "admin");
            requestMap.put("sessionId", "");
            String requestBody = JSON.toJSONString(requestMap);
            System.out.println("requestBody=" + requestBody);
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/user/detail")
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

