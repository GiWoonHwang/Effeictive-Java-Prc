package effectivejava.chapter2.item9.tryfinally;

import java.io.*;

/**
 * 현재 코드의 문제점
 * FileInputStream 예외가 발생한 후, OutputStream 예외가 발생하면 첫 번째 예외는 사라지고 두 번째 예외만 전달된다.
 */
public class CopyPrc {

    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try{
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0,n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }

    }
    public  static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
