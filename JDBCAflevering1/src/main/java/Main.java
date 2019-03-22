import dal.IUserDAO;
import dal.UserDAOImpls163595;
import dto.UserDTO;

import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IUserDAO.DALException {
        System.out.println("Hello World!");
        UserDAOImpls163595 dao = new UserDAOImpls163595();

//          Get user list!
//        System.out.println("Getting users from database...");
//        List<UserDTO> list = dao.getUserList(); // Calls function controller which then calls DAO to get list with users (currently an ArrayList).
//
//        for (UserDTO user : list) { // For-each user in userList print user, which uses UserDTO toString() method.
//            System.out.println(user);
//        }

//        Get User (userId)
//        System.out.println(dao.getUser(1));

//             Create a User
        UserDTO user = new UserDTO();
        user.setUserId(2);
        user.setUserName("thomas");
        user.setIni("thr");
        user.addRole("student");

        try {
            dao.createUser(user);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }

//        Update user
//        UserDTO user = new UserDTO();
//        user.getUserId();
//        user.setUserName("thomas");
//        user.setIni("THM");
//        user.setRoles(Collections.singletonList("teacher"));
//
//
//        try {
//            dao.updateUser(user);
//        } catch (IUserDAO.DALException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
}