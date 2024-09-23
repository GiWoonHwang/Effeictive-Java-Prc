package effectivejava.chapter2.item3.field;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
public class ElvisPrc {

    public static final ElvisPrc INSTANCE = new ElvisPrc();


    private ElvisPrc() {}

    public void leaveTheBuilding() { System.out.println("public static final 방식의 싱글턴");}


    public  static void main(String[] args) {
        ElvisPrc elvisPrc = ElvisPrc.INSTANCE;
        elvisPrc.leaveTheBuilding();
    }

}
