public class Main {

    public static void main(String[] args) {
        Weapon claws = new Weapon();
        claws.setType(WeaponType.MELEE);
        claws.setName("Mighty Claws");

        Boss boss = new Boss();
        boss.setHealth(1200);
        boss.setDefense(250);
        boss.setDamage(80);
        boss.setWeapon(claws);
        boss.printInfo();

        Weapon bowgun = new Weapon();
        bowgun.setType(WeaponType.RANGED);
        bowgun.setName("Heavy Bowgun");

        Skeleton kostyanka = new Skeleton();
        kostyanka.setHealth(600);
        kostyanka.setDefense(80);
        kostyanka.setDamage(20);
        kostyanka.setWeapon(bowgun);
        kostyanka.setArrowsAmount(80);
        kostyanka.printInfo();

        Weapon bimba = new Weapon();
        bimba.setType(WeaponType.EXPLOSIVE);
        bimba.setName("Pocket Bimba");

        Skeleton bones = new Skeleton();
        bones.setHealth(450);
        bones.setDefense(40);
        bones.setDamage(60);
        bones.setWeapon(bimba);
        bones.setArrowsAmount(25);
        bones.printInfo();

    }

}
