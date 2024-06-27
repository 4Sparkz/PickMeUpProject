import java.util.List;

public abstract class Skill {

    private int id;

    private String name;
    private String description;
    private List<Clazz> compatibleClasses;
    private Rarity rarity;
    private List<SkillType> skillTypes;
    private List<Skill> skillsRequired;

    public Skill(String name, String description, List<Clazz> compatibleClasses, Rarity rarity, List<SkillType> skillTypes, List<Skill> skillsRequired) {
        this.name = name;
        this.description = description;
        this.compatibleClasses = compatibleClasses;
        this.rarity = rarity;
        this.skillTypes = skillTypes;
        this.skillsRequired = skillsRequired;
    }
    
}
