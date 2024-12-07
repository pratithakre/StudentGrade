import java.util.Scanner;
class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        double[] grades = new double[numSubjects];
        double total = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter grade for subject " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i];
        }

        double average = total / numSubjects;
        System.out.println("Average Grade: " + average);

        String letterGrade;
        if (average >= 90) {
            letterGrade = "A";
        } else if (average >= 80) {
            letterGrade = "B";
        } else if (average >= 70) {
            letterGrade = "C";
        } else if (average >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        System.out.println("Overall Grade: " + letterGrade);
    }
}
