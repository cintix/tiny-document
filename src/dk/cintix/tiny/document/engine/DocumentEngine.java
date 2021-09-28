package dk.cintix.tiny.document.engine;

import dk.cintix.tiny.document.Tag;
import dk.cintix.tiny.document.engine.base.Document;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    
    public byte[] process(Document document) throws IOException {
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        List<DocumentPart> parts = new LinkedList<>();
        extractDocumentParts(parts, document);
        
        for (DocumentPart part : parts) {
            Tag tag = convertToTag(part);
            if (tag != null) {
                content.write(tag.process());
            } else {
                content.write(part.getTag().getBytes());
            }
        }
        return content.toByteArray();
    }
    
    private void extractDocumentParts(List<DocumentPart> parts, Document document) {
        // Find Parts
        List<DocumentPart> otherParts = new LinkedList<>();
        Collections.sort(parts, documentPartComparator);
        int index = 0;
        for (DocumentPart part : parts) {
            if (part.getIndex() > index) {
                otherParts.add(index, new DocumentPart(index, document.getData().substring(index, part.getIndex()), false));
            }
            index = part.getIndex() + part.getIndex();
        }
        if (index < document.getData().length()) {
            otherParts.add(index, new DocumentPart(index, document.getData().substring(index), false));
        }
        parts.addAll(otherParts);
        Collections.sort(parts, documentPartComparator);
    }
    
    private Tag convertToTag(DocumentPart part) {
        return null;
    }
    
    private class DocumentPart {
        
        private final int index;
        private final int length;
        private final String tag;
        private final boolean isObj;
        
        public DocumentPart(int index, String tag, boolean isObj) {
            this.index = index;
            this.tag = tag;
            this.length = tag.length();
            this.isObj = isObj;
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
        
        public boolean isClass() {
            return isObj;
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
