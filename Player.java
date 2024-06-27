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

                        if(inputArray.length < 2) {
                            System.out.println("Showing all characters");

                            for (Character c : myCharacters) {
                                System.out.println(c);
                            }
                            break;
                        }

                        int id = Integer.parseInt(inputArray[1]);

                        Character c = myCharacters.stream().filter(ch -> ch.getId() == id).findFirst().orElse(null);

                        characterMenu(c);
                    
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
        System.out.println("C - show all characters");
        System.out.println("C <id> - show character <id>");
        System.out.println("S <number> - summon new characters");
        System.out.println("Q - quit");
        System.out.println("------------------------------------------");
        System.out.print("> ");
    }

    private static void characterMenu(Character c) {
        
        boolean exited = false;
        
        while(!exited) {
            printCharacterMenu(c);
            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine().toLowerCase()) {
                case "l":
                    System.out.println("Leveling up character");
                    break;
                case "r":
                    c.rankUp();
                    break;
                case "b":
                    exited = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }

    }

    private static void printCharacterMenu(Character c) {
        System.out.println("\n------------------------------------------\n");
        System.out.print(c);
        System.out.println("\n------------------------------------------");
        System.out.println("L - level up character");
        System.out.println("R - rank up character");
        System.out.println("B - go back");
        System.out.println("------------------------------------------");
        System.out.print("> ");
    }
    
}
