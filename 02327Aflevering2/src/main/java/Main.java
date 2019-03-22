import dal.IUserDAO;
import dal.UserDAOImpls163595;
import dal.dto.IUserDTO;
import dal.dto.UserDTO;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IUserDAO.DALException {
        System.out.println("Hello World!");
        UserDAOImpls163595 dao = new UserDAOImpls163595();

////          Get user list!
//        System.out.println("Getting users from database...");
//        List<IUserDTO> list = dao.getUserList(); // Calls function controller which then calls DAO to get list with users (currently an ArrayList).
//
//        for (IUserDTO user : list) { // For-each user in userList print user, which uses UserDTO toString() method.
//            System.out.println(user);
//        }

//        Get User (userId)
//        System.out.println(dao.getUser(3500));

//             Create a User
//        UserDTO user = new UserDTO();
//        user.setUserId(1);
//        user.setUserName("john");
//        user.setIni("lol");
//        user.addRole("student");
//        user.addRole("Teacher");
//        user.addRole("idiot");
//
//
//        try {
//            dao.createUser(user);
//        } catch (IUserDAO.DALException e) {
//            e.printStackTrace();
//        }


//        Update user
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ID of user to update: ");
        int userID = scan.nextInt();

        System.out.println("Enter new username: ");
        String userName = scan.next();
        System.out.println("Enter new initials: ");
        String ini = scan.next();
        System.out.println("Enter new role: ");
        String roles = scan.next();

        IUserDTO user = dao.getUser(userID);
        user.setUserName(userName);
        user.setIni(ini);
        user.addRole(roles);
        try {
            dao.updateUser(user);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
////
//        Delete user
//         Scanner scan = new Scanner(System.in);
//         System.out.println("Enter ID of user to delete: ");
//         int userId = scan.nextInt();
//         dao.deleteUser(userId);


//
//    }
    }
}
