package tools;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> inputFileToList(File file) {
        List<String> templist = new ArrayList<>();
        FileReader.liteIterator(file,templist);
        return templist;
    }


    private static void liteIterator(File file, List<String> templist) {
        try (LineIterator lineIterator = FileUtils.lineIterator(file)) {
            while (lineIterator.hasNext()) {
                String line = lineIterator.next();
                templist.add(line.trim());
            }
        } catch (IOException ignored) {
        }
    }
}
