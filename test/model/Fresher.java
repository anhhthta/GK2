package test.model;

import java.io.Serializable;

/**
 *
 * @author anhth
 */
public class Fresher extends Staff implements Serializable{
    private String graDate;
    private String graRank;
    private String education;

    public Fresher(String gra_date, String gra_rank, String education, String id, String fullName, String birthDay, String email, String type,String phone, int count) {
        super(id, fullName, birthDay, email, type,phone, count);
        this.graDate = gra_date;
        this.graRank = gra_rank;
        this.education = education;
    }

    public String getGra_date() {
        return graDate;
    }

    public void setGra_date(String gra_date) {
        this.graDate = gra_date;
    }

    public String getGra_rank() {
        return graRank;
    }

    public void setGra_rank(String gra_rank) {
        this.graRank = gra_rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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
               ", Graducation date: " + getGra_date()+
               ", Graducation rank: " + getGra_rank()+
               ", Education: "+ getEducation() +" }"
        );
    }

    @Override
    public String toString() {
        return "{ Id: " + getId() + 
               ", Name: " + getFullName()+
               ", Birth Day: " + getBirthDay()+
               ", Email: " + getEmail()+
               ", Employee Type: " + getType()+    
               ", STT: " + getCount()+
               ", Graducation date: " + getGra_date()+
               ", Graducation rank: " + getGra_rank()+
               ", Education: "+ getEducation();
    }
}
