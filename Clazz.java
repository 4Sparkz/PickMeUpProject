import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Clazz {

    COMMONER(Rarity.COMMON, List.of()),

    // DPS
    WARRIOR(Rarity.UNCOMMON, List.of(Attributes.STRENGTH)),
    SPEARMAN(Rarity.RARE, List.of(Attributes.STRENGTH, Attributes.DEXTERITY)),
    SWORDSMAN(Rarity.RARE, List.of(Attributes.STRENGTH)),
    KNIGHT(Rarity.EPIC, List.of(Attributes.STRENGTH)),
    LANCER(Rarity.EPIC, List.of(Attributes.STRENGTH, Attributes.DEXTERITY)),
    SWORDMASTER(Rarity.LEGENDARY, List.of(Attributes.STRENGTH, Attributes.DEXTERITY)),
    POLEMASTER(Rarity.LEGENDARY, List.of(Attributes.STRENGTH, Attributes.DEXTERITY)),
    WEAPON_MASTER(Rarity.MYTHIC, List.of(Attributes.STRENGTH)),
    SWORD_SAINT(Rarity.UNIQUE, List.of(Attributes.STRENGTH, Attributes.DEXTERITY, Attributes.CONSTITUTION)),
    
    HUNTER(Rarity.UNCOMMON, List.of(Attributes.DEXTERITY)),
    SCOUT(Rarity.RARE, List.of(Attributes.DEXTERITY)),
    ARCHER(Rarity.RARE, List.of(Attributes.DEXTERITY)),
    BOWMASTER(Rarity.MYTHIC, List.of(Attributes.DEXTERITY)),

    BANDIT(Rarity.UNCOMMON, List.of(Attributes.LUCK)),
    ROGUE(Rarity.RARE, List.of(Attributes.LUCK)),
    ASSASSIN(Rarity.EPIC, List.of(Attributes.LUCK)),
    
    // DPS MAGIC
    MAGE(Rarity.RARE, List.of(Attributes.MAGICAL_AFFINITY)),
    SORCERER(Rarity.EPIC, List.of(Attributes.MAGICAL_AFFINITY)),
    ELEMENTALIST(Rarity.LEGENDARY, List.of(Attributes.MAGICAL_AFFINITY)),
    WARLOCK(Rarity.LEGENDARY, List.of(Attributes.MAGICAL_AFFINITY)),
    NECROMANCER(Rarity.MYTHIC, List.of(Attributes.MAGICAL_AFFINITY)),
    ARCHMAGE(Rarity.UNIQUE, List.of(Attributes.MAGICAL_AFFINITY)),
    
    // TANK
    BARBARIAN(Rarity.RARE, List.of(Attributes.CONSTITUTION, Attributes.STRENGTH)),
    SHIELDER(Rarity.RARE, List.of(Attributes.STRENGTH, Attributes.CONSTITUTION)),
    PALADIN(Rarity.EPIC, List.of(Attributes.STRENGTH, Attributes.CONSTITUTION)),
    SENTINEL(Rarity.LEGENDARY, List.of(Attributes.STRENGTH, Attributes.CONSTITUTION)),

    // SUPPORT
    HERBALIST(Rarity.RARE, List.of(Attributes.INTELLIGENCE)),
    MEDIC(Rarity.RARE, List.of(Attributes.INTELLIGENCE)),
    CLERIC(Rarity.EPIC, List.of(Attributes.INTELLIGENCE)),
    BISHOP(Rarity.LEGENDARY, List.of(Attributes.INTELLIGENCE)),
    SAINT(Rarity.MYTHIC, List.of(Attributes.INTELLIGENCE)),
    APOSTLE(Rarity.UNIQUE, List.of(Attributes.INTELLIGENCE)),
    
    // UTILITY
    ALCHEMIST(Rarity.RARE, List.of(Attributes.INTELLIGENCE)),
    ENCHANTER(Rarity.RARE, List.of(Attributes.INTELLIGENCE)),
    BLACKSMITH(Rarity.RARE, List.of(Attributes.INTELLIGENCE, Attributes.CONSTITUTION, Attributes.STRENGTH)),
    ENGINEER(Rarity.RARE, List.of(Attributes.INTELLIGENCE)),
    ARTIFICER(Rarity.EPIC, List.of(Attributes.INTELLIGENCE, Attributes.MAGICAL_AFFINITY)),

    ALCHEMIST_MASTER(Rarity.LEGENDARY, List.of(Attributes.INTELLIGENCE, Attributes.MAGICAL_AFFINITY)),
    ENCHANTER_MASTER(Rarity.LEGENDARY, List.of(Attributes.INTELLIGENCE, Attributes.MAGICAL_AFFINITY)),
    BLACKSMITH_MASTER(Rarity.LEGENDARY, List.of(Attributes.INTELLIGENCE, Attributes.MAGICAL_AFFINITY)),
    ENGINEER_MASTER(Rarity.LEGENDARY, List.of(Attributes.INTELLIGENCE, Attributes.MAGICAL_AFFINITY)),
    ARTIFICER_MASTER(Rarity.LEGENDARY, List.of(Attributes.INTELLIGENCE, Attributes.MAGICAL_AFFINITY));

    private final Rarity rarity;

    private final List<Attributes> attributes;

    Clazz(Rarity rarity, List<Attributes> attributes) {
        this.rarity = rarity;
        this.attributes = attributes;
    }

    public int getRarity() {
        return rarity.getValue();
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }

    public static List<Clazz> findPossibleEvolutions(Clazz currentClass) {

        if(currentClass.equals(Clazz.COMMONER)) {
            return Arrays.stream(Clazz.values())
                    .filter(c -> c.getRarity() == 2)
                    .collect(Collectors.toList());
        }

        int nextRarity = currentClass.getRarity() + 1;
        return Arrays.stream(Clazz.values())
                .filter(c -> c.getRarity() == nextRarity && !Collections.disjoint(c.getAttributes(), currentClass.getAttributes()))
                .collect(Collectors.toList());
    }

    public static Clazz evolve(Clazz currentClass) {
        List<Clazz> possibleEvolutions = findPossibleEvolutions(currentClass);

        System.out.println("Possible evolutions: " + possibleEvolutions);

        if (!possibleEvolutions.isEmpty()) {
            int index = new Random().nextInt(possibleEvolutions.size());
            System.out.println("Evolving to: " + possibleEvolutions.get(index));
            return possibleEvolutions.get(index);
        }
        return currentClass;
    }
    
}
