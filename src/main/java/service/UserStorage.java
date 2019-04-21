package service;

public interface UserStorage {
    public void logout();
    public boolean registration(String login, String password, int admin);
    public boolean login(String login, String password);
}
