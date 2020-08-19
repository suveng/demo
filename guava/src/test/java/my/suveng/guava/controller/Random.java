package my.suveng.guava.controller;

public class Random {
    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();
        int i = random.nextInt();
        int j = -3;
        int i1 = j >>> 31;
        System.out.println(i1);

    }
}
