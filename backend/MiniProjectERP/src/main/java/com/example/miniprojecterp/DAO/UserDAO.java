package com.example.miniprojecterp.DAO;

import com.example.miniprojecterp.Bean.User;

public interface UserDAO {
    public boolean login(String user_name,String user_password);

    public User getUser(int user_id);
}
