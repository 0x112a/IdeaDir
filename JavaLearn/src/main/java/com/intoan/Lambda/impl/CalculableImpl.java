package com.intoan.Lambda.impl;

import com.intoan.Lambda.Calculable;

public class CalculableImpl implements Calculable {
    @Override
    public int calculable(int a, int b) {

        return a+b;
    }

    public static Calculable calculable(char opr){
        Calculable result;

        if (opr == '+'){
            result = new Calculable() {
                @Override
                public int calculable(int a, int b) {
                    return a+b;
                }
            };
        }else {
            result = new Calculable() {
                @Override
                public int calculable(int a, int b) {
                    return a-b;
                }
            };
        }

        return result;
    }

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;
        Calculable f1 = calculable('+');
        Calculable f2 = calculable('-');

        System.out.println(f1.calculable(n1,n2));
        System.out.println(f2.calculable(n1,n2));
    }
}
