import React,{useState} from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import BoardList from './BoardList';//보드리스트라는 컴포넌트를 사용하겠다는 의미
import Write from './Write';
import Slide from './Slide';
import Footer from './include/Footer';
import Header from "./include/Header";
//부트스트랩 cdn선언


const App: React.FC = () => {
 const [isModifyMode, setIsModifyMode] = useState(false);
 const [isComplete, setIsComplete] = useState(true);
 const [boardId, setBoardId] = useState(0);

 const handleModify = (checkList: any) => {//게시글 수정을 위한 함수
    if(checkList.length === 0) {//수정할 글을 선택하지 않았다면
      alert('수정할 게시글을 선택하세요')
    } else if (checkList.length > 1) {
      alert('하나의  게시글만 선택하세요');
    }
    //수정모드로 진입여부 설정
    setIsModifyMode(checkList.length === 1);
    //선택된 게시글 id설정
    setBoardId(checkList[0] || 0);
    //첫번째 선택항목의 id를 설정 없으면 0으로 기본값 설정
 }

 const handleCancel = () => {
  setIsModifyMode(false);
  setIsComplete(false);
  setBoardId(0);
 }

 const renderComplete = () => {
  setIsComplete(true);
 }

  return (
  <>
<Header/>
<Slide/>
<BoardList
isComplete={isComplete}
handleModify={handleModify}
renderComplete={renderComplete}
/>
<Write
isModifyMode={isModifyMode}
boardId = {boardId}
handleCancel={handleCancel}
/>
<Footer/>
  </>  
  );
}

export default App;