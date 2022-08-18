package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest
{

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given: 무언가가 주어졌는데
        Member member = new Member(1L, "memberA" , Grade.VIP); //test를 위한 데이터 주입
        //when : 이걸로 실행했을때
        memberService.join(member); //가입 실행
        Member findMember = memberService.findMember(1L); //아이디가 1인 (l은 long타입이기 때문에) 정보 검색
        //then : 결과가 이게 나와야함
        Assertions.assertThat(member).isEqualTo(findMember); //정상 검색 검증을 위한 코드
        //member안에    들어있는 정보와, findmember을 통해 찾은 정보가 일치하는지 확인
        }
        }
