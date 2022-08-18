package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //DIP 원칙 준수. 추상화에 의존하고 있으며, memberRepository안에 무슨 method를 사용하는지 impl은 모른다

    //객체 생성
    //인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입될 경우 구현 객체의 번지가 저장됩니다.


    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) { //가입 기능
        memberRepository.save(member); //join 호출시 MemoryMemberRepository에서 save 메소드 실행

    }

    @Override
    public Member findMember(Long memberId) { //회원 조회 기능
        return memberRepository.findById(memberId); //MemoryMemberRepository에서 findById를 함. 매개값은 memberId
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
