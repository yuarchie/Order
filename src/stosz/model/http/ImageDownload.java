package stosz.model.http;

import java.io.*;
import java.net.*;
import java.util.Map;

/**
 * Created by yu on 2017/8/15.
 */
public class ImageDownload implements Runnable {

    private Map<String,String> headers;
    private ImageListener imageListener;
    private static Proxy sProxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",1080));
    private static final String IMAGE = "http://erp.stosz.com:9090/index.php?g=api&m=checkcode&a=index&length=4&font_size=20&width=248&height=42&use_noise=1&use_curve=0";


    public ImageDownload(ImageListener imageListener,Map<String,String> headers) {
        this.imageListener = imageListener;
        this.headers = headers;
    }

    @Override
    public void run() {

        try {
            URL url = new URL(IMAGE);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(sProxy);
           for (Map.Entry<String,String> entry:headers.entrySet()) {
               conn.setRequestProperty(entry.getKey(),entry.getValue());
           }
           conn.setRequestMethod("GET");
           conn.connect();
           if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
               InputStream is = conn.getInputStream();
               ByteArrayOutputStream os = new ByteArrayOutputStream();
               byte[] buffer = new byte[1024];
               int len = -1;
               while ((len = is.read(buffer,0,1024)) != -1) {
                   os.write(buffer, 0, len);
               }
               os.close();
               is.close();
               imageListener.showImage(os.toByteArray());
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
