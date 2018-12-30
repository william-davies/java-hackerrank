package com.jetbrains;

public class TimeInWords {

    private static final String[] numNames = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one",
    "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine",
    "half"};

    static String timeInWords(int h, int m) {
        String time = "";

        if (m == 0){
            time += numNames[h] + " o' clock";
            return time;
        }

        if (m <= 30){
            time += numNames[m];
            if (m != 15 && m != 30){
                time += " minute";
                if (m != 1){
                    time += "s";
                }
            }
            time += " past " + numNames[h];
            return time;
        }

        time += numNames[60 - m];
        if (m != 45){
            time += " minute";
            if (m != 59) {
                time += "s";
            }
        }
        time += " to ";
        if (h != 12){
            time += numNames[h + 1];
        } else {
            time += numNames[1];
        }
        return time;
    }

    public static void main(String[] args){
        int h = 7;
        int m = 29;
        String time = timeInWords(h, m);
        System.out.println(time);
    }

}
