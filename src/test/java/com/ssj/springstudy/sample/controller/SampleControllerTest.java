package com.ssj.springstudy.sample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/spring/mvc-config.xml", "classpath:/spring/application*" })
@WebAppConfiguration
public class SampleControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private MockHttpSession session;
	
	@Autowired 
	private MockHttpServletRequest request;


	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	

	
	@Test
	public void testSampleInsert() throws Exception {
		
		this.mockMvc.perform(post("/sample/sampleInsert")
				.param("id", "3")
				.param("title", "cccccc")
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())				
				.andExpect(handler().handlerType(SampleController.class))
				.andExpect(handler().methodName("sampleInsert"))
				.andDo(MockMvcResultHandlers.print());		
		
	}
	
	@Test
	public void testSampleModifyForm() throws Exception {
//		session 추가 방법
//		UserDomain user = new UserDomain();
//		user.setFirstName("johnny");
//		
//		session.setAttribute("sessionParm",user);
//		this.mockMvc.perform(get("/mysessiontest").session(session)

		
		this.mockMvc.perform(post("/sample/sampleModifyForm")
				.param("id", "2")
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())				
				.andExpect(handler().handlerType(SampleController.class))
				.andExpect(handler().methodName("sampleModifyForm"))				
				.andExpect(model().attribute("sample" , hasProperty("id" , is("2"))))
				.andExpect(model().attribute("sample" , hasProperty("title" , is("bbbbbbb"))))
//				.andExpect(model().attribute("sample" , hasItem( //- 리스트 일경우 다시 재확인
//						allOf(
//							hasProperty("id" , is("2"))
//							,hasProperty("title" , is("bbbbbbb"))
//						)	
//				)))
				.andDo(MockMvcResultHandlers.print());		
		
	}
	
	@Test
	public void testSampleList() throws Exception {
		this.mockMvc.perform(post("/sample/sampleList")				
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())				
				.andExpect(handler().handlerType(SampleController.class))
				.andExpect(handler().methodName("sampleList"))				
				.andExpect(model().attribute("sampleList" , hasItem( //- 리스트 일경우 다시 재확인
						allOf(
							hasProperty("id" , is("3"))
							,hasProperty("title" , is("ddddd"))
						)	
				)))
				.andExpect(model().attribute("sampleList" , hasItem( //- 리스트 일경우 다시 재확인
						allOf(
							hasProperty("id" , is("4"))
							,hasProperty("title" , is("ddddd"))
						)	
				)))
				.andExpect(model().attribute("sampleList" , hasItem( //- 리스트 일경우 다시 재확인
						allOf(
							hasProperty("id" , is("5"))
							,hasProperty("title" , is("eeeee"))
						)	
				)))
				.andDo(MockMvcResultHandlers.print());		
		
	}
	
	@Test
	public void testSampleUpdate() throws Exception {
		
		this.mockMvc.perform(post("/sample/sampleUpdate")
				.param("id", "3")
				.param("title", "ddddd")
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())				
				.andExpect(handler().handlerType(SampleController.class))
				.andExpect(handler().methodName("sampleUpdate"))
				.andDo(MockMvcResultHandlers.print());		
		
	}
	
	@Test
	public void testSampleDelete() throws Exception {
		this.mockMvc.perform(post("/sample/sampleDelete")
				.param("id", "2")
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())				
				.andExpect(handler().handlerType(SampleController.class))
				.andExpect(handler().methodName("sampleDelete"))
				.andDo(MockMvcResultHandlers.print());		
		
	}

}
