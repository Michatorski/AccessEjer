package org.iesfm.jpalibrary.repository;

import org.iesfm.jpalibrary.pojo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {


    List<Member> findByName(String name);


    int deleteByNameAndSurname(String name, String surname);

}
