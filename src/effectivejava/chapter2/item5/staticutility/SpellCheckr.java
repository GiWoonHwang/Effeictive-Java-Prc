package effectivejava.chapter2.item5.staticutility;

import java.util.List;

// 코드 5-1 정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
// 사전의 종류는 여러가지가 될 수 있기 때문이다.
//public class SpellCheckr {
//    private static final Lexicon dictionary = "test";
//
//    private SpellCheckr() {}
//
//    public static boolean isValid (String word) { return true}
//    public static List<String> suggestions(String typo) {
//        String s = "test List";
//    }
//
//}
