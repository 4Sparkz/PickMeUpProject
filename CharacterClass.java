public class CharacterClass {

    private Clazz clazz;
    private String rarity;
    
    public CharacterClass(Clazz clazz) {
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }
    
    public String toString() {
        return clazz.toString();
    }
    
}
