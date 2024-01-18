package com.example.miniprojecterp.Services;

import com.example.miniprojecterp.Bean.User;
import com.example.miniprojecterp.DAO.DAOImplement.UserDAOImpl;

public class LoginService {
    public boolean login(User user)
    {
        String user_name= user.getUser_name();
        String user_password= user.getUser_password();

        boolean result = new UserDAOImpl().login(user_name, user_password);
        return result;
    }
}
