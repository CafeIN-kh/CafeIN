var ContactForm = function () {
//커스텀마이징 수정폼 사용
    return {
        
        //Contact Form
        initContactForm: function () {
	        // Validation
	        $("#sky-form3").validate({
	            // Rules for form validation
	            rules:
	            {
	                name:
	                {
	                    required: true
	                },
	                title:
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
	                    minlength: 3,
	                    maxlength: 20
	                },
	                message:
	                {
	                    required: true,
	                    minlength: 10
	                },
	                captcha:
	                {
	                    required: true,
	                    remote: '/CafeIN/resources/cafein_user/assets/plugins/sky-forms-pro/skyforms/captcha/process.php'
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
	                name:
	                {
	                    required: 'Please enter your name',
	                },
	                title:
	                {
	                	reauired: 'Please enter yout title',
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
	                message:
	                {
	                    required: 'Please enter your message'
	                },
	                captcha:
	                {
	                    required: 'Please enter characters',
	                    remote: 'Correct captcha is required'
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
	                        $('#sky-form3 button[type="submit"]').attr('disabled', true);
	                        $('.modal').hide();
	                        alert("beforesend");
	                        //alert("beforesend upload_modify : " + $('#upload_modify').val());
	                    },
	                    success: function(data)
	                    {
	                    	alert("success");
	                        $("#sky-form3").addClass('submited');
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