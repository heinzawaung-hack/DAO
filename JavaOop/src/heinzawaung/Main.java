package heinzawaung;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();
        try {
            database.connection();
            System.out.println("Connected to MySQL Database.");
        } catch (SQLException e) {
            System.out.println("Can't connect to MySQL Database.");
            e.printStackTrace();
        }

        //Delete Method.
//        try {
//            database.deleteByID(7);
//        } catch (SQLException e) {
//            System.out.println("Can't delete user that you entered.");
//            e.printStackTrace();
//        }
//
//        //Update Data Method.
        try {
            User user1 = database.selectID(9);
            user1.setName("Nyan Linn Aung");
            user1.setEmail("nyanlinnaung3@hotmail.com");
            database.updateData(user1);
            System.out.println("Update data Success..");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Insert Data Method.
//        try {
//            User user = new User("Su Thet Paing", "info@suthetpaing.com");
//            database.save(user);
//            System.out.println("Insert data success.");
//
//            //Retrieve Data
//            List<User> userList = database.getUser();
//            for (User data:userList){
//                System.out.println(data.getId() + " : " + data.getName() + " : " + data.getEmail());
//            }
//            System.out.println();
//            System.out.println("Retrieve data from MySQL Database successfully.");
//        } catch (SQLException e) {
//            System.out.println("Error Occurred.");
//            e.printStackTrace();
//        }


           //User Search.
//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter your Email.");
//            String  email = scanner.nextLine();
//
//            User u1 = database.getEmail(email);
//            if (u1 != null) {
//                System.out.println(u1.getId() + " : " + u1.getName() + " : " + u1.getEmail());
//            } else {
//                System.out.println("Sorry , Email not found on server that you entered.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

          //Get data with id.
//        try {
//            User user = database.selectID(20);
//            if (user != null){
//                System.out.println(user.getId() + " : " + user.getName() + " : " + user.getEmail());
//            }else {
//                System.out.println("Sorry, User not found on server that you entered.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            database.connectionClose();
            System.out.println("No error occurred, Database closed.");
        } catch (SQLException e) {
            System.out.println("Can't close MySQL Database.");
            e.printStackTrace();
        }


    }
}
