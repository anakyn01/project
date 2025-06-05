import React, {useState} from "react";
//import {Component} from "react" 클래스형 일때 선언;
import {Form, Button, Container, Row, Col, ButtonGroup} from "react-bootstrap";
//react에서 api통신할때 사용하는 모듈 axios
import Axios from "axios"; //미들웨어
//write라는 페이지는 쓰기 페이지여서 이벤트 발생 1)글을 쓴다 2)성공 또는 실패




/*class Write extends Component{
    render(){*/
const Write = () => {

    //상태 초기화
const [isModifyMode, setIsModifyMode] = useState(false) ;//수정모드 여부
//현재작성모드(false) 수정모드 (true)인지를 나타냄
const [formData, setFormData] = useState({
   id:null,  title: "", content: "",
});//사용자가 입력한 제목과 내용을 상태로 관리함

//2.입력 핸들러 폼의 name속성(title, content)를 키로 사용하여 상태를 업데이트
const handleChange = (e: React.ChangeEvent <HTMLInputElement | HTMLTextAreaElement> ) =>{
/* 이벤트 객체 e는 React.ChangeEvent타입이며
<HTMLInputElement | HTMLTextAreaElement>는 input또는 
textarea에서 발생하는 이벤트만 처리함을 의미합니다*/
    const {name, value} = e.target;//e.target은 이벤트가 발생한 dom요소 이두값을 추출하여 폼상테를 업데이트하는데 사용
    setFormData((prevData) => ({//setFormData는 폼데이터를 저장하는 상태 업데이트 함수
...prevData,//prevData는 이전 폼데이터 상태 스프레드 연산자로 기존 데이터를 복사
[name]: value,//를 통해 해당 필드값만 업데이트
    }));
}

//write
const write = () => {
    Axios.post("http://localhost:8080/insert", {
        title:formData.title,
        content:formData.content,
    })
}

//update
const update = () => {
    Axios.post("http://localhost:8080/update", {
        id:formData.id,
        title:formData.title,
        content:formData.content,
    })
}

        return(
            <>
<Container>
    <Row>
        <Col>
        <Form>
    <Form.Group className="mb-3">
<Form.Label>제목</Form.Label>
<Form.Control
type="text" 
name="title"
value={formData.title}
onChange={handleChange}
placeholder="제목을 입력 하세요"
/>
    </Form.Group>
    <Form.Group className="my-3">
<Form.Label>내용</Form.Label>
<Form.Control 
as="textarea" 
name="content"
value={formData.content}
onChange={handleChange}
placeholder="내용을 입력하세요"/>
    </Form.Group>
</Form>
<div className="">
    <div className="d-flex justify-content-end mt-4 mb-2">
        <ButtonGroup>
            <Button variant="info"
            onClick={isModifyMode ? update : write}
            >
            작성완료
            </Button>
            <Button variant="danger">취소</Button>
        </ButtonGroup>
    </div>
</div>
        </Col>
    </Row>
</Container>            
            </>
           
        );
}


export default Write;
/*상태 초기화를 해줌
state = {
    isModifyMode : false,//수정모드는 허용하지 않음
title:"",//타이틀 비우고
content:"",//내용 비우고
}

//write 를 실행하는 함수 작성 get기존에 있는 내용을 리턴 
//쓰는 명령어를 줄때는 일반적으로 post사용 
write = () => {
    Axios.post("http://")
}*/