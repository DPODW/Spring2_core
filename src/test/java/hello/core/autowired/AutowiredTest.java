package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    //옵션 처리 예제
    //ㄴ 주입할 스프링 빈이 없더라도, 동작해야할때가 있다. 그럴땐 자동 주입 옵션 기능을 사용하여 처리한다
    static class TestBean {

        @Autowired(required = false) //1번째 옵션 기능. 자동 빈 주입(Autowired)를 사용하되, require을 false로 지정함으로서, 빈이 없더라도 작동되게 만든다
        //기본값은 true이며 가져올 빈이 없는데 실행시, 예외 발생
        public void setNoBean(Member noBean1){ //Member class는 java class 이기 때문에 빈이 아니다. (vo)
            System.out.println("no Bean1 = " + noBean1);

        }

        @Autowired
        public void setNoBean1(@Nullable Member noBean2){ //2번째 옵션 기능. @Nullable어노테이션을 활용함으로서 자동 주입할 대상이 없을시, null 을 출력한다
            System.out.println("no Bean2 = " + noBean2);

        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){ //3번째 옵션 기능. java8 기능인 optional<>기능 사용
            //해당 기능은 매개값이 null 일수도 아닐수도 있을때 사용한다.
            //해당 매개값은 null 이니까 optional.empty를 출력
            System.out.println("no Bean3 = " + noBean3);
        }
    }
}