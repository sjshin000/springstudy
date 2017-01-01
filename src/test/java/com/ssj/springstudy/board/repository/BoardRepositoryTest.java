package com.ssj.springstudy.board.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by sjshin on 2017-01-01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/spring/mvc-config.xml", "classpath:/spring/application*" })
@WebAppConfiguration
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void getBoardListTotalCountTest() {
        int count = boardRepository.getBoardListTotalCount();
        System.err.println("============>>>>>>" + count);
    }

    @Test
    public void boardSelectListTest() {
//        boardRepository.boardSelectList();
    }
}
