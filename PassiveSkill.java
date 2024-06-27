import java.util.List;

public class PassiveSkill extends Skill {

    public PassiveSkill(String name, String description, List<Clazz> compatibleClasses, Rarity rarity,
            List<SkillType> skillTypes, List<Skill> skillsRequired) {
        super(name, description, compatibleClasses, rarity, skillTypes, skillsRequired);
    }
    
}
