import java.util.Scanner;

public class StudentResult 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int totalMarks = 0;
        int subjects = 6;

        System.out.println("Enter marks for 6 subjects (out of 100):");
        for (int i = 1; i <= subjects; i++) 
        {
            System.out.print("Subject " + i + ": ");
            int marks = sc.nextInt();
            totalMarks += marks;
        }

        double percentage = totalMarks / (double) subjects;

        String grade;
        if (percentage >= 90) 
        {
            grade = "A";
        } 
        else if (percentage >= 75) 
        {
            grade = "B";
        } 
        else if (percentage >= 60) 
        {
            grade = "C";
        } 
        else if (percentage >= 40) 
        {
            grade = "D";
        } 
        else 
        {
            grade = "F";
        }

        // Show result
        System.out.println("\n===== Result =====");
        System.out.println("Total Marks = " + totalMarks + " out of " + (subjects * 100));
        System.out.println("Percentage = " + percentage + "%");
        System.out.println("Grade = " + grade);

    }
}
