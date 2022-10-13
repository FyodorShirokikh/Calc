import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String st;
       st = scanner.nextLine();
       int plus = st.indexOf("+");
       if (plus > 0) {
            int plus_next = st.indexOf("+",plus+1);
            if (plus_next > 0) {
                System.out.println("Два плюса");
            }
       }
       int minus = st.indexOf("-");
       if (minus > 0) {
           int minus_next = st.indexOf("-",minus+1);
           if (minus_next > 0) {
               System.out.println("Два минуса");
           }
       }
       int umnoj = st.indexOf("*");
       if (umnoj > 0) {
           int umnoj_next = st.indexOf("*",umnoj+1);
           if (umnoj_next > 0) {
               System.out.println("Два умножения");
           }
       }int delen = st.indexOf("/");
       if (delen > 0) {
           int delen_next = st.indexOf("/",delen+1);
           if (delen_next > 0) {
               System.out.println("Два деления");
           }
       }


       // char[] star = st.toCharArray();

       // for (int i=0; i<st.length(); i++) {
       //    System.out.println(star[i]);
       // }


    }
}