public class Medic extends Hero {

    private double healPoints = 10;

    @Override
    public void applySuperAbility() {
        System.out.println("Medic has applied " + getSuperAbility() + " ability.");
    }

    public double getHealPoints() {
        return healPoints;
    }

    public void increaseExperience() {
        healPoints *= 1.1;
    }

}
