package dk.cintix.tiny.document.demo;

import dk.cintix.tiny.document.engine.DocumentEngine;
import dk.cintix.tiny.document.demo.tags.TextToList;
import dk.cintix.tiny.document.demo.tags.Value;
import dk.cintix.tiny.document.engine.HTML;

/**
 *
 * @author migo
 */
public class Demo {

    public Demo() {
        DocumentEngine.register(TextToList.class, "cintix-list");
        DocumentEngine.register(Value.class, "cintix-value");

        DocumentEngine engine = new DocumentEngine();
        byte[] processed = engine.process(new HTML());

        System.out.println(new String(processed));

    }

    public static void main(String[] args) {
        new Demo();
    }
}
