package effectivejava.chapter2.item3.staticfactory;

// 코드 3-2 정적 팩터리 방식의 싱글턴 (24쪽)
public class ElvisPrc {

    public static final ElvisPrc INSTANCE = new ElvisPrc();

    private ElvisPrc() {}


    public static ElvisPrc getInstance() {
        return INSTANCE;

    }


}
