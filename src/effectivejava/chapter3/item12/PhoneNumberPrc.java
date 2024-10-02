package effectivejava.chapter3.item12;

/**
 * 기본 toString() 메서드는 객체의 클래스 이름과 메모리 주소만 반환하여 객체 내부 상태를 이해하기 어렵다.
 * toString()을 재정의하여 객체의 필드값을 포함한 의미 있는 문자열을 반환하자. 이는 디버깅이나 로깅을 유용하게 한다.
 * 복잡한 객체의 경우에도 중요한 필드와 연관된 객체의 정보를 toString()에 포함하여 객체를 문자열로 표현할 수 있다.
 */
public final class PhoneNumberPrc {
    private final short areaCode, prefix, lineNum;

    public PhoneNumberPrc(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix   = rangeCheck(prefix,   999, "프리픽스");
        this.lineNum  = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof effectivejava.chapter3.item11.PhoneNumber))
            return false;
        PhoneNumberPrc pn = (PhoneNumberPrc)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환한다.
     * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
     * XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자 번호다.
     * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
     *
     * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면,
     * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
     * 전화번호의 마지막 네 문자는 "0123"이 된다.
     */
//    @Override public String toString() {
//        return String.format("%03d-%03d-%04d",
//                areaCode, prefix, lineNum);
//    }

    public static void main(String[] args) {
        PhoneNumberPrc jenny = new PhoneNumberPrc(707, 867, 5309);
        System.out.println("제니의 번호: " + jenny);
    }
}
