package effectivejava.chapter2.item8;

import java.lang.ref.Cleaner;

/**
 * 자바의 객체 소멸자인 finalizer, cleaner의 사용을 피하라.
 * 이유1: 오동작, 낮은 성능, 이식성 문제, 예측불가, 느리고 불필요하다.
 * 이유2: cleaner는 자신을 수행할 스레드를 제어할 수 있지만 여전히 백그라운드에서 수행되며 가비지 컬렉터의 통제하에 있다.
 * 이유3: 자바 언어는 두 소멸자의 수행 시점뿐 아니라 수행 여부조차 보장하지 않는다.
 */
public  class RoomPrc implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    // 정적이 아닌 중첩 클래스는 자동으로 바깥 객체의 참조를 갖게 된다
    private static class State implements  Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public  RoomPrc (int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    @Override
    public void close()  {
        cleanable.clean();
    }
}