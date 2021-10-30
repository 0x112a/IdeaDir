package com.nowcoder.java;

class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
        System.err.println("aaa");
    }

    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            //当try中带有return时，会先执行return前的代码，然后暂时保存需要return的信息，再执行finally中的代码，最后再通过return返回之前保存的信息。
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
