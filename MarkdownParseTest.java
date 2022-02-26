import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testfiles() throws IOException {
        ArrayList<String> testfile1 = new ArrayList<>();
        testfile1.add("https://something.com");
        testfile1.add("some-page.html");
        String testfilemd = MarkdownParse.converter("test-file.md");
        assertEquals(testfile1, MarkdownParse.getLinks(testfilemd));
    }

    @Test
    public void testCharacterAfter() throws IOException {
        ArrayList<String> CharacterAfter = new ArrayList<>();
        CharacterAfter.add("google.com");
        String CharacterAfterTest = MarkdownParse.converter("CharacterAfter.md");
        assertEquals(CharacterAfter, MarkdownParse.getLinks(CharacterAfterTest));
    }

    @Test
    public void testInBetween() throws IOException {
        ArrayList<String> InBetween = new ArrayList<>();
        InBetween.add("hi.com");
        InBetween.add("hi.com");
        String InBetweenTest = MarkdownParse.converter("InBetween.md");
        assertEquals(InBetween, MarkdownParse.getLinks(InBetweenTest));
    }

    @Test
    public void testImage() throws IOException {
        ArrayList<String> Image = new ArrayList<>();
        Image.add("link.com");
        Image.add("thiswebsite.com");
        String ImageTest = MarkdownParse.converter("Image.md");
        assertEquals(Image, MarkdownParse.getLinks(ImageTest));
    }

    @Test
    public void testSnippet1() throws IOException {
        ArrayList<String> snippet1 = new ArrayList<>();
        snippet1.add("`google.com");
        snippet1.add("ucsd.edu");
        String snippet1Test = MarkdownParse.converter("snippet1.md");
        assertEquals(snippet1, MarkdownParse.getLinks(snippet1Test));
    }

    @Test
    public void testSnippet2() throws IOException {
        ArrayList<String> snippet2 = new ArrayList<>();
        snippet2.add("a.com");
        snippet2.add("a.com((");
        snippet2.add("example.com");
        String snippet2Test = MarkdownParse.converter("snippet2.md");
        assertEquals(snippet2, MarkdownParse.getLinks(snippet2Test));
    }

    @Test
    public void testSnippet3() throws IOException {
        ArrayList<String> snippet3 = new ArrayList<>();
        snippet3.add("https://www.twitter.com");
        snippet3.add("https://ucsd-cse15l-w22.github.io/");
        snippet3.add("https://cse.ucsd.edu/");
        String snippet3Test = MarkdownParse.converter("snippet3.md");
        assertEquals(snippet3, MarkdownParse.getLinks(snippet3Test));
    }
}
