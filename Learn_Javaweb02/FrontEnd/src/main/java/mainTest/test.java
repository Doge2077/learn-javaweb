package mainTest;

class test {
    public static void main(String[] args) {
        testFace test1 = s -> System.out.println(s);
        test1.fxxk("javascript is a shit");

        testFace test2 = System.out::println;
        test2.fxxk("javascript is a shit");

        shitOn(str -> {
            System.out.println(str);
        });

        shitOn(System.out::println);

        shitOn(test1);
    }

    interface testFace {
        void fxxk(String s);
    }

    public static void shitOn(testFace testcase) {
        testcase.fxxk("javascript is a shit");
    }

}