package dal;

import dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO Rename class
public class UserDAOImpls163595 implements IUserDAO {
    //TODO Make a connection to the database


    private Connection createConnection() throws DALException {
        try {
            return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s163595",
                    "s163595", "oDjrnV74VAGDSzevuH86K");
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override


    public UserDTO getUser(int userId) throws DALException {
        try (Connection c = createConnection())
        {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM UsersData WHERE userId = " + userId);

            resultSet.next();

            UserDTO user = new UserDTO();
            user.setUserId(resultSet.getInt(1));
            user.setUserName(resultSet.getString(2));
            user.setIni(resultSet.getString(3));
            user.setRoles(Collections.singletonList(resultSet.getString(4)));




            return user;

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }




    @Override
    public List<UserDTO> getUserList() throws DALException {
        //TODO Implement this
        List<UserDTO> list = new ArrayList<>();

        try (Connection c = createConnection()) {
            ResultSet rs = c.createStatement().executeQuery("SELECT * FROM UsersData");
            while (rs.next()){
                // This while loop gets the userid from every user in the database
                // It then sends the user id to the getUser, so that we store it in the UserDTO
                list.add(getUser(rs.getInt(1)));
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

        return list;
    }


    @Override
    public void createUser(UserDTO user) throws DALException {
        //TODO Implement this


        try (Connection c = createConnection()){
            ResultSet rs = c.createStatement().executeQuery("SELECT MAX(userId) FROM UsersData");
            rs.next();
            int maxID = rs.getInt(1);
            int userId = maxID+1;
            String userName = user.getUserName();
            String ini = user.getIni();
            StringBuilder rolesBuilder = new StringBuilder();
            for (int i = 0; i < user.getRoles().size(); i++) {
                if (user.getRoles().size() > 0) {
                    rolesBuilder.append(user.getRoles().get(i) + ";");
                } else {
                    rolesBuilder.append(user.getRoles().get(i));
                }
            }
            c.createStatement();
            c.createStatement().executeUpdate("INSERT INTO UsersData (userId, userName, ini, roles) VALUES ("+ userId +", '" + userName +"' , '" + ini + "','" + rolesBuilder +"')");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private String makeStringFromList(List<String> roles) {
        String listString = "";
        for (String s: roles) {
            listString += s + ";";
        }
        return listString;
    }

    private List<String> makeListOfString(String roles) {
        //det som skal returneres / den liste som der komme ud
        List<String> roleList2 = new ArrayList<>();
        //
        String[] roleInfo = roles.split(";");

        for (String role : roleList2) {
            roleList2.add(role);
        }

        return roleList2;

    }


    @Override
    public void updateUser(UserDTO user) throws DALException {
        //TODO Implement this

        try (Connection c = createConnection())
        {
            Statement statement = c.createStatement();
            statement.executeUpdate("UPDATE UsersData"+"SET userName='"+user.getUserName()+"' ,"+"ini='"+user.getIni()+"',"+"roles='"+user.getRoles()+"' WHERE userId="+user.getUserId());

            //c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteUser(int userId) throws DALException {
        //TODO Implement this

        try (Connection c = createConnection()){
            c.createStatement().executeUpdate("DELETE FROM UsersData WHERE userId =" + userId);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
            //dette er løsningsforslag.
//    package dal;
//
//        import dto.IUserDTO;
//        import dto.UserDTO;
//
//        import java.sql.*;
//        import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.List;
//
//public class UserDAOImpls134000 implements IUserDAO {
//    private Connection createConnection() throws SQLException {
//        return  DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/chbu?"
//                + "user=chbu&password=4thVbCaMOxKiLKnXi3aJ4");
//    }
//
//    @Override
//    public IUserDTO getUser(int userId) throws DALException {
//        try (Connection c = createConnection()){
//            Statement statement = c.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE userId=" + userId);
//            IUserDTO user = null;
//            if (resultSet.next()){
//                user = makeUserFromResultset(resultSet);
//            }
//            return user;
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    @Override
//    public IUserDTO getUserByIni(String initials) throws DALException {
//        try (Connection c = createConnection()){
//            Statement statement = c.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE ini=" + initials);
//            IUserDTO user = null;
//            if (resultSet.next()){
//                user = makeUserFromResultset(resultSet);
//            }
//            return user;
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    @Override
//    public List<IUserDTO> getUserList() throws DALException {
//        try (Connection c = createConnection()){
//            Statement statement = c.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//            List<IUserDTO> userList = new ArrayList<>();
//            while (resultSet.next()){
//                IUserDTO user = makeUserFromResultset(resultSet);
//                userList.add(user);
//            }
//            return userList;
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    @Override
//    public void createUser(IUserDTO user) throws DALException {
//        try (Connection c = createConnection()){
//            Statement statement = c.createStatement();
//            String roleString = String.join(";", user.getRoles());
//            statement.execute("INSERT INTO users (userId,userName,ini,roles)" +
//                    "VALUES (" + user.getUserId() + ", '" + user.getUserName() + "', '" + user.getIni() + "', '" + roleString +"')");
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    @Override
//    public void updateUser(IUserDTO user) throws DALException {
//        try (Connection c = createConnection()){
//            Statement statement = c.createStatement();
//            String roleString = String.join(";", user.getRoles());
//            statement.execute("UPDATE users SET " +
//                    "userName = '" + user.getUserName() + "', " +
//                    "ini = '" + user.getIni() + "', " +
//                    "roles = '" + roleString + "' " +
//                    "WHERE userId = " + user.getUserId());
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteUser(int userId) throws DALException {
//        try (Connection c = createConnection()){
//            Statement statement = c.createStatement();
//            statement.execute("DELETE FROM users WHERE userId = " + userId);
//        } catch (SQLException e) {
//            throw new DALException(e.getMessage());
//        }
//    }
//
//    private IUserDTO makeUserFromResultset(ResultSet resultSet) throws SQLException {
//        IUserDTO user = new UserDTO();
//        user.setUserId(resultSet.getInt("userId"));
//        user.setUserName(resultSet.getString("userName"));
//        user.setIni(resultSet.getString("ini"));
//        //Extract roles as String
//        String roleString = resultSet.getString("roles");
//        //Split string by ;
//        String[] roleArray = roleString.split(";");
//        //Convert to List
//        List<String> roleList = Arrays.asList(roleArray);
//        user.setRoles(roleList);
//        return user;
//    }
