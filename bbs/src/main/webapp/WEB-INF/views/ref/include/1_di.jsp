<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<pre>
pom.xml은 메이븐 프로젝트에 대한 설정 정보를 관리하는 파일로서 
프로젝트에서 필요로 하는 의존 모듈이나 플로그인 등에 대한 설정을 담는다.
메이븐은 한 개의 모듈을 아티팩트라는 단위로 관리한다.

메이븐 리포지토리
메이븐은 코드를 컴파일하거나 실행할 때 <dependecy>로 설정한 아티팩트 파일을 사용한다. 
아티 팩트 파일은 아래 과정을 거쳐 구한다.

메이븐 로컬 리포지토리에서 [그룹ID][아티팩트ID]\버전] 폴더에 아티팩트ID-버전.jar 형식의 
이름을 갖는 파일이 있는 검사하고, 존재하면 이 파일을 사용한다.
로컬 리포지토리에 파일이 없으면 메이븐 원격 중앙 리포지토리로부터 
해당 파일을 다운로드하여 로컬 리포지토리에 복사한 뒤 그 파일을 사용한다.

의존 전이(Transitive Dependencies)
spring-context를 사용하려면 spring-aop, spring-beans등 다른 아티팩트도 추가로 필요하다. 
따라서 메이븐은 spring-context에 대한 의존 설정이 있으면 
spring-context가 의존하는 다른 아티팩트도 함께 다운로드한다.

메이븐은 의존하는 대상뿐만 아니라 의존 대상이 다시 의존하는 대상도 함께 다운로드한다. 
이렇게 의존 대상이 다시 의존하는 대상까지도 의존 대상에 포함하기 때문에 
이를 의존 전이(Transitive Dependencies)라고 한다.

메이븐 기본 폴더 구조
src\main\java 폴더에는 자바 소스 코드가 위치한다.
src\main\resources 폴더에는 
XML이나 프로퍼티와 같이 자바 소스 외의 자원 파일이 들어간다.
웹 어플리케이션을 개발할 때에는 src\main\webapp 폴더를 
웹 어플리케이션 기준 폴더로 사용하며, 
이 폴더를 기준으로 JSP 소스 코드나 WEB-INF\web.xml 파일등을 작성해서 넣는다.

@Configuration : 해당 클래스를 스프링 설정 클래스로 지정한다.

스프링 객체 컨테이너
BeanFactory 인터페이스는 객체 생성과 검색에 대한 기능을 정의 한다. 
예를 들어 생성된 객체를 검색하는데 필요한 getBean() 메서드가 BeanFactory에 정의되어 있다. 
객체를 검색하는 것 이외에 싱글톤/프로토타입 빈인지 확인하는 기능도 제공한다.

ApplicationContext 인터페이스는 메시지, 프로필/환경 변수 등을 처리할 수 있는 기능을 추가로 제공한다.

ApplicationContext(또는 BeanFactory)는 빈 객체의 생성, 초기화, 보관, 제거 등을 관리하고 있어서
ApplicationContext나 BeanFactaory 등을 컨테이너(Container)라고도 부른다.

스프링은 기본적으로 한 개의 @Bean 애노테이션에 대해 한 개의 빈 객체를 생성한다.
</pre>