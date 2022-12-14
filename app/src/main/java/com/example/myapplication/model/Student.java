package com.example.myapplication.model;

public class Student {

    public String name;
    public String id;
    public Boolean cb;
    public String phone;
    public String address;

    public Student(String name, String id, Boolean cb, String phone, String address) {
        this.name = name;
        this.id = id;
        this.cb = cb;
        this.phone = phone;
        this.address = address;
    }

    public Boolean getCb() {
        return cb;
    }

    public void setCb(Boolean cb) {
        this.cb = cb;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
