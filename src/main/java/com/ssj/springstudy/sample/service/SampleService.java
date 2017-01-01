package com.ssj.springstudy.sample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssj.springstudy.sample.model.Sample;
import com.ssj.springstudy.sample.repository.SampleRepository;

@Service
public class SampleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);
	
	@Autowired 
	private SampleRepository sampleRepository;
	
	/**
	 * 가져오기
	 * @param id
	 * @return
	 */
	public Sample sampleSelect(String id) {
		logger.debug("sampleSelect  {}.", id);
		Sample sample = sampleRepository.sampleSelect(id);		
		return sample;
	}
	
	/**
	 * 리스트 가져오기
	 * @return
	 */
	public List<Sample> sampleSelectList() {
		logger.debug("sampleSelectList  {}.");
		List<Sample> sampleList = sampleRepository.sampleSelectList();		
		return sampleList;
	}
	
	/**
	 * 저장하기
	 * @param sample
	 * @return
	 */
	public int sampleInsert(Sample sample) {
		logger.debug("sampleInsert  {}.", sample);
		int insertCnt = sampleRepository.sampleInsert(sample);		
		return insertCnt;
	}
	
	/**
	 * 수정하기
	 * @param sample
	 * @return
	 */
	public int sampleUpdate(Sample sample) {
		logger.debug("sampleUpdate  {}.", sample);
		int insertCnt = sampleRepository.sampleUpdate(sample);		
		return insertCnt;
	}
	
	/**
	 * 삭제하기
	 * @param id
	 * @return
	 */
	public int sampleDelete(String id) {
		logger.debug("sampleDelete  {}.", id);
		int insertCnt = sampleRepository.sampleDelete(id);		
		return insertCnt;
	}	
	
}
