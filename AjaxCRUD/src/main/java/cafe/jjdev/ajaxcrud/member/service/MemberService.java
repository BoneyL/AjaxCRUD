package cafe.jjdev.ajaxcrud.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.member.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Transactional
	public Map<String, Object> selectMemberList(int currentPage){
		System.out.println("======MemberService selectMemberList======");
		System.out.println("currentPage : " + currentPage );
		
		Map<String, Object> map = new HashMap<String, Object>();
		final int rowPerPage = 15;	
		int StartRow = (currentPage - 1)* rowPerPage;
		List<Member> list = memberMapper.selectMemberList(StartRow, rowPerPage);
		map.put("list", list);
			
		int memberCount = memberMapper.selectMemberCount();
		int lastPage = memberCount/rowPerPage;
		if(memberCount%rowPerPage != 0) {
			lastPage++;
		}
		
		final int pageRange = 10;
		int startPage = ((currentPage -1) / pageRange) * pageRange + 1;
		int endPage = startPage + pageRange-1;
		int currentPageBlock = currentPage/pageRange + 1;
		if(currentPage%pageRange == 0) {
			currentPageBlock--;
		}
		int lastPageBlock = lastPage/pageRange +1;
		if(lastPage%pageRange == 0) {
			lastPageBlock--;
		}
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		
		
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("currentPageBlock", currentPageBlock);
		map.put("lastPageBlock", lastPageBlock);
		map.put("currentPage", currentPage);
			
		
		return map;
		
	}
}

