public class Skeleton extends Boss {

    private int arrowsAmount;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Arrows left: " + arrowsAmount);
    }

    public int getArrowsAmount() {
        return arrowsAmount;
    }

    public void setArrowsAmount(int arrowsAmount) {
        this.arrowsAmount = arrowsAmount;
    }

}
