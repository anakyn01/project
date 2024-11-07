<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file='../include/header.jsp'%>
<br><br>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
		      <div class="card o-hidden border-0 shadow-lg my-5">
	<div class="card-body p-0">
	<div class="row">
		<div class="col-lg-5 d-none d-lg-block bg-register-image">
		</div>
		<div class="col-lg-7">
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-grey-900 mb-4">
					Create an Account!
					</h1>
					<form class="user" method="post" class="was-validated" id="join_form">
					
					<div class="form-group row mb-3">
						<div class="col-sm-12 mb-3 mb-sm-0">
							<input type="text" 
							class="form-control form-control-user userId"
							placeholder="아이디"
							name="userId"
							maxlength="20"
							id="userId"
							/>
						</div>

						
						<!-- add -->
						<span class="id_input_re_1">사용 가능한 아이디입니다.</span>
						<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
						<span class="final_id_ck">아이디를 입력해 주세요</span>
					
					</div>
					
					<div class="form-group mb-3 d-flex">
					<input 
					type="password"
					class="form-control form-control-user me-3 userPass"
					placeholder="비밀번호"
					name="userPass"
					maxlength="20"
					/>
					<input 
					type="password"
					class="form-control form-control-user"
					placeholder="비밀번호확인"
					name="userPassRe"
					maxlength="20"
					/>
					</div>
					<span class="final_pw_ck">비밀번호를 입력해 주세요</span>
					<span class="final_pwck_ck">비밀번호 확인을 입력해 주세요</span>
					
					<div class="form-group row mb-3">
						<div class="col-sm-12 mb-3 mb-sm-0">
							<input type="text" 
							class="form-control form-control-user userName"
							placeholder="이름"
							name="userName"
							maxlength="20"
							/>
						</div>
					</div>
					<span class="final_name_ck">이름을 입력해 주세요</span>
					
					<div class="form-group row mb-3">
						<div class="col-sm-12 mb-3 mb-sm-0">
						<!--  <div class="input-group">-->
							<!--  <div class="mail_check_input_box w-75" id="mail_check_input_box_false">-->
							    <input type="email" 
								class="form-control form-control-user userEmail"
								placeholder="이메일"
								name="userEmail"
								maxlength="40"
								/>
							<!--  </div>-->
						
							<!--  <a class="btn btn-outline-success mail_check_button w-25">인증번호 전송</a>-->
						</div>
							<!-- <span id="mail_check_input_box_warn"></span>
						</div> -->
					</div>
					<span class="final_mail_ck">이메일을 입력해 주세요</span>
					
					<div class="form-group row mb-3">
						<div class="col-sm-12 mb-3 mb-sm-0">
							<input type="text" 
							class="form-control form-control-user userPhone"
							placeholder="휴대폰"
							name="userPhone"
							maxlength="20"
							/>
						</div>
					</div>
												</div>
					
			<div class="input-group my-4">
				<label class="input-group-text">주소</label>
				<input type="text" class="form-control address_input_1" name="userAddr1" readonly="readonly"/>
				<a class="btn btn-outline-primary border-radius-top-right-sm" onclick="go_daum_address()">주소 찾기</a>
			</div>
			
			<div class="input-group my-4">
				<input type="text" class="form-control address_input_2 br20" name="userAddr2" readonly="readonly"/>
			</div>
			
			<div class="input-group my-4">
				<input type="text" class="form-control address_input_3 br20" name="userAddr3" readonly="readonly"/>
			</div>

					
					
					<div class="form-group mb-3">
					
					<div class="btn-group">
						<label class="btn border-0 active">
							<input type="radio" name="userGender" value="남자" autocomplete="off" checked>남자
						</label>
						<label class="btn border-0">
							<input type="radio" name="userGender" value="여자" autocomplete="off">여자
						</label>
					</div>
					
					</div>
					
					<p class="mb-3">
						<!--  <a href="login.jsp" class="btn btn-primary btn-user btn-block">
							Register Account
						</a>-->
						<input type="submit" 
						class="btn btn-primary btn-user btn-block signup_btn"
						value="회원가입"
						onclick="IDCheck"
						/>
					</p>
					<p class="mb-3">
						<a href="https://kauth.kakao.com/oauth/authorize?client_id={REST_API_KEY}&redirect_uri={REDIRECT_URI}&response_type=code" class="btn btn-kakao btn-user btn-block">
							<i class="fab fa-google fa-fw w-100">
							코코아톡으로 회원가입
							</i>
						</a>
					</p>
					<p class="mb-3">
						<a href="login.jsp" class="btn btn-facebook btn-user btn-block">
							<i class="fab fa-facebook fa-fw w-100">
							Register with Facebook
							</i>
						</a>
					</p>
					
					</form>
					<hr>
					<div class="text-center">
						<a class="small" href="/user/forgot.jsp">
						Forgot Password?
						</a>
					</div>
					
					<div class="text-center">
						<a class="small" href="/user/login.jsp">
						Already have an account? Login!
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
		</div>
	</div>
</div>

	

<%@ include file='../include/footer.jsp'%>
