package kr.co.study.repository;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import kr.co.study.domain.Account;

@MapperScan
@Repository
public interface SignInMapper {

	Account selectUserById(String id);

}
