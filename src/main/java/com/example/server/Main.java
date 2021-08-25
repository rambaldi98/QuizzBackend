package com.example.server;

public class Main {

//    cho 2 mảng số nguyên A và B, tìm các cặp số (A[i], B[j]) thoả mãn:
//            - A[i] và B[j] không đồng thời là số chẵn
//- A[i] + B[j] chia hết cho 3
    public static void main(String args []) {
        int a[] = {1,2,3,5,6};
        int b[] = {2,3,4,5,6};

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {

                if(a[i] %2 == 0) {
                    if ( b[j] %2 != 0 && a[i] + b[j] % 3 == 0)
                        System.out.println(" cap so a va b la " + a[i] + " " + b[j]);
                }
                else {
                    if( a[i] + b[j] % 3 == 0) {
                        System.out.println(" cap so a va b la " + a[i] + " " + b[j]);
                    }

                }


            }
        }
    }
}
