/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject;

import java.util.StringTokenizer;

/**
 *
 * @author j.kw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] subjects = {"Fred Budd, Computer", "Barney Stone, Math"};
        System.out.println(getSubjects(subjects));
    }

    public static String getSubjects(String[] subjects) {
        String subjectName = "";
        for (String sub : subjects) {
            StringTokenizer one = new StringTokenizer(sub, ",");
            one.nextToken();
            subjectName += one.nextToken() + " \n";
        }
        return subjectName;
    }

}
