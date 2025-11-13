package CA_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Loads applicant full names (First + Last) from the TXT file provided
// Called by Main in SORT and SEARCH options of the Employee Management System
public class ApplicantsLoader {

    // Reads the file, skips the header,
    // and returns a list of "First Last" full names
    public List<String> loadFullNames(String fileName) {
        List<String> names = new ArrayList<>();
        List<String> lines;

        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            return names;
        }

        if (lines.isEmpty()) {
            return names;
        }

        // Skip header line (column names)
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line == null || line.trim().isEmpty()) {
                continue;
            }

            // Split content line by comma
            String[] columns = line.split(",", -1);
            if (columns.length < 2) {
                continue;
            }

            String firstName = columns[0].trim();
            String lastName  = columns[1].trim();

            if (!firstName.isEmpty() || !lastName.isEmpty()) {
                String fullName = (firstName + " " + lastName).trim();
                names.add(fullName);
            }
        }

        return names;
    }
}
