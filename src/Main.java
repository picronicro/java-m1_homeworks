import java.util.Objects;
import java.util.Random;

public class Main {

    public static final int GOLEM_INDEX = 4;
    public static final int WITCHER_INDEX = 6;

    public static int bossHealth = 1500;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static boolean isStunned = false;
    public static int[] heroesHealth = {290, 270, 250, 350, 635, 280, 450, 290};
    public static int[] heroesDamage = {20, 15, 10, 0, 5, 10, 0, 15};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Golem", "Lucky", "Witcher", "Thor"};
    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static void playRound() {
        roundNumber++;
        if (!isStunned) {
            chooseBossDefence();
            bossAttacks();
        } else {
            isStunned = false;
            System.out.println("The boss is out of stun.");
        }
        heroesAttack();
        printStatistics();
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length); // 0, 1, 2
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void bossAttacks() {
        int absorbedDamage = (int) (bossDamage * 0.2);
        boolean isGolemAlive = heroesHealth[GOLEM_INDEX] > 0;

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesAttackType[i].equals("Lucky")) {
                    if (new Random().nextBoolean()) {
                        System.out.println("Lucky has dodged an attack.");
                        continue;
                    }
                }

                int newDmg = bossDamage;
                // golem' damage absorption
                if (isGolemAlive) {
                    newDmg = bossDamage - absorbedDamage;
                    heroesHealth[4] -= absorbedDamage;
                    if (heroesHealth[GOLEM_INDEX] < 0) heroesHealth[GOLEM_INDEX] = 0;
                }

                // deal damage
                if (heroesHealth[i] - newDmg < 0) {
                    if (heroesHealth[WITCHER_INDEX] > 0) {
                        heroesHealth[i] = heroesHealth[WITCHER_INDEX];
                        heroesHealth[WITCHER_INDEX] = 0;
                        System.out.println("Witcher sacrificed his life for " + heroesAttackType[i] + ".");
                    } else {
                        heroesHealth[i] = 0;
                    }
                } else {
                    heroesHealth[i] = heroesHealth[i] - newDmg;
                }
            }
        }
    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                // Medic' special
                if (heroesAttackType[i].equals("Medic")) {
                    for (int j = 0; j < heroesHealth.length; j++) {
                        int hp = heroesHealth[j];
                        if (hp < 100 && !heroesAttackType[j].equals("Medic")) {
                            int heal = new Random().nextInt(40) + 40;
                            heroesHealth[j] += heal;
                            System.out.println(heroesAttackType[j] + " was healed by " + heal + "hp.");
                            break;
                        }
                    }
                }

                // Thor' special
                if (heroesAttackType[i].equals("Thor")) {
                    isStunned = new Random().nextBoolean();
                    if (isStunned) {
                        System.out.println("Thor has stunned the boss for one round.");
                    }
                }

                int damage = heroesDamage[i];
                if (Objects.equals(heroesAttackType[i], bossDefence)) {
                    Random random = new Random();
                    int coefficient = random.nextInt(9) + 2; // 2,3,4,5,6,7,8,9,10
                    damage = heroesDamage[i] * coefficient;
                    System.out.println("Critical damage: " + damage);
                }
                bossHealth = Math.max(bossHealth - damage, 0);
            }
        }
    }

    public static void printStatistics() {
        System.out.println("\nROUND " + roundNumber + " -----------------");
        System.out.println("BOSS health: " + bossHealth + " damage: " + bossDamage
                + " weakness: " + (bossDefence == null ? "Nothing" : bossDefence)
                + (isStunned ? " | STUNNED" : " ") + "\n");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i]
                    + " damage: " + heroesDamage[i]);
        }
        System.out.println();
    }
}