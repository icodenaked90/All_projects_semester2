package dal;

import dal.dto.IUserDTO;
import dal.dto.UserDTO;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;


public class UserDAOImpls163595 implements IUserDAO {
    //TODO Make a connection to the database
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s163595",
                "s163595", "oDjrnV74VAGDSzevuH86K");
    }

    @Override
    public void createUser(IUserDTO user) throws DALException {
        //TODO Implement this - Should insert a user into the db using data from UserDTO object.
        try (Connection c = createConnection()) {
            String insert = "INSERT INTO user(userId, userName, ini)" +
                    "VALUES (" + user.getUserId() + ", '" + user.getUserName() + "', '" + user.getIni() + "')";
            PreparedStatement ps = c.prepareStatement(insert);
            ps.executeUpdate();
            makeStringFromList(user.getRoles(),user.getUserId());

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public IUserDTO getUser(int userId) throws DALException {

        //TODO Implement this - should retrieve a user from db and parse it to a UserDTO
        try (Connection c = createConnection()) {
            String select1 = ("SELECT * FROM user WHERE userId=" + userId);
            String select2 = ("SELECT * FROM Roles WHERE user_userId=" + userId);
            PreparedStatement ps = c.prepareStatement(select1);
            PreparedStatement ps2 = c.prepareStatement(select2);
            ResultSet resultSet = ps.executeQuery();
            ResultSet resultSet2 = ps2.executeQuery();
            ArrayList<String> rolelist = new ArrayList<>();
            while (resultSet2.next()){
                rolelist.add(resultSet2.getString("roleName"));
            }

            IUserDTO user = null;
            if (resultSet.next()) {
                user = makeUserFromResultset(resultSet,rolelist);
            }
            return user;
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }


    @Override
    public List<IUserDTO> getUserList() throws DALException {
        //TODO Implement this - Should retrieve ALL users from db and parse the resultset to a List of UserDTO's.
        try (Connection c = createConnection()) {
            String select = ("SELECT * FROM user");
            PreparedStatement ps = c.prepareStatement(select);
            ResultSet resultSet = ps.executeQuery();
            List<IUserDTO> userList = new ArrayList<>();

            while (resultSet.next()) {
                ArrayList<String> rolelist = new ArrayList<>();
                int i = resultSet.getInt("userId");
                String select1 = ("SELECT * FROM Roles WHERE user_userId = " + i);
                PreparedStatement ps1 = c.prepareStatement(select1);
                ResultSet resultSet1 = ps1.executeQuery();


                while (resultSet1.next()){
                    rolelist.add(resultSet1.getString("roleName"));
                }
                IUserDTO user = makeUserFromResultset(resultSet,rolelist);


                userList.add(user);
            }

            return userList;
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }


    @Override
    public void updateUser(IUserDTO user) throws DALException {
        //TODO Implement this - Should update a user in the db using data from UserDTO object.
        try (Connection c = createConnection()) {
            String update = ("UPDATE user "+"SET userName='"+user.getUserName()+"' ,"+"ini='"+user.getIni()+"' WHERE userId="+user.getUserId());
            PreparedStatement ps = c.prepareStatement(update);
            updaterolelist(user.getRoles(),user.getUserId());
            ps.executeUpdate();



        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) throws DALException {
        //TODO Implement this - Should delete a user with the given userid from the db.
        try (Connection c = createConnection()) {
            String delete = ("DELETE FROM user WHERE userId = " + userId);
            String delete1 = ("DELETE FROM Roles WHERE user_userId = " + userId);
            PreparedStatement ps = c.prepareStatement(delete);
            PreparedStatement ps1 = c.prepareStatement(delete1);
            ps.executeUpdate();
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    private IUserDTO makeUserFromResultset(ResultSet resultSet,ArrayList rolelist) throws SQLException {
        IUserDTO user = new UserDTO();
        user.setUserId(resultSet.getInt("userId"));
        user.setUserName(resultSet.getString("userName"));
        user.setIni(resultSet.getString("ini"));
        user.setRoles(rolelist);
        return user;
    }

    private String makeStringFromList(List<String> roles, int userid) {
        String rollen = "";
        for (String i: roles) {
            rollen = i;
            try (Connection c = createConnection()){
                String insertrole ="INSERT INTO Roles(user_userId, roleName)" +
                        "VALUES (" + userid+ ", '" + rollen + "')";
                PreparedStatement ps = c.prepareStatement(insertrole);
                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e);
            }

        }return rollen;
    }
    private String updaterolelist(List<String> roles, int userId) {
        String rollen = "";
        for (String i: roles) {
            rollen = i;
            try (Connection c = createConnection()){

                String delete1 = ("DELETE FROM Roles WHERE user_userId = " + userId);
                PreparedStatement ps1 = c.prepareStatement(delete1);
                ps1.executeUpdate();
                String updaterole ="INSERT INTO Roles(user_userId, roleName)" +
                        "VALUES (" + userId+ ", '" + rollen + "')";
                PreparedStatement ps = c.prepareStatement(updaterole);
                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e);
            }

        }return null;
    }
}
