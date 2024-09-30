package effectivejava.chapter3.item10;

// 코드 10-6 전형적인 equals 메서드의 예 (64쪽)
public final class PhoneNumberPrc {

    private final short areaCode, prefix, lineNum;

    public PhoneNumberPrc(int areaCode, int prefix, int lineNUm) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNUm, 9999, "가입자 번호");
    }



    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val >max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o ){
        if (o == this)
            return true;

        if (!(o instanceof  PhoneNumberPrc))
            return false;

        PhoneNumberPrc pn = (PhoneNumberPrc) o;

        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;



    }





}
