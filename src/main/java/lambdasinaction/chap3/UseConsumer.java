package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UseConsumer {
    public static void main(String... args) {
        forEach(Arrays.asList("1", "2", "3", "4", "5"),
                (String output) -> System.out.println(output));
    }

    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T i : list) {
            consumer.accept(i);
        }
    }
}
