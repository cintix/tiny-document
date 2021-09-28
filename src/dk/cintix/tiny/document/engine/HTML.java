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

    @Override
    public String process() {
        return null;
    }

    @Override
    public String getPattern() {
        return "<?>";
    }
    
}
