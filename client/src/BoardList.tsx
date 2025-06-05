import {Component} from "react";
import {Table, Button, Container, Row, Col} from "react-bootstrap";
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
id, title, registerId, registerDate,
}:{id:number; title:string; registerId:string; registerDate:string}) =>{
    return(
        <tr>
<td><input type="checkbox" className="form-check"/></td>
<td>{id}</td>
<td>{title}</td>
<td>{registerId}</td>
<td>{registerDate}</td>           
        </tr>
    )
}

//보드리스트라는 클래스형 컴포넌트
class BoardList extends Component{

    state = {//1) 상태 비워져있는 배열을 만듭니다
      boardList:[],
    };
    //2) getList 라는 함수로 api리스트를 얻음 get현재만들어져 있는 값을 리턴 비동기
    getList = () => {
        Axios.get("http://localhost:8080/list", {})
        .then((res) => {
            const {data} = res;
            this.setState({
                boardList:data,
            });
        }).catch((e) =>{//처리중 에러가 생길경우
            console.error(e);//에러가 발생할 경우 에러메세지 출력
        })
    }

    //3)만들어진 로직(리스트로직:[getList]을 화면에 붙인다
    componentDidMount(){
        this.getList();
    }

    render(){//리액트에서 상태 (이벤트)나 를 출력하는 렌더함수
const {boardList} : {boardList:any} = this.state;
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
id={v.BOARD_ID}  
title={v.BOARD_TITLE}
registerId={v.REGISTER_ID}
registerDate={v.REGISTER_DATE}         
            />
        )
    })
}
    </tbody>
</Table>
<div className="mt-5 mb-3 d-flex justify-content-end">
    <div className="btn-group">
        <Button variant="primary">
            쓰기
        </Button>
        <Button variant="secondary">
            수정
        </Button>
        <Button variant="danger">
            삭제
        </Button>
    </div>
</div>
                    </Col>
                </Row>
            </Container>

        );
    }

}
export default BoardList;//모듈화 되었을때 화면에서 보여지게 해줌