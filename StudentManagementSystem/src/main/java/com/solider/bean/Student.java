package com.solider.bean;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String grade;

    public Student(Integer id, String name, Integer age, String sex, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Student() {
    }

    private void setId(Integer id){
    this.id = id;
    }

    public void setName(String name){
    this.name = name;
    }

    public void setAge(Integer age){
    this.age = age;
    }

    public void setSex(String sex){
    this.sex = sex;
    }

    public void setGrade(String grade){
    this.grade = grade;
    }

    public Integer getId(){
    return this.id;
    }

    public String getName(){
    return this.name;
    }

    public Integer getAge(){
    return this.age;
    }

    public String getSex(){
    return this.sex;
    }

    public String getGrade(){
    return this.grade;
    }

}
