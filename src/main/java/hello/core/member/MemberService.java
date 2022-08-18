package hello.core.member;

public interface MemberService {

    //Service Interface
    void join(Member member);
    Member findMember(Long memberId);
}
