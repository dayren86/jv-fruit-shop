package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final String FILE_PATH = "src/main/resources/fruits.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report_fruits.csv";

    @Override
    public List<String> readFromFile() {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + e);
        }

        return stringList;
    }

    @Override
    public void writeReportToFile(String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(REPORT_FILE_PATH))) {
            bufferedWriter.write(report);

        } catch (IOException e) {
            throw new RuntimeException("Can't write file" + e);
        }
    }
}
