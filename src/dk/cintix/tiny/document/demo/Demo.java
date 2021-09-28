package dk.cintix.tiny.document.demo;

import dk.cintix.tiny.document.engine.DocumentEngine;
import dk.cintix.tiny.document.demo.tags.TextToList;
import dk.cintix.tiny.document.demo.tags.Value;
import dk.cintix.tiny.document.engine.HTML;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migo
 */
public class Demo {

    public Demo() {
        try {
            DocumentEngine.register(TextToList.class, "cintix-list");
            DocumentEngine.register(Value.class, "cintix-value");

            System.out.println("dir: " + new File(".").getAbsolutePath());
            DocumentEngine engine = new DocumentEngine();
            byte[] processed = engine.process(new HTML(new File("web/index.html")));

            System.out.println(new String(processed));
        } catch (IOException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new Demo();
    }
}
