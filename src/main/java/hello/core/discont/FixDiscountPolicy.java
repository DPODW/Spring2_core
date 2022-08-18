package hello.core.discont;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;
    //할인 값 1000원을 생성
    //++고정 할인 정책임(VIP는 무조건 1000원 할인.)

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){ //등급이 VIP라면
            return discountFixAmount; //1000을 반환한다
            //여기서 당장 할인을 하는것이 아닌, 1000원 권환을 주면서 할인을 허락한다는 뜻으로 이해하면 편하다
        }else{
        return 0;}
    }
}
