import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects;
        double totalScore = 0;
        double averageScore;
        char grade;

        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter score for subject " + i + ": ");
            double score = scanner.nextDouble();
            totalScore += score;
        }

         
        averageScore = totalScore / numberOfSubjects;

         
        if (averageScore >= 90) {
            grade = 'A';
        } else if (averageScore >= 80) {
            grade = 'B';
        } else if (averageScore >= 70) {
            grade = 'C';
        } else if (averageScore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

         
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
