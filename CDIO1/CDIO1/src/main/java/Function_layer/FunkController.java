package Function_layer;

import Data_layer.dal.IUserDAO;
import Data_layer.dal.UserDAOimpl;
import Data_layer.dto.UserDTO;

import java.util.List;

public class FunkController {

    // Initialization of DAO and PasswordGenerator
    IUserDAO idao = new UserDAOimpl();
    PasswordGenerator gen = new PasswordGenerator();

    // Methods

    // Creates and sets user values based on params from TUI and helping function class
    public void createUser(String userName, String initials, int cpr, String roles) throws IUserDAO.DALException
    {
        UserDTO user = new UserDTO(); // Creates new UserDTO

        user.setUserId(idao.idCount()); // Sets id which it gets from DAO, which gets it from a counter in database.
        user.setUserName(userName);
        user.setIni(initials);
        user.setCpr(cpr);
        user.setPass(gen.generatePassword()); // skal tildeles et tilfældigt genereret password, som overholder DTU's regler for kodeord.
        user.setRoles(roles);
        idao.createUser(user); // Sender UserDTO objektet videre ved kald af metode i dao'en, som så gemmer brugeren i databasen.

    }

    // Gets user list from DAO and returns it to TUI
    public List<UserDTO> getUsers() throws IUserDAO.DALException
    {
        return idao.getUserList();
    }

    // Gets user from DAO. Updates it with values from TUI and sends it to DAO again.
    public void updateUser(int id,String userName,String ini,String roles) throws IUserDAO.DALException
    {
        UserDTO user= idao.getUser(id);
        user.setUserName(userName);
        user.setIni(ini);
        user.setRoles(roles);
        idao.updateUser(user);

    }

    // Passes along userId to DAO from TUI.
    public void deleteUser(int userID) throws IUserDAO.DALException
    {
        idao.deleteUser(userID);
    }

}
