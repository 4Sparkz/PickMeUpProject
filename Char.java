import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Char {

    int id;
    String name;
    String gender;
    int attack;
    int hp;
    int initialAttack;
    int initialHp;
    int rarity;
    int exp;
    int level;
    int expLimit;
    int age;
    int lifespan;

    public final File male = new File("/Files/male.txt");
    public final File female = new File("/Files/female.txt");
    public final File surname = new File("/Files/last-names.txt");
    public final int genderOffset = 7;
    public final int maleSize = 2949;
    public final int femaleSize = 5007;
    public final int surnameSize = 88799;

    //TODO falta id
    public Char() throws FileNotFoundException {

         Random random = new Random();

            //Raridade
            int r = random.nextInt(1, 1000000); // 1 000 000
            if(r<1){ //0.0001% --- 0.0001%
                rarity = 7;
            }else if(r<10){// 0.001% --- 0.0009%
                rarity = 6;
            }else if(r<100){// 0.01% --- 0.0089%
                rarity = 5;
            }else if(r<1000){// 0.1% --- 0.0889%
                rarity = 4;
            }else if(r<10000){// 1% --- 0.8889%
                rarity = 3;
            }else if(r<100000){//10% --- 8.8889%
                rarity = 2;
            }else if(r<1000000){//100% --- 88.8889%
                rarity = 1;
            }else{
                rarity = 0;
            }

            //Name and gender
            r = random.nextInt(0,1);
            if(r == 0){
                gender = "M";
                Scanner sc = new Scanner(male);
                r = random.nextInt(1, maleSize);
                for(int i = 0; i<r; i++){
                    sc.nextLine();
                }
                name = sc.nextLine() + " ";
                sc.close();
            }else{
                gender = "F";
                Scanner sc = new Scanner(female);
                r = random.nextInt(1, femaleSize);
                for (int i = 0; i < r; i++) {
                    sc.nextLine();
                }
                name = sc.nextLine() + " ";
                sc.close();
            }
                Scanner sca = new Scanner(surname);
                r = random.nextInt(1, surnameSize);
                for (int i = 0; i < r; i++) {
                    sca.nextLine();
                }
                name.concat(sca.nextLine());
                sca.close();

            //atck hp
            r = random.nextInt(1, 10);
            hp = r*rarity;
            initialHp = hp;
            r = random.nextInt(1, 10);
            attack = r*rarity;
            initialAttack = attack;

            //exp lvl
            exp = 0;
            level = 1;
            expLimit = level/2*rarity*100;

            //age lifespan
            r = random.nextInt(1, 80);
            age = r;
            r = random.nextInt(age, 81+(rarity-1)*30);
            lifespan = r;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return name.split(" ")[0];
    }

    public String getSurname() {
        return name.split(" ")[1];
    }

    public String getGender() {
        return gender;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getInitialAttack() {
        return initialAttack;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getRarity() {
        return rarity;
    }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public int getAge() {
        return age;
    }

    public int getLifespan() {
        return lifespan;
    }

    public int getExpLimit() {
        return expLimit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExpLimit(int expLimit) {
        this.expLimit = expLimit;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }
}
