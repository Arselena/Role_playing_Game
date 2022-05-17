import java.util.Scanner;
import java.util.Set;

public class Hero extends Character {
    private int level;
    private int statPoints;
    private static Scanner sc;
    private static String choisMenu;

    public Hero(String name) {
        super(name);
        this.level = 1;
        this.statPoints = 3;
    }

    public Hero(String name, int dexterity, int health, int force, int exp, int gold) {
        super(name, dexterity, health, force, exp, gold);
        this.level = 1;
        this.statPoints = 3;
    }

    public int getLevel() {
        return level;
    }

    public int getStatPoints() {
        return statPoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStatPoints(int statPoints) {
        this.statPoints = statPoints;
    }

    @Override
    public int attack() {
        return super.attack() + getExp();
    }

    public void useStatPoints() {
        int amount;
        while (true) {
            choisMenu = this.menu();
            switch (choisMenu) {
                case "1": {
                    amount = menuChois("ловкость");
                    this.setDexterity(this.getDexterity() + amount);
                    statPoints -= amount;
                    System.out.println(this);
                    break;
                }
                case "2": {
                    // создаем монстра
                    amount = menuChois("сила");
                    this.setForce(this.getForce() + amount);
                    statPoints -= amount;
                    System.out.println(this);
                    break;
                }
                case "3": {
                    return;
                }
            }
        }
    }

    private String menu() {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Вы можете распределить StatPoints на ловкость и силу " + "\n" +
                    "1. Добавить ловкость" + "\n" +
                    "2. Добавить силу" + "\n" +
                    "3. Вернуться в главное меню \n -> ");
            Set<String> set = Set.of("1", "2", "3");
            choisMenu = sc.next();
            if (set.contains(choisMenu)) {
                return choisMenu;
            } else System.out.println("Вы не выбрали пункт меню. Попробуйте еще раз");
        }
    }

    private int menuChois(String nameChois) {
        sc = new Scanner(System.in);
        System.out.print("У вас " + this.statPoints + " StatPoints. Сколько добавить к " + nameChois + "? -> ");
        choisMenu = sc.next();
        try {
            if (Integer.parseInt(choisMenu) <= this.statPoints) {
                return Integer.parseInt(choisMenu);
            }
            else System.out.println("Нет у вас столько StatPoints");
        } catch (NumberFormatException e) {
            System.out.println("Что-то пошло не так");
        }
        return 0;
    }

    @Override
    public String toString() {
        return getName() + ": ловкость=" + getDexterity() +
                ", здоровье=" + getHealth() +
                ", сила=" + getForce() +
                ", опыт=" + getExp() +
                ", уровень=" + level +
                ", StartPoints=" + statPoints +
                ", золото=" + getGold();

    }
}