import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class NetHttp {

    private static void get(String u) {
        try {
            URL url = new URL(u);
            URLConnection conn = url.openConnection();
            conn.connect();
            try (InputStream in = conn.getInputStream(); InputStreamReader in2 = new InputStreamReader(in)) {
                char[] buf = new char[100];
                while(true) {
                    int read = in2.read(buf);
                    if(read < 100) break;
                }
                System.out.println("ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        get("https://www.google.com"); // get the crypto stuff initialized, seems to increase chances of the problem appearing
        for (int i = 1; i <= 20; i++) {
            Thread t = new Thread(() -> {
                get("https://www.cloudflare.com");
            });
            t.start();
            Thread.sleep(50);
        }
    }
}