package dk.cintix.tiny.document.engine;

import dk.cintix.tiny.document.engine.base.Document;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author migo
 */
public class HTML extends Document {

    public HTML(File filename) throws IOException {
        super(filename);
    }

    public HTML(String data) {
        super(data);
    }

    public HTML() {
        super("");
    }

    @Override
    public String process() {
        return null;
    }

    @Override
    public String getPattern(String name) {
        return "(?i)<" + name + "([^>]+)>(.+?)</" + name + ">";
    }

    @Override
    public String getPatternSingle(String name) {
        return "(?i)<" + name + "([^>]+) />";
    }
}
