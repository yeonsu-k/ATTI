package com.ssafy.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserFindIdReq;
import com.ssafy.api.service.UserService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.user.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 단순 회원가입 페이지 이동
	@GetMapping("/signup")	
	public String register() {
		return "user/join";
	}
	
	// 단순 로그인 페이지 이동
	@GetMapping("/login")	
	public String login() {
		return "user/login";
	}
	
	// 일반 회원가입
	@ApiResponses({
		@ApiResponse(code =  200, message = "성공"),
		@ApiResponse(code = 401, message = "인증 실패"),
		@ApiResponse(code = 404, message = "사용자 없음"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	@PostMapping("/signup/normal")
	public ResponseEntity<?> signUpNormal(@RequestBody @Valid User user) throws Exception {
		userService.signUp(user);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	// 소셜 회원가입
	@PostMapping("/signup/social")
	public void signUpSocial(User user) {
		
	}
	
	// 아이디 중복 체크
	@GetMapping("/idcheck")
	public Boolean idCheck(@RequestParam("ckid") String checkId) throws Exception {
		User user = userService.IdCheck(checkId);
		if(user==null) return true;
		return false;
	}
	
	// 아이디 찾기
	@PostMapping("/findId")
	public ResponseEntity<?> findId(@RequestBody UserFindIdReq findIdInfo) {
		List<User> userList = userService.findId(findIdInfo);
		if(userList.isEmpty())
			return ResponseEntity.status(404).body(BaseResponseBody.of(404, "일치하는 회원이 없습니다."));
		User user = userList.get(0);
		String result = String.format("(%s) 에 해당하는 아이디는 \" %s \" 입니다.", user.getEmail(), user.getUserId());
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, result));
	}
	

}