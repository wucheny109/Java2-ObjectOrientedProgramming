/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author j.kw
 */
public class Student {

    private int grade;

    public void setGrade(int grade) throws Exception {
        if (grade < 0 || grade > 100) {
            throw new Exception("Grade can't be negative or greater than 100");
        }
        this.grade = grade;
    }
    
    public int getGrade(){
        return this.grade;
    }

}
