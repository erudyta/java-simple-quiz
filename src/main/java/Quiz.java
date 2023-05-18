import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    File questionJson;

    public Quiz(String fileName) {
        String file = this.getClass().getResource(fileName).getFile();
        questionJson = new File(file);
        //System.out.println(file);
    }


    public void play() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ilu jest uczestników konkursu? ");
        int numberOfParticipant = Integer.parseInt(scanner.nextLine());

        List<Participant> participants = participants(numberOfParticipant, scanner);
        System.out.println(participants.size());

        ObjectMapper mapper = new ObjectMapper();
        List<Question> questions = mapper.readValue(questionJson, new TypeReference<>() {});

        for (Question question : questions) {
            System.out.println(question.getPytanie());
            System.out.println("a: " + question.getA());
            System.out.println("b: " + question.getB());
            System.out.println("c: " + question.getC());
            System.out.println("d: " + question.getD());

            for (int i = 0; i <= participants.size()-1; i++) {
                String name = participants.get(i).getName();
                System.out.println("Odpowiedz uczestnika " + name +": ");
                String answer = scanner.nextLine();
                if (answer.equals(question.getPrawidlowaOdpowiedz())){
                    participants.get(i).dodajPunkt();
                }
            }
            System.out.println("Prawidlowa odpopwiedz: " + question.getPrawidlowaOdpowiedz());
            System.out.println("Aktualna punktacja: ");
            for (int i = 0; i <= participants.size() -1; i++) {
                String name = participants.get(i).getName();
                System.out.println(name +": " + participants.get(i).getScore());
            }
            Thread.sleep(3000);
        }
        scanner.close();
    }


    public List<Participant> participants(int numberOfParticipant, Scanner scanner) throws IOException {
        String name;
        List<Participant> participants = new ArrayList<>();
        for (int i = 1; i < numberOfParticipant + 1; i++) {
            System.out.println("Imie " + i + " uczestnika: ");
            name = scanner.nextLine();
            Participant participant = new Participant(name);
            participants.add(participant);
        }
        return participants;
    }
}

