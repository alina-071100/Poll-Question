
package com.epam.manager;

        import com.epam.model.UserRegister;

        import java.sql.*;

public class LoginManager extends UserRegister {
    public boolean validate(UserRegister userRegister) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/userdatabase", "root", "alina2000");


        PreparedStatement preparedStatement = connection.prepareStatement("select * from userregister where username = ? and password = ? ");
        preparedStatement.setString(1, userRegister.getUsername());
        preparedStatement.setString(2, userRegister.getPassword());
        return preparedStatement.execute();

    }

//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
}

