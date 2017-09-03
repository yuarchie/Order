package stosz.model;

import stosz.model.http.ImageDownload;
import stosz.model.http.LoginAnalysis;

import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2017/8/18.
 */
public class OrderModel {


    private LoginAnalysis analysis;
    private ImageDownload download;
    private Map<String,String> headers;
    private CookieManager cookieManager;
    private static Proxy sProxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",1080));

    public OrderModel() {
       headers = new HashMap<String, String>();
       headers.put("Accept-Language","zh-CN,zh;q=0.8");
       headers.put("Host","erp.stosz.com:9090");
       headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36");
    }







}
