package kr.co.study.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.study.domain.Board;
import kr.co.study.repository.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper boardMapper;

	@Transactional(readOnly = true)
	public List<Board> selectBoardList(){
		return boardMapper.selectBoardList();
	}

	@Transactional(readOnly = false)
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}

}
