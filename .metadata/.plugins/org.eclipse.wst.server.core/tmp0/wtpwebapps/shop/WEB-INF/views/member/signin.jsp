<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file='../include/header.jsp'%>
<div class="container-fluid bg-gradient-primary">
<div class="row justify-content-center">
   
      <div class="col-xl-10 col-lg-12 col-md-9">
      <!-- 대형에서는 10 데스크탑 12 태블릿은 9 -->
         <div class="card o-hidden border-0 shadow-lg my-5">
         
            <div class="card-body p-0">
               <div class="row">
                  <!-- 배경이미지 -->
                  <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                   
                   <!-- input -->
                   <div class="col-lg-6">
                      
                      <div class="p-5">
                         
                         <div class="text-center">
                            <h1 class="h4 text-grey-900 mb-4">
                            Welcome Back!
                            </h1>
                         </div>
                         
                         <form  method="post" autocomplete="off">
                         
                         <div class="form-group mb-3">
                            <input type="text" 
                            class="form-control form-control-user"
                            placeholder="아이디"
                            name="userId"
                            maxlength="20"
                            required="required" 
                            />
                         </div>
                         
                         <div class="form-group mb-3">
                           <input type="password"
                           class="form-control form-control-user"
                           placeholder="비밀번호"
                           name="userPass"
                           maxlength="20"
                            required="required" 
                           
                           />
                        </div>
                        
                        <div class="form-group mb-3 ">
                        
                           <div class="custom-control custom-checkbox small">
                           
                           <input type="checkbox" 
                           class="custom-control-input"
                           id="customCheck"/>
                           <label class="custom-control-label" for="customCheck">
                           Remember Me
                           </label>
                           </div>
                        
                        
                        </div>
                        <p class="mb-3">
                           <!--  <a href="${path}/login.jsp" class="btn btn-primary btn-user btn-block">
                           Login
                           </a>-->
                           <input type="submit" 
                           class="btn btn-primary btn-user btn-block" 
                           value="로그인"
                           id="signin_btn"
                           name="signin_btn"
                           />
                        </p>

                        <c:if test="${msg == false }">
                        <p class="text-danger">로그인에 실패했습니다</p>
                        </c:if>


                        <hr>
                        <p class="mb-3">
                        <a href="${path}/google.jsp" class="btn btn-google btn-user btn-block">
                           <i class="fab fa-google fa-fw w-100">
                           &nbsp;Login with Google
                           </i>
                        </a>
                        </p>

                        
                        <a href="${path}/face.jsp" class="btn btn-facebook btn-user btn-block">
                           <i class="fab fa-facebook-f fa-fw w-100">
                           &nbsp;Login with Facebook
                           </i>
                        </a>
                        
                        
                        
                         
                         
                         
                         </form>
                         
                         <hr>
                         
                         <div class="text-center mb-3">
                            <a class="small" href="${path}/forgot">
                            Forgot Password?
                            </a>
                         </div>
                         
                         <div class="text-center mb-3">
                            <a class="small" href="${path}/join">
                            회원가입
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

   

<%@ include file='../include/footer.jsp'%>
