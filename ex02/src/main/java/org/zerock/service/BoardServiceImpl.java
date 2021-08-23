package org.zerock.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired
	// @Autowired는 자바의 BoardMapper mapper = new BoardMapper와 같은 개념.
	private BoardMapper mapper;
	// 게시판 글쓰기(register) 구현부
	public void register(BoardVO board) {
		logger.info("register......"+board);
		mapper.insertSelectKey(board);
	}
	// 게시판 상세페이지(get) 구현부
	public BoardVO get(int bno) {
		return mapper.read(bno);
	}
	// 게시판 글수정(modify) 구현부
	public boolean modify(BoardVO board) {
		return mapper.update(board);
	}
	// 게시판 글삭제(remove) 구현부
	public boolean remove(int bno) {
		return mapper.delete(bno);
	}
	// 게시판 글목록 리스트(getList) 구현부
	public ArrayList<BoardVO> getList() {
		return mapper.getList();
	}
	// 게시판 글목록 리스트+페이징 처리(getListWithPaing) 구현부
	public ArrayList<BoardVO> getListWithPaing(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
	public int getTotalCount(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
}
