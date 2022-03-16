package com.epam.manager;


import com.epam.config.DBConnectionProvider;
import com.epam.model.UserRegister;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerServiceImpl implements EmployeeManagerService<UserRegister,Integer> {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

public List<UserRegister> getAll(){
    List<UserRegister> users = new ArrayList<>();

    try {
        String query = "SELECT * From userregister";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            UserRegister user = new UserRegister();
            user.setId(resultSet.getInt("id"));
            user.setFirst_name(resultSet.getString("first_name"));
            user.setLast_name(resultSet.getString("last_name"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setAddress(resultSet.getString("address"));
            user.setEmail(resultSet.getString("email"));
            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}

    @Override
    public void createUser(UserRegister obj) {
        try {
            String query = "INSERT INTO userregister(first_name,last_name,username,password,address,email) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,obj.getFirst_name());
            statement.setString(2, obj.getLast_name());
            statement.setString(3,obj.getUsername());
            statement.setString(4,obj.getPassword());
            statement.setString(5,obj.getAddress());
            statement.setString(6,obj.getEmail());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

@Override
public void updateUser(UserRegister obj) {
    try {
        String query = "UPDATE userregister SET first_name=?, last_name=?, username=?, password=?,  address=?, email=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,obj.getFirst_name());
        preparedStatement.setString(2,obj.getLast_name());
        preparedStatement.setString(3,obj.getUsername());
        preparedStatement.setString(4,obj.getPassword());
        preparedStatement.setString(5,obj.getAddress());
        preparedStatement.setString(6,obj.getEmail());
        preparedStatement.setInt(7,obj.getId());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public boolean getByUsernameAndPassword(UserRegister userRegister) {
        boolean status = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userregister where username=? and password=?");
            preparedStatement.setString(1, userRegister.getUsername());
            preparedStatement.setString(2, userRegister.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
