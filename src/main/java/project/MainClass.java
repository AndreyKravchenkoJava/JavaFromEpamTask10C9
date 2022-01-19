package project;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        try {
            Path path = FileSystems.getDefault().getPath("Code.txt");
            List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder code = new StringBuilder();
            for (String text : list) {
                code.append(text + "\n");
            }

            System.out.println("");
            System.out.println(code);
            System.out.println("------------------------------------");
            System.out.println(code.toString().replaceAll("(\\/[^)]+\\/)", ""));

            File file = new File("CodeResult.txt");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(code.toString().replaceAll("(\\/[^)]+\\/)", ""));
            printWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
