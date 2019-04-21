package service;

public interface UserAccessService {
    public User getUserByLogin(String login);
    public boolean registrationUser(String login, String password);
}
