package effectivejava.chapter3.item10;

// 단순한 불변 2차원 정수 점(point) 클래스 (56쪽)
public class PointPrc {

    private final int x;

    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override public boolean equals(Object o) {
        if (!(o instanceof PointPrc))
            return false;
        PointPrc p = (PointPrc)o;

        return p.x == x && p.y == y;
    }

    @Override public int hashCode() {return 30 * x + y;}

}
