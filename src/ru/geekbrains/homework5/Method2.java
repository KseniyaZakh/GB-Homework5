package ru.geekbrains.homework5;

public class Method2 {


    public static void main(String[] args) throws InterruptedException {
        addArray();
    }

    public static void addArray() throws InterruptedException {
        int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long start = System.currentTimeMillis();

        float[] leftPart = new float[size / 2];
        float[] rightPart = new float[size / 2];

        System.arraycopy(arr, 0, leftPart, 0, size / 2);

        System.arraycopy(arr, size / 2, rightPart, 0, size / 2);

        long devide =System.currentTimeMillis();

        final MyThread Thread1 = new MyThread(leftPart);
        Thread1.start();


        final MyThread Thread2 = new MyThread(rightPart);
        Thread2.start();

        Thread1.join();
        Thread2.join();
        long count =System.currentTimeMillis();

        System.arraycopy(Thread1.getArray(), 0, arr, 0, size / 2);
        System.arraycopy(Thread2.getArray(), 0, arr, size / 2, size / 2);
        System.out.println("Время разбивки массива: "+ (devide - start));
        System.out.println("Время просчета массива: "+ (count-devide));
        System.out.println("Время склейки: " + (System.currentTimeMillis()-count));
        System.out.println("Время работы метода2: " + (System.currentTimeMillis() - start));


    }
}

class MyThread extends Thread {
    private float[] array;

    public MyThread(float[] array) {
        this.array = array;
    }

    public float[] getArray() {
        return array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}


