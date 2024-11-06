import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static final int TIME_LIMIT = 10;   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         
        String[][] questions = {
            {"What is the capital of France?", "1. Paris", "2. Rome", "3. London", "4. Madrid", "1"},
            {"Who developed Java?", "1. Microsoft", "2. Sun Microsystems", "3. Oracle", "4. IBM", "2"},
            {"What is the largest planet in our solar system?", "1. Earth", "2. Mars", "3. Jupiter", "4. Saturn", "3"}
        };

        System.out.println("Welcome to the Quiz Application!");

         
        for (String[] question : questions) {
            if (!askQuestion(scanner, question)) {
                System.out.println("Time's up! Moving to the next question.");
            }
        }

        System.out.println("Quiz Over! Your final score is: " + score);
        scanner.close();
    }

 
    private static boolean askQuestion(Scanner scanner, String[] question) {
        System.out.println("\n" + question[0]);
        System.out.println(question[1]);
        System.out.println(question[2]);
        System.out.println(question[3]);
        System.out.println(question[4]);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                timer.cancel();
            }
        };

        timer.schedule(task, TIME_LIMIT * 1000);   

        System.out.print("Enter your answer (1-4): ");
        long startTime = System.currentTimeMillis();
        boolean answered = false;

        while ((System.currentTimeMillis() - startTime) < TIME_LIMIT * 1000 && !answered) {
            if (scanner.hasNextInt()) {
                int answer = scanner.nextInt();
                timer.cancel();  

                if (String.valueOf(answer).equals(question[5])) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong answer.");
                }
                answered = true;
            }
        }

        return answered;
    }
}
