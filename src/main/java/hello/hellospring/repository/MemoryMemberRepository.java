package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //정보저장
    private static long sequence = 0L; //일련번호 생성에 활용됨

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //아이디 세팅
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이 있을 수도 있으니 optional로 감쌈 id에 해당하는 Member객체가 반환된다

    }

    @Override
//    store 맵에서 이름이 name과 일치하는 회원을 찾고, 해당 회원을 Optional<Member>로 감싸서 반환 Optional은 값이 있을 수도 없을 수도 있는 상황에 대비하여 널 체크와 관련된 유연성을 제공하는 래퍼 클래스
    public Optional<Member> findByName(String name) {
       return store.values().stream().filter(member -> member.getName().equals(name)).findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear(); //store 다 비워줌
    }

}
