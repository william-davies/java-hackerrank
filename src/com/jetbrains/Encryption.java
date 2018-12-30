package com.jetbrains;
import java.lang.StringBuilder;

public class Encryption {


    // Complete the encryption function below.
    static String encryption(String s) {
        int length = s.length();
        double cols_double = Math.ceil(Math.sqrt(length));
        // numbers of cols will always be ceil of sqrt
        int cols = (int) cols_double;
        StringBuilder msg = new StringBuilder();

        // create string for every col
        for (int col = 0; col < cols; col++) {
            StringBuilder str = new StringBuilder();
            // append char in every row of current column
            for (int idx = col; idx < s.length(); idx += cols) {
                str.append(s.charAt(idx));
            }
            // append space to str
            str.append(" ");
            // append str to msg
            msg.append(str);
        }
        // do not print the final space at the end of msg
        return msg.substring(0, length + (cols - 1));
    }

    public static void main(String[] args){
        String s = "chillout";
        String msg = Encryption.encryption(s);
        System.out.println(msg);
    }
}