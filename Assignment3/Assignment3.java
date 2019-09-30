package Assignment3;

public class Assignment3 {

    public String countAndSay(int n){
        if(n < 1 || n > 30){
            return null;
        } else {
            String s = "1";
            for(int i = n; i > 0; i--){
                int j = 0, counter = 0;
                char cur = 0, prev = 0;
                StringBuilder temp = new StringBuilder();
                while(j < s.length()){
                    cur = s.charAt(j + 1);
                    if(cur == prev){
                        counter++;
                    } else {
                        if(j > 1){
                            temp.append(counter).append(prev);
                            counter = 1;
                        }
                    }
                    if(j == s.length()){
                        temp.append(counter).append(cur);
                        prev = cur;
                    }
                }
                s = temp.toString();
            }
            return s;
        }
    }


    public String reverseString(String s){
        if(s.length() < 2){
            return s;
        }
        StringBuilder result = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for(int i = words.length - 1; i >=0; i--){
            result.append(words[i] + " ");
        }
        return result.toString().trim();
    }


    public int[] spiralOrder(int[][] matrix){
        if(matrix.length < 1){
            return null;
        }
        int r1 = matrix.length, c1 = matrix[1].length;
        boolean[][] seen = new boolean[r1][c1];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r2 = 0, c2 = 0, di = 0;
        int[] arr = new int[r1 * c1];
        for(int i =0; i < r1 * c1; i++){
            arr[i] = (matrix[r1][c1]);
            seen[r2][c2] = true;
            int cr = r2 + dr[di];
            int cc = c2 + dc[di];
            if(cr >= 0 && cr < r1 && cc >= 0 && cc < c1 && !seen[cr][cc]){
                r2 = cr;
                c2 = cc;
            } else {
                di = (di + 1) % 4;
                r2 = r2 + dr[di];
                c2 = c2 + dc[di];
            }
        }
        return arr;
    }

    public String zigzagString(String s, int n){
        if(n < 1){
            return null;
        } else if(n == 1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * n - 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j + i < s.length(); j += cycleLen){
                result.append(s.charAt(j + 1));
                if(i != 0 && i != n - 1 && j + cycleLen - i < s.length()){
                    result.append(s.charAt(j + cycleLen - 1));
                }
            }
        }
        return result.toString();
    }

    /*

   Encapsulation:

   It is a restricting of direct access to some of object components;
   It can hide some value inside a class and prevent outsiders directly accessing them;
   For example, if we want to create a course class, and want to protect the inside data;
   so that the data cannot be changed easily, which may result in some problems;
   we can create the course class and make the member variables(course ID...) private to protect them;
   and then create public getter and setter methods for outsiders to get or change the values;

     */



    /* Difference between Encapsulation and Abstraction:

    Encapsulation hides data from the outside world;
    It hides some implementation in a class so that outsiders cannot access it directly;
    They must access through getter and setter methods;

    Abstraction hides unnecessary details for focusing on relevant information;
    It is in a higher degree than Encapsulation.
    Users don't care what the abstract class is, they just need to know what it can do;

    */

}
