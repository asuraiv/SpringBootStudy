package com.dyKim.service;

import java.util.List;

import com.dyKim.domain.BoardDTO;

public interface BoardService {
	
	boolean registerBoard(BoardDTO params);
	
	public BoardDTO getBoardDetail(Long idx);
	
	public boolean deleteBoard(Long idx);
	
	public List<BoardDTO> getBoardList();

}
