import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Abilities[] abilities = Abilities.values();
        Hero[] heroes = {new Magic(), new Medic(), new Warrior()};

        for (Hero hero : heroes) {
            Random r = new Random();
            hero.setHealth(r.nextInt(200) + 50);
            hero.setDamage(r.nextInt(50) + 20);
            hero.setSuperAbility(abilities[r.nextInt(0, abilities.length)].toString());
            hero.applySuperAbility();

            if (hero instanceof Medic) {
                Medic medic = (Medic) hero;
                System.out.println("Medic' heal points before: " + medic.getHealPoints());
                medic.increaseExperience();
                System.out.println("Medic' heal points after: " + medic.getHealPoints());
            }
        }
    }

}
