import React, {useState} from "react";
//import {Component} from "react" 클래스형 일때 선언;
import {Form, Button, Container, Row, Col} from "react-bootstrap";
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
    title: "", content: "",
});//사용자가 입력한 제목과 내용을 상태로 관리함

//2.입력 핸들러 폼의 name속성(title, content)를 키로 사용하여 상태를 업데이트
const handleChange = (e: React.ChangeEvent <HTMLInputElement | HTMLTextAreaElement> ) =>{
    const {name, value} = e.target;
    setFormData((prevData) => ({
...prevData,
[name]: value,
    }));
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
placeholder="제목을 입력 하세요"
/>
    </Form.Group>
    <Form.Group className="my-3">
<Form.Label>내용</Form.Label>
<Form.Control as="textarea" placeholder="내용을 입력하세요"/>
    </Form.Group>
</Form>
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