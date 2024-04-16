package test.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author anhth
 */
public class StaffManager {
    private List<Staff> staffs;

    public StaffManager() {
        staffs = new ArrayList<>();
    }
    
    public Staff create(String type) {
        Scanner sc = new Scanner(System.in);
        Staff c = null;

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Phone: " );
        String phone = sc.nextLine();

        System.out.print("Enter Birth Day: ");
        String day = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        if(null != type) switch (type) {
            case "intern" -> {
                System.out.print("Enter Majors: ");
                String major = sc.nextLine();
                
                System.out.print("Enter Semester: ");
                String Semester = sc.nextLine();
                
                System.out.print("Enter University: ");
                String university = sc.nextLine();
                
                c = new Intern(major, Semester, university,"-1", name, day, email,"Intern",phone, -1);
            }
            case "fresher" -> {
                System.out.print("Enter Graduation Date: ");
                String date = sc.nextLine();
                System.out.print("Enter Graduation Rank: ");
                String rank1 = sc.nextLine();
                System.out.print("Enter Education: ");
                String education = sc.nextLine();
                
                c = new Fresher(date, rank1, education,"-1", name, day, email,"fresher",phone, -1);
            }
            case "ex" -> {
                System.out.print("Enter Expln Year: ");
                String year = sc.nextLine();
                System.out.print("Enter Pro Skill: ");
                String skill = sc.nextLine();
                
                c = new Experience(year, skill,"-1", name, day, email,"experience",phone, -1);
            }
            default -> {
            }
        }
        
        return c;
    }
    
    public void delete(String id) {
        staffs = staffs.stream().filter(staff -> !(staff.getId().equals(id))).collect(Collectors.toList());
    }
    
    public void update(String id) {
        staffs.stream().map(staff -> {
            if(staff.getId().equals(id)){
                Scanner sc = new Scanner(System.in);
               
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Birth Day: ");
                String day = sc.nextLine();
                
                System.out.print("Enter Phone: " );
                String phone = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();
                
                staff.setFullName(name);
                staff.setBirthDay(day);
                staff.setEmail(email);
                staff.setPhone(phone);
                
                if(staff instanceof Intern intern) {
                    System.out.print("Enter Majors: ");
                    String major = sc.nextLine();
                
                    System.out.print("Enter Semester: ");
                    String Semester = sc.nextLine();
                
                    System.out.print("Enter University: ");
                    String university = sc.nextLine();
                    
                    intern.setMajors(major);
                    intern.setSemester(Semester);
                    intern.setUniversity(university);
                    intern.setType("intern");

                    return intern;
                } else if(staff instanceof Fresher fresher) {
                    System.out.print("Enter Graduation Date: ");
                    String date = sc.nextLine();
                    System.out.print("Enter Graduation Rank: ");
                    String rank1 = sc.nextLine();
                    System.out.print("Enter Education: ");
                    String education = sc.nextLine();
                
                    fresher.setGra_date(date);
                    fresher.setGra_rank(rank1);
                    fresher.setEducation(education);
                    fresher.setType("fresher");

                    return fresher;
                } else {
                    Experience experience = (Experience) staff;
                    System.out.print("Enter Expln Year: ");
                    String year = sc.nextLine();
                    System.out.print("Enter Pro Skill: ");
                    String skill = sc.nextLine();
                    
                    experience.setExplnYear(year);
                    experience.setProSkill(skill);
                    experience.setType("experience");

                    return experience;
                }
            }
            
            return staff;
        }).collect(Collectors.toList());
    }
    
    public void read() {
        staffs.stream().forEach(staff -> {
            if(staff instanceof Intern intern) {
                intern.showInfoṛ();
            } else if(staff instanceof Experience experience) {
                experience.showInfoṛ();
            } else if(staff instanceof Fresher fresher) {
                fresher.showInfoṛ();
            }
            
        });
    }
    
    public void readIntern() {
        staffs.stream().forEach(staff -> {
            if(staff instanceof Intern intern) {
                intern.showInfoṛ();
            }
        });    
    }
    
    public void readFresher() {
        staffs.stream().forEach(staff -> {
            if(staff instanceof Experience experience) {
                experience.showInfoṛ();
            }
        });    
    }
    
    public void readExperience() {
        staffs.stream().forEach(staff -> {
            if(staff instanceof Fresher fresher) {
                fresher.showInfoṛ();
            }
        });    
    }
    
    public Staff find(String id) {
        Optional<Staff> i = staffs.stream().filter(item -> item.getId().equals(id)).findFirst();
        return i.get();
    }
    
    public void add(Staff staff) {
        staffs.add(staff);
    }
    
    public void clear() {
        this.staffs.clear();
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
