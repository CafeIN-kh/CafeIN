var ContactForm = function () {
//커스텀마이징 수정 폼에서 사용
    return {
        
        //Contact Form
        initContactForm: function () {
	        // Validation
	        $("#sky-form3").validate({
	            // Rules for form validation
	            rules:
	            {
	            	custom_name:
	                {
	                    required: true
	                },
	                custom_introduce:
                	{
	                	required: true
                	},
                	custom_recipe:
	                {
	                    required: true
	                },
	                custom_hash_tag:
	                {
	                    required: true
	                },
	                franchise_num:
	                {
	                	required: true
	                }
/*	                captcha:
	                {
	                    required: true,
	                    remote: '/CafeIN/resources/cafein_user/assets/plugins/sky-forms-pro/skyforms/captcha/process.php'
	                },*/
	                /*pcafe_img:
	                {
	                	required: true,
	                    remote: '/CafeIN/resources/cafein_user/assets/plugins/sky-forms-pro/skyforms/captcha/process.php'
	                },*/             
	            },
	                                
	            // Messages for form validation
	            messages:
	            {
	            	custom_name:
	                {
	                    required: 'Please enter your custom_menu_name',
	                },
	                custom_introduce:
	                {
	                	required: 'Please enter your custom_introduce',
	                },
	                custom_recipe:
	                {
	                    required: 'Please enter your custom_recipe',
	                },
	                franchise_num:
	                {
	                    required: 'Please enter your custom_recipe',
	                },
	                custom_hash_tag:
	                {
	                    required: 'Please enter your custom_tag',
	                }
/*	                captcha:
	                {
	                    required: 'Please enter characters',
	                    remote: 'Correct captcha is required'
	                },*/
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
	                    },
	                    success: function()
	                    {
	                    	var custom_num = $('#custom_num').val();
	                    	var u_uid = $('#u_uid').val();
	                    	var franchise_num = $('#franchise_num').val();
	                    	
	                        $("#sky-form3").addClass('submited');
	                        alert("메뉴 글 수정 완료");
	                        location.replace("/CafeIN/cafein_user/customizing/customizing_detail.do?custom_num="+custom_num+"&franchise_num="+franchise_num+"&u_uid="+u_uid);
	                    }
	                });
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