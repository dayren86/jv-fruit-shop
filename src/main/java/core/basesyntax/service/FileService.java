package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFromFile();

    void writeReportToFile(String report);
}
