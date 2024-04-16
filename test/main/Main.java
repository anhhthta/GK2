package test.main;

import java.sql.SQLException;
import test.controller.ctl;
import test.model.StaffManager;

public class Main {
    public static void main(String[] args) throws SQLException {
        StaffManager staffManager = new StaffManager(); 
        ctl ctl = new ctl(staffManager);
    }
}
