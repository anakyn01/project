//import {Component} from "react";
import React, {useEffect, useState} from "react";
import {Table, Button, Container, Row, Col, ButtonGroup} from "react-bootstrap";
import Axios from "axios";
//api와 통신할때는 axios라는 미들웨어사용한다 node package manage install axios 의존성 주입
/*
mysql에 만들엇던 board라는 테이블에 데이터베이스를 리액트에서 열릴수 있도록
설정을 한다
1) 데이터를 담을 정의를 한다

*/
//props를 구조분해 할당 방식으로 사용하고 있습니다
const Board = ({//테이블에 들어가는 네임값과 타입{변수타입}을 설정
//몇개의 항목이 들어갈건지 정의 문자는 string
id, 
title, 
registerId, 
registerDate,
onCheckboxChange,
}:{
id:number; 
title:string; 
registerId:string; 
registerDate:string
onCheckboxChange: (checked: boolean, id: string) => void;
}) =>{
    return(
        <tr>
<td className="d-flex justify-content-center align-items-center">
<input type="checkbox" 
className="form-check" 
value={id} 
onChange={(e) => onCheckboxChange(e.currentTarget.checked, e.currentTarget.value)}
/>
    </td>
<td className="text-center">{id}</td>
<td>{title}</td>
<td className="text-center">{registerId}</td>
<td className="text-center">{registerDate}</td>           
        </tr>
    );
};
//java에도 있는 interface는 바디가 없는 구현체 클래스보다 큰 개념
// 커피사윤{} 커피사윤{윤희야 커피 사온나}
interface IProps{
isComplete: boolean;
handleModify: (checkList: string[]) => void;
renderComplete: () => void
}

//보드리스트라는 클래스형 컴포넌트
const  BoardList: React.FC<IProps> = ({isComplete, handleModify, renderComplete}) => {
    //게시글에 목록상태 초기값은 빈 배열
    const [boardList, setBoardList] = useState<any[]>([]);
//타입을 <string[]>로 명시하여 문자열 배열만 들어가도록 지정하였습니다
const [checkList, setCheckList] = useState<string[]>([]);

//add 현재 페이지 상태 추가
const [currentPage, setCurrentPage] = useState<number>(1);
//페이지당 게시글수 고정값
const pageSize = 10;
//총페이지 수를 받아올 상태 (서버에서 받음)
const [totalPages, setTotalPages] = useState<number>(1);


    /*위에서 만들었던 인터페이스를 props를 받는 컴포넌트임을 명시합니다 old
    state = {//1) 상태 비워져있는 배열을 만듭니다
      boardList:[],
    };*/
    //2) getList 라는 함수로 api리스트를 얻음 get현재만들어져 있는 값을 리턴 비동기
    const getList = (page = 1) => {
Axios.get(`http://localhost:8080/list?page=${page}&size=${pageSize}`)
  .then((res) => {
    console.log("서버 응답:", res.data);

    const { data, totalCount } = res.data;

    setBoardList(Array.isArray(data) ? data : []);

    const safeTotalCount = typeof totalCount === "number" && totalCount >= 0 ? totalCount : 0;
    const pages = Math.ceil(safeTotalCount / pageSize);
    setTotalPages(pages > 0 ? pages : 1);
    
    setCurrentPage(page);
    renderComplete();
  })
  .catch((e) => {
    console.error("API 오류:", e);
    setBoardList([]);
    setTotalPages(1);
  });

    };

const handleDelete = () => {
    //선택을 안되었을때 경고창
    if (checkList.length === 0) {
        alert("삭제할 게시글을 선택하세요");
        return;
    }
    //체크된 항목들의 id리스트
   // const boardIdList = checkList.map((v) => `'${v}'`).join(",");
   const boardIdList = checkList.map((v) => Number(v));
    /*
    checkList : 체크된 항목들의 ID리스트(예:[1,2,3])
    map((v) => : 각  ID를 '1' '2' '3'처럼 문자열로 감쌉니다
    .join(",") : 위에 것들을 쉼표로 이어 '1' ,'2' ,'3' 형태의 문자열로 만듭니다
    결과 '1' ,'2' ,'3'
    위에 사항은 백앤드에서 sql in ('1','2','3')형식으로 사용할때 자주 사용됩니다
    지정된 여러 값 중하나라도 일치하는 경우를 찾기 위해 사용됩니다
    */
    Axios.post("http://localhost:8080/delete",{
        boardIdList,
    }).then(() =>{
        //Promise객체와 함께 사용되며 비동기 작업이 성공적으로 완료된후 실행할 작업을 정의할때 사용됩니다
alert("삭제가 완료 되었습니다");
getList(currentPage);//현재페이지의 리스트를 다시 불러옴(갱신)
setCheckList([]);//체크리스트 초기화(사용자가 선택했던 항목들을 해제)
    }).catch((e) =>{
        console.error("삭제 오류:", e);
        alert("삭제 중 오류가 발생했습니다");
    })
    /*
    http://localhost:8080/delete 로컬개발 서버에서 삭제 API
    boardIdList를 body에 포함시켜 전송 {"boardIdList":'1','2','3'"}
    */
}

    //체크박스 상태를 관리하기 위한 함수 checked현재 체크박스가 체크되었는지 여부 T or f
    const onCheckboxChange = (checked: boolean, id: string) =>{
        //체크박스의 상태가 바뀔대 호출
        setCheckList((prev) => {//이전 체크리스트 상태를 기준으로 새상태를 계산
const filtered = prev.filter((v) => v !== id);
//현재 상태 배열에서 해당 id를 제거
return checked ? [...filtered, id] : filtered;
//체크박스가 체크되었으면 id를 배열에 추가 체크박스가 헤제 되었으면 제거된 배열을 유지
        })
    }

    useEffect(() => {
        getList(1);
    },[]);
/*
useEffect 컴포넌트가 마운트(처음 렌더링 될때) 실행되는 hook
두번째 인자가 빈 배열[]이므로 , 이 후크는 딱 한 번만 실행됩니다.
따라서 컴포넌트가 처음 화면에 그려질때 getList()함수를 호출해서 데이터를 불러옵니다
*/
    useEffect(() => {
        if(!isComplete){
            getList(currentPage);
        }
    },[isComplete]);

    //페이지 이동 핸들러
    const handlePageChange = (page: number) => {
        if(page < 1 || page > totalPages) return;
        getList(page);
    }
/*
isComplete라는 상태나 prop이 변경될때 마다 실행되고
실행조건을 검사하는데 isComplete가 거짓일때만 
getList();를 다시호출 합니다
*/

    //render(){리액트에서 상태 (이벤트)나 를 출력하는 렌더함수
//const {boardList} : {boardList:any} = this.state;
//this.state객체안에 있는 boardList속성을 꺼내서 const 보드리스트로 선언
        return(
            <Container>
                <Row>
                    <Col>
<h1 className="my-5 text-secondary text-bold">BBS</h1>                    
<Table striped bordered hover>
    <colgroup>
<col style={{width:"5%"}}/>
<col style={{width:"5%"}}/>
<col style={{width:"70%"}}/>
<col style={{width:"10%"}}/>
<col style={{width:"10%"}}/>
    </colgroup>
    <thead>
<tr className="text-center">
<th>선택</th><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
</tr>
    </thead>
 <tbody>
  {Array.isArray(boardList) && boardList.length > 0 ? (
    boardList.map((v: any) => (
      <Board
        key={v.BOARD_ID}
        id={v.BOARD_ID}
        title={v.BOARD_TITLE}
        registerId={v.REGISTER_ID}
        registerDate={v.REGISTER_DATE}
        onCheckboxChange={onCheckboxChange}
      />
    ))
  ) : (
    <tr>
      <td colSpan={5} className="text-center">게시글이 없습니다.</td>
    </tr>
  )}
</tbody>
</Table>

<div className="d-flex justify-content-center my-3">
    <ButtonGroup>
        <Button variant="outline-primary"
        onClick={() => handlePageChange(currentPage - 1)}
        disabled={currentPage === 1}
        >이전</Button>

       {[...Array(totalPages > 0 ? totalPages : 1)].map((_, i) => {
  const pageNum = i + 1;
  return (
    <Button
      key={pageNum}
      variant={pageNum === currentPage ? "primary" : "outline-primary"}
      onClick={() => handlePageChange(pageNum)}
    >
      {pageNum}
    </Button>
  );
})}
                <Button 
                variant="outline-primary"
                onClick={() => handlePageChange(currentPage + 1)}
                disabled={currentPage === totalPages}
                >다음</Button>

    </ButtonGroup>
</div>

<div className="mt-5 mb-3 d-flex justify-content-end">
    <ButtonGroup>
        <Button variant="outline-primary">
            글쓰기
        </Button>
        <Button 
        variant="outline-secondary" 
        onClick={() => handleModify(checkList)}
        >
            수정하기
        </Button>
        <Button 
        variant="outline-danger"
        onClick={handleDelete}
        >
            삭제
        </Button>
        </ButtonGroup>
    </div>

                    </Col>
                </Row>
            </Container>

        );
    }

export default BoardList;//모듈화 되었을때 화면에서 보여지게 해줌
/*
    //3)만들어진 로직(리스트로직:[getList]을 화면에 붙인다
    componentDidMount(){
        this.getList();
    }
*/