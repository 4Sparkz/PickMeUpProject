import java.util.Arrays;
import java.util.List;
import java.util.Random;


public enum Clazz {

    COMMONER(Rarity.COMMON, List.of()),

    // DPS
    WARRIOR(Rarity.UNCOMMON, List.of()),
        SWORDSMAN(Rarity.RARE, List.of(WARRIOR)),
            KNIGHT(Rarity.EPIC, List.of()),
                SWORDMASTER(Rarity.LEGENDARY, List.of()),
                    SWORD_GRANDMASTER(Rarity.MYTHIC, List.of()),
                        SWORD_SAINT(Rarity.UNIQUE, List.of()),
        SPEARMAN(Rarity.RARE, List.of(WARRIOR)),
            LANCER(Rarity.EPIC, List.of()),
                POLEMASTER(Rarity.LEGENDARY, List.of()),
                    POLE_GRANDMASTER(Rarity.MYTHIC, List.of()),
                        SPEAR_SAINT(Rarity.UNIQUE, List.of()),
        BARBARIAN(Rarity.RARE, List.of(WARRIOR)),
            BERSERKER(Rarity.EPIC, List.of()),
            VIKING(Rarity.EPIC, List.of()),

    HUNTER(Rarity.UNCOMMON, List.of()),
        SCOUT(Rarity.RARE, List.of()),
            SABOTEUR(Rarity.EPIC, List.of()),
            BEASTMASTER(Rarity.EPIC, List.of()),
        ARCHER(Rarity.RARE, List.of()),
            BOWMAN(Rarity.EPIC, List.of()),
                BOWMASTER(Rarity.LEGENDARY, List.of()),
                    BOW_GRANDMASTER(Rarity.MYTHIC, List.of()),
                        BOW_SAINT(Rarity.UNIQUE, List.of()),
            CROSSBOWMAN(Rarity.EPIC, List.of()),
                MUSKETEER(Rarity.LEGENDARY, List.of()),
                    GUNSLINGER(Rarity.MYTHIC, List.of()),
                        GUN_SAINT(Rarity.UNIQUE, List.of()),

    BANDIT(Rarity.UNCOMMON, List.of()),
        ROGUE(Rarity.RARE, List.of()),
            ASSASSIN(Rarity.EPIC, List.of()),
                POISON_MASTER(Rarity.LEGENDARY, List.of()),

                DAGGER_MASTER(Rarity.LEGENDARY, List.of()),
                    SHADOW_DANCER(Rarity.MYTHIC, List.of()),
                        ASSASSIN_LORD(Rarity.UNIQUE, List.of()),
        THIEF(Rarity.RARE, List.of()),
            BANDIT_LORD(Rarity.EPIC, List.of()),
                SWINDLER(Rarity.LEGENDARY, List.of()),
                    SPECTRAL_THIEF(Rarity.MYTHIC, List.of()),
                        TRICKSTER(Rarity.UNIQUE, List.of()),
    
    TANK(Rarity.UNCOMMON, List.of()),
        SHIELDER(Rarity.RARE, List.of()),
            PALADIN(Rarity.EPIC, List.of()),
                SENTINEL(Rarity.LEGENDARY, List.of()),
                    GUARDIAN(Rarity.MYTHIC, List.of()),
                        IMMORTAL(Rarity.UNIQUE, List.of()),

    BEGINNER_MAGE(Rarity.UNCOMMON, List.of()),
        MAGE(Rarity.RARE, List.of()),
            SORCERER(Rarity.EPIC, List.of()),
                DARK_MAGE(Rarity.LEGENDARY, List.of()),
                    WARLOCK(Rarity.MYTHIC, List.of()),
                        DEMON_LORD(Rarity.MYTHIC, List.of()),
                    NECROMANCER(Rarity.MYTHIC, List.of()),
                        OVERLORD(Rarity.UNIQUE, List.of()),
                    SPIRITUALIST(Rarity.LEGENDARY, List.of()),
                        SPIRIT_MASTER(Rarity.MYTHIC, List.of()),
                            SPIRIT_SAINT(Rarity.UNIQUE, List.of()),
            ELEMENTALIST(Rarity.LEGENDARY, List.of()),
                GRANDMAGE(Rarity.MYTHIC, List.of()),
                    ARCHMAGE(Rarity.UNIQUE, List.of()),
        PRIEST(Rarity.RARE, List.of()),
            CLERIC(Rarity.EPIC, List.of()),
                BISHOP(Rarity.LEGENDARY, List.of()),
                    CARDINAL(Rarity.MYTHIC, List.of()),
                        SAINT(Rarity.UNIQUE, List.of()),

    APPRENTICE(Rarity.UNCOMMON, List.of()),
        HERBALIST(Rarity.RARE, List.of()),
            POTION_MAKER(Rarity.EPIC, List.of()),
                ALCHEMIST(Rarity.LEGENDARY, List.of()),
            MEDIC(Rarity.EPIC, List.of()),
        TINKERER(Rarity.RARE, List.of()),
            ENCHANTER(Rarity.EPIC, List.of()),
            BLACKSMITH(Rarity.EPIC, List.of()),
                BLACKSMITH_MASTER(Rarity.LEGENDARY, List.of()),
        ENGINEER(Rarity.RARE, List.of()),
        FARMER(Rarity.RARE, List.of()),
        CHEF(Rarity.RARE, List.of()),
        TEACHER(Rarity.RARE, List.of());

    private final Rarity rarity;
    // private final List<Attributes> attributes;

    private List<Clazz> fatherClasses;

    Clazz(Rarity rarity, List<Clazz> sub) {
        this.rarity = rarity;
        this.fatherClasses = sub;
    }

    public int getRarity() {
        return rarity.getValue();
    }

    public static Clazz evolve(Clazz currentClass) {
        List<Clazz> possible = Arrays.stream(Clazz.values())
                .filter(c -> c.fatherClasses.contains(currentClass)).toList();
        
        return possible.get(new Random().nextInt(possible.size())); 
    }

    public static Clazz getFirstClazz(Attributes highestStat) {
        switch (highestStat) {
            case STRENGTH:
                return WARRIOR;
            case DEXTERITY:
                return HUNTER;
            case INTELLIGENCE:
                return APPRENTICE;
            case MAGICAL_AFFINITY:
                return BEGINNER_MAGE;
            case LUCK:
                return BANDIT;                    
            default:
                return TANK;
        } 
    }
    
}
