/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j.kw
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Student one = new Student();
        int grade = Integer.parseInt(args[0]);
        try{
            one.setGrade(grade);
            System.out.println(one.getGrade());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}