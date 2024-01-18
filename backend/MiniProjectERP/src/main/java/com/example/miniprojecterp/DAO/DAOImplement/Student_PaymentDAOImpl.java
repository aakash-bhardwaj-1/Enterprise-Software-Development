package com.example.miniprojecterp.DAO.DAOImplement;

import com.example.miniprojecterp.Bean.Bill;
import com.example.miniprojecterp.Bean.Student_Payment;
import com.example.miniprojecterp.DAO.Student_PaymentDAO;
import com.example.miniprojecterp.Util.HibernateSessionUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Student_PaymentDAOImpl implements Student_PaymentDAO {
    @Override
    public List<Student_Payment> viewPayments() {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            Query query= session.createQuery("from Student_Payment ");
            List <Student_Payment> payments= query.getResultList();
//          transaction.commit();
            return payments;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void delBills(int billId) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            System.out.println(billId);
            Query query= session.createQuery("delete from Student_Payment where bill.id="+ billId);

            int result = query.executeUpdate();
            System.out.println(result);

            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
        }
    }

    @Override
    public boolean addPayment(Student_Payment payment) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();

            session.persist(payment);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
