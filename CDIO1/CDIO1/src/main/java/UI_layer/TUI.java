package UI_layer;

import Data_layer.dal.IUserDAO;
import Data_layer.dto.UserDTO;
import Function_layer.FunkController;

import java.util.List;
import java.util.Scanner;

public class TUI {

    // Initialization of scanner and controller
    Scanner scan = new Scanner(System.in);
    FunkController fCon = new FunkController();


    // Methods

    // "Main menu" method. Takes user input and sends them in a direction.
    public void showMenu() throws IUserDAO.DALException {
        boolean menuActive = true;

        do {
            System.out.print("press ENTER to continue...");
            scan.nextLine();
            System.out.println("");
            System.out.println("--- Main Menu ---\n(1) Create User\n(2) Show Users\n(3) Update User\n(4) Delete User\n(5) Exit\n--- Main Menu ---");
            int menu = scan.nextInt();

            switch (menu)
            {
                case 1:
                    createUser();
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    menuActive = false;
                    break;

                default: break;
            }

        } while (menuActive == true);

        scan.close(); // close scanner
    }


    // Use Case methods


    // Scans user input and passes along to functionController which generates remaining user info and creates user.
    public void createUser() throws IUserDAO.DALException {
        System.out.println("--- Enter details below. User ID and Password will be assigned automatically. ---");
        System.out.println("Enter username: ");
        String userName = scan.next();
        System.out.println("Enter initials (2-4 characters): ");
        String initials = scan.next();
        System.out.println("Enter cpr: ");
        int cpr = scan.nextInt();
        System.out.println("Enter roles: ");
        String roles = scan.next();


        fCon.createUser(userName, initials, cpr, roles); // Calls function controller and passes along params

        System.out.println("[User Created Sucessfully]");
    }

    // Gets userList from DAO through functionController and prints users.
    public void showUsers()throws IUserDAO.DALException
    {
        System.out.println("Getting users from database...");
        List<UserDTO> userList = fCon.getUsers(); // Calls function controller which then calls DAO to get list with users (currently an ArrayList).

        for (UserDTO user : userList) { // For-each user in userList print user, which uses UserDTO toString() method.
            System.out.println(user);
        }

    }

    // Scans user input and passes along to functionController which sets new user info.
    public void updateUser() throws IUserDAO.DALException {
        System.out.println("Enter ID of user to update: ");
        int userID = scan.nextInt();

        System.out.println("Enter new username: ");
        String userName = scan.next();
        System.out.println("Enter new initials: ");
        String ini = scan.next();
        System.out.println("Enter new role: ");
        String roles = scan.next();
        fCon.updateUser(userID,userName,ini,roles); //
    }

    // Scans user input for id of user to delete and passes it along to functionController
    public void deleteUser() throws IUserDAO.DALException
    {
        System.out.println("Select userID of the user you wish to delete: ");
        int id = scan.nextInt();
        fCon.deleteUser(id);
    }






}
