package org.iesfm.jpalibrary.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true, nullable = false)
    private String nif;
    private String name;
    private String surname;
    @OneToMany(orphanRemoval = true,
    cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
    mappedBy = "memberId")
//    @JoinColumn(name = "member_Id",
//    referencedColumnName = "id")
    private List<BoolLend> boolLends;

    public Member(Integer id, String nif, String name, String surname, List<BoolLend> boolLends) {
        this.id = id;
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.boolLends = boolLends;
    }

    public Member(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<BoolLend> getBoolLends() {
        return boolLends;
    }

    public void setBoolLends(List<BoolLend> boolLends) {
        this.boolLends = boolLends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(nif, member.nif) && Objects.equals(name, member.name) && Objects.equals(surname, member.surname) && Objects.equals(boolLends, member.boolLends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nif, name, surname, boolLends);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", boolLends=" + boolLends +
                '}';
    }
}
