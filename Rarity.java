public enum Rarity {

    COMMON("Common", 1),
    UNCOMMON("Uncommon", 2),
    RARE("Rare", 3),
    EPIC("Epic", 4),
    LEGENDARY("Legendary", 5),
    MYTHIC("Mythic", 6),
    UNIQUE("Unique", 7);

    private String name;
    private int value;

    Rarity(String string, int value) {
        this.name = string;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
    
}
