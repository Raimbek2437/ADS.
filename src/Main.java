import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswerIndex + 1;
    }
}

class Quiz {
    private String title;
    private List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("\nStarting Quiz: " + title);
        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong answer!\n");
            }
        }
        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Java Basics");

        List<String> options1 = Arrays.asList("int", "double", "char", "string");
        List<String> options2 = Arrays.asList("class", "object", "method", "variable");

        quiz.addQuestion(new Question("Which data type is used to store whole numbers?", options1, 0));
        quiz.addQuestion(new Question("What is an instance of a class called?", options2, 1));

        quiz.startQuiz();
    }
}
