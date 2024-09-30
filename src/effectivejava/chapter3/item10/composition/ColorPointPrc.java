package effectivejava.chapter3.item10.composition;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

import java.util.Objects;

// 코드 10-5 equals 규약을 지키면서 값 추가하기 (60쪽)
public class ColorPointPrc {

    private  final Point point;
    private final Color color;

    public ColorPointPrc(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {return point; }

    @Override public boolean equals(Object o) {
        if(!(o instanceof ColorPointPrc))
            return false;
        ColorPointPrc cp = (ColorPointPrc) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override public int hashCode() {return 31 * point.hashCode() + color.hashCode();}


}
