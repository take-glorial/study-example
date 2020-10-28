package kr.co.study.web.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class JoinDTO {

	@NotEmpty(message="아이디 입력")
	private String id;

	@NotEmpty(message = "이름 입력")
	private String name;

	@NotEmpty(message = "비번 입력")
	private String password;

}
