package com.ssj.springstudy.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssj.springstudy.sample.model.Sample;
import com.ssj.springstudy.sample.service.SampleService;


@Controller
@RequestMapping("/sample")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleService sampleService;
	
	/**
	 * 수정 폼
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping("/sampleModifyForm")
	public ModelAndView sampleModifyForm(@RequestParam("id") String id ) {
		ModelAndView mav = new ModelAndView("/sample/sampleModifyForm");
		logger.debug("sample test  {}.", id);		
		Sample sample = sampleService.sampleSelect(id);
		
		mav.addObject("sample", sample);
		
		return mav;
	}
	
	/**
	 * 리스트 가져오기.
	 * @param id
	 * @return
	 */
	@RequestMapping("/sampleList")
	public ModelAndView sampleList() {
		ModelAndView mav = new ModelAndView("/sample/sampleList");
		logger.debug("sample list  {}.");		
		List<Sample> sampleList = sampleService.sampleSelectList();
		
		mav.addObject("sampleList", sampleList);
		
		return mav;
	}
	
	/**
	 * 쓰기폼
	 * @param mav
	 * @return
	 */
	@RequestMapping("/sampleWriteForm")
	public ModelAndView sampleWriteForm() {
		ModelAndView mav = new ModelAndView("/sample/sampleWriteForm");
	
		return mav;
	}
	
	/**
	 * 저장하기
	 * @param sample
	 * @param mav
	 * @return
	 */
	@RequestMapping("/sampleInsert")
	public ModelAndView sampleInsert(Sample sample ) {
		ModelAndView mav = new ModelAndView("/sample/sampleModifyForm");
		sampleService.sampleInsert(sample);
		
		sample = sampleService.sampleSelect(sample.getId());
		
		mav.addObject("sample", sample);
		
		return mav;
	}
	
	/**
	 * 수정하기
	 * @param sample
	 * @param mav
	 * @return
	 */
	@RequestMapping("/sampleUpdate")
	public ModelAndView sampleUpdate(Sample sample ) {
		ModelAndView mav = new ModelAndView("/sample/sampleModifyForm");
		sampleService.sampleUpdate(sample);
		
		sample = sampleService.sampleSelect(sample.getId());
		
		mav.addObject("sample", sample);
		
		return mav;
	}
	
	/**
	 * 삭제하기
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping("/sampleDelete")
	public ModelAndView sampleDelete(@RequestParam("id") String id ) {
		ModelAndView mav = new ModelAndView("/sample/sampleModifyForm");
		sampleService.sampleDelete(id);
		
		Sample sample = sampleService.sampleSelect(id);
		
		mav.addObject("sample", sample);
		
		return mav;
	}
	
}
