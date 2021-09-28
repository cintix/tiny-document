package dk.cintix.tiny.document.engine.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author migo
 */
public abstract class Document {

    private final String data;

    public Document(File filename) throws IOException {
        byte[] bytes = Files.readAllBytes(filename.toPath());
        this.data = new String(bytes);
    }

    public Document(String data) {
        this.data = data;
    }

    public abstract String getPattern();

    public abstract String process();

}
