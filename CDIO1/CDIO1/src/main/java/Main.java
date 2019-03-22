import UI_layer.TUI;
import Data_layer.dal.IUserDAO;

public class Main {

    public static void main(String[] args) throws IUserDAO.DALException {
        TUI tui = new TUI(); //initialize tui
        tui.showMenu(); //call tui showMenu method.
    }
}
