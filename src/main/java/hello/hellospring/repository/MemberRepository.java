package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  //save 메서드는 Member 객체를 반환
    Optional<Member> findById(Long id);  //Optional은 null을 처리하는 용도, findById 메서드는 id 반환한다
    Optional<Member> findByName(String name);
    List<Member> findAll(); //Member객체의 리스트를 반환함

}
