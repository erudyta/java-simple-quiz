import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Quiz quiz = new Quiz(wyborQuizu());
        quiz.play();

    }

    public static String wyborQuizu(){
        Scanner scanner = new Scanner(System.in);
        String quizName;
        int wybor;
        System.out.println("Jaki quiz chcesz wybrac?");
        System.out.println("1. Geograficzny");
        System.out.println("2. Sportowy");
        System.out.println("3. Wiedza Ogolna");
        wybor = Integer.parseInt(scanner.nextLine());

        switch (wybor){
            case 1 -> quizName = "GeograficznyQuiz.json";
            case 2 -> quizName = "SportowyQuiz.json";
            case 3 -> quizName = "WiedzaOgolnaQuiz.json";
            default -> quizName = "SportowyQuiz.json";
        }
    return quizName;
    }
}
