package com.ssj.springstudy.board.service;

import java.util.List;

import com.ssj.springstudy.common.model.PageNavigationModel;
import com.ssj.springstudy.common.model.ParentBoard;
import com.ssj.springstudy.sample.repository.SampleRepository;
import javafx.scene.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssj.springstudy.board.model.Board;
import com.ssj.springstudy.board.repository.BoardRepository;
import com.ssj.springstudy.common.util.PageNavigation;

@Service
public class BoardService {
	private static final Logger logger = LoggerFactory.getLogger(SampleRepository.class);

	@Autowired
	private BoardRepository boardRepository;
	
	public int boardInsert(Board board) {
		int insertCnt = boardRepository.boardInsert(board);		
		return insertCnt;
	}
	
	
	public Board boardSelect(int boardId) {
		Board board = boardRepository.boardSelect(boardId);
		return board;
	}
	
	public int boardUpdate(Board board) {
		int inserCnt = boardRepository.boardUpdate(board);
		return inserCnt;
	}

	public ParentBoard<Board> getBoard(int nowPage) {
		//레코드의 총 갯수만 가져오기
		int recodeTotalCount = boardRepository.getBoardListTotalCount();
		int pagingCount = 10;

		PageNavigationModel pageNavigationModel = PageNavigation.pageNavigation(pagingCount, recodeTotalCount, nowPage);

		List<Board> boardList = boardRepository.boardSelectList(pageNavigationModel);

		ParentBoard<Board> parentBoard = new ParentBoard();
		parentBoard.setBoardList(boardList);
		parentBoard.setPageNavigationModel(pageNavigationModel);

		System.err.println("===========>>>>");
		logger.debug("parentBoard {}", parentBoard);
		return parentBoard;
	}

	public int boardDelete(int boardId) {
		int deleteCnt = boardRepository.boardDelete(boardId);
		return deleteCnt;
	}
	
//	public PageNavigationModel pageNavi(int pageNum, int count) {
//		int num = 10; //페이징 처리할 갯수
//		int totalCount = count; //총 레코드 갯수
//		int pageCount = totalCount/num; //총페이지 갯수  1페이지면 1~10 로우 셀렉트 //2페이면//SELECT * FROM board ORDER BY boardId DESC LIMIT 1,10;
//		//1페이지면 1,10 / 2페이지면 21~30    ?,?//  (?*10)+1, (?+1)*10; 
//		int lastPageList = totalCount/10%1;//마지막 페이지의 리스트 수   // (?*10)+1,lastPageList;
//		int page = 1;
//		
//
//		//PageNavigationModel pageNavi = boardRepository.boardSelectPage(pageNum);
//		
//		
//		return null;
//	}
}
