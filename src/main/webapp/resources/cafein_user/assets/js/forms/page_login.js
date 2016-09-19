var Login = function () {
//개인카페 등록/수정에서 사용중
    return {
        
        //Masking
        initLogin: function () {
	        // Validation for login form
	        $("#sky-form1").validate({
	            // Rules for form validation
	            rules:
	            {
	                email:
	                {
	                    required: true,
	                    email: true
	                },
	                password:
	                {
	                    required: true,
	                    minlength: 3,
	                    maxlength: 20
	                },
	                /*개인카페 등록 부분*/
	                upload:
	                {
	                	//카페 등록 부분 파일첨부 null 불허
	                	required: true
	                },
	                /*upload_modify:
	                {
	                	//카페 수정 부분은 파일첨부 null 허용
	                	required: false
	                },*/
	                pcafe_name:
	                {
	                	required: true
	                },
	                pcafe_phone:
	                {
	                	required: true
	                },
	                pcafe_address:
	                {
	                	required: true
	                },
	                pcafe_url:
	                {
	                	required: true
	                },
	                pcafe_time:
	                {
	                	required: true
	                },
	                pcafe_introduce:
	                {
	                	required: true
	                },
	                pcafe_hash_tag:
	                {
	                	required: true
	                }     
	                /*개인카페 등록 부분 END*/
	            },
	                                
	            // Messages for form validation
	            messages:
	            {
	                email:
	                {
	                    required: 'Please enter your email address',
	                    email: 'Please enter a VALID email address'
	                },
	                password:
	                {
	                    required: 'Please enter your password'
	                },
	                /*개인카페 등록 부분*/
	                upload:
	                {
	                	required: 'Please enter FileUpload',
	                    remote: 'Correct File is required'
	                },
	                /*upload_modify:
	                {
	                	required: 'Please enter FileUploadModify',
	                    remote: 'Correct File is required'
	                },*/
	                pcafe_name:
	                {
	                	required: 'Please enter your name',
	                },
	                pcafe_phone:
	                {
	                	required: 'Please enter your phone number',
	                },
	                pcafe_address:
	                {
	                	required: 'Please enter your address',
	                },
	                pcafe_url:
	                {
	                	required: 'Please enter your url',
	                },
	                pcafe_time:
	                {
	                	required: 'Please enter your time',
	                },
	                pcafe_introduce:
	                {
	                	required: 'Please enter your introduce',
	                },
	                pcafe_hash_tag:
	                {
	                	required: 'Please enter your tag',
	                }
	                /*개인카페 등록 부분 END*/
	            },
	            
	            // Ajax form submition                  
	            submitHandler: function(form)
	            {
	                $(form).ajaxSubmit(
	                {
	                    beforeSend: function()
	                    {
	                        $('#sky-form1 button[type="submit"]').attr('disabled', true);
	                        $('.modal').hide();
	                       // alert("beforesend");
	                        //alert("beforesend upload_modify : " + $('#upload_modify').val());
	                    },
	                    success: function(data)
	                    {
	                    	//alert("success");
	                        $("#sky-form1").addClass('submited');
	                        location.reload();
	                    }
	                });
	            },
	            
	            // Do not change code below
	            errorPlacement: function(error, element)
	            {
	            	//alert("error:" + error);
	                error.insertAfter(element.parent());
	            }
	        });
        }

    };

}();