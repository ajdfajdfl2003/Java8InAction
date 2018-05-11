package lambdasinaction.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SelfDoExecuteAround {
    private static ClassLoader classLoader = ExecuteAround.class.getClassLoader();

    public static void main(String... args) throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println("This is one line:\n" + oneLine);

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println("This is two line:\n" + twoLines);
    }

    private static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(classLoader.getResource("lambdasinaction/chap3/data.txt").getPath()))) {
            return processor.process(reader);
        }
    }

    interface BufferedReaderProcessor {
        String process(BufferedReader reader) throws IOException;
    }
}
