import dao.UserDAOImpl;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DBConnection.getConnection();
        UserDAOImpl userDAO = new UserDAOImpl(connection);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== USER MANAGEMENT MENU =====");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Get User by ID");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("Enter Name :");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email :");
                    String email = scanner.nextLine();
                    userDAO.addUser(new User(0, name, email));

                }
                case 2: {
                    List<User> users = userDAO.getAllUser();
                    for (User user : users) {
                        System.out.println(user.getId() + " | " + user.getName() + " | " + user.getEmail());
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter Id: ");
                    int id = scanner.nextInt();
                    User user = userDAO.getUserById(id);
                    System.out.println(user.getId() + " | " + user.getName() + " | " + user.getEmail());
                    break;
                }
                case 4: {

                    System.out.print("Enter Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    User newUser = new User(id, newName, newEmail);
                    userDAO.updateUser(newUser);
                    break;
                }
                case 5: {
                    System.out.print("Enter Id: ");
                    int id = scanner.nextInt();
                    userDAO.deleteUser(id);
                    break;
                }
                case 6: {
                    System.out.println("👋 Exiting... Bye!");
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid choice. TRY AGAIN");
                    break;
                }
            }

        }


    }
}