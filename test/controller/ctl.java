package test.controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import test.DAO.testDAO;
import test.model.Intern;
import test.model.StaffManager;
import test.model.Fresher;
import test.model.Experience;
import test.model.Staff;

/**
 *
 * @author anhth
 */
public class ctl {
    private StaffManager temp;
    private StaffManager manager;
    private int i = 0;
    public ctl(StaffManager manager) throws SQLException {
        this.manager = manager;
        init();
        event();
    }
    
    private void init() throws SQLException {
        manager.clear();
        
        Stream<Staff> list = new testDAO().readVehical();
        list.forEach(item -> {
            item.setCount(++i);
            manager.add(item);
        });
    }
    
    private void event() throws SQLException {
        boolean c = true;
        while(c) {
            System.out.println("---------------------------------");
            System.out.println("1. Create new Interm");
            System.out.println("2. Create new Fresher");
            System.out.println("3. Create new Experience");
            System.out.println("4. Print all");
            System.out.println("5. Print Interm");
            System.out.println("6. Print Fresher");
            System.out.println("6. Print Experien");
            System.out.println("8. Update by Id");
            System.out.println("9. Delete by Id");
            System.out.println("10. Write list to file");
            System.out.println("11. Read from file");
            System.out.println("0: exit");
            
            System.out.println("---------------------------------");
            
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();
            
            switch (choose) {
                case "1" -> {
                    createInterm();
                }

                case "2" -> {
                    createFresher();
                }

                case "3" -> {
                    createex();
                }
                case "4" -> {
                    read();
                }
                case "5" -> {
                    readInterm();
                }
                case "6" -> {
                    readFresher();
                }
                case "7" -> {
                    readex();
                }
                case "8" -> {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    manager.update(id);
                    Staff item = manager.find(id);
                    
                    testDAO dao = new testDAO();
                    dao.update(id, item);
                }
                case "9" -> {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    manager.delete(id);
                    testDAO dao = new testDAO();
                    dao.delete(id);
                }
                case "10" -> {
                    try {
                        System.out.print("Please enter the file path: ");
                        String src = sc.nextLine();
                        File file = new File(src);
                        OutputStream os = new FileOutputStream(file);
                        
                        ObjectOutputStream oos = new ObjectOutputStream(os);
                        
                        List<Staff> list = manager.getStaffs();
                        
                        for(Staff staff : list){
                            if(staff instanceof Intern ) {
                                Intern intern = (Intern) staff;
                                try {
                                    oos.writeObject(intern);
                                } catch (IOException ex) {
                                    Logger.getLogger(ctl.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else if(staff instanceof Fresher) {
                                Fresher fresher = (Fresher) staff;
                                try {
                                    oos.writeObject(fresher);
                                } catch (IOException ex) {
                                    Logger.getLogger(ctl.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else if(staff instanceof Experience) {
                                Experience experience = (Experience) staff;
                                try {
                                    oos.writeObject(experience);
                                } catch (IOException ex) {
                                    Logger.getLogger(ctl.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        System.out.println("Done");
                        System.out.println("Data can be override");
                        oos.flush();
                        oos.close();
                        
                    } catch (Exception e) {
                        System.err.println("Your path or something error");
                    }
                }
                case "11" -> {
                    temp = new StaffManager();
                    System.out.print("Please enter the file path: ");
                    String src = sc.nextLine();
                    File file = new File(src);
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        Staff staff = null;
                        while (true) {
                            try {
                                staff = (Staff) ois.readObject();
                                temp.add(staff);
                            } catch (EOFException e) {
                                break;
                            } catch (ClassNotFoundException e) {
                                System.err.println("Your path or something error");
                            }
                        }
                        temp.read();
                    } catch (IOException e) {
                        System.err.println("Your path or something error");
                    }
                }
                case  "0" ->{
                    c = false;
                }
                default -> throw new AssertionError();
            }
            
        }
    }
    
    private void createInterm() {
         try {
            Staff staff = manager.create("intern");
            testDAO dao = new testDAO();
            ++i;
            
            staff.setCount(i);
            dao.insertVehical(staff);
            if(staff != null)
                manager.add(staff);
        } catch (Exception ex) {
            Logger.getLogger(ctl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createFresher() {
        try {
            Staff staff = manager.create("fresher");
            testDAO dao = new testDAO();
            ++i;
            staff.setCount(i);
            dao.insertVehical(staff);
            
            if(staff != null)
                manager.add(staff);
        } catch (SQLException ex) {
            Logger.getLogger(ctl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createex() {
        try {
            Staff staff = manager.create("ex");
            testDAO dao = new testDAO();
            ++i;
            staff.setCount(i);
            dao.insertVehical(staff);
            
            if(staff != null)
                manager.add(staff);
        } catch (SQLException ex) {
            Logger.getLogger(ctl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void read() throws SQLException {
        manager.read();
    }
    
    private void readInterm() throws SQLException {
        manager.readIntern();
    }
    
    private void readFresher() throws SQLException {
        manager.readFresher();
    }
    
    private void readex() throws SQLException {
        manager.readExperience();
    }
}
