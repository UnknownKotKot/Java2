import java.util.Arrays;

public class SomeMethods {

    private static final int size = 10000000;
    private static final int h = size / 2;
    private long aT1;
    private long aT2;

    public void method1(){
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public void method2(){
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long aD = System.currentTimeMillis() - a;

        Thread t1 = new Thread(()->{
            aT1 = System.currentTimeMillis();
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            aT1 = System.currentTimeMillis() - aT1;
        });
        t1.start();
        Thread t2 = new Thread(()->{
            aT2 = System.currentTimeMillis();
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            aT2 = System.currentTimeMillis() - aT2;
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long aC = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        aC = System.currentTimeMillis() - aC;
        System.out.println(" ");
        System.out.println(a);//время старта метода
        System.out.println(aD);//время на разбивку
        System.out.println(aT1);//время выполнения 1 разбивки в 1 потоке
        System.out.println(aT2);//время выполнения 2 разбивки в 2 потоке
        System.out.println(aC);//время склеивания
        System.out.println(System.currentTimeMillis() - a);//время работы программы c учетом вывода в консоль
    }
}
