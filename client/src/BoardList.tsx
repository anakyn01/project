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
<td>
<input type="checkbox" 
className="form-check" 
value={id} 
onChange={(e) => onCheckboxChange(e.currentTarget.checked, e.currentTarget.value)}
/>
    </td>
<td>{id}</td>
<td>{title}</td>
<td>{registerId}</td>
<td>{registerDate}</td>           
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
    const [boardList, setBoardList] = useState([]);
//타입을 <string[]>로 명시하여 문자열 배열만 들어가도록 지정하였습니다
const [checkList, setCheckList] = useState<string[]>([]);

    /*위에서 만들었던 인터페이스를 props를 받는 컴포넌트임을 명시합니다 old
    state = {//1) 상태 비워져있는 배열을 만듭니다
      boardList:[],
    };*/
    //2) getList 라는 함수로 api리스트를 얻음 get현재만들어져 있는 값을 리턴 비동기
    const getList = () => {
        Axios.get("http://localhost:8080/list")
        .then((res) => {
            setBoardList(res.data);//서버로부터 받은 데이터를 boardList에 저장
            renderComplete();
            //목록 로딩이 완료된후 부모 컴포넌트등에 완료 알림을 콜백함수
            //const {data} = res;
            //this.setState({boardList:data,
            //});
        }).catch((e) =>{//처리중 에러가 생길경우
            console.error(e);//에러가 발생할 경우 에러메세지 출력
        });
    };

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
        getList();
    },[]);
/*
useEffect 컴포넌트가 마운트(처음 렌더링 될때) 실행되는 hook
두번째 인자가 빈 배열[]이므로 , 이 후크는 딱 한 번만 실행됩니다.
따라서 컴포넌트가 처음 화면에 그려질때 getList()함수를 호출해서 데이터를 불러옵니다
*/
    useEffect(() => {
        if(!isComplete){
            getList();
        }
    },[isComplete]);
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
<col style={{width:"10%"}}/>
<col style={{width:"10%"}}/>
<col style={{width:"60%"}}/>
<col style={{width:"10%"}}/>
<col style={{width:"10%"}}/>
    </colgroup>
    <thead>
<tr className="text-center">
<th>선택</th><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
</tr>
    </thead>
    <tbody>
{
    boardList.map((v: any) => {
        return(
            <Board
key={v.BOARD_ID}
id={v.BOARD_ID}  
title={v.BOARD_TITLE}
registerId={v.REGISTER_ID}
registerDate={v.REGISTER_DATE}   
onCheckboxChange={onCheckboxChange}      
            />
        )
    })
}
    </tbody>
</Table>
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
        <Button variant="outline-danger">
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