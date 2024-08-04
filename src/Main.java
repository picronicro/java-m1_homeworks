public class Main {
    public static void main(String[] args) {

        System.out.println(permission(21, -10));
        System.out.println(permission(19, 28));
        System.out.println(permission(46, -10));

    }

    public static String permission(int age, float temp) {
        if ((age >= 20 && age <= 45) && (temp >= -20 && temp <= 30)) {
            return "Можно идти гулять 1";
        } else if (age < 20 && (temp >= 0 && temp <= 28)) {
            return "Можно идти гулять 2";
        } else if (age > 45 && (temp >= -10 && temp <= 25)) {
            return "Можно идти гулять 3";
        } else {
            return "Оставайтесь дома";
        }
    }
}