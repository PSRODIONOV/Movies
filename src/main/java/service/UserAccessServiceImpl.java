package service;

import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class UserAccessServiceImpl implements UserAccessService{
    Connection con = null;
    public UserAccessServiceImpl(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ", "C##user", "12345");
            System.out.println("База данных для Пользователей успешно подкючена.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public User getUserByLogin(String login){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from UserStorage where login = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(login, rs.getString("password"), rs.getInt("admin"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
            }
            ;
            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception e) {}
        }
        return null;
    }

    @Override
    public boolean registrationUser(String login, String password) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from UserStorage where login = ?");
            stmt.setString(1, login);
            int countRow = stmt.executeUpdate();
            if(countRow  == 0){
                stmt = con.prepareStatement("insert into UserStorage values (?, ?, ?)") ;
                stmt.setString(1, login);
                stmt.setString(2, password);
                stmt.setInt(3, 0);
                stmt.executeUpdate();
                return true;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (rs != null)
                    rs.close(); }
            catch (Exception e) {};
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (Exception e) {};
        }
        return  false;
    }
}
