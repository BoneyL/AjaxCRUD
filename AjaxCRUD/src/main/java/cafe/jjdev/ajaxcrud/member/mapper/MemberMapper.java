package cafe.jjdev.ajaxcrud.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxcrud.member.vo.Member;

@Mapper
public interface MemberMapper {
	public int selectMemberCount();
	public List<Member> selectMemberList(int StartRow, int rowPerPage);
	public int insertMember(Member member);
	public int deleteMember(Member member);
	public int updateMember(Member member);

}
