package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ReportGenerator {
    public static String generate(Path logFolder, Path reportFile)
            throws IOException {
        long totalDeposits = 0;
        long totalWithdrawals = 0;
        StringBuilder fileDetails = new StringBuilder();

        if (Files.exists(logFolder)) {
            try (DirectoryStream<Path> files =
                         Files.newDirectoryStream(logFolder, "*.log")) {
                for (Path file : files) {
                    BasicFileAttributes attributes =
                            Files.readAttributes(
                                    file, BasicFileAttributes.class);

                    fileDetails.append(file.getFileName())
                            .append(" | ")
                            .append(attributes.size())
                            .append(" bytes | ")
                            .append(attributes.lastModifiedTime())
                            .append('\n');

                    try (BufferedReader reader =
                                 Files.newBufferedReader(
                                         file, StandardCharsets.UTF_8)) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.trim().split("\\s+");

                            if (parts.length < 3) {
                                continue;
                            }

                            long amount;

                            try {
                                amount = Long.parseLong(parts[2]);
                            } catch (NumberFormatException exception) {
                                continue;
                            }

                            if (parts[0].equalsIgnoreCase("DEPOSIT")) {
                                totalDeposits += amount;
                            } else if (parts[0]
                                    .equalsIgnoreCase("WITHDRAW")) {
                                totalWithdrawals += amount;
                            }
                        }
                    }
                }
            }
        }

        String report = "Total deposits: " + totalDeposits + "\n"
                + "Total withdrawals: " + totalWithdrawals + "\n"
                + "Net change: "
                + (totalDeposits - totalWithdrawals) + "\n"
                + "\nLog file details:\n"
                + fileDetails;

        Path parent = reportFile.getParent();

        if (parent != null) {
            Files.createDirectories(parent);
        }

        Files.write(
                reportFile,
                report.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );

        return report;
    }
}