public enum Clazz {

    COMMONER(1),
    WARRIOR(2),     // STR
    HUNTER(2),      // DEX
    MAGE(2),        // MAGIC AFFINITY
    CLERIC(2),      // MAGIC RES
    ROGUE(2),       // LUCK
    BARBARIAN(2);   // CON

    private int minRarity;

    Clazz(int minRarity) {
        this.minRarity = minRarity;
    }
    
}
