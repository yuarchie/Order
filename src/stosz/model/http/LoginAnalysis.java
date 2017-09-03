package stosz.model.http;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2017/8/19.
 */
public class LoginAnalysis implements Runnable {

    public static final String LOGIN = "http://erp.stosz.com:9090/admin/public/login";
    private Map<String,String> headers;
    private ImageListener listener;



    public LoginAnalysis(ImageListener listener) {
        this.listener = listener;
        headers = new HashMap();
        headers.put("Accept-Language","zh-CN,zh;q=0.8");
        headers.put("Host","erp.stosz.com:9090");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36");

    }

    @Override
    public void run() {

        try {
            Connection conn = Jsoup.connect(LOGIN);
            conn.headers(headers);
            conn.method(Connection.Method.GET);
            Connection.Response response = conn.execute();
            String cookie = "";
            for (Map.Entry<String,String> entry:response.cookies().entrySet()) {
                cookie = cookie + entry.getKey()+"="+entry.getValue()+";";
            }
            headers.put("Cookie",cookie);
            updateImage();
            System.out.println(response.body().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateImage() {
        new Thread(new ImageDownload(listener,headers)).start();
    }
}
