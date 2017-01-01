package com.ssj.springstudy.sample.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssj.springstudy.sample.model.Sample;


@Repository
public class SampleRepository {	
	private static final Logger logger = LoggerFactory.getLogger(SampleRepository.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 가져오기
	 * @param id
	 * @return
	 */
	public Sample sampleSelect(String id) {
		logger.debug("sampleSelect  {}.", id);
		Sample sample = sqlSession.selectOne("sample.select" , id);
		return sample;
	}
	
	/**
	 * 리스트 가져오기
	 * @return
	 */
	public List<Sample> sampleSelectList() {
		logger.debug("sampleSelectList  {}.");
		List<Sample> sampleList = sqlSession.selectList("sample.selectList");
		return sampleList;
	}
	
	
	
	/**
	 * 저장하기
	 * @param sample
	 * @return
	 */
	public int sampleInsert(Sample sample) {
		logger.debug("sampleInsert  {}.", sample);
		int insertCnt = sqlSession.insert("sample.insert" , sample);
		return insertCnt;
	}
	
	/**
	 * 수정하기
	 * @param sample
	 * @return
	 */
	public int sampleUpdate(Sample sample) {
		logger.debug("sampleUpdate  {}.", sample);
		int insertCnt = sqlSession.update("sample.update" , sample);
		return insertCnt;
	}
	
	/**
	 * 삭제하기
	 * @param id
	 * @return
	 */
	public int sampleDelete(String id) {
		logger.debug("sampleUpdate  {}.", id);
		int insertCnt = sqlSession.update("sample.delete" , id);
		return insertCnt;
	}	
	
}
