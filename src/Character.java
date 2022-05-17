public abstract class Character implements Fighterable {
    private String name;
    private int dexterity; // ловкость
    private int health;  // здоровье
    private int force; // сила
    private int exp; // опыт
    private int gold; // золото

    public Character(String name) {
        this.name = name;
        this.dexterity = 5;
        this.health = 100;
        this.force = 10;
        this.exp = 1;
        this.gold = 100;
    }

    public Character(String name, int dexterity, int health, int force, int exp, int gold) {
        this.name = name;
        this.dexterity = dexterity;
        this.health = health;
        this.force = force;
        this.exp = exp;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getHealth() {
        return health;
    }

    public int getForce() {
        return force;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setHealth(int health) {
        if (health > 0) {
            this.health = health;
        }
        else this.health = 0;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public int attack() {
        if (dexterity * 3 > (int)(Math.random() * 100)) return force;
        return 0;
    }

    @Override
    public String toString() {
        return name + ": ловкость=" + dexterity +
                ", здоровье=" + health +
                ", сила=" + force +
                ", опыт=" + exp +
                ", золото=" + gold;
    }
}
