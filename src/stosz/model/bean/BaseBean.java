package stosz.model.bean;

/**
 * Created by yu on 2017/8/20.
 */
public class BaseBean {
    private static BaseBean sBaseBean = new BaseBean();

    private BaseBean() {
    }

    public static BaseBean getInstance() {
        return sBaseBean;
    }

}
