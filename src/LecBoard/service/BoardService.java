package LecBoard.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import LecBoard.dao.BoardDAO;
import LecBoard.vo.BoardVO;

/*
       --->         ---> 
	UI      SERVICE      DAO
	   <---         <---
*/
public class BoardService {
	private BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public void insertBoard(BoardVO newBoard) {
		
		// 게시판 번호 setting
		int no = BoardSequence.getBoardSequence();
		newBoard.setNo(no);
		
		// 등록일(현재시간) setting
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(new Date());
		
		newBoard.setRegDate(now);
		
		boardDAO.insertBoard(newBoard);
	}
	
	public List<BoardVO> selectAllBoard() {
		
		List<BoardVO> list = boardDAO.selectAllBoard();
		
		return list;
	}
	
	public BoardVO selectBoardByNo(int no) {
		
		BoardVO board = boardDAO.selectBoardByNo(no);
		return board;
		
	}
	
	public void modifyBoard(BoardVO board) {
		boardDAO.modifyBoard(board);
	}
	
	public void deleteBoardByNo(int no) {
		boardDAO.deleteBoardByNo(no);
	}
}










