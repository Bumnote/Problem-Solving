import java.util.*;

public class File implements Comparable<File> {
    
    String original;
    String head;
    Integer number;
    String tail;
    int order;
    
    File(String head, String number, String tail, String original, int order) {
        this.original = original;
        this.head = head.toLowerCase();
        this.number = Integer.parseInt(number);
        this.tail = tail;
        this.order = order;
    }
    
    @Override
    public int compareTo(File o) {
        int headCompare = this.head.compareTo(o.head);
        if (headCompare != 0) { 
            return headCompare;
        }

        int numberCompare = Integer.compare(this.number, o.number);
        if (numberCompare != 0) { 
            return numberCompare;
        }

        return 0;
    }
}

class Solution {
    
    int n;
    
    public String[] solution(String[] files) {
        n = files.length;
        List<File> lst = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            File f = splitFileName(files[i], i);
            lst.add(f);
        }
        
        Collections.sort(lst);
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = lst.get(i).original;
        }
        
        return answer;
    }
    
    private File splitFileName(String file, int order) {
        
        int length = file.length();
        String head = "";
        String number = "";
        String tail = "";
        
        int idx = 0;
        // Head 
        for (int i = 0; i < length; i++) {
            char ch = file.charAt(i);
            if (!Character.isDigit(ch)) {
                head += String.valueOf(ch);
            } else {
                idx = i;
                break;
            }
        }
        
        // Number
        for (int i = idx; i < length; i++) {
            char ch = file.charAt(i);
            if (Character.isDigit(ch) && number.length() < 5) {
                number += String.valueOf(ch);
            } else {
                idx = i;
                break;
            }
        }
        
        // Tail 
        tail = file.substring(idx, length);
        
        return new File(head, number, tail, file, order);
    }
}