package org.iesfm.jpalibrary.repository;

import org.iesfm.jpalibrary.pojo.Book;
import org.iesfm.jpalibrary.pojo.BoolLend;
import org.iesfm.jpalibrary.pojo.Member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class JpaLibraryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookLendRepository bookLendRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveBookTest() {
        bookRepository.save(
                new Book(
                        "xxx1",
                        "La mar",
                        "Raul",
                        List.of("Bobobo")
                )
        );
    }

    @Test
    @Transactional
    public void listBookByAuthorTest() {
        List<Book> books =
                bookRepository.findByAuthor("Raul");
        for (Book book :
                books) {
            System.out.println(book);
        }
    }

    @Test
    @Transactional
    public void listLendBook() {
        List<Book> books =
                bookRepository.findAllLendBooks();
        for (Book book :
                books) {
            System.out.println(book);
        }
    }

    @Test
    public void saveMemberTest() {
        memberRepository.save(
                new Member(
                        null,
                        "BBB",
                        "Raul",
                        "Alb",
                        List.of()
                )
        );
    }

    @Test
    @Transactional
    public void findMemberByNameTest() {
        List<Member> members =
                memberRepository.findByName("Raul");
        for (Member m :
                members) {
            System.out.println(m);
        }
    }

    @Test
    @Transactional
    public void removeMemberByNameAndSurnameTest() {
        memberRepository.deleteByNameAndSurname("Raul", "Alb");

    }

    @Test
    public void saveBookLendTest() {
        bookLendRepository.save(
                new BoolLend(
                        1,
                        "xxx1",
                        new Date()
                )
        );
    }

    @Test
    @Transactional
    public void listMemberLendsTest() {
        List<BoolLend> boolLends =
                bookLendRepository.findMemeberLends("AAA");

        for (BoolLend bl :
                boolLends) {
            System.out.println(bl);
        }
    }
}
