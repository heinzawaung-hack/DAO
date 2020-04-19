package heinzawaung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection connection;


    public void connection() throws SQLException {
       String password = "";
       String userName = "root";
       String url = "jdbc:mysql://localhost:3308/linux";
       connection = DriverManager.getConnection(url, userName, password);
   }


   public void connectionClose() throws SQLException {
       if (connection != null ){
           connection.close();
       }
   }

   public void save(User user) throws SQLException {

        String name = user.getName();
        String email = user.getEmail();
       String insert = "insert into user (name,email) values (?,?);";
       PreparedStatement preparedStatement = connection.prepareStatement(insert);
       preparedStatement.setString(1,name);
       preparedStatement.setString(2,email);
       preparedStatement.execute();
   }

   public List<User> getUser() throws SQLException {
       String retrieve = "select * from user";
       Statement statement = connection.createStatement();
       ResultSet resultSet =  statement.executeQuery(retrieve);

       List<User> userList = new ArrayList<>();

       while (resultSet.next()){
           int id = resultSet.getInt("id");
           String name = resultSet.getString("name");
           String email = resultSet.getString("email");
           User user = new User(id,name,email);
           userList.add(user);
       }
       return userList;

   }

   public User selectID(int id) throws SQLException {
       String idRetrieve = "select * from user where id=?";
       PreparedStatement preparedStatement = connection.prepareStatement(idRetrieve);
       preparedStatement.setInt(1,id);
       ResultSet resultSet = preparedStatement.executeQuery();

       User user = null;

       if (resultSet.next()){
           String selectString = resultSet.getString("name");
           String selectEmail = resultSet.getString("email");
            user = new User(id,selectString,selectEmail);
       }
       System.out.println("You enter id " + id);
       return user;
   }

   public User getEmail(String email) throws SQLException {
        String userEmail = "select * from user where email=?";
        PreparedStatement preparedStatement = connection.prepareStatement(userEmail);
        preparedStatement.setString(1,email);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            user = new User(id,name,email);
        }
       System.out.println("You entered " + email);
        return user;
   }

   public void updateData(User user) throws SQLException {
        int id = user.getId();
        String name = user.getName();
        String email = user.getEmail();
        String update = "update user set name=?,email=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,email);
        preparedStatement.setInt(3,id);
        preparedStatement.executeUpdate();
   }

   public void deleteByID(int id) throws SQLException {
        String delete = "delete from user where id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        System.out.println("Deleted user that you entered id :" + id );
   }
}
