package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file = new File(System.getProperty("user.home") + File.separator + "output.txt");

    public File getFile() {
        return file;
    }

    public void setFile(final File file) {
        this.file = file;
    }

    public String getPath() {
        return file.getPath();
    }

    public void writeFile(final String input) throws IOException {
        try (PrintStream ps = new PrintStream(file)) {
            ps.print(input);
        }
    }
}
