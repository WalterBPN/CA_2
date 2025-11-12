package CA_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Loads applicant full names (First + Last) from the file

public class ApplicantsLoader {

    // Reads file, skips header, returns a list of "First Last" names
    public List<String> loadFullNames(String fileName) {
        List<String> names = new ArrayList<>();
        List<String> lines;

        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            return names;
        }

        if (lines.isEmpty()) return names;

        // Skip header
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line == null || line.trim().isEmpty()) continue;

            // naive file split
            String[] cols = line.split(",", -1);
            if (cols.length < 2) continue;

            String first = cols[0].trim();
            String last  = cols[1].trim();
            if (!first.isEmpty() || !last.isEmpty()) {
                names.add((first + " " + last).trim());
            }
        }
        return names;
    }
}
