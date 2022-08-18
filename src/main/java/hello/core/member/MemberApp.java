package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService =  appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //spring container 생성을 하려면 ApplicationContext객체를 생성해야 하고(하는 일은 모든 스프링 관련된 bean 같은걸 관리해줌)
        //AnnotationConfigApplicationContext 를 생성하고 매개값으로 appconfig.class를 값으로 준다.
        //그러면 스프링 컨테이너가 Appconfig.class에 있는 bean들을 다 관리 저장 해준다
        //이제 appconfig에서 직통으로 찾던걸, spring 을 통해서 찾아야 함


        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //(이름, 타입)
        //spring 을 통한 bean search

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
        //메인 메소드를 통한 test (console print)

    }
}
