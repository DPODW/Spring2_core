package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //getBeanDefinitionNames: 빈의 이름을 가져옴
        for (String beanDefinitionName : beanDefinitionNames) { //for문을 통해서 빈 검색
            Object bean = ac.getBean(beanDefinitionName); //빈의 타입을 아직 모르기 때문에 type: object
            System.out.println("name = " + beanDefinitionName+ "object = " + bean);
            //beanDefinitionName: bean의 이름 , bean: 빈의 구체적인 내용까지 출력(구현체 까지 알려줌)

        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findAppBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //ROLE_APPLICATION: spring 자동 생성 빈 말고, 사용자가 임의로 제작한 빈을 검색
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName+ " object = " + bean);
            }

        }
    }
}
