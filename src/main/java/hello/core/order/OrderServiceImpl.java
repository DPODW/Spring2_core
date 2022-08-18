package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discont.DiscountPolicy;
import hello.core.discont.FixDiscountPolicy;
import hello.core.discont.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor //LomBok의 기능. final이 붙은 생성자를 보면, 알아서 만들어준다 (ctrl + f12를 누르면 확인 가능)
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
  //생성자 주입의 장점: final 키워드 사용 가능 생성자 주입을 사용하면 필드에 final 키워드를 사용할 수 있다. 그래서 생성자에서 혹시라도 값이
  //설정되지 않는 오류를 컴파일 시점에 막아준다
    
    //@RequiredArgsConstructor의 사용으로 인한 수동 생성자 각주 처리
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    
    
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//   //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입될 경우 구현 객체의 번지가 저장됩니다.


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //DISCOUNT에 MEMBER을 넘겨서 알아서 등급및 그런걸 판단, 계산한다

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }




}
