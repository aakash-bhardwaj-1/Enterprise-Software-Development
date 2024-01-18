package com.example.miniprojecterp.Driver;

import com.example.miniprojecterp.Bean.Bill;
import com.example.miniprojecterp.Bean.Student;
import com.example.miniprojecterp.Bean.Student_Payment;
import com.example.miniprojecterp.Bean.User;
import com.example.miniprojecterp.DAO.BillDAO;
import com.example.miniprojecterp.DAO.DAOImplement.BillDAOImpl;
import com.example.miniprojecterp.DAO.DAOImplement.StudentDAOImpl;
import com.example.miniprojecterp.DAO.DAOImplement.Student_PaymentDAOImpl;
import com.example.miniprojecterp.DAO.DAOImplement.UserDAOImpl;
import com.example.miniprojecterp.DAO.StudentDAO;
import com.example.miniprojecterp.DAO.Student_PaymentDAO;
import com.example.miniprojecterp.DAO.UserDAO;

import java.util.List;

public class Application {
    public static void main(String args[]){
        System.out.println("Application Started");
        runApplication();
        System.out.println("End");
    }
    private static void runApplication() {

//        User user= new User();
//        UserDAO userDAO= new UserDAOImpl();
//
//        boolean result= userDAO.login("nickfury@shield.com", "director");

//        user= userDAO.getUser(101);
//        System.out.println(result);


        BillDAO billDAO= new BillDAOImpl();
        Bill billPayed= billDAO.getBill(13);
        Student studentPayed= billPayed.getStud();
//
        Student_PaymentDAO payDAO= new Student_PaymentDAOImpl();
        payDAO.delBills(17);
        Student_Payment paymentNew= new Student_Payment();
        paymentNew.setBill(billPayed);
        paymentNew.setStudent(studentPayed);
        paymentNew.setAmount(billPayed.getAmount());
        paymentNew.setPayment_date("2022-12-02");
        paymentNew.setDescription("Fees Paid");

        if(payDAO.addPayment(paymentNew)) {
            System.out.println("Payment 1 added Successfully");
        }

//        billDAO.deleteBill(12);
//        List<Bill> billsPrint= billDAO.getAllBills();
//
//        for(Bill b: billsPrint){
//            System.out.println(b);
//        }
//        Bill billPrint= billDAO.getBill(13);
//        System.out.println(billPrint);

//        StudentDAO studDAO= new StudentDAOImpl();
//        List<Student> students= studDAO.getDomainStudents(301);
//
//        for(Student s: students){
//            System.out.println(s);
//        }
//
//        StudentDAO studDAO= new StudentDAOImpl();
//        Student stud1= studDAO.getStudent(203);
//        System.out.println(stud1);
//
//        Bill bill1= new Bill();
//        bill1.setBill_date("2022-12-01");
//        bill1.setDeadline("2022-12-31");
//        bill1.setAmount(3000);
//        bill1.setDescription("2nd Late fee");
//        bill1.setStud(stud1);
//        System.out.println(bill1);
//
//        BillDAO billDAO= new BillDAOImpl();
//
//        if(billDAO.addBillDomain(301, bill1)) {
//            System.out.println("Bill 1 added Successfully");
//        }
    }
}