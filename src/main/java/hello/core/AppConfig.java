package hello.core;

import hello.core.discont.DiscountPolicy;
import hello.core.discont.FixDiscountPolicy;
import hello.core.discont.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
    // 애플리케이션 실제 동작에 필요한 구현 객체 생성
    //AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다

    //++appconfig 리펙토링 -> 중복되는 부분을 제거하고, 참조값으로 줄 객체들을 생성자로 만든다. 그리고 그 생성자를 참조값으로 부여

     //시작
    @Bean
    public MemberService memberService() { //memberservice 호출시, 해당 interface의 구현체인 impl 호출
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() { //위와 진행 방식 동일
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    //끝 (리펙토링[중복 제거] 한 코드)

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
}
