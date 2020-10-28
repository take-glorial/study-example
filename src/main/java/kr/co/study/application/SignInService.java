package kr.co.study.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.study.domain.Account;
import kr.co.study.repository.SignInMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignInService implements UserDetailsService {

	private final SignInMapper signInMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = signInMapper.selectUserById(username);
		if(account == null ) {
			throw new UsernameNotFoundException("사용자 정보를 찾을 수 없습니다.");
		}

		account.setPassword(passwordEncoder.encode(account.getPassword()));
		log.debug("account : {}", account);

		return account;
	}

}
