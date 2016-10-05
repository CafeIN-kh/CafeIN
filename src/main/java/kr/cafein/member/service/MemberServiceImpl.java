package kr.cafein.member.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kr.cafein.customizing.dao.CustomizingMapper;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.member.dao.MemberMapper;
import kr.cafein.pcafe.dao.PCafeMapper;
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
	public void deleteLevel(String u_uid) {
		
		memberMapper.deleteLevel(u_uid); // update level =4  ���� ����
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
	public void deleteAll(String u_uid) {
		/*// id�� �ۼ��� �θ���� ��ȣ�� ����
		List <Integer> seq = boardMapper.selectSeqById(id);
		// �ش� id�� �ۼ��� �θ�ۿ� �޸� ��� ����
		if(seq!=null && !seq.isEmpty()){
			boardMapper.deleteReplyBySeqList(seq);
		}
		
		// �ش� id�� �ۼ��� ��� ����
		boardMapper.deleteReplyById(id);
		// �ش� id�� �ۼ��� �θ�� ����
		boardMapper.deleteById(id);
		
		// �ش� id ����
		*/
		
		
		
		// ����ī�� �Խñ�, ���� ��� ����
		// 1. �ش� ȸ���� �ۼ��� pcafe_num ���ϱ�
		List<Integer> pCafeSeq =  pcafeMapper.selectPCafeSeqByUid(u_uid); 
		
		System.err.println(pCafeSeq);
		// 2. ���� pCafeseq ���� ���� ���� ����
		for(int i=0; i < pCafeSeq.size() ; i++){
			
			//private_cafe�� �����ִ� ���ƿ� ��� ����
			pcafeMapper.deleteLikeByPCafe(pCafeSeq.get(i));
			System.err.println("private_cafe�� �����ִ� ���ƿ� ��� ����");
			
			//private_cafe�� �����ִ� ���ã�� ��� ����
			pcafeMapper.deleteBookmarkByPCafe(pCafeSeq.get(i));
			System.err.println("private_cafe�� �����ִ� ���ã�� ��� ����");
			
			//private_cafe�� �޷��ִ� ��� ��� ����
			pcafeMapper.deletePCafeReplyByPCafe(pCafeSeq.get(i));
			System.err.println("private_cafe�� �޷��ִ� ��� ��� ����");
			
			
			//private_cafe���� ��� �޴� ã��(�޴��� ���ƿ� �����ֱ� ���ؼ�)
			List<PCafeMenuCommand> pcafeMenuCommand = null;
			pcafeMenuCommand = pcafeMapper.selectPCafeMenuByPCafe(pCafeSeq.get(i));
			
			
			//private_cafe_menu�� �����ִ� ���ƿ� ��� ����
			for(int j=0; j<pcafeMenuCommand.size(); j++) {
				int pmenu_num = pcafeMenuCommand.get(j).getPmenu_num();
				pcafeMapper.deletePCafeMenuLikekByPCafe(pmenu_num);
				System.err.println("private_cafe_menu�� �����ִ� ���ƿ� ��� ����");
				
				//�ش� pmenu_num�� ���ε�� �̹��� �����
				String saveMenuName = pcafeMenuCommand.get(j).getPmenu_img();
				File file = new File (FileUtil_PrivateMenu.UPLOAD_PATH + "/" + saveMenuName);
				if(file.exists()){		//������ �����Ѵٸ�
					if(file.delete()) {	//�ش� �̹���or���丮 ����
						System.err.println("����ī�� �޴��� �̹��� ���� �Ϸ� : " + saveMenuName);
					}else {
						System.err.println("����ī�� �޴��� �̹��� ���� ���� : " + saveMenuName);
					}
				}
				
			}
			
			
			
			//private_cafe���� �ش� �޴� ��� ����
			pcafeMapper.deleteMenuByPCafe(pCafeSeq.get(i));
			System.err.println("�޴� ���� �Ϸ�");
			
			//����ī���� �̹������� ����� ���� ����ī�� ���� ã��
			PCafeCommand pcafeCommand = pcafeMapper.selectPCafe(pCafeSeq.get(i));
			String pcafeImgName = pcafeCommand.getPcafe_img();
		    String[] pcafeImgNameArray;
		    
		    //���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
		    pcafeImgNameArray = pcafeImgName.split(",");
		    for (int x = 0; x < pcafeImgNameArray.length; x++) {
				//pcafeImgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
				if(pcafeImgNameArray[x].indexOf("*") != -1){
					//*�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
					//��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
					pcafeImgNameArray[x] = pcafeImgNameArray[x].replace("*","");
				}
			}
		    
			
		    
		    //����ī�信 ���ε�� �̹��� �����
		    File pcafeFile;
		    for(int j = 0; j < pcafeImgNameArray.length; j++) {
				pcafeFile = new File (FileUtil_Private.UPLOAD_PATH + "/" + pcafeImgNameArray[j]);
				if(pcafeFile.exists()){		//������ �����Ѵٸ�
					if(pcafeFile.delete()) {	//�ش� �̹���or���丮 ����
						System.err.println("����ī���� �̹��� ���� �Ϸ� : " + pcafeImgNameArray[j]);
					}else {
						System.err.println("����ī���� �̹��� ���� ���� : " + pcafeImgNameArray[j]);
					}
				}
		    }
		    
		    
		  //�ش� private_cafe ���� ����
		    //�Ķ���� �ΰ��� mapper�� �ѱ� �� �����Ƿ� map �������� �ѱ�
		    HashMap<String,Object> deleteMap = new HashMap<String,Object>();
		    deleteMap.put("pcafe_num", pCafeSeq.get(i));
		    deleteMap.put("u_uid", u_uid);
		    pcafeMapper.deletePCafe(deleteMap);
		    System.err.println("����ī�� ���� ���� �Ϸ�");
		
		  
		   
			
		} // End for pCafeSeq.get(i)
		
		
		 //-----------------------------------
	    /*
		//�ش� u_uid�� �ۼ��� 
		customizingMapper.deleteCboard(custom_num);*/
		
		
		
		// Ŀ���� ���ƿ�, ���ã��, Ŀ���� ���� ����, Ŀ���� �ѿ� ����� ���
		// ���ƿ� ���ã�� ���̺� �ִ� ��� ���� 
		
		
		
		// user ���̺� ����
		//memberMapper.deleteAll(u_uid); 
	}




}
