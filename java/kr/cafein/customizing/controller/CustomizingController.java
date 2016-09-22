package kr.cafein.customizing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("command")
public class CustomizingController {

	@RequestMapping(value="/cafein_user/customizing/customizing_main.do", method = RequestMethod.GET)
	public String customizing_main() {
		return "customizing_main";
	}
	
}
