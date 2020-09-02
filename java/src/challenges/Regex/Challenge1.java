package challenges.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge1 {

    public static void main(String[] args) {
       //Challenge 1: write a regext to match i want a ball.

        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
//        System.out.println(challenge1.matches("I want a bike"));
//        System.out.println(challenge1.matches("I want a bike."));

        //challenge 2: Regex to Match I want a bike and I want a ball
        String regex= "I want a b.*";
        String regex1 = "I want a (bike|ball).";
        String regex2 = "I want a \\w+."; // + quantifier means we want to match one or more chars before period nad \\w is any one word

//        System.out.println(challenge1.matches(regex));
//        System.out.println(challenge2.matches(regex));
//        System.out.println(challenge1.matches(regex1));
//        System.out.println(challenge2.matches(regex1));
//        System.out.println(challenge1.matches(regex2));
//        System.out.println(challenge2.matches(regex2));

        //challenge 2: Use the pattern and matcher class to find if regex works.
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(challenge1);
        System.out.println(match.matches());

        Pattern pattern1 = Pattern.compile(regex1);
        Matcher match1 = pattern1.matcher(challenge2);
        System.out.println(match1.matches());

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher match2 = pattern2.matcher(challenge1);
        System.out.println(match2.matches());

        //Challenge 4: replacce all the occurences of blank with underscore in the string
        String challenge4= "Replace all the blanks with underscores";
        System.out.println(challenge4.replaceAll("blanks","_"));

    }
}
