package hello.hellospring.domain;

public class Member {
    // 여기서 id는 시퀀스로 오르는 임의의 값
    // 고객이 정하는 아이디가 아닌 시스템이 저장하는 아이디
    private Long id; // 회원 ID
    private String name; // 이름

    // ALT + Insert로 getter, setter 만들기

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
