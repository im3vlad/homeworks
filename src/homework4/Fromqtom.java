package homework4;

import java.util.Scanner;

public class Fromqtom {
    public static void main(String[] args) {
        String str = "qwertyuiopasdfghjklzxcvbnm";
        Scanner scr = new Scanner(System.in);
        String s = scr.nextLine();
        char[] chr = str.toCharArray();
        if (s.equals(Character.toString(chr[0]))){
            System.out.print(chr[chr.length - 1]);
        }
        for (int i = 1; i < chr.length; i++) {
            if (chr[i] == s.charAt(0)) {
                System.out.print(chr[i - 1]);
            }
        }

    }
}
