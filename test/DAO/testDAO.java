package test.DAO;

import test.conection.DTBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import test.model.Experience;
import test.model.Fresher;
import test.model.Intern;
import test.model.Staff;

public class testDAO {
    private Connection con;
    
    public void insertVehical(Staff staff) throws SQLException {
        con = DTBC.getConnection();
        String sql;
        PreparedStatement pst;
        int id;
        
        sql = "INSERT INTO `ts1`.`staff` (`fullname`, `birthday`, `email`, `type`, `phone`) VALUES (?, ?, ?, ?, ?);";
        pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, staff.getFullName());
        pst.setString(2, staff.getBirthDay());
        pst.setString(3, staff.getEmail());
        pst.setString(4, staff.getType());
        pst.setString(5, staff.getPhone());
        
        pst.execute();
        ResultSet rs1 = pst.getGeneratedKeys();
        
        rs1.first();
        id = rs1.getInt(1);
        rs1.close();
        
        if(staff instanceof Intern) {
            Intern intern = (Intern) staff;
            sql = "INSERT INTO `ts1`.`intern` (`id`, `majors`, `semester`, `university`) VALUES (?, ?, ?, ?);" ;
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, intern.getMajors());
            pst.setString(3, intern.getSemester());
            pst.setString(4, intern.getUniversity());

            pst.execute();
        } else if(staff instanceof Experience) {
            Experience experience = (Experience) staff;
            sql = "INSERT INTO `ts1`.`experience` (`id`, `explnYear`, `proSkill`) VALUES (?, ?, ?);" ;
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, experience.getExplnYear());
            pst.setString(3, experience.getProSkill());

            pst.execute();
        } else if(staff instanceof Fresher) {
            Fresher fresher = (Fresher) staff;
            sql = "INSERT INTO `ts1`.`fresher` (`id`, `graDate`, `graRank`, `education`) VALUES (?, ?, ?, ?);" ;
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, fresher.getGra_date());
            pst.setString(3, fresher.getGra_rank());
            pst.setString(4, fresher.getEducation());
    

            pst.execute();
        }  
        pst.close();
        
        DTBC.closeConnection(con);
        staff.setId(String.valueOf(id));
    }
    
    public Stream<Staff> readVehical() throws SQLException {
        con = DTBC.getConnection();
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT staff.id,staff.fullname, staff.birthday , staff.email, staff.type, staff.phone, intern.majors, intern.semester, intern.university FROM staff INNER JOIN intern ON staff.id = intern.id;";
        
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            list.add(
                new Intern(
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9), 
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    -1
                )
           );
        }
       
        sql = "SELECT staff.id,staff.fullname, staff.birthday , staff.email, staff.type, staff.phone, fresher.graDate, fresher.graRank, fresher.education FROM staff INNER JOIN fresher ON staff.id = fresher.id;";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()){
            list.add(
                new Fresher(
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9), 
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    -1
                )
           );
        }
        
        sql = "SELECT staff.id,staff.fullname, staff.birthday , staff.email, staff.type, staff.phone, experience.explnYear, experience.proSkill FROM staff INNER JOIN experience ON staff.id = experience.id;";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()){
            list.add(
                new Experience(
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    -1
                )
           );
        }

        rs.close();
        pst.close();
        DTBC.closeConnection(con);
        
        
        return list.stream();
    }
    
    public Stream<Staff> readIntern() throws SQLException {
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT staff.id,staff.fullname, staff.birthday , staff.email, staff.type, staff.phone, intern.majors, intern.semester, intern.university FROM staff INNER JOIN intern ON staff.id = intern.id;";
        
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            list.add(
                new Intern(
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9), 
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    -1
                )
           );
        }
        rs.close();
        pst.close();
        DTBC.closeConnection(con);
        return list.stream();

    }
    
    public Stream<Staff> readFresher() throws SQLException {
        con = DTBC.getConnection();
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT staff.id,staff.fullname, staff.birthday , staff.email, staff.type, staff.phone, fresher.graDate, fresher.graRank, fresher.education FROM staff INNER JOIN fresher ON staff.id = fresher.id;";
        
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            list.add(
                new Intern(
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9), 
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    -1
                )
           );
        }
        rs.close();
        pst.close();
        DTBC.closeConnection(con);
        return list.stream();

    }
    
    public void update(String id, Staff staff) throws SQLException {
        con = DTBC.getConnection();
        
        String sql = "UPDATE `ts1`.`staff` SET `fullname` = ?, `birthday` = ?, `email` = ?, `type` = ?, `phone` = ? WHERE (`id` = ?);";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, staff.getFullName());
        pst.setString(2, staff.getBirthDay());
        pst.setString(3, staff.getEmail());
        pst.setString(4, staff.getType());
        pst.setString(5, staff.getPhone());
        pst.setString(6, id);        
        pst.executeUpdate();
        
        if(staff instanceof Intern) {
            Intern intern = (Intern) staff;
            sql = "UPDATE `ts1`.`intern` SET `majors` = ?, `semester` = ?, `university` = ? WHERE (`id` = ?););";
            pst = con.prepareStatement(sql);
        
            pst.setString(1, intern.getMajors());
            pst.setString(2, intern.getSemester());
            pst.setString(3, intern.getUniversity());

            pst.setString(4, id);        
            pst.executeUpdate();
        } else if (staff instanceof Fresher) {
            Fresher fresher = (Fresher) staff;
            sql = "UPDATE `ts1`.`fresher` SET `graDate` = ?, `graRank` = ?, `education` = ? WHERE (`id` = ?);";
            pst = con.prepareStatement(sql);
        
            pst.setString(1, fresher.getGra_date());
            pst.setString(2, fresher.getGra_rank());
            pst.setString(3, fresher.getEducation());
            pst.setString(4, id);        
            
            pst.executeUpdate();
        } else if (staff instanceof Experience) {
            Experience experience = (Experience) staff;
            sql = "UPDATE `ts1`.`experience` SET `explnYear` = ?, `proSkill` = ? WHERE (`id` = ?);";
            pst = con.prepareStatement(sql);
        
            pst.setString(1, experience.getExplnYear());
            pst.setString(2, experience.getProSkill());
            pst.setString(3, id);        
            
            pst.executeUpdate();
        }

        pst.close();
        DTBC.closeConnection(con); 
    }
    
    public void delete(String id) throws SQLException {
        con = DTBC.getConnection();
        
        String sql = "DELETE FROM `ts1`.`intern` WHERE (`id` = ?);";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);
        pst.executeUpdate();
        
        sql = "DELETE FROM `ts1`.`fresher` WHERE (`id` = ?);";
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
        pst.executeUpdate();
        
        sql = "DELETE FROM `ts1`.`experience` WHERE (`id` = ?);";
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
        pst.executeUpdate();

        sql = "DELETE FROM `ts1`.`staff` WHERE (`id` = ?);";
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
        pst.executeUpdate();
        
        pst.close();
        DTBC.closeConnection(con);
    }
}
