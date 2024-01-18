package com.example.miniprojecterp.DAO.DAOImplement;

import com.example.miniprojecterp.Bean.Bill;
import com.example.miniprojecterp.Bean.Student;
import com.example.miniprojecterp.DAO.StudentDAO;
import com.example.miniprojecterp.Util.HibernateSessionUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public Student getStudent(int id) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            Student s= session.get(Student.class, id);
//            transaction.commit();
            return s;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Student> getDomainStudents(int dom) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            Query query= session.createQuery("from Student where domain=: dom");
            query.setParameter("dom", dom);
            List <Student> students= query.getResultList();
//          transaction.commit();
            return students;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
