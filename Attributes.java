public enum Attributes {

    STRENGTH("Strength"),
    DEXTERITY("Dexterity"),
    INTELLIGENCE("Intelligence"),
    CONSTITUTION("Constitution"),
    LUCK("Luck"),
    MAGICAL_AFFINITY("Magical Affinity"),
    MAGIC_RES("Magic Resistance"),
    PHYSICAL_RES("Physical Resistance");

    private String name;

    Attributes(String string) {
        this.name = string;
    }

    public String getName() {
        return name;
    }   
    
}
