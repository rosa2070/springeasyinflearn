package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given : 뭔가 주어졌는데
        Member member = new Member();
        member.setName("spring");

        // when : 이걸 실행했을 때
        Long saveId = memberService.join(member);

        // then : 결과가 이게 나와야 해 (검증)
        Member findMember = memberService.findOne(saveId).get();
        // assertj의 Assertions
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        // given
        // member1, member2의 이름을 모두 spring으로 해보자
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        // join도 두 번 해보자
        memberService.join(member1);
        // asserThrows의 오른쪽 매개변수에 있는 로직이 실행되면,
        // 왼쪽 매개변수에 있는 예외(IllegalStateException)가 터져야 함
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try {
            memberService.join(member2);
            // 중복회원이므로 catch문으로 안 내려가면 실패
            fail();
        } catch(IllegalStateException e) {
            // 성공하면 에외가 터져 catch문으로 옴
            // message가 MemberService의 validateDuplicateMember 메소드 안의 메시지와 같아야 함
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        // then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}