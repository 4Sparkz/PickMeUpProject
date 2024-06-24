import java.util.List;
import java.util.Scanner;

public class Player {

    List<Character> myCharacters;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            do {

                printMenu();

                String input = sc.nextLine();

                String[] inputArray = input.split(" ");

                if (inputArray[0].equalsIgnoreCase("C")) {
                    System.out.println("Showing characters");
                } else if (inputArray[0].equalsIgnoreCase("S")) {
                    if (inputArray.length < 2) {
                        System.out.println("Correct format: S <number>");
                        continue;
                    }
                    int n = Integer.parseInt(inputArray[1]);
                    List<Character> chars = Summoner.summon(n);

                    for (Character c : chars) {
                        System.out.println(c);
                    }

                } else if (inputArray[0].equalsIgnoreCase("Q")) {
                    System.out.println("Quitting...");
                    break;
                } else {
                    System.out.println("Invalid command");
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
        System.out.println("Q - quit");
        System.out.println("------------------------------------------");
        System.out.print("> ");
    }
    
}
