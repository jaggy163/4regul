package codewars;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
//        String str = "the-ste_Al_th-warrior";
//        String result="";
//
//        for (int i=0; i<str.length(); i++) {
//            if (str.charAt(i)=='-' || str.charAt(i)=='_') {
//                result += String.valueOf(str.charAt(i+1)).toUpperCase();
//                i++;
//            } else {
//                result += str.charAt(i);
//            }
//        }
//        System.out.println(result);
        System.out.println(Integer.toString(2_147_483_647, 2).replaceAll("[^1]", "").length());

        Long x = 4_500_000_000L * 4_500_000_000L;
        System.out.println(x);
        System.out.println(Long.MAX_VALUE);
        BigInteger bigInteger = BigInteger.valueOf(x);
        BigInteger bigInteger1 = BigInteger.valueOf(x);
        for (int i=1; i< 1_000_000; i++) {
            bigInteger = bigInteger.multiply(bigInteger1);
            if (i%100==0) {
                System.out.println("i = " + i);
            }
        }
        System.out.println(bigInteger.toString());
    }
}
