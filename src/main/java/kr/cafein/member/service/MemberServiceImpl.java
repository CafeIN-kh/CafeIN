package kr.cafein.member.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.customizing.dao.CustomizingMapper;
import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.UserLogCommand;
import kr.cafein.member.dao.MemberMapper;
import kr.cafein.pcafe.dao.PCafeMapper;
import kr.cafein.util.FileUtilCus;
import kr.cafein.util.FileUtil_Private;
import kr.cafein.util.FileUtil_PrivateMenu;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource
	private MemberMapper memberMapper;
	
	@Resource
	private PCafeMapper pcafeMapper;

	@Resource
	private CustomizingMapper customizingMapper;
	
	
	
	@Override
	public void insert(MemberCommand member) {
		memberMapper.insert(member);
	}

	@Override
	public MemberCommand selectMember(String u_uid) {
		return memberMapper.selectMember(u_uid);
	}

	@Override
	public void update(MemberCommand member) {
		memberMapper.update(member);
	}

	@Override
	public String selectUid(String u_email) {
		// TODO Auto-generated method stub
		return memberMapper.selectUid(u_email);
	}

	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return memberMapper.getMemberCount();
	}

	@Override
	public List<MemberCommand> getMemberList(Map<String, Object> map) {
		
		return memberMapper.getMemberList(map);
	}

	@Override
	public List<MemberCommand> getAllMemberList() {
		// TODO Auto-generated method stub
		return memberMapper.getAllMemberList();
	}

	@Override
	public void insertMemberUserLog(UserLogCommand userLog) {
		memberMapper.insertMemberUserLog(userLog);
	}

	@Override
	public MemberCommand selectMemberUserLogByUid(String u_uid) {
		return memberMapper.selectMemberUserLogByUid(u_uid);
	}

	@Override
	public void deleteLevel(String u_uid) {
		memberMapper.deleteLevel(u_uid);
	}

	@Override
	public void deleteAll(String u_uid) {
		//-------------- private 삭제 ----------------
		
		// 개인카페 게시글, 연결 댓글 삭제
		// 1. 해당 회원이 작성한 pcafe_num 구하기
		List<Integer> pCafeSeq =  pcafeMapper.selectPCafeSeqByUid(u_uid); 
		
		System.err.println(pCafeSeq);
		// 2. 구한 pCafeseq 값에 따라 삭제 시작
		for(int i=0; i < pCafeSeq.size() ; i++){
			
			//private_cafe에 눌려있는 좋아요 모두 삭제
			pcafeMapper.deleteLikeByPCafe(pCafeSeq.get(i));
			System.err.println("private_cafe에 눌려있는 좋아요 모두 삭제");
			
			//private_cafe에 눌려있는 즐겨찾기 모두 삭제
			pcafeMapper.deleteBookmarkByPCafe(pCafeSeq.get(i));
			System.err.println("private_cafe에 눌려있는 즐겨찾기 모두 삭제");
			
			//private_cafe에 달려있는 댓글 모두 삭제
			pcafeMapper.deletePCafeReplyByPCafe(pCafeSeq.get(i));
			System.err.println("private_cafe에 달려있는 댓글 모두 삭제");
			
			
			//private_cafe안의 모든 메뉴 찾기(메뉴의 좋아요 지워주기 위해서)
			List<PCafeMenuCommand> pcafeMenuCommand = null;
			pcafeMenuCommand = pcafeMapper.selectPCafeMenuByPCafe(pCafeSeq.get(i));
			
			
			//private_cafe_menu에 눌려있는 좋아요 모두 삭제
			for(int j=0; j<pcafeMenuCommand.size(); j++) {
				int pmenu_num = pcafeMenuCommand.get(j).getPmenu_num();
				pcafeMapper.deletePCafeMenuLikekByPCafe(pmenu_num);
				System.err.println("private_cafe_menu에 눌려있는 좋아요 모두 삭제");
				
				//해당 pmenu_num에 업로드된 이미지 지우기
				String saveMenuName = pcafeMenuCommand.get(j).getPmenu_img();
				File file = new File (FileUtil_PrivateMenu.UPLOAD_PATH + "/" + saveMenuName);
				if(file.exists()){		//파일이 존재한다면
					if(file.delete()) {	//해당 이미지or디렉토리 삭제
						System.err.println("개인카페 메뉴의 이미지 삭제 완료 : " + saveMenuName);
					}else {
						System.err.println("개인카페 메뉴의 이미지 삭제 실패 : " + saveMenuName);
					}
				}
				
			}
			
			
			
			//private_cafe안의 해당 메뉴 모두 삭제
			pcafeMapper.deleteMenuByPCafe(pCafeSeq.get(i));
			System.err.println("메뉴 삭제 완료");
			
			//개인카페의 이미지들을 지우기 위해 개인카페 정보 찾기
			PCafeCommand pcafeCommand = pcafeMapper.selectPCafe(pCafeSeq.get(i));
			String pcafeImgName = pcafeCommand.getPcafe_img();
		    String[] pcafeImgNameArray;
		    
		    //문자열에 ,가 있다면 쪼개서 배열에 담기
		    pcafeImgNameArray = pcafeImgName.split(",");
		    for (int x = 0; x < pcafeImgNameArray.length; x++) {
				//pcafeImgNameArray 인덱스 안에 * 값이 없으면 -1 반환
				if(pcafeImgNameArray[x].indexOf("*") != -1){
					//*이 있다는 것이므로 *표를 빈값으로 대체
					//대표이미지 찾아서 *표시 없애주기
					pcafeImgNameArray[x] = pcafeImgNameArray[x].replace("*","");
				}
			}
		    
			
		    
		    //개인카페에 업로드된 이미지 지우기
		    File pcafeFile;
		    for(int j = 0; j < pcafeImgNameArray.length; j++) {
				pcafeFile = new File (FileUtil_Private.UPLOAD_PATH + "/" + pcafeImgNameArray[j]);
				if(pcafeFile.exists()){		//파일이 존재한다면
					if(pcafeFile.delete()) {	//해당 이미지or디렉토리 삭제
						System.err.println("개인카페의 이미지 삭제 완료 : " + pcafeImgNameArray[j]);
					}else {
						System.err.println("개인카페의 이미지 삭제 실패 : " + pcafeImgNameArray[j]);
					}
				}
		    }
		    
		    
		  //해당 private_cafe 정보 삭제
		    //파라미터 두개를 mapper에 넘길 수 없으므로 map 형식으로 넘김
		    HashMap<String,Object> deleteMap = new HashMap<String,Object>();
		    deleteMap.put("pcafe_num", pCafeSeq.get(i));
		    deleteMap.put("u_uid", u_uid);
		    pcafeMapper.deletePCafe(deleteMap);
		    System.err.println("개인카페 정보 삭제 완료");
		
		  
		   
			
		} // End for pCafeSeq.get(i)
		
		
		 //-----------------------------------
	  
		
		//----------- custom 삭제 --------------
		
		
		// 커스텀 좋아요, 즐겨찾기, 커스텀 넘을 지움, 커스텀 넘에 연결된 댓글
		
		// 해당 u_uid가 만든 커스텀의 seq 값
		List<Integer> customSeq = customizingMapper.selectCustomSeqByUid(u_uid);
		
		System.err.println(customSeq);
		
		
		for(int z=0; z < customSeq.size() ; z++){
			
			CustomizingCommand customizingCommand = customizingMapper.selectBoard(customSeq.get(z));
			
			
			//글 삭제
			customizingMapper.deleteU_like(customSeq.get(z));
			customizingMapper.deleteBookmark(customSeq.get(z));
			customizingMapper.deleteReply(customSeq.get(z));
			customizingMapper.deleteCboard(customSeq.get(z));
			
			//파일 삭제 여부 체크
			if(customizingCommand.getCustom_img() != null) {
				FileUtilCus.removeFile(customizingCommand.getCustom_img());
			}
			
		}
		
		
		//-----------------End customizing ----------------------
		//-------------------------------------------------------
		//즐겨찾기 (Bookmark) 테이블에 있는 모든 정보 // memberMapper 에 작성함
		
		memberMapper.deleteBookmark(u_uid);
		
		// 좋아요 
		memberMapper.deleteUlike(u_uid);
		
		// user 테이블 삭제
		memberMapper.deleteAll(u_uid); 
		
		
		//!!! 회원의 게시글이 아닌 다른 사람의 개인카페등의 게시글에 작성한 private_Cafe_reply 는 삭제되지 않음.
		//  신고 테이블의 값은 삭제되지 않음. -> 탈퇴 회원이라고만 뜸
	}




}
