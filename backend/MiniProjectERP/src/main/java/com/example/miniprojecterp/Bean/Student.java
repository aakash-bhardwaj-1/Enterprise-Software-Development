package com.example.miniprojecterp.Bean;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name= "student")
public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int student_id;

    @Column(name="roll_no")
    private int roll_no;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Column(name="first_name")
    private String first_name;

    @Column(name= "last_name")
    private String last_name;

    @Column(name= "domain")
    private int domain;

//    @OneToMany(mappedBy = "stud", fetch = FetchType.EAGER)
//    private List<Bill> billsList;

    public Student(int roll_no, String first_name, String last_name, int domain) {
        this.roll_no = roll_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.domain = domain;
//        this.billsList = billsList;
    }

    public Student() {

    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

//    public List<Bill> getBillsList() {
//        return billsList;
//    }

//    public void setBillsList(List<Bill> billsList) {
//        this.billsList = billsList;
//    }

    public int getDomain() {
        return domain;
    }

    public void setDomain(int domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", roll_no=" + roll_no +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", domain=" + domain +
                '}';
    }
}
