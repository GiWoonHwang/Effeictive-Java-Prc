package effectivejava.chapter2.item1;
//
//public interface HelloService {
//    String hello();
//}
//
//class KoreanHelloService implements HelloService {
//    @Override
//    public String hello(){
//        return "안녕";
//    }
//}
//
//class EnglishHelloService implements HelloService {
//    @Override
//    public  String hello(){
//        return "hello";
//    }
//}
//
//class HelloServiceFactory {
//    public static of(String lang) {
//        if (lang.equals("ko")){
//           return new KoreanHelloService();
//        }else{
//            return new EnglishHelloService();
//        }
//
//    }
//}
//
//public class Prc {
//}
