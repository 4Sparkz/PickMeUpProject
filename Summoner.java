import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Summoner {

    private static final Random random = new Random();

    private static int idCounter = 0;

    private final static File male = new File("txtFiles/male.txt");
    private final static File female = new File("txtFiles/female.txt");
    private final static File surname = new File("txtFiles/last-names.txt");

    private static List<String> maleNames = new ArrayList<>();
    private static List<String> femaleNames = new ArrayList<>();
    private static List<String> lastNames = new ArrayList<>();

    static {
        loadNames(male, maleNames, 7);
        loadNames(female, femaleNames, 7);
        loadNames(surname, lastNames, 0);
    }

    private static void loadNames(File file, List<String> namesList, int offset) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                if (lineCount < offset-1) {
                    lineCount++;
                    continue;
                }
                namesList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateName(String gender) {
        String name;
        if(gender.equals("Male")) {
            name = maleNames.get(random.nextInt(maleNames.size()));
        } else {
            name = femaleNames.get(random.nextInt(femaleNames.size()));
        }
        name += " " + lastNames.get(random.nextInt(lastNames.size()));
        return name;
    }

    public static List<Character> summon(int n) throws FileNotFoundException {

        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int rarity = calculateExponentialRarity();
            String gender = random.nextInt(2) == 0 ? "Male" : "Female";
            String name = generateName(gender);
            System.out.println("Summoned " + name + " with rarity " + rarity + " stars");
            chars.add(new Character(idCounter, name, gender, rarity));
            idCounter++;
        }
        return chars;
    }

    private static int calculateExponentialRarity() {
        double rand = random.nextDouble() * 100;
    
        if (rand < 88.8889) return 1;
        else if (rand < 88.8889 + 10) return 2;
        else if (rand < 98.8889 + 1) return 3;
        else if (rand < 99.8889 + 0.1) return 4;
        else if (rand < 99.9889 + 0.01) return 5;
        else if (rand < 99.9989 + 0.001) return 6;
        else return 7;
    }

}
