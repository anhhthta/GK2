
package test.model;

import java.io.Serializable;

/**
 *
 * @author anhth
 */
public abstract class Staff implements IEmployee, Serializable{
    private String id;
    private String fullName;
    private String birthDay;
    private String email;
    private String type;
    private int count;
    private String phone;
    
    public Staff() {
    }

    public Staff(String id, String fullName, String birthDay, String email, String type, String phone,int count) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.email = email;
        this.type = type;
        this.count = count;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
