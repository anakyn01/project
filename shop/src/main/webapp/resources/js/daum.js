function go_daum_address(){
	
	new daum.Postcode({
		oncomplete: function(data){
			
			var addr = '';
			var extraAddr = '';
			
			if(data.userSelectedType === 'R'){//사용자가 도로명 주소를 선택했을때
				addr = data.roadAddress;
			}else{//사용자가 지번 주소를 선택했을 경우
				addr = data.jibunAddress;
			}
			
			//사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다
			if(data.userSelectedType === 'R'){
				//법정동이 있을때 추가한다
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					extraAddr += data.bname;
				}
				//건물명이 있고 공동 주택일 경우 추가한다
				if(data.buildingName !== '' && data.apartment === 'Y'){
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName: data.buildingName);
				}
				//표시할 참고 항목이 있을경우, 괄호까지 추가한 최종 문자열을 만든다
				if(extraAddr  !== ''){
					extraAddr = '('+extraAddr+')';
				}
				addr += extraAddr;
			}else{
				addr += ' ';
			}
			
			$(".address_input_1").val(data.zonecode);
			$(".address_input_2").val(addr);
			$(".address_input_3").attr("readonly",false);
			$(".address_input_3").focus();			
		}
	}).open();
	
}
