package effectivejava.chapter2.item3.enumtype;

public  enum ElvisPrc {

    INSTANCE;

    public void leaveTheuBuilding() { System.out.println("제가 가겠습니다");}


    public static void main(String[] args) {
        ElvisPrc elvis = ElvisPrc.INSTANCE;

        elvis.leaveTheuBuilding();
    }


}