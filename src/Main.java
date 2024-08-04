import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println(permission(21, -10));
        System.out.println(permission(19, 28));
        System.out.println(permission(46, -10));
        System.out.println(permission(16, 29));
        System.out.println(permission(999, -6969));

        System.out.println(); // небольшой отступ
        System.out.println(permission(generateRandomAge(), 10));
        System.out.println(permission(generateRandomAge(), 25));

    }

    public static String permission(int age, float temp) {
        System.out.println("Возраст: " + age + ", темп: " + temp);
        if ((age >= 20 && age <= 45) && (temp >= -20 && temp <= 30) ||
                age < 20 && (temp >= 0 && temp <= 28) ||
                age > 45 && (temp >= -10 && temp <= 25)) {
            return "Можно идти гулять";
        } else {
            return "Оставайтесь дома";
        }
    }

    public static int generateRandomAge() {
        return new Random().nextInt(100);
    }

}