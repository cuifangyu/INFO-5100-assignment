package Assignment7;

import java.io.*;

public class Assignment7 {

    public String reverseWords() throws IOException {
        InputStream f = new FileInputStream("/Users/judy/IdeaProjects/5100/src/Assignment7/test1.txt");
        int size = f.available();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append((char)f.read());
        }
        return reverseWords(sb.toString());
    }
    public String reverseWords(String s){
        if(s.length() < 1){
            return s;
        }
        String[] words = s.split(" ");
        if(words.length < 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            if(words[i].equals("")){
                continue;
            }
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    int k = 0;
    public String decodeString(String s) throws IOException{
        InputStream f = new FileInputStream(s);
        int size = f.available();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append((char)f.read());
        }
        return decode(sb.toString());
    }
    String decode(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (k < s.length()) {
            char c = s.charAt(k++);
            if ('0' <= c && c <= '9') {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                String inner = decode(s);
                for (; count != 0; --count){
                    sb.append(inner);
                }
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void countLines(String[] fileNames){
        for(int i = 0; i < fileNames.length; i++){
            System.out.println(fileNames[i] + ":");
            countLines(fileNames[i]);
        }
    }
    public void countLines(String fileName) {
        BufferedReader in;
        int lineCount = 0;
        try {
            in = new BufferedReader(new FileReader(fileName));
        }
        catch (Exception e) {
            System.out.println("Invalid File");
            return;
        }
        try {
            String line = in.readLine();
            while (line != null) {
                lineCount++;
                line = in.readLine();
            }
        }
        catch (Exception e) {
            System.out.println("Invalid File");
            return;
        }
        System.out.println(lineCount + " lines");
    }




}
