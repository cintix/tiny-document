package dk.cintix.tiny.document.tags;

import dk.cintix.tiny.document.Tag;
import java.io.InputStream;

/**
 *
 * @author migo
 */
public class Value extends Tag {

    public Value(InputStream request) {
        super(request);
    }

    @Override
    public String tagBegin() {
        return "Name :" + getAttribute("name");
    }

    @Override
    public String tagEnd() {
        return "!";
    }

}
