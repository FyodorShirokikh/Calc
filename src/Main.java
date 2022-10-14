import java.util.Arrays;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String st;
       int ans = 0;
       String[] oper = new String[100];
       st = scanner.nextLine();
       st = st.replace(" ", "");

       int plus = st.indexOf("+"); int minus = st.indexOf("-"); int umnoj = st.indexOf("*"); int delen = st.indexOf("/");
       if ((plus == -1) && (minus == -1) && (umnoj == -1) && (delen == -1)) {
           throw new RuntimeException("т.к. строка не является математической операцией");
       }
       if (plus >= 0) {
            oper = st.split("\\+");
            if (oper.length <= 1) {
                throw new RuntimeException("т.к. строка не является математической операцией");
            }
            if (oper.length > 2) {
                throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if ( ifArabic(oper[0]) && ifArabic(oper[1]) ) {
               ans = Integer.parseInt(oper[0]) + Integer.parseInt(oper[1]);
               System.out.println(ans);
            } else
                if (ifRoman(oper[0]) && ifRoman(oper[1])) {
                    ans = romanToInt(oper[0]) + romanToInt(oper[1]);
                    System.out.println(intToRoman(ans));
                }else {
               throw new RuntimeException("т.к. используются одновременно разные системы счисления или операнд <1, >10, нецелое число");
            }
            int plus_next = st.indexOf("+",plus+1);
            if (plus_next > 0) {
                throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
       }
       if (minus >= 0) {
           oper = st.split("-");
           if (oper.length <= 1) {
               throw new RuntimeException("т.к. строка не является математической операцией");
           }
           if (oper.length > 2) {
               throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           }
           if ( ifArabic(oper[0]) && ifArabic(oper[1]) ) {
               ans = Integer.parseInt(oper[0]) - Integer.parseInt(oper[1]);
               System.out.println(ans);
           } else
               if (ifRoman(oper[0]) && ifRoman(oper[1])) {
                   ans = romanToInt(oper[0]) - romanToInt(oper[1]);
                   if (ans > 0) {
                       System.out.println(intToRoman(ans));
                   } else {
                       throw new RuntimeException("т.к. в римской системе нет отрицательных чисел");
                   }
               }else {
               throw new RuntimeException("т.к. используются одновременно разные системы счисления или операнд <1, >10, нецелое число");
           }
           int minus_next = st.indexOf("-",minus+1);
           if (minus_next > 0) {
               throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           }
       }
       if (umnoj >= 0) {
           oper = st.split("\\*");
           if (oper.length <= 1) {
               throw new RuntimeException("т.к. строка не является математической операцией");
           }
           if (oper.length > 2) {
               throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           }
           if ( ifArabic(oper[0]) && ifArabic(oper[1]) ) {
               ans = Integer.parseInt(oper[0]) * Integer.parseInt(oper[1]);
               System.out.println(ans);
           } else
               if (ifRoman(oper[0]) && ifRoman(oper[1])) {
                   ans = romanToInt(oper[0]) * romanToInt(oper[1]);
                   System.out.println(intToRoman(ans));
               }else {
               throw new RuntimeException("т.к. используются одновременно разные системы счисления или операнд <1, >10, нецелое число");
                }
           int umnoj_next = st.indexOf("*",umnoj+1);
           if (umnoj_next > 0) {
               throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           }
       }
       if (delen >= 0) {
           oper = st.split("/");
           if (oper.length <= 1) {
               throw new RuntimeException("т.к. строка не является математической операцией");
           }
           if (oper.length > 2) {
               throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           }
           if ( ifArabic(oper[0]) && ifArabic(oper[1]) ) {
               try {
                   ans = Integer.parseInt(oper[0]) / Integer.parseInt(oper[1]);
                   System.out.println(ans);
               } catch (ArithmeticException e) {
                   throw new RuntimeException("т.к. деление на ноль");
               }
           } else
           if (ifRoman(oper[0]) && ifRoman(oper[1])) {
               ans = romanToInt(oper[0]) / romanToInt(oper[1]);
               System.out.println(intToRoman(ans));
           }else {
               throw new RuntimeException("т.к. используются одновременно разные системы счисления или операнд <1, >10, нецелое число");
           }
           int delen_next = st.indexOf("/",delen+1);
           if (delen_next > 0) {
               throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
           }
       }
    }
    static String intToRoman(int a) {
        int[] values =           {1000,900,500,400, 100, 90, 50,  40, 10,  9,   5,  4,   1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(a >= values[i]) {
                a = a - values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    static int romanToInt(String s) {
        int i = 0;
        switch (s) {
            case "I":
                i = 1;
                break;
            case "II":
                i = 2;
                break;
            case "III":
                i = 3;
                break;
            case "IV":
                i = 4;
                break;
            case "V":
                i = 5;
                break;
            case "VI":
                i = 6;
                break;
            case "VII":
                i = 7;
                break;
            case "VIII":
                i = 8;
                break;
            case "IX":
                i = 9;
                break;
            case "X":
                i = 10;
        }
        return i;
    }

    static boolean ifArabic(String s){
        return Arrays.asList("1","2","3","4","5","6","7","8","9","10").contains(s);
    }
    static boolean ifRoman(String s) {
        return Arrays.asList("I","II","III","IV","V","VI","VII","VIII","IX","X").contains(s);
    }
    }