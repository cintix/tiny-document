package dk.cintix.tiny.document.demo.tags;

import dk.cintix.tiny.document.Tag;
import java.io.InputStream;

/**
 *
 * @author migo
 */
public class TextToList extends Tag {

    public TextToList(InputStream request) {
        super(request);
    }

    @Override
    public String tagBegin() {
        return "<ul><br/>\n<li>";
    }

    @Override
    public String tagEnd() {
        return "\n</li><br/></ul>";
    }

}
