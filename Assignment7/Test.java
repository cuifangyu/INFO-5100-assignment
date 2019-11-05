package Assignment7;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        Assignment7 assignment = new Assignment7();
        System.out.println(assignment.reverseWords());
        System.out.println(assignment.decodeString("/Users/judy/IdeaProjects/5100/src/Assignment7/test23.txt"));
        String[] files = new String[3];
        files[0] = "/Users/judy/IdeaProjects/5100/src/Assignment7/test1.txt";
        files[1] = "/Users/judy/IdeaProjects/5100/src/Assignment7/test2.txt";
        files[2] = "/Users/judy/IdeaProjects/5100/src/Assignment7/test3.txt";
        assignment.countLines(files);
    }

}
