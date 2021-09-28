package dk.cintix.tiny.document.engine;

import dk.cintix.tiny.document.Tag;
import dk.cintix.tiny.document.engine.base.Document;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author migo
 */
public class DocumentEngine {

    private static final Map<String, Class<?>> registeredTags = new TreeMap<>();
    private final DocumentPartComparator documentPartComparator = new DocumentPartComparator();

    public static <T extends Tag> void register(Class<T> tag, String name) {
        registeredTags.get(name);
    }

    public byte[] process(Document document) {
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        List<DocumentPart> parts = new LinkedList<>();
        
        // Find Parts
        
        Collections.sort(parts, documentPartComparator);
        for (DocumentPart part : parts) {
            // DO 
        }

        return content.toByteArray();
    }

    private class DocumentPart {

        private final int index;
        private final int length;
        private final String tag;

        public DocumentPart(int index, String tag) {
            this.index = index;
            this.tag = tag;
            this.length = tag.length();
        }

        @Override
        public String toString() {
            return "DocumentPart{" + "tag=" + tag + '}';
        }

        public int getIndex() {
            return index;
        }

        public int getLength() {
            return length;
        }

        public String getTag() {
            return tag;
        }

    }

    private class DocumentPartComparator implements Comparator<DocumentPart> {
        @Override
        public int compare(DocumentPart d, DocumentPart d2) {
            if (d2.getIndex() < d.getIndex()) {
                return +1;
            } else if (d2.getIndex() > d.getIndex()) {
                return -1;
            }
            return 0;
        }

    }

}
