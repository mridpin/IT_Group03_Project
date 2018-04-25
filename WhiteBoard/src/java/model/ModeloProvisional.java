/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.data.Student;

/**
 *
 * @author ridao
 */
public class ModeloProvisional {

    static List<Student> students = new ArrayList<>();

    public ModeloProvisional() {

    }

    public static boolean login(String user, String password) {
        students.add(new Student("manuel", "password"));
        students.add(new Student("student", "student"));
        for (Student s : students) {
            if (s.getUser().equals(user) && s.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
