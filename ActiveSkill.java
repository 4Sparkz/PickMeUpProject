import java.util.List;

public class ActiveSkill extends Skill {

    public ActiveSkill(String name, String description, List<Clazz> compatibleClasses, Rarity rarity,
            List<SkillType> skillTypes, List<Skill> skillsRequired) {
        super(name, description, compatibleClasses, rarity, skillTypes, skillsRequired);
    }
    
}
