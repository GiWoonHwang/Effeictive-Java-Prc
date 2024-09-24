package effectivejava.chapter2.item5.singleton;


import java.util.List;

// 코드5-2 싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
//
//public class SpellChecker {
//    private final Lexicon dictionary = "test";
//
//    private SpellChecker() {}
//
//    public static SpellChecker INSTANCE = new SpellChecker();
//
//    public boolean isValid(String word){}
//    public List<String> suggestions(String typo) {}
//}
