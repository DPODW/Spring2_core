package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    //싱글톤 문제점 확인
    //객체가 하나로 통일 되면서, 만약 해당 객체에 값을 1번 이상 넣었을때, 값이 덮어 씌워지는 현상 발생
    //이상적인 설계 방식인 무설계 방식으로 해당 문제를 해결함
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
       int userAprice = statefulService1.order("userA",10000);

        //ThreadB: B사용자 20000원 주문
       int userBprice = statefulService2.order("userB",20000);

//        int price = statefulService1.getPrice(); //원래라면 만원이 나와야 이상적이지만, 싱글톤이 유지되면서 중간에 추가된 +이만원이 출력되게 됨됨
       System.out.println("price=  " + userAprice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }


    }

}