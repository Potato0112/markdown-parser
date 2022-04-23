//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    static String[] notlink = {".png", "jpg", "gif", "jpeg", "pdf"};
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(linksyntaxcheck(openBracket, closeBracket, openParen, closeParen)){
                break;
            }
            if(!linktypecheck(markdown.substring(openParen + 1, closeParen))){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }

    public static boolean linktypecheck(String link){
        for(String i : notlink){
            if(link.contains(i)){
                return true;
            }
        }
        return false;
    }

    public static boolean linksyntaxcheck(int openBracket, int closeBracket, int openParen, int closeParen){
        if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
