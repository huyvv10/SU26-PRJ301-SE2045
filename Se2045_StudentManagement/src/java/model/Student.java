package model;

import java.util.Date;

public class Student {
    private String id, name;
    private int age;
    private Date dob;

    public Student() {
    }

    public Student(String id, String name, int age, Date dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + '}';
    }
    
}
