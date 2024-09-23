package effectivejava.chapter2.item4;

/**
 * 정적 필드와 정적 메소드만으로 구성된 클래스를 만드는 경우
 * 1. 인스턴스를 만든다는 것은 객체마다 다른 속성값을 가지고 있을 때 의미가 있다. 정적 필드와 메소드로만 구성된 클래스는 객체를 만드는 것이 의미가 없다.
 * 2. static은 클래스 자체에 속하기 때문에 메모리의 메서드 영역에 로드된다. 따라서 특정 객체에 속하지 않게 된다.
 */


// 코드 4-1 인스턴스를 만들 수 없는 유틸리티 클래스 (26~27쪽)
public class UtilityClass {
    // 기본 생성자가 만들어지는 것을 막는다(인스턴스화 방지용).
    private UtilityClass() {
        throw new AssertionError();
    }

    // 나머지 코드는 생략
}
