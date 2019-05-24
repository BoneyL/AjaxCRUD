package cafe.jjdev.ajaxcrud.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxcrud.member.vo.Member;

@Mapper
public interface MemberMapper {
	public List<Member> selectMemberList();
	public int insertMember(Member member);
	public int deleteMember(Member member);
	public int updateMember(Member member);

}
