package effectivejava.chapter2.item1;



public class StaticFactoryMethodTestUser {
    private static StaticFactoryMethodTestUser USER = new StaticFactoryMethodTestUser();
    private String name;

    // 외부에서 생성자를 만들 수 없다.
    private  StaticFactoryMethodTestUser() {

    }

    /**
     * 장점
     * 1. 구체적인 이름을 명시하여 객체의 특성을 묘사할 수 있다.
     * 2. 호출될 때마다 인스턴스를 새로 생성 하지 않아도 된다. 상수를 만들어 호출 될 때 마다 새로운 객체가 아닌 동일한 객체가 리턴 되도록 한다.
     * 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
     *
     * 단점
     * 1. 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
     */
    public  static StaticFactoryMethodTestUser withName(String name){
        StaticFactoryMethodTestUser user = USER;
        user.name = name;
        return user;
    }

    public static StaticFactoryMethodTestUser getInstance() {
        return USER;
    }

    public static void main(String[] args) {
        StaticFactoryMethodTestUser user = StaticFactoryMethodTestUser.getInstance();
        System.out.println(user);
    }

}





