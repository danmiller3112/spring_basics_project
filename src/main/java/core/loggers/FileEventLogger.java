package core.loggers;

import core.beans.Event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by RDL on 21/04/2017.
 */
public class FileEventLogger implements EventLogger {
    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    private void init() throws IOException{
        this.file = new File(filename);
        if (!file.canWrite()){
            throw new IOException("Can't write file " + filename);
        }

    }

    public void logEvent(Event event) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(event.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
