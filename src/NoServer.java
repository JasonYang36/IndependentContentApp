import java.io.*;
import java.util.Scanner;

public class NoServer {
    public static String[] CreateQuestions(){
        //Set n to number of questions
        int n = 3;
        String[] res = new String[n];

        //Set questions here
        res[0] = "Enter 1.";
        res[1] = "Enter 2.";
        res[2] = "Enter 3.";
        //Increase/decrease as needed

        return res;
    }

    public static String[] Survey(String[] questions){
        Scanner keyboard = new Scanner(System.in);

        String[] res = new String[questions.length];
        for(int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            String answer = keyboard.nextLine();
            res[i] = answer;
        }

        keyboard.close();
        return res;
    }

    public static void main(String[] args) {
        String[] questions;
        String[] answers;

        questions = CreateQuestions();
        answers = Survey(questions);


    }
}
