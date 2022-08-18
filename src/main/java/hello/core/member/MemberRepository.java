package hello.core.member;

public interface MemberRepository {
    //DB INTERFACE
    void save(Member member);

    Member findById(Long memberId);
}
