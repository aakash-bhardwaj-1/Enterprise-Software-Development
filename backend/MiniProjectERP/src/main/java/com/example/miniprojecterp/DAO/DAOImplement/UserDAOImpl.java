package com.example.miniprojecterp.DAO.DAOImplement;

import com.example.miniprojecterp.Bean.Bill;
import com.example.miniprojecterp.Bean.User;
import com.example.miniprojecterp.DAO.UserDAO;
import com.example.miniprojecterp.Util.HibernateSessionUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean login(String user_name, String user_password) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();

            List<User> users = new ArrayList<User>();
            Query query = session.createQuery("from User where user_name =:user_name");
            query.setParameter("user_name", user_name);

            users = query.getResultList();

            transaction.commit();
            session.close();

            if(users.isEmpty()){
                System.out.println("Wrong email");
                return false;
            }
            else{
                if(users.get(0).getUser_password().equals(user_password))
                    return true;
                else
                    System.out.println("Wrong password");
                    return false;
            }
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public User getUser(int user_id) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = ((Session) session).beginTransaction();
            User user= session.get(User.class, user_id);
//            transaction.commit();
            return user;
        }
    }
}