package com.example.miniprojecterp.Services;

import com.example.miniprojecterp.Bean.Bill;
import com.example.miniprojecterp.Bean.Student;
import com.example.miniprojecterp.Bean.Student_Payment;
import com.example.miniprojecterp.DAO.BillDAO;
import com.example.miniprojecterp.DAO.DAOImplement.BillDAOImpl;
import com.example.miniprojecterp.DAO.DAOImplement.StudentDAOImpl;
import com.example.miniprojecterp.DAO.DAOImplement.Student_PaymentDAOImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BillService {
    public Student getStudentId(int id) {
        Student student = new StudentDAOImpl().getStudent(id);
        return student;
    }

    public List<Student> getStudentList(int domainId) {
        List<Student> students = new StudentDAOImpl().getDomainStudents(domainId);
        return students;
    }

    public List<Bill> viewAllBills()
    {
        List<Bill> allBills= new BillDAOImpl().getAllBills() ;
        return allBills;
    }

    public List<Bill> viewPaidBills()
    {
        List<Student_Payment> paidBills= new Student_PaymentDAOImpl().viewPayments();
        List<Bill> paidBillsfromId= new ArrayList<Bill>();

        for(Student_Payment p: paidBills){
            paidBillsfromId.add(p.getBill());
        }
        return paidBillsfromId;
    }

    public List<Bill> viewUnpaidBills()
    {
        List<Bill> allBills = new BillDAOImpl().getAllBills();
        List<Student_Payment> paidBills= new Student_PaymentDAOImpl().viewPayments() ;

        List<Integer> paidBillId = new ArrayList<Integer>();

        for(Student_Payment p : paidBills){
            paidBillId.add(p.getBill().getId());
        }

        List<Bill> unpaidBills = new ArrayList<Bill>();

        for(Bill b : allBills){

            if(paidBillId.contains(b.getId())){
                System.out.println("Not Added");
            }else{
                unpaidBills.add(b);
            }
        }
        return unpaidBills;
    }


    public void addNewSingleBill(String description, int amount, String bill_date, String deadline, Student student){
        Bill bill= new Bill();
        bill.setDescription(description);
        bill.setAmount(amount);
        bill.setBill_date(bill_date);
        bill.setDeadline(deadline);
        bill.setStud(student);

        new BillDAOImpl().addBill(bill);
    }

    public void addBillToDomain(String description, int amount, String bill_date, String deadline, int domain){
        Bill bill= new Bill();
        bill.setDescription(description);
        bill.setAmount(amount);
        bill.setBill_date(bill_date);
        bill.setDeadline(deadline);

        new BillDAOImpl().addBillDomain(domain, bill);
    }

    public void updateBillAmount(Integer billId,Integer amount)
    {
        new BillDAOImpl().updateBillAmt(billId, amount);
    }

    public void updateBillDead(Integer billId,String date)
    {
        new BillDAOImpl().updateBillDeadline(billId,date);
    }

    public void deleteBill(Integer billId)
    {
        new Student_PaymentDAOImpl().delBills(billId);
        new BillDAOImpl().deleteBill(billId);

    }
}
