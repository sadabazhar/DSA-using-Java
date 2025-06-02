import java.util.ArrayDeque;
import java.util.Deque;

public class RedundantBrackets {

    public static boolean checkRedundantBrackets(String s){

        if (s.isEmpty()) return false;

        Deque<Character> st = new ArrayDeque<>();

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%'){
                st.push(ch);
            }else{
                int count = 0;

            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        
    }

}
