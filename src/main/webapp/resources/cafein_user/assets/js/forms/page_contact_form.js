var PageContactForm = function () {
//개인카페 메뉴추가에서 사용중
    return {
        
        //Contact Form
        initPageContactForm: function () {
	        // Validation
	        $("#sky-form5").validate({
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
	                message:
	                {
	                    required: true,
	                    minlength: 10
	                },
	                captcha:
	                {
	                    required: true,
	                    //remote: 'assets/plugins/sky-forms/version-2.0.1/captcha/process.php'
	                },
	                /*개인카페 메뉴 등록 부분*/
	                pmenu_name:
	                {
	                	required: true
	                },     
	                pmenu_price:
	                {
	                	required: true
	                },     
	                pmenu_introduce:
	                {
	                	required: true
	                },     
	                upload_menu:
	                {
	                	required: true
	                },
	                /*개인카페 메뉴 등록 부분 END*/
	                d_content:
	                {
	                	required: true
	                } 
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
	                message:
	                {
	                    required: 'Please enter your message'
	                },
	                captcha:
	                {
	                    required: 'Please enter characters',
	                    remote: 'Correct captcha is required'
	                },
	                /*개인카페 메뉴 등록 부분*/
	                pmenu_name:
	                {
	                	required: 'Please enter your menu',
	                },     
	                pmenu_price:
	                {
	                	required: 'Please enter your price',
	                },     
	                pmenu_introduce:
	                {
	                	required: 'Please enter your introduce',
	                },     
	                upload_menu:
	                {
	                	required: 'Please enter your file upload',
	                	remote: 'Correct File is required'
	                },
	                /*개인카페 메뉴 등록 부분 END*/
	                d_content:
	                {
	                	required: 'Please select your declear content'
	                } 
	            },
	                                
	            // Ajax form submition                  
	            submitHandler: function(form)
	            {
	                $(form).ajaxSubmit(
	                {
	                    beforeSend: function()
	                    {
	                        $('#sky-form5 button[type="submit"]').attr('disabled', true);
	                        $('.modal').hide();
	                        //alert("beforesend");
	                    },
	                    success: function()
	                    {
	                    	//alert("success");
	                        $("#sky-form5").addClass('submited');
	                        location.reload();
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