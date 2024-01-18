package com.example.miniprojecterp.DAO.DAOImplement;

import com.example.miniprojecterp.Bean.Bill;
import com.example.miniprojecterp.Bean.Student;
import com.example.miniprojecterp.Bean.Student_Payment;
import com.example.miniprojecterp.Bean.User;
import com.example.miniprojecterp.DAO.BillDAO;
import com.example.miniprojecterp.DAO.StudentDAO;
import com.example.miniprojecterp.Util.HibernateSessionUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO {
    @Override
    public boolean addBill(Bill bill) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
//            StudentDAO studDAO= new StudentDAOImpl();
//            Student stud1= studDAO.getStudent(203);
//            System.out.println(stud1);
//
//            bill.setStud(stud1);

            session.persist(bill);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean addBillDomain(int domId, Bill bill) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
//            System.out.println("Hello");
            StudentDAO studDAO= new StudentDAOImpl();
            List<Student> students= studDAO.getDomainStudents(301);

            for(Student s: students){
                System.out.println(s);
                Bill billAdd= new Bill();
                bill.setStud(s);
                bill.setId(billAdd.getId());
//                System.out.println(bill);
//                System.out.println(s);

                BillDAO billDAO= new BillDAOImpl();
                billDAO.addBill(bill);
            }
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Bill getBill(int billId) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            Bill bill= session.get(Bill.class, billId);

//            System.out.println(bill);

//            transaction.commit();
            return bill;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Bill> getAllBills() {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            Query query= session.createQuery("from Bill");
            List <Bill> bills= query.getResultList();
//          transaction.commit();
            return bills;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void updateBillAmt(int billId, int amount) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            Query query= session.createQuery("update Bill set amount=:amount where id=: billId");

            query.setParameter("amount", amount);
            query.setParameter("billId", billId);

            int modifications=query.executeUpdate();
            System.out.println(modifications);

            transaction.commit();
            return;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return;
        }
    }

    @Override
    public void updateBillDeadline(Integer billId, String deadline) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            Query query= session.createQuery("update Bill set deadline=:deadline where id=: billId");

            query.setParameter("deadline", deadline);
            query.setParameter("billId", billId);

            int modifications=query.executeUpdate();
            System.out.println(modifications);

            transaction.commit();
            return;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return;
        }
    }

    @Override
    public void deleteBill(Integer billId) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();

            Query query= session.createQuery("delete from Bill where id=: billId");

            query.setParameter("billId", billId);

            int result = query.executeUpdate();
            System.out.println(result);

            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
