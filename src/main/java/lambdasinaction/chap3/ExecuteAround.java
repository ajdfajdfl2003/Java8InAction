package lambdasinaction.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    private static ClassLoader classLoader = ExecuteAround.class.getClassLoader();

    public static void main(String... args) throws IOException {

        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(classLoader.getResource("lambdasinaction/chap3/data.txt").getPath()))) {
            return br.readLine();
        }
    }


    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource("lambdasinaction/chap3/data.txt").getPath()))) {
            return p.process(br);
        }

    }

    public interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;

    }
}
