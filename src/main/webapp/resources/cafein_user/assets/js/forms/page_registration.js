var Registration = function () {
//로그인에서 사용,개인카페 신고 모달에서 사용
    return {
        
        //Registration Form
        initRegistration: function () {
	        // Validation       
	        $("#sky-form4").validate({                   
	            // Rules for form validation
	            rules:
	            {
	                username:
	                {
	                    required: true
	                },
	                email:
	                {
	                    required: true,
	                    email: true
	                },
	                password:
	                {
	                    required: true,
	                    minlength: 4,
	                    maxlength: 20
	                },
	                passwordConfirm:
	                {
	                    required: true,
	                    minlength: 4,
	                    maxlength: 20,
	                    equalTo: '#password'
	                },
	                firstname:
	                {
	                    required: true
	                },
	                lastname:
	                {
	                    required: true
	                },
	                terms:
	                {
	                    required: true
	                },
	                mem_id:
	                {
	                	required: true
	                },
	                d_mem_id:
	                {
	                	required: true
	                },
	                d_content:
	                {
	                	required: true
	                }          
	            },
	            
	            // Messages for form validation
	            messages:
	            {
	                login:
	                {
	                    required: 'Please enter your login'
	                },
	                email:
	                {
	                    required: 'Please enter your email address',
	                    email: 'Please enter a VALID email address'
	                },
	                password:
	                {
	                    required: 'Please enter your password'
	                },
	                passwordConfirm:
	                {
	                    required: 'Please enter your password one more time',
	                    equalTo: 'Please enter the same password as above'
	                },
	                firstname:
	                {
	                    required: 'Please select your first name'
	                },
	                lastname:
	                {
	                    required: 'Please select your last name'
	                },
	                terms:
	                {
	                    required: 'You must agree with Terms and Conditions'
	                },
	                mem_id:
	                {
	                	required: 'Please select your name'
	                },
	                d_mem_id:
	                {
	                	required: 'Please select your name'
	                },
	                d_content:
	                {
	                	required: 'Please select your declear content'
	                } 
	            },                  
	            
	            // Do not change code below
	            errorPlacement: function(error, element)
	            {
	                error.insertAfter(element.parent());
	            }
	        });
        }

    };
}();