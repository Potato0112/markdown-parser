import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    ArrayList<String> compare = new ArrayList<>();
    @Test
    public void addition(){
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> compare = new ArrayList<>();
        compare.add("https://something.com");
        compare.add("some-thing.html");
        assertEquals(compare, MarkdownParse.getLinks(content));
    }
}
