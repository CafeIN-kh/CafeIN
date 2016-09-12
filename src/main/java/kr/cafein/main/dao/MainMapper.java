package kr.cafein.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.MainBookmarkCommand;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.PrivateCafeMenuCommand;
import kr.cafein.domain.ULikeCommand;


@Repository
public interface MainMapper {
	
	// * 커스텀마이징 메뉴 좋아요 * 
	public List<ULikeCommand> uList(Map<String, Object> map);
	//좋아요 높은 커스텀마이징 메뉴 번호 구하기 (순서)
	@Select("select c.custom_num, count(*) custom_like from customizing c , u_like u where c.custom_num = u.custom_num and c.custom_num in (select custom_num from u_like) group by c.custom_num order by custom_like desc")
	public List<ULikeCommand> selectCLike();
	//커스텀 정보, 좋아요 수
	@Select("select cus.*,COALESCE(c, 0) as cCount from customizing cus left join (select custom_num,count(*) c from u_like group by custom_num) e on cus.custom_num = e.custom_num order by cCount desc")
	public List<CustomizingCommand> selectLikeCustomizing();
	
	// * 프랜차이즈 즐겨찾기 *
	public List<MainBookmarkCommand> bList(Map<String, Object> map);
	
	@Select("select * from (select f.franchise_num, f.franchise_name, f.franchise_img, f.franchise_introduce ,count(*) as count from franchise f, bookmark b where f.franchise_num =  b.franchise_num group by f.franchise_num, f.franchise_name, f.franchise_img, f.franchise_introduce order by count desc) where rownum =1")
	public FranchiseCommand selectBookmarkFranchise();
	
	
	// * 개인카페 즐겨찾기 *
	//즐겨찾기 높은 개인카페 번호 구하기(순서)
	
	//개인카페 번호에 따른 정보 구하기
	@Select("select p.pcafe_img, p.pcafe_num, p.pcafe_name, p.pcafe_reg_date, p.pcafe_introduce , count(*) count from private_cafe p join bookmark b on p.pcafe_num = b.pcafe_num and p.pcafe_num in (select pcafe_num from bookmark) group by p.pcafe_img, p.pcafe_num, p.pcafe_name, p.pcafe_reg_date, p.pcafe_introduce order by count desc")
	public List<PrivateCafeCommand> selectBookmarkPrivateCafe();
	
	//프랜차이즈 메뉴 좋아요
	public List<ULikeCommand> selectFMLike();
	@Select("select f.franchise_name, fm.fmenu_name, fm.fmenu_img, count(*) fcount from franchise f join franchise_menu fm on f.franchise_num = fm.franchise_num join u_like u on fm.fmenu_num = u.fmenu_num and fm.franchise_num in (select fmenu_num from u_like) group by f.franchise_name, fm.fmenu_name, fm.fmenu_img order by fcount desc")
	public List<FranchiseMenuCommand> selectLikeFmenu();
		
	
	//개인카페 메뉴 좋아요
	public List<ULikeCommand> selectPMLike();
	@Select("select p.pcafe_name, pm.pmenu_name, pm.pmenu_img, p.pcafe_reg_date, count(*) pcount from private_cafe p join private_cafe_menu pm on p.pcafe_num = pm.pcafe_num join u_like u on pm.pmenu_num = u.pmenu_num group by  p.pcafe_name,pm.pmenu_name,pm.pmenu_img, p.pcafe_reg_date order by pcount desc")
	public List<PrivateCafeMenuCommand> selectLikePmenu();
	
	
	
}
