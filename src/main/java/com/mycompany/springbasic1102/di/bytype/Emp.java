package com.mycompany.springbasic1102.di.bytype;

public class Emp {
    private String name;
   private Dept dept;
   private Motor motor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Emp{" + "name=" + name + ", dept=" + dept + ", motor=" + motor + '}';
    }
   
}
