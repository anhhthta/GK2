package test.model;

import java.io.Serializable;

/**
 *
 * @author anhth
 */
public class Experience extends Staff implements Serializable{
    private String explnYear;
    private String proSkill;

    public Experience(String explnYear, String proSkill, String id, String fullName, String birthDay, String email, String type, String phone, int count) {
        super(id, fullName, birthDay, email, type, phone, count);
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    public String getExplnYear() {
        return explnYear;
    }

    public void setExplnYear(String explnYear) {
        this.explnYear = explnYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
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
               ", Expln year: " + getExplnYear()+
               ", Pro skill: " + getProSkill()+" }"
        );
    }

    @Override
    public String toString() {
        return  "{ Id: " + getId() + 
               ", Name: " + getFullName()+
               ", Birth Day: " + getBirthDay()+
               ", Email: " + getEmail()+
               ", Employee Type: " + getType()+    
               ", STT: " + getCount()+
               ", Expln year: " + getExplnYear()+
               ", Pro skill: " + getProSkill()+
            ",Count"+ getCount()+ " }";
    }
    
}
