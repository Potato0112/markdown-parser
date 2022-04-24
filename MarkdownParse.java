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
        //System.out.println("markdownlength:" + markdown.length());
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            /*
            System.out.println("currentIndex: " + currentIndex);
            System.out.println("openBracket:" + openBracket);
            System.out.println("closeBracket:" + closeBracket);
            System.out.println("openParen:" + openParen);
            System.out.println("closeParen:" + closeParen);
            //System.out.println(markdown.charAt(29));
            //System.out.println(markdown.charAt(30));
            */
            if(!linktypecheck(markdown.substring(openParen, closeParen))){
                //System.out.println("passed linktypecheck");
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            /*
            else{
                System.out.println("failed linktypecheck");
            }
            */
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
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}