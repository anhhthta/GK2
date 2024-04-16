package test.model;

import java.io.Serializable;

/**
 *
 * @author anhth
 */
public class Intern extends Staff implements Serializable{
    private String majors;
    private String Semester;
    private String university;

    public Intern(String majors, String Semester, String university, String id, String fullName, String birthDay, String email, String type, String phone, int count) {
        super(id, fullName, birthDay, email, type, phone, count);
        this.majors = majors;
        this.Semester = Semester;
        this.university = university;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    @Override
    public String toString() {
        return "{ Id: " + getId() + 
               ", Name: " + getFullName()+
               ", Birth Day: " + getBirthDay()+
               ", Email: " + getEmail()+
               ", Employee Type: " + getType()+    
               ", STT: " + getCount()+
               ", Majors: " + getMajors()+
               ", Semester: " + getSemester()+
               ", Univesity Name"+ getUniversity() +" }";
    }
    
    @Override
    public void showInfoṛ() {
        System.out.println(
                "{ Id: " + getId() + 
               ", Name: " + getFullName()+
               ", Birth Day: " + getBirthDay()+
               ", Email: " + getEmail()+
               ", Employee Type: " + getType()+    
               ", Count: " + getCount()+
               ", Majors: " + getMajors()+
               ", Semester: " + getSemester()+
               ", Univesity Name: "+ getUniversity() +" }"

        );
    }
}
