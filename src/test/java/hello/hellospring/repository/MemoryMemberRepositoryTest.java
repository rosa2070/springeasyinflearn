package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 아래의 메서드들이 끝날 때마다 하는 동작
    @AfterEach
    public void afterEach() {
        repository.clearStore();

    }

    // 우리가 만들었던 save 기능이 제대로 동작하는지 테스트
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // Optional에서 값을 꺼낼 때는 get을 통해 꺼낼 수 있음
        Member result = repository.findById(member.getId()).get();
        // expected(기대하는 값)가 result, actual이 member
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // shift + f6해서 member1 한꺼번에 member2로 변경 (같은 변수 한꺼번에 변경)
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // findByName이 잘 작동하는지 테스트
        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
