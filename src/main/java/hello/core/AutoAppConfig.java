package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        //탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다
        basePackageClasses = AutoAppConfig.class,
        //클래스를 기준으로 탐색


        excludeFilters = @ComponentScan.Filter(type  = FilterType.ANNOTATION, classes = Configuration.class)
        //ComponentScan을 할때, 필터링 할 값을 주는 코드로(스캔 하지 않을 값) 필터 타입은 어노테이션, 필터링할 클래스는 configuration.class이다
        //해당 클래스를 제외 스캔 하는 이유는, ComponentScan이 모든 코드를 읽고 자동 빈을 생성해주는 기능인데, Configuration은 수동으로 빈을 생성해준다
        //즉 우리가 가진 AppConfig가 빈을 수동으로 또 만들기 때문에 충돌이 날수 있기 때문이다 (우리가 만든 다른 config도 마찬가지)
        //기존 예제코드를 최대한 남기기 위해 이렇게 함
        
)
public class AutoAppConfig {
}
