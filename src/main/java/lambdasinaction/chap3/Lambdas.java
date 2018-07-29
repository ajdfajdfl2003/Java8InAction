package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

import static java.util.Comparator.comparing;

public class Lambdas {
    public static void main(String... args) {

        // Simple example
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        // Filtering with lambdas
        List<Apple> inventory = Arrays.asList(new Apple(80, "green", 100), new Apple(155, "green", 160),
                new Apple(120, "red", 125), new Apple(80, "green", 90));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        List<Apple> greenApples1 = filter(inventory, a -> "green".equals(a.getColor()));
        System.out.println(greenApples);


        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(c);
        System.out.println(inventory);

        Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple, Apple> c2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple, Apple, Integer> c3 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // [Apple{color='green', weight=155}, Apple{color='red', weight=120}, Apple{color='green', weight=80}]
        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getPrice));
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";
        private int price = 0;

        public Apple(int weight, String color, int price) {
            this.weight = weight;
            this.color = color;
            this.price = price;
        }

        public Integer getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }

        public int getPrice() {
            return price;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }

    interface ApplePredicate {
        public boolean test(Apple a);
    }
}