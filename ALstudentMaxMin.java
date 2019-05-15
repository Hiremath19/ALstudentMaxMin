package filerwintoarraylistmaxmin;

import java.io.*;
import java.util.*;


// Program reads all the lines of blrstudent2.csv
// loads student atrributes to Student object - to be done as assignment

public class ALstudentMaxMin {

    public static void main(String args[]) {

        String filepath = "C:\\Users\\Bharath\\Documents\\arrayliststudentmaxmin.csv";
        ArrayList<String> linesRead = new ArrayList<String>();
        ArrayList<Student> records = new ArrayList<Student>();
        ArrayList<String> nameList=new ArrayList<String>();

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                linesRead.add(currentline);// Add line to String Arraylist
                currentline = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //ArrayList<Integer> ageList = new ArrayList<Integer>();
        ArrayList<Double> marksList = new ArrayList<Double>();
        //using enhanced loop to st
        // ore details into objects
        Student sobj;
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        for (String s : linesRead) {
            String[] tokens = s.split(","); //this splits the line based on "," as delimiter
            sobj = new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]));
            records.add(sobj);
            ageList.add(sobj.getAge());
            marksList.add(sobj.getMarks());
        }

        System.out.println("\nThe size of List is  " + records.size() + "\n");

        System.out.println("Now printing Object Values");
        for (Student st : records) {
            System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
        }

        int maxage = Collections.max(ageList);
        System.out.println("Max age is : " + maxage);
        int minage = Collections.min(ageList);
        System.out.println("min age is :" +minage);

        double maxmarks = Collections.max(marksList);
        System.out.println("Max marks is : " + maxmarks);

        Student element;
        element=Collections.max(records,Comparator.comparingDouble(Student::getMarks));
        System.out.println("Max marks is " + element.getMarks());
        System.out.println("Student Details with Max Marks is : " + element.getRollno() + " " + element.getName() + " " + element.getAge() + "" + element.getMarks());

        System.out.println();





       /* element=Collections.max(records,Comparator.comparingDouble(Student::getName));
        System.out.println("Alphabetically LastName " +element.getName());
        System.out.println("Student Details with Max Marks is : " +element.getRollno() + "" + element.getName() + " " + element.getAge() + "" + element.getMarks());*/



    }


    }


// Student class and constructor
class Student {
    private int rollno;
    private String name;
    private int age;
    private double marks;

    Student(int rollno, String name, int age, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }


    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public  String getName() {
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

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}

