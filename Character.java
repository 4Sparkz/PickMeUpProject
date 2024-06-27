import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Character {

    int id;
    String name;
    String gender;
    int age;
    int lifespan;
    int rarity;
    int exp;
    int level;

    int talent; //first rarity

    Clazz charClass;

    int baseAttack;
    int currentHp;
    int expLimit;

    Map<Attributes, int[]> attributes = new LinkedHashMap<>();
    List<Skill> skills = new ArrayList<>();


    Random random = new Random();

    public Character(int id, String name, String gender, int rarity) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.talent = rarity;
        this.gender = gender;
        this.age = random.nextInt(1, 80);
        int lifespanBound = Math.max(2, 80 * rarity - age - 1);
        this.lifespan = age + random.nextInt(1, lifespanBound);
        this.exp = 0;
        this.level = 1;
        this.expLimit = 100+(rarity-1)*50+level*level*(level/2);                
        generateStats();
        generateClass();

    }

    private void generateClass() {
        
        if (rarity == 1) {
            charClass = Clazz.COMMONER;
            return;
        }
    
        Attributes highestStat = findHighestAttribute();

        charClass = Clazz.getFirstClazz(highestStat);
        if (rarity == 2) {
            return;
        }

        int counter = rarity ;
        while(counter > 2) {
            charClass = Clazz.evolve(charClass);
            counter--;
        }

            

    }

    private Attributes findHighestAttribute() {
        List<int[]> stats = new ArrayList<>(attributes.values());

        int highestStatValue = stats.get(0)[0];
        int highestStatIndex = 0;

        for (int i = 1; i < stats.size(); i++) {
            if (stats.get(i)[0] > highestStatValue) {
                highestStatValue = stats.get(i)[0];
                highestStatIndex = i;
            }
        }

        return (Attributes) attributes.keySet().toArray()[highestStatIndex];
    }

    private void generateStats() {
        int r = random.nextInt(1, 11);
        int[] strength = {r + random.nextInt(rarity / 2, 5 + rarity), r};
        
        r = random.nextInt(1, 11);
        int[] dexterity = {r + random.nextInt(rarity / 2, 5 + rarity), r};
        
        r = random.nextInt(1, 11);
        int[] constitution = {r + random.nextInt(rarity / 2, 5 + rarity), r};
        
        r = random.nextInt(1, 11);
        int[] luck = {r + random.nextInt(rarity / 2, 5 + rarity), r};
        
        r = random.nextInt(1, 11);
        int[] intelligence = {r + random.nextInt(rarity / 2, 5 + rarity), r};
        
        r = random.nextInt(1, 11);
        int[] magic_affinity = {r + random.nextInt(rarity / 2, 5 + rarity), r};
        
        r = random.nextInt(1, 11);
        int[] magic_res = {r + random.nextInt(rarity / 2, 5 + rarity), r};

        r = random.nextInt(1, 11);
        int[] phy_res = {r + random.nextInt(rarity / 2, 5 + rarity), r};

        attributes.put(Attributes.STRENGTH, strength);
        attributes.put(Attributes.DEXTERITY, dexterity);
        attributes.put(Attributes.CONSTITUTION, constitution);
        attributes.put(Attributes.LUCK, luck);
        attributes.put(Attributes.INTELLIGENCE, intelligence);
        attributes.put(Attributes.MAGICAL_AFFINITY, magic_affinity);
        attributes.put(Attributes.MAGIC_RES, magic_res);
        attributes.put(Attributes.PHYSICAL_RES, phy_res);

    }

    private void updateStats() {
        int[] strength = attributes.get(Attributes.STRENGTH);
        strength[0] += strength[1] + random.nextInt(rarity / 2, 5 + rarity);

        int[] dexterity = attributes.get(Attributes.DEXTERITY);
        dexterity[0] += dexterity[1] + random.nextInt(rarity / 2, 5 + rarity);

        int[] constitution = attributes.get(Attributes.CONSTITUTION);
        constitution[0] += constitution[1] + random.nextInt(rarity / 2, 5 + rarity);

        int[] luck = attributes.get(Attributes.LUCK);
        luck[0] += luck[1] + random.nextInt(rarity / 2, 5 + rarity);

        int[] intelligence = attributes.get(Attributes.INTELLIGENCE);
        intelligence[0] += intelligence[1] + random.nextInt(rarity / 2, 5 + rarity);

        int[] magicAffinity = attributes.get(Attributes.MAGICAL_AFFINITY);
        magicAffinity[0] += magicAffinity[1] + random.nextInt(rarity / 2, 5 + rarity);

        int[] magicRes = attributes.get(Attributes.MAGIC_RES);
        magicRes[0] += magicRes[1] + random.nextInt(rarity / 2, 5 + rarity);

        int[] phyRes = attributes.get(Attributes.PHYSICAL_RES);
        phyRes[0] += phyRes[1] + random.nextInt(rarity / 2, 5 + rarity);
    }

    public void addExp(int exp) {
        this.exp += exp;
        if (this.exp >= expLimit) {
            this.exp = this.exp - expLimit;
            levelUp();
        }

    }

    public void levelUp() {
        this.level++;
        this.expLimit = 100+(rarity-1)*50+level*level*(level/2);
        updateStats();       
    }

    public void rankUp() {
        if (this.rarity == 7) {
            System.out.println("Max rarity reached");
            return;
        }
        this.rarity++;
        this.level = 1;
        this.exp = 0;
        this.expLimit = 100+(rarity-1)*50+level*level*(level/2);
        updateStats();

        if(charClass.equals(Clazz.COMMONER)) {
            generateClass();
        } else {
            int baseEvolveChance = 5;
            int talentBonus = talent * 5;
            int evolveChance = baseEvolveChance + talentBonus;
            int evolveRoll = random.nextInt(1, 101);
            System.out.println("Evolve roll: " + evolveRoll + " Evolve chance: " + evolveChance);
            if (evolveRoll <= evolveChance) {
                evolve();
            } else {
                evolve();
                System.out.println("Not evolving");
            }
        }

    }

    public void evolve() {
        System.out.println("Evolving...");
        charClass = Clazz.evolve(charClass);
    }

    public int getMaxHp() {
        return 100 + attributes.get(Attributes.CONSTITUTION)[0]*10;
    }


    public String toString() {
        String attributesStr = "";
        for (Attributes a : attributes.keySet()) {
            attributesStr += a.getName() + ": " + Arrays.toString(attributes.get(a)) + "\n\t";
        }
        return "Id: " + id + " Name: " + name + " Rarity: " + rarity + " Classe: " + charClass + " Level: " + level + " Exp: " + exp + " Exp Limit: " + expLimit + " Age: " + age + " Lifespan: " + lifespan + "\n\t"
        + attributesStr;
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
