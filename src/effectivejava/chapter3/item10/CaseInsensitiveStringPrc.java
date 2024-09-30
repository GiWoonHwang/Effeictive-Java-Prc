package effectivejava.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 재정의 할 필요가 없는 경우
 * 1. 객체의 고유한 값으로만 비교할 떄
 * 2. 불변객체 일 때
 * 3. 상태를 비교할 필요가 없고, 단순히 동일한 객체인지 확인만 하고 싶을 때,
 * 4. equals의 동작이 중요하지 않을 때
 *
 * 재정의 하는 경우
 * 1. 논리적으로 값은 객체를 정의한다. 메모리주소는 다르지만  속성이 같은 경우
 *
 * 재정의 할 때 지켜야 하는 규약
 * 1. 본인과 본인을 비교하면 true여야 한다.
 * 2. x == y 이면 y == x여야 한다.
 * 3. x == y, y == z 라면, x == z여야 한다.
 * 4. x == y는 변경되지 않는 한 계속 같아야 함
 */
public final class CaseInsensitiveStringPrc {

    private final String s;

    public CaseInsensitiveStringPrc(String s) {this.s = Objects.requireNonNull(s);}


    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveStringPrc)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveStringPrc) o).s);

        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);

        return false;
    }

    public static void main(String[] args) {
        CaseInsensitiveStringPrc cis = new CaseInsensitiveStringPrc("Polish");
        String s = "polish";

        List<CaseInsensitiveStringPrc> list = new ArrayList<>();
        list.add(cis);


        System.out.println(list.contains(s));
    }



}
