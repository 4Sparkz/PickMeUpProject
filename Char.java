public class Char {

    int id;
    String name;
    String gender;
    int attack;
    int hp;
    int rarity;
    int exp;
    int level;
    int expLimit;

    public Char(int id, String name, String gender, int attack, int hp, int rarity, int expLimit){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.attack = attack;
        this.hp = hp;
        this.rarity = rarity;
        this.exp = 0;
        this.level = 1;
        this.expLimit = expLimit;
    }

    public Char(int id) {
        this.id = id;
        this.name = null;
        this.attack = -1;
        this.hp = -1;
        this.rarity = -1;
        this.exp = 0;
        this.level = 1;
        this.expLimit = -1;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public int getHp(){
        return hp;
    }
    public int getAttack(){
        return attack;
    }
    public int getRarity(){
        return rarity;
    }
    public int getExp(){
        return exp;
    }
    public int getLevel(){
        return level;
    }
    public int getExpLimit(){
        return expLimit;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setRarity(int rarity){
        this.rarity = rarity;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setExpLimit(int expLimit){
        this.expLimit = expLimit;
    }
}
