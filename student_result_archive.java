/*
Student Result Archive

Create:

Student
│
| - GraduateStudent

Requirements:

Override:

calculateGrade()

for GraduateStudent.

Overloading:

Create:

displayResult()

displayResult(String semester)

Use:

FileOutputStream

to save student result data.

Use:

FileInputStream

to read and display the data.
  */
package JavaIgniteDay12;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

	// Parent Class
	class Student {
	    int rollNo;
	    String name;
	    double marks;

	    Student(int rollNo, String name, double marks) {
	        this.rollNo = rollNo;
	        this.name = name;
	        this.marks = marks;
	    }

	    void calculateGrade() {
	        if (marks >= 90)
	            System.out.println("Grade: A");
	        else if (marks >= 75)
	            System.out.println("Grade: B");
	        else if (marks >= 60)
	            System.out.println("Grade: C");
	        else
	            System.out.println("Grade: D");
	    }

	    // Overloaded Methods
	    void displayResult() {
	        System.out.println("Roll No: " + rollNo);
	        System.out.println("Name: " + name);
	        System.out.println("Marks: " + marks);
	    }

	    void displayResult(String semester) {
	        System.out.println("Semester: " + semester);
	        displayResult();
	    }
	}

	// Child Class
	class GraduateStudent extends Student {

	    GraduateStudent(int rollNo, String name, double marks) {
	        super(rollNo, name, marks);
	    }

	    @Override
	    void calculateGrade() {
	        if (marks >= 85)
	            System.out.println("Grade: Distinction");
	        else if (marks >= 70)
	            System.out.println("Grade: First Class");
	        else if (marks >= 50)
	            System.out.println("Grade: Second Class");
	        else
	            System.out.println("Grade: Fail");
	    }
	}

	public class Student_Result_Archive {

	    public static void main(String[] args) {
	    	// TODO Auto-generated method stub
	        GraduateStudent s1 =
	                new GraduateStudent(101, "Rahul", 88);

	        // Overloading Demo
	        s1.displayResult();
	        System.out.println();

	        s1.displayResult("Semester 4");
	        System.out.println();

	        // Overriding Demo
	        s1.calculateGrade();

	        // FileOutputStream
	        try {
	            FileOutputStream fout =
	                    new FileOutputStream("studentResult.txt");

	            String data =
	                    "Roll No: " + s1.rollNo + "\n" +
	                    "Name: " + s1.name + "\n" +
	                    "Marks: " + s1.marks + "\n";

	            fout.write(data.getBytes());
	            fout.close();

	            System.out.println("\nStudent result saved successfully.");

	        } catch (IOException e) {
	            System.out.println("Error while writing file.");
	        }

	        // FileInputStream
	        try {
	            FileInputStream fin =
	                    new FileInputStream("studentResult.txt");

	            int ch;

	            System.out.println("\nContents of studentResult.txt:\n");

	            while ((ch = fin.read()) != -1) {
	                System.out.print((char) ch);
	            }

	            fin.close();

	        } catch (IOException e) {
	            System.out.println("Error while reading file.");
	        }
	    }

	}
