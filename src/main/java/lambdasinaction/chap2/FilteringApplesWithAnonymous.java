package lambdasinaction.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApplesWithAnonymous {

    public static void main(String... args) {
        List<Apple> inventoryOfApple = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Banana> inventoryOfBanana = Arrays.asList(
                new Banana(80, "yellow"),
                new Banana(155, "black"),
                new Banana(120, "black"));

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filter(inventoryOfApple, apple -> apple.getWeight() > 150);
        System.out.println(heavyApples);

        // [Banana{color='black', weight=155}]
        List<Banana> heavyBanana = filter(inventoryOfBanana, banana -> banana.getWeight() > 150);
        System.out.println(heavyBanana);

        // [Apple{color='red', weight=120}]
        List<Apple> redApples = filter(inventoryOfApple, apple -> apple.getColor().equals("red"));
        System.out.println(redApples);
        // [Banana{color='black', weight=155}, Banana{color='black', weight=120}]
        List<Banana> blackBanana = filter(inventoryOfBanana, banana -> banana.getColor().equals("black"));
        System.out.println(blackBanana);
    }

    public interface Predicate<T> {
        boolean test(T a);
    }

    /*
        Java doesn't know what type of T is.
        Until I instantiate a type
        Because this is a static method,
            I have to tell what type of this static method is
    */
    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T type : inventory) {
            if (p.test(type)) {
                result.add(type);
            }
        }
        return result;
    }

    public static class Banana {
        private int weight;
        private String color;

        Banana(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        Integer getWeight() {
            return weight;
        }

        String getColor() {
            return color;
        }

        public String toString() {
            return "Banana{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static class Apple {
        private int weight;
        private String color;

        Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        Integer getWeight() {
            return weight;
        }

        String getColor() {
            return color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}