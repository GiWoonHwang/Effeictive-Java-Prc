package effectivejava.chapter3.item11;

import java.util.HashMap;
import java.util.Map;

/**
 * hashCode() 메서드 재정의의 중요성: equals()를 재정의하면 hashCode()도 반드시 재정의해야 한다.
 * 그렇지 않으면 HashMap, HashSet과 같은 해시 기반 컬렉션에서 equals()가 true를 반환하더라도 hashCode()가 다르면 서로 다른 객체로 인식되어 의도치 않은 결과를 초래할 수 있습니다.
 */
public final class PhoneNumberPrc {
    private final short areaCode, prefix, lineNum;

    public PhoneNumberPrc(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumberPrc))
            return false;
        PhoneNumberPrc pn = (PhoneNumberPrc)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }


    // hashCode 없이는 제대로 동작하지 않는다. 다음 셋 중 하나를 활성화하자.

//    // 헬퍼메서드를 사용하지 않고 직접적으로 값을 계산하기 때문에 성능이점을 가질 수 있다.
//    // 31이라는 소수분포를 이용해 해시분포를 효율적으로 만듬
//    // 코드가 비교적 복잡하고 필드가 변경될 때 마다 코드를 다시 계산해야 한다.
//    @Override public int hashCode() {
//        int result = Short.hashCode(areaCode);
//        result = 31 * result + Short.hashCode(prefix);
//        result = 31 * result + Short.hashCode(lineNum);
//        return result;
//    }

//    // 코드가 간결하고 메서드 호출이 편리함
//    // Objects.hash는 내부적으로 배열을 사용하여 성능이 저하될 수 있다, 추가적인 객체를 생성한다.
//    @Override public int hashCode() {
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

//    //
//    private int hashCode; // 자동으로 0으로 초기화된다.
//    처음 호출될 때마 계싼하여 저장하고 이후 호출에는 저장된 값을 반환함
//    불필요한 연산을 줄여 성능을 최적화함
//    코드가 복잡하고, 멀티 스레드 환경에서 해시코드를 초기화 할 때 동시성 문제가 있다.
//    @Override public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = Short.hashCode(areaCode);
//            result = 31 * result + Short.hashCode(prefix);
//            result = 31 * result + Short.hashCode(lineNum);
//            hashCode = result;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Map<PhoneNumberPrc, String> m = new HashMap<>();
        m.put(new PhoneNumberPrc(707, 867, 5309), "제니");
        System.out.println(m.get(new PhoneNumberPrc(707, 867, 5309)));
    }
}
