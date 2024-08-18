public class Boss extends GameEntity {

    private Weapon weapon;

    public void printInfo() {
        System.out.println();
        System.out.println("Health: " + getHealth());
        System.out.println("Defense: " + getDefense());
        System.out.println("Damage: " + getDamage());

        System.out.println("Weapon\n Name: " + weapon.getName() + "\n Type: " + weapon.getType());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
