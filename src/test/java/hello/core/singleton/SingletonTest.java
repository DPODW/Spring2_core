package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링이 없는 순수한 di 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1.조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2.조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //호출할때 마다 객체를 생성하면, jvm에 계속해서 객체가 쌓이고, 이것은 효율적이지 못한 방법으로 귀결된다

        assertThat(memberService1).isNotSameAs(memberService2);


        }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 =" + singletonService1);
        System.out.println("singletonService2 =" + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

    }


    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    //순수 자바와 다르게, 싱글톤 관련된 코드는 단 한줄도 작성되지 않았다. 그러나 Spring Container에 의해서 모두 싱글톤으로 관리된다.
    //Bean을 돌려가며 쓰는 방식이라 생각하면 된다
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        System.out.println("singletonService1 =" + memberService1);
        System.out.println("singletonService2 =" + memberService2);

        assertThat(memberService1).isSameAs(memberService2);

    }


        }

