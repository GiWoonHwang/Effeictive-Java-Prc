package effectivejava.chapter2.item6;

// 코드 6-3 끔찍이 느리다! 객체가 만들어지는 위치를 찾았는가? (34쪽)
public class SumPrc {

    private static long sumPrc() {
        long sum = 0L;

        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static  void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        long x = 0;

        for(int i = 0; i < numSets; i ++){
            long start = System.nanoTime();
            x += sumPrc();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000 + " mx. ");
        }

        if (x == 42)
            System.out.println();

    }
}
