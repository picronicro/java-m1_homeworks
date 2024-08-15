import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.setHealth(700);
        boss.setDamage(50);
        boss.setProtection("Magic");
        System.out.println(
                "Boss stats\n Health: " + boss.getHealth() +
                        "\n Damage: " + boss.getDamage() +
                        "\n Protection: " + boss.getProtection()
        );

        System.out.println();

        for (Hero hero : createHeroes()) {
            System.out.println(
                    "Hero stats\n Health: " + hero.getHealth() +
                            "\n Damage: " + hero.getDamage() +
                            "\n Ability: " + hero.getAbility()
            );
        }
    }

    public static Hero[] createHeroes() {
        Hero[] heroes = new Hero[3];
        for (int i = 0; i < 2; i++) {
            Random r = new Random();
            Hero hero = new Hero(r.nextInt(200) + 50, r.nextInt(30) + 20);
            heroes[i] = hero;
        }
        heroes[2] = new Hero(250, 25, "Devour");

        return heroes;
    }

}