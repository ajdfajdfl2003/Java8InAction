package lambdasinaction.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SelfDoExecuteAround {
    private static ClassLoader classLoader = ExecuteAround.class.getClassLoader();

    public static void main(String... args) throws IOException {
        String result = processFile();
        System.out.println(result);
    }

    private static String processFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(classLoader.getResource("lambdasinaction/chap3/data.txt").getPath()))) {
            return reader.readLine();
        }
    }
}
