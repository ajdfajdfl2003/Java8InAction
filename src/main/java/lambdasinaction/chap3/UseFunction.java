package lambdasinaction.chap3;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UseFunction {
    public static void main(String... args) {
        List<Integer> list = map(Arrays.asList("lambdas", "in", "action"),
                (String item) -> item.length());
        System.out.println(new Gson().toJson(list));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}
