package com.ssj.springstudy.sample.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ssj.springstudy.sample.model.Sample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/spring/mvc-config.xml", "classpath:/spring/application*" })
@WebAppConfiguration
public class SampleServiceTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Autowired
	private SampleService sampleService;

	@Test
	public void testSampleInsert() throws Exception {
		Sample sample = new Sample();
		sample.setId("2");
		sample.setTitle("bbbbbb");
		int result = sampleService.sampleInsert(sample);
		
		Assert.assertEquals(result, 1);
	}
	
	
	@Test
	public void testSampleSelect() throws Exception {
		
		Sample sample = sampleService.sampleSelect("2");
		
		Assert.assertEquals(sample.getId(), "2");
		
	}
	
	@Test
	public void testSampleSelectList() throws Exception {
		
		List<Sample> sampleList = sampleService.sampleSelectList();
		
		Assert.assertEquals(sampleList.size(), 3);
		
	}
	
	@Test
	public void testSampleUpdate() throws Exception {
		Sample sample = new Sample();
		sample.setId("2");
		sample.setTitle("ccccc");
		sampleService.sampleUpdate(sample);
		
		Sample resultSample = sampleService.sampleSelect(sample.getId());
		
		Assert.assertEquals(resultSample.getTitle(), "ccccc");
	}
	
	@Test
	public void testSampleDelete() throws Exception {
		
		int result = sampleService.sampleDelete("2");
		
		Assert.assertEquals(result, 1);
	}

}
