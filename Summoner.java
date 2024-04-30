import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Summoner {

    public final int star7 = 20;
    public final int star6 = star7 + 50;
    public final int star5 = star6 + 150;
    public final int star4 = star5 + 400;
    public final int star3 = star4 + 1000;
    public final int star2 = star3 + 3000;
    public final int star1 = star2 + 6000;

    public final File male = new File("/Files/male.txt");
    public final File female = new File("/Files/female.txt");
    public final File surname = new File("/Files/last-names.txt");
    public final int genderOffset = 7;

    public void Summon(int n) throws FileNotFoundException{

        for(int i = 1; i<=n; i++){

            Random random = new Random();

            //Raridade
            int r = random.nextInt(1, star1);
            int rarity;
            if(r<star7){
                rarity = 7;
            }else if(r<star6){
                rarity = 6;
            }else if(r<star5){
                rarity = 5;
            }else if(r<star4){
                rarity = 4;
            }else if(r<star3){
                rarity = 3;
            }else if(r<star2){
                rarity = 2;
            }else if(r<star1){
                rarity = 1;
            }else{
                rarity = 0;
            }

            //Name and gender
            r = random.nextInt(0,1);
            String gender;
            String name;
            if(r == 0){
                gender = "M";
                Scanner sc = new Scanner(male);
                
            }
        }
    }

}
