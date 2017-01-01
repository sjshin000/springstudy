package com.ssj.springstudy.sample.repository;

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
public class SampleRepositoryTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Autowired
	private SampleRepository sampleRepository;

	@Test
	public void testSampleInsert() throws Exception {
		Sample sample = new Sample();
		sample.setId("5");
		sample.setTitle("eeeee");
		int result = sampleRepository.sampleInsert(sample);
		
		Assert.assertEquals(result, 1);
	}
	
	
	@Test
	public void testSampleSelect() throws Exception {
		
		Sample sample = sampleRepository.sampleSelect("2");
		
		Assert.assertEquals(sample.getId(), "2");
		
	}
	
	@Test
	public void testSampleSelectList() throws Exception {
		
		List<Sample> sampleList = sampleRepository.sampleSelectList();
		
		Assert.assertEquals(sampleList.size(), 3);
		
	}
	
	@Test
	public void testSampleUpdate() throws Exception {
		Sample sample = new Sample();
		sample.setId("2");
		sample.setTitle("ccccc");
		sampleRepository.sampleUpdate(sample);
		
		Sample resultSample = sampleRepository.sampleSelect(sample.getId());
		
		Assert.assertEquals(resultSample.getTitle(), "ccccc");
	}
	
	@Test
	public void testSampleDelete() throws Exception {
		
		int result = sampleRepository.sampleDelete("2");
		
		Assert.assertEquals(result, 1);
	}

}
