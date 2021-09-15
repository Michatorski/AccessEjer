package org.iesfm.controller;

import org.iesfm.Member;
import org.iesfm.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class MemberController {
    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/members")
    public List<Member> getMembersByName(
            @RequestParam(value = "name", required = false) String name
    ){
        return memberRepository.findMemberByName(name);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, path = "/members")
    public void delete(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname
    ){
        int deletionRows = memberRepository.deleteByNameAndSurname(name, surname);
        if (deletionRows == 0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No existe miembro"
            );
        }
    }
}
