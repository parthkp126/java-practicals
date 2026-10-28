import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

public class FolderReport {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        Path report = Paths.get("folder-report.txt");

        StringBuilder content = new StringBuilder();

        Files.walkFileTree(root, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(
                    Path file,
                    BasicFileAttributes attributes
            ) {
                content.append(file)
                       .append(" | ")
                       .append(attributes.size())
                       .append(" bytes | ")
                       .append(Instant.ofEpochMilli(
                               attributes.lastModifiedTime().toMillis()))
                       .append('\n');

                return FileVisitResult.CONTINUE;
            }
        });

        Files.write(report, content.toString().getBytes());
        System.out.println("Report saved to " + report);
    }
}