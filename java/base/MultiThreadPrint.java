package base;

public class MultiThreadPrint {

    public static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1(true);
        Thread1 thread2 = new Thread1(false);
        thread1.start();
        thread2.start();
    }

    static class Thread1 extends Thread {
        private boolean first = true;

        public Thread1(boolean first) {
            this.first = first;
        }

        @Override
        public void run() {
            int i = 0;
            if (!first) {
                i = 1;
            }
            while (i < 100) {
                if (flag && first) {
                    System.out.println(this.getName() + ":" + i);
                    i += 2;
                    flag = false;
                }else if(!first && !flag){
                    System.out.println(this.getName() + ":" + i);
                    i += 2;
                    flag = true;
                }
            }
        }
    }

}
