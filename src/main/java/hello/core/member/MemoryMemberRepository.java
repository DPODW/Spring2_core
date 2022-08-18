package hello.core.member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{
    //DB. 현재는 외부DB를 사용하지 않고, 컴퓨터 메모리 DB를 사용한다 ++MemberRepository의 구현 class 이다
    //즉 db의 역할도 하면서, 동시에 구현 class의 기능도 가진다 (메모리 db니까 hashmap)
    //주문 설계의 최하단부.

    private static Map<Long, Member> store = new HashMap<>(); //hash map 형태로 저장
    //name: long , id:member 

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //해쉬맵인 STORE에  해당 정보 저장


    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //해쉬맵에서 GET 을 통하여 아이디 추출
    }
}
