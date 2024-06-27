import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillRepository {

    private static final Map<Integer, Skill> skills = new HashMap<>();

    // initialize skills
    static {
        Integer counter = 0;
        skills.put(counter++, new ActiveSkill("Fireball", "A fireball that deals damage", List.of(Clazz.MAGE), Rarity.COMMON, List.of(SkillType.DAMAGE, SkillType.MAGIC), List.of()));
        skills.put(counter++, new ActiveSkill("Heal", "Heals a target", List.of(Clazz.CLERIC), Rarity.COMMON, List.of(SkillType.HEALING), List.of()));
        skills.put(counter++, new ActiveSkill("Slash", "A basic attack", List.of(Clazz.WARRIOR), Rarity.COMMON, List.of(SkillType.DAMAGE), List.of()));
        skills.put(counter++, new ActiveSkill("Stab", "A basic attack", List.of(Clazz.ROGUE), Rarity.COMMON, List.of(SkillType.DAMAGE), List.of()));
        skills.put(counter++, new ActiveSkill("Bash", "A basic attack", List.of(Clazz.SHIELDER), Rarity.COMMON, List.of(SkillType.DAMAGE), List.of()));
        skills.put(counter++, new ActiveSkill("Shoot", "A basic attack", List.of(Clazz.ARCHER), Rarity.COMMON, List.of(SkillType.DAMAGE), List.of()));
        skills.put(counter++, new ActiveSkill("Bolt", "A basic attack", List.of(Clazz.MAGE), Rarity.COMMON, List.of(SkillType.DAMAGE), List.of())); 
    }
    
}
