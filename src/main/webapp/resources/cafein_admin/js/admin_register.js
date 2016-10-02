$(document).ready(function(){
	
	var checkIdDuplicated =0;
	
	
	$('#admin_RegisterBtn').click(function(){
	
	
		 var name = document.getElementById('r_u_name');
		 var email = document.getElementById('r_u_email');
		 var password = document.getElementById('r_u_password');
		 
		 	$('#message_name').html(''); // 메시지 초기화
			$('#message_email').html(''); // 메시지 초기화
			$('#message_password').html(''); // 메시지 초기화
			
		 
		 
		 // 공백 불가 체크
		 if(!name.value){
			   $('#message_name').css('color','red').text('Please enter your Username(등록)');
			    
			    //name.focus();
			   
		 }
	
		 if(!email.value){
			   $('#message_email').css('color','red').text('Please enter your email address');
			     
			   // email.focus();
			    
		 }
		 
		 if(!password.value){
			  $('#message_password').css('color','red').text('Please enter your password(등록)');
				    
				  //password.focus();
			 }
		 
		 if(!name.value || !email.value || !password.value){
			 return false;
		 }
			 	
		 
		 
		 $('#message_email').html(''); // 메시지 초기화
		 
		 // 이메일 형식 체크
	    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 
	    if (!filter.test(email.value)) {
	    $('#message_email').css('color','red').text('Please enter a VALID email address(영어,숫자)');
	    
	    email.focus();
	    return false;
	 }
	    
	    
		 
		alert("공백 return false 이후 ");

		 	$('#message_name').html(''); // 메시지 초기화
			$('#message_email').html(''); // 메시지 초기화
			$('#message_password').html(''); // 메시지 초기화
			
		
		// 비밀번호 형식 체크
		    if(password.value.length <4 || password.value.length >10){
		    	  $('#message_password').css('color','red').text('비밀번호는 4자이상 10자이하로 입력하세요.');
				    
				  password.focus();
				  return false;
		    }
		
		
		    
		    $('#message_name').html(''); // 메시지 초기화
			$('#message_email').html(''); // 메시지 초기화
			$('#message_password').html(''); // 메시지 초기화
			
			$('#loading').show(); //로딩 이미지 노출
		    // 이메일 중복 체크
			
			$.ajax({
				url:'confirmId.do',
				type:'post',
				data:{
					u_email:$('#r_u_email').val()
					},
				dataType:'json',
				cache:false, //데이타를 보관 변하지 않으면 저장된 데이터 사용, 하지만 이건 변하는 데이터이기때문에 보관 xx
				timeout:30000,
				success:function(data){
					$('#loading').hide(); // 로딩이미지 감추기
					
					if(data.result == 'idNotFound'){
						$('#message_email').css('color','#000000').text('등록가능ID');
						checkIdDuplicated =1;
						
					}else if(data.result=='idDuplicated'){
						$('#message_email').css('color','red').text('중복된 ID');
						checkIdDuplicated =0;
						return false;
					}
					
					
					
					 if(checkIdDuplicated==1){
						 adminRegister();
					 }
					
					
				},
				error:function(){
					$('#loading').hide(); // 로딩 이미지 감추기
					alert('네트워크 오류 발생!');
				}
				
			});
		    
		    
		    
		  
    
	});  //submit
	
	
	
	
	
	
	
	
	
	 var adminRegister = function(){
	    
	    
		$('#message_name').html(''); // 메시지 초기화
		$('#message_email').html(''); // 메시지 초기화
		$('#message_password').html(''); // 메시지 초기화
		$('#loading').show(); //로딩 이미지 노출
		
		
		//var formData = $("#admin_registerform").serialize();

		$.ajax({
			url:'adminRegister.do',
			type:'post',
			data:{
				u_email:$('#r_u_email').val() ,
				u_name:$('#r_u_name').val() ,
				u_password:$('#r_u_password').val()
				
			},
			cache:false, //데이타를 보관 변하지 않으면 저장된 데이터 사용, 하지만 이건 변하는 데이터이기때문에 보관 xx
			timeout:30000,
			success:function(data){
				$('#loading').hide(); // 로딩이미지 감추기
				
			//	alert(data.result);
				if(data.result == 'success'){
					$('#message_1').css('color','red').text('가입되었습니다.');
					
				}else if(data.result=='failure'){
					$('#message_2').css('color','red').text('가입 실패.');
					
				}
         	
			},
			error:function(){
				$('#loading').hide(); // 로딩 이미지 감추기
				alert('네트워크 오류 발생!');
			}
			
		});
	    
	 };
	
});