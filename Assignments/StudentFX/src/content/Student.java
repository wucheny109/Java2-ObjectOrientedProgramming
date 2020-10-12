/**
 * CHENYU WU
 * 991566725
 * Assignment 3
 * Mar 6 2020
 */
package content;

public class Student {

    private int id;
    private double[] grade;

    public void setGrade(double[] grade) {
        this.grade = grade;
    }

    public double[] getGrade() {
        return grade;
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getAvgStudent() {
        double sum = 0;
        for (double sub : grade) {
            sum += sub;
        }
        return (int) sum / grade.length;
    }

}
