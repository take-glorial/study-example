package kr.co.study.repository;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import kr.co.study.domain.Board;

@MapperScan
@Repository
public interface BoardMapper {

	List<Board> selectBoardList();

	Integer insertBoard(Board board);

}
