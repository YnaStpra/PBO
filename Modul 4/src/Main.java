import api.Dataset;
import api.JDBC;
import gui.LoginApp;
import tools.WPMCalculate;

public class Main {

    public static void main(String[] args) {
        JDBC db = new JDBC();
        Dataset dataset = new Dataset();
        LoginApp login = new LoginApp();
        login.showLogin();





    }
}
