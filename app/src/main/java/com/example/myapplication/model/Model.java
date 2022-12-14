package com.example.myapplication.model;


import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        for (int i = 0; i < 5; i++) {
            addStudent(new Student("name" + i, "" + i, false, "" + i + 123, "limor " + i));
        }
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudent() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
    }

    public void deleteStudent(int pos) {
        data.remove(pos);
    }

    public void editStudent(Student st, int pos) {
        data.set(pos, st);
    }

    public Student getStudentByPosition(int pos) {
        return data.get(pos);
    }
}
