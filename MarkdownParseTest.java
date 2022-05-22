import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    ArrayList<String> compare = new ArrayList<>();
    ArrayList<String> compare1 = new ArrayList<>();
    ArrayList<String> compare2 = new ArrayList<>();
    ArrayList<String> compare3 = new ArrayList<>();
    @Test
    public void addition(){
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException{
        Path fileName = Path.of("/Users/robin/Desktop/cse15l stuff/markdown-parse/othertests/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> compare = new ArrayList<>();
        compare.add("https://something.com");
        compare.add("some-thing.html");
        assertEquals(compare, MarkdownParse.getLinks(content));
    }
    
    @Test
    public void getSnippet1() throws IOException{
        Path fileName1 = Path.of("/Users/robin/Desktop/cse15l stuff/markdown-parse/labreport4/snippet1.md");
        String content1 = Files.readString(fileName1);
        ArrayList<String> compare1 = new ArrayList<>();
        compare1.add("`google.com");
        compare1.add("google.com");
        compare1.add("ucsd.edu");
        assertEquals(compare1, MarkdownParse.getLinks(content1));
    }
    
    @Test
    public void getSnippet2() throws IOException{
        Path fileName2 = Path.of("/Users/robin/Desktop/cse15l stuff/markdown-parse/labreport4/snippet2.md");
        String content2 = Files.readString(fileName2);
        ArrayList<String> compare2 = new ArrayList<>();
        compare2.add("a.com");
        compare2.add("a.com(())");
        compare2.add("example.com");
        assertEquals(compare2, MarkdownParse.getLinks(content2));
    }
    @Test
    public void getSnippets3() throws IOException{
        Path fileName3 = Path.of("/Users/robin/Desktop/cse15l stuff/markdown-parse/labreport4/snippet3.md");
        String content3 = Files.readString(fileName3);
        ArrayList<String> compare3 = new ArrayList<>();
        compare3.add("https://www.twitter.com");
        compare3.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        compare3.add("https://cse.ucsd.edu/");
        assertEquals(compare3, MarkdownParse.getLinks(content3));
    }
}
