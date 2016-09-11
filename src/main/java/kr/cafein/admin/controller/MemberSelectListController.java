package kr.cafein.admin.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.MemberCommand;
import kr.cafein.member.service.MemberService;

// spring MVC�� Controller Ŭ���� ������ �ܼ�ȭ�����ش�.
//������ ��Ʈ�ѷ�, ������ ����� �ʿ䰡 ������, @Controller�� ��ϵ� Ŭ���� ���Ͽ� ���� bean�� �ڵ����� �������ش�.
@Controller
public class MemberSelectListController {
   //�α�ó��
   private Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name="memberService")
   private MemberService memberService;
   
   	   // 2. ȣ��� ��Ʈ�ѷ�  @RequestMapping - URL�� ��Ʈ�ѷ��� �޼���� ������ �� ����Ѵ�.
	   // method ���� �������� �ʴ� ��� ��� HTTP Request method�� ���ؼ� ó��
   		// value ���� Ŭ���� ���� ������ @RequestMapping�� value ���� ��ӹ޴´�. 
   @RequestMapping("/admin/memberlist.do") 
   public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")
                                    int currentPage){
	   // ModelAndView - �� ���� �� �� ������ ��� �ִ� ModelAndView ��ü 
	   
/*@RequestParam annotation�� key=value ���·� ȭ�鿡�� �Ѿ���� ������Ʈ�� 
	   Ȥ�� �� �����͸� �޼ҵ��� �Ķ���ͷ� �����Ѵ�. ��ü�� �Ķ������ ������ ������ ����Ѵ�.
	 
	   method( @RequestParam( PARAM ) Obj )
	   method( @RequestParam Map)
PARAM: ���޵Ǵ� �Ķ������ �̸��� �����Ѵ�. �̸� �ܿ� �⺻��(defaultValue), �ʼ�����(required)��  ������ �� �ִ�.
 		���� �Ҵ�� ������ Ÿ���� Map Ȥ�� MultiValueMap�� �� ������� �ʴ´�.
Obj: PARAM���� ������ �̸��� ��ġ�ϴ� �Ķ������ ���� �Ҵ��� ����. ���� String Ÿ���� ���������� �Ѿ�� ���� �ݵ�� ������ ��쿡 ���ؼ� int ���� ���� Ÿ�Ե� �����ϴ�.

@RequestParam ������̼��� ����� �Ķ���ʹ� �⺻������ �ʼ� �Ķ�����̴�.
����, ����� �Ķ���Ͱ� �������� ���� ��� 400 ������ �߻��Ѵ�.
�ʼ� ����� �ƴ� ���, @RequestParam(value="id", required="false")�� ���� �ɼ��� �ְ� ����� �� �ִ�.



Map ��� (N:1 ����)

���� �Ҵ��� ������ Ÿ���� Map Ȥ�� MultiValueMap���� ����ϴ� ���.

@RequestMapping("/faqDetail")
public String faqDetail(@RequestParam HashMap<String, String> map) {
    String searchValue = map.get("searchValue"); 
    // req.getParameter("searchValue") �� ����.
 
    return "/board/faq/faqDetail";
}

*/
	   
	   
      if(log.isDebugEnabled()){
         log.debug("pageNum : " + currentPage);
      }
      
      int count = memberService.getMemberCount(); // ȸ���� �� ���� ����
      
     // PagingUtil page = new PagingUtil(currentPage,count,20,20,"memberlist.do");
      
      List<MemberCommand> list = null;
      if(count>0){
    	  
    	 /* Map, ModelMap

    	  �信 ������ ��ü ������ ��� �ִ� Map Ȥ�� ModelMap�� �����Ѵ�. �̶� �� �̸��� ��û URL�κ��� �����ȴ�. 
    	  */
    	  
    	  Map<String,Object> map = new HashMap<String,Object>();
    	
    	  
    	  list = memberService.getAllMemberList();
      }else{
    	  list = Collections.emptyList();
      }
      
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("memberManagement");
      mav.addObject("count", count);
      mav.addObject("list", list);
     
     
      return mav;
   }
   
}