package com.ssj.springstudy.board.controller;

import java.util.List;

import com.ssj.springstudy.common.model.ParentBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssj.springstudy.board.model.Board;
import com.ssj.springstudy.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 쓰기 화면 뷰 용(jsp로 포워딩만)
	 */
	@RequestMapping("/boardWriteForm")
	public ModelAndView boardWriteForm(){
		ModelAndView mov = new ModelAndView("/board/boardWriteForm");
		return mov;
	}
	
	/**
	 * 쓰기 Insert용 
	 * @param board
	 * @return
	 */
	@RequestMapping("/boardInsert")
	public ModelAndView boardInsert(Board board) {
		boardService.boardInsert(board);

		ModelAndView mav = new ModelAndView("forward:/board/boardList");
		return mav;
	}
	
	/**
	 * 게시판 수정 page 가져오기
	 */
	@RequestMapping("/boardModifyForm")
	public ModelAndView boardModifyForm(@RequestParam(value="boardId" , required = false) int boardId ) {
		ModelAndView mov = new ModelAndView("/board/boardModifyForm");
		Board board = boardService.boardSelect(boardId);
		mov.addObject("board", board);
		return mov;
	}
	
	/**
	 * 수정 - Update
	 * @return
	 */
	@RequestMapping("/boardUpdate")
	public ModelAndView boardUpdate(Board board){
		ModelAndView mov = new ModelAndView("redirect:/board/boardList");
		boardService.boardUpdate(board);
		return mov;
	}
	
	/**
	 * 리스트 가져오기(화면뷰)
	 * @return
	 */
	@RequestMapping("/boardList")
	public ModelAndView boardList(@RequestParam(value = "page" , required = false) String page) {
		int nowPage = 0;
		if (StringUtils.isEmpty(page)) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		ModelAndView mov = new ModelAndView("/board/boardList");

		ParentBoard<Board>  parentBoard= boardService.getBoard(nowPage);

		mov.addObject("boardList", parentBoard.getBoardList());
		mov.addObject("pageNavigationModel", parentBoard.getPageNavigationModel());
		mov.addObject("parentBoard", parentBoard);
		return mov;
	}
	
	/**
	 * 삭제
	 */
	@RequestMapping("/boardDeleteForm")
	public ModelAndView boardDeleteForm() {
		ModelAndView mov = new ModelAndView("/board/boardList");
		return mov;
	}
	
	@RequestMapping("/boardDelete")
	public ModelAndView boardDelete(@RequestParam(value="boardId" , required = false) int boardId) {
		ModelAndView mov = new ModelAndView("redirect:/board/boardList");
		boardService.boardDelete(boardId);
		return mov;
	}
}
