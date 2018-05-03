package lambdasinaction.chap2;

import java.util.Arrays;
import java.util.List;

public class Quiz2_1 {
    public static void main(String... args) {
        List<Apple> inventory =
                Arrays.asList(
                        new Apple(80, "green"),
                        new Apple(155, "green"),
                        new Apple(120, "red"));

        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }

    private static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    private static class AppleSimpleFormatter implements AppleFormatter {

        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    interface AppleFormatter {
        String accept(Apple apple);
    }

    private static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
