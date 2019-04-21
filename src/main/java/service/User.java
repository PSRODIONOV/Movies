package service;

public class User {
    private String login;
    private String password;
    private boolean isAdmin;

    User(String login, int isAdmin){
        this.login = login;
        if(isAdmin == 1)
            this.isAdmin = true;
        else
            this.isAdmin = false;
    }

    User(String login, String password, int isAdmin){
        this.login = login;
        this.password = password;
        if(isAdmin == 1)
            this.isAdmin = true;
        else
            this.isAdmin = false;
    }

    public boolean checkAdmin(){
        return isAdmin;
    }

    public String getlogin(){
        return login;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
}
