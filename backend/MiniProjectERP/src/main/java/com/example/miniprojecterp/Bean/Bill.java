package com.example.miniprojecterp.Bean;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;


@Entity
@Table(name= "bill")
public class Bill {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name= "description")
    private String description;

    @Column(name= "amount")
    private int amount;

    @Column(name= "bill_date")
    private String bill_date;

    @Column(name= "deadline")
    private String deadline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name= "bill_student_id", nullable = false)
    private Student stud;

    public Bill(String description, int amount, String bill_date, String deadline, Student stud) {
        this.description = description;
        this.amount = amount;
        this.bill_date = bill_date;
        this.deadline = deadline;
        this.stud = stud;
    }

    public Bill() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Student getStud() {
        return stud;
    }

    public void setStud(Student stud) {
        this.stud = stud;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", bill_date='" + bill_date + '\'' +
                ", deadline='" + deadline + '\'' +
                ", stud=" + stud +
                '}';
    }
}
