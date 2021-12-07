package com.dyKim.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dyKim.domain.BoardDTO;
import com.dyKim.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;
		if(params.getIdx() == null) {
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public BoardDTO getBoardDetail(Long idx) {
		return boardMapper.selectBoardDetail(idx);
	}

	@Override
	public boolean deleteBoard(Long idx) {
		int queryResult = 0;
		
		BoardDTO board = boardMapper.selectBoardDetail(idx);
		if(board != null ) {
			if("N".equals(board.getDeleteYn())) {
				queryResult = boardMapper.deleteBoard(idx);
			}
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = Collections.emptyList();
		
		int boardTotalCount = boardMapper.selectBoardCount();
		
		if(boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList();
		}
		
		return boardList;
	}
	
}
