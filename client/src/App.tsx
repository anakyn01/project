import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import BoardList from './BoardList';//보드리스트라는 컴포넌트를 사용하겠다는 의미
import Write from './Write';
import Slide from './Slide';
//부트스트랩 cdn선언


function App() {
  return (
  <>
<Slide/>
<BoardList/>
<Write/>
  </>  
  );
}

export default App;