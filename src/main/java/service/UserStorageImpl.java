package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ejb.Singleton;
import java.sql.*;

@Component
@Singleton
public class UserStorageImpl implements UserStorage{
    @Autowired
    private UserAccessService uas;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    private User currentUser;

    public UserStorageImpl(){

    }
    @Override
    public boolean login(String login, String password) {
        if((currentUser = uas.getUserByLogin(login))!= null) {
            if(currentUser.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean registration(String login, String password, int admin){
        return uas.registrationUser(login, password);
    }

    public void logout(){
        currentUser = null;
    }
}

