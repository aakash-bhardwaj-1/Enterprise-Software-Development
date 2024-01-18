package com.example.miniprojecterp.Bean;

import jakarta.persistence.*;

@Entity
@Table(name= "student_payment")
public class Student_Payment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pay_id;

    @Column(name= "description")
    private String description;

    @Column(name= "amount")
    private int amount;

    @Column(name= "payment_date")
    private String payment_date;

    @OneToOne
    @JoinColumn(name= "bill_id", referencedColumnName = "id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name= "student_id")
    private Student student;



    public Student_Payment(String description, int amount, String payment_date, Bill bill, Student student) {
        this.description = description;
        this.amount = amount;
        this.payment_date = payment_date;
        this.bill = bill;
        this.student = student;
    }

    public Student_Payment() {

    }

    public int getId() {
        return pay_id;
    }

    public void setId(int id) {
        this.pay_id = id;
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

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Student_Payment{" +
                "id=" + pay_id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", payment_date='" + payment_date + '\'' +
                ", bill=" + bill +
                ", student=" + student +
                '}';
    }
}
