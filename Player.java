import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private static List<Character> myCharacters = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            do {

                printMenu();

                String input = sc.nextLine();

                String[] inputArray = input.split(" ");

                switch(inputArray[0].toLowerCase()) {

                    case "c":
                        System.out.println("Showing characters");

                        for (Character c : myCharacters) {
                            System.out.println(c);
                        }
                        break;
                    
                    case "s":
                        if (inputArray.length < 2) {
                            System.out.println("Correct format: S <number>");
                            continue;
                        }
                        int n = Integer.parseInt(inputArray[1]);
                        List<Character> newChars = Summoner.summon(n);
                        myCharacters.addAll(newChars);

                        // for (Character c : newChars) {
                        //     System.out.println(c);
                        // }
                        break;
                    
                    case "r":
                        if (inputArray.length < 2) {
                            System.out.println("Correct format: R <id>");
                            continue;
                        }
                        int id = Integer.parseInt(inputArray[1]);
                        Character c = myCharacters.stream().filter(ch -> ch.getId() == id).findFirst().orElse(null);

                        if (c == null) {
                            System.out.println("Character not found");
                            continue;
                        }

                        c.rankUp();

                        break;
                        
                    case "q":
                        System.out.println("Quitting...");
                        return;
                    default:
                        System.out.println("Invalid command");
                        break;

                }

            } while(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printMenu() {
        System.out.println("\n------------------------------------------");
        System.out.println("C - show characters");
        System.out.println("S <number> - summon new characters");
        System.out.println("R <id> - rank up character");
        System.out.println("Q - quit");
        System.out.println("------------------------------------------");
        System.out.print("> ");
    }
    
}
