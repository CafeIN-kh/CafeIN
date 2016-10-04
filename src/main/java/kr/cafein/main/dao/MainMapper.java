package kr.cafein.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.PrivateCafeMenuCommand;
import kr.cafein.domain.ULikeCommand;
import kr.cafein.domain.UserCountLogCommand;


@Repository
public interface MainMapper {
	
	// * Ŀ���Ҹ���¡ �޴� ���ƿ� * 
	//public List<ULikeCommand> uList(Map<String, Object> map);
	//���ƿ� ���� Ŀ���Ҹ���¡ �޴� ��ȣ ���ϱ� (����)
	@Select("select c.custom_num, count(*) custom_like from customizing c , u_like u where c.custom_num = u.custom_num and c.custom_num in (select custom_num from u_like) group by c.custom_num order by custom_like desc")
	public List<ULikeCommand> selectCLike();
	//Ŀ���� ����, ���ƿ� ��
	@Select("select cus.*,COALESCE(c, 0) as cCount from customizing cus left join (select custom_num,count(*) c from u_like group by custom_num) e on cus.custom_num = e.custom_num order by cCount desc")
	public List<CustomizingCommand> selectLikeCustomizing();
	
	// * ���������� ���ã�� *
	//public List<MainBookmarkCommand> bList(Map<String, Object> map);
	
	@Select("select * from (select f.franchise_num, f.franchise_name, f.franchise_img, f.franchise_introduce ,count(*) as count from franchise f, bookmark b where f.franchise_num =  b.franchise_num group by f.franchise_num, f.franchise_name, f.franchise_img, f.franchise_introduce order by count desc) where rownum =1")
	public FranchiseCommand selectBookmarkFranchise();
	
	
	// * ����ī�� ���ã�� *
	//���ã�� ���� ����ī�� ��ȣ ���ϱ�(����)
	
	//����ī�� ��ȣ�� ���� ���� ���ϱ�
	@Select("select p.pcafe_img, p.pcafe_num, p.pcafe_name, p.pcafe_reg_date, p.pcafe_introduce , count(*) count from private_cafe p join bookmark b on p.pcafe_num = b.pcafe_num and p.pcafe_num in (select pcafe_num from bookmark) group by p.pcafe_img, p.pcafe_num, p.pcafe_name, p.pcafe_reg_date, p.pcafe_introduce order by count desc")
	public List<PrivateCafeCommand> selectBookmarkPrivateCafe();
	
	//���������� �޴� ���ƿ�
	//public List<ULikeCommand> selectFMLike();
	@Select("select f.franchise_num, f.franchise_name, fm.fmenu_name, fm.fmenu_img, count(*) fcount from franchise f join franchise_menu fm on f.franchise_num = fm.franchise_num join u_like u on fm.fmenu_num = u.fmenu_num and fm.franchise_num in (select fmenu_num from u_like) group by f.franchise_num, f.franchise_name, fm.fmenu_name, fm.fmenu_img order by fcount desc")
	public List<FranchiseMenuCommand> selectLikeFmenu();
		
	
	//����ī�� �޴� ���ƿ�
	//public List<ULikeCommand> selectPMLike();
	@Select("select p.pcafe_num, p.pcafe_name, pm.pmenu_name, pm.pmenu_img, p.pcafe_reg_date, count(*) pcount from private_cafe p join private_cafe_menu pm on p.pcafe_num = pm.pcafe_num join u_like u on pm.pmenu_num = u.pmenu_num group by p.pcafe_num, p.pcafe_name,pm.pmenu_name,pm.pmenu_img, p.pcafe_reg_date order by pcount desc")
	public List<PrivateCafeMenuCommand> selectLikePmenu();
	
	//���� �������� �α�, ���� ��¥�� �����Ͱ� ������ insert, ������ update�� +1 ī��Ʈ
	@Insert("INSERT INTO user_count_log (ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) VALUES (user_count_log_seq.nextval,sysdate,0,0,0,0,0,0,0)")
	public void insertMainUserCountLog();
	@Update("UPDATE user_count_log SET ucnt_total=ucnt_total+1,ucnt_log_main=ucnt_log_main+1 WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public void updateMainUserCountLog();
	@Select("SELECT * FROM user_count_log WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public UserCountLogCommand selectMainUserCountLogByDate();
	
}
