import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get("logs");
        Files.createDirectories(folder);

        Path firstLog = folder.resolve("app1.log");
        Path secondLog = folder.resolve("app2.log");

        Files.write(firstLog, (
                "DEPOSIT AC0001 500\n"
                + "Login successful\n"
                + "WITHDRAW AC0001 100\n"
        ).getBytes());

        Files.write(secondLog, (
                "Login failed\n"
                + "DEPOSIT AC0002 300\n"
        ).getBytes());

        String keyword = "DEPOSIT";
        int totalLines = 0;
        int matchingLines = 0;

        try (DirectoryStream<Path> files =
                     Files.newDirectoryStream(folder, "*.log")) {
            for (Path file : files) {
                BasicFileAttributes attributes =
                        Files.readAttributes(
                                file, BasicFileAttributes.class);

                System.out.println("File: " + file.getFileName());
                System.out.println("Size: " + attributes.size() + " bytes");

                try (BufferedReader reader =
                             Files.newBufferedReader(file)) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        totalLines++;

                        if (line.toLowerCase()
                                .contains(keyword.toLowerCase())) {
                            matchingLines++;
                        }
                    }
                }
            }
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing " + keyword + ": "
                + matchingLines);
    }
}