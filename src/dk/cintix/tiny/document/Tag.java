package dk.cintix.tiny.document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author migo
 */
public abstract class Tag {

    private final Map<String, String> env = new TreeMap<>();
    private final Map<String, String> attributes = new TreeMap<>();
    private final List<Tag> children = new LinkedList<>();
    private final ByteArrayOutputStream content = new ByteArrayOutputStream();

    protected final OutputStream response = new ByteArrayOutputStream();
    protected final InputStream request;

    public Tag(InputStream request) {
        this.request = request;
    }

    public abstract String tagBegin();

    public abstract String tagEnd();

    public byte[] process() throws IOException {
        response.write(tagBegin().getBytes());
        for (Tag child : children) {
            child.process();
            response.write(child.getContent());
        }
        response.write(tagEnd().getBytes());
        content.write(((ByteArrayOutputStream) response).toByteArray());
        return getContent();
    }

    public byte[] getContent() {
        return content.toByteArray();
    }

    public void setContent(byte[] content) {
        this.content.writeBytes(content);
    }

    public Map<String, String> getEnv() {
        return env;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void addChild(Tag tag) {
        children.add(tag);
    }

    public String getAttribute(String key) {
        if (attributes.containsKey(key)) {
            return attributes.get(key);
        } else {
            return "";
        }
    }

    public String getEnv(String key) {
        if (env.containsKey(key)) {
            return env.get(key);
        } else {
            return "";
        }
    }

}
