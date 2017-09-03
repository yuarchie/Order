package stosz.main;

import stosz.controller.OrderController;
import stosz.model.OrderModel;
import stosz.model.http.ImageListener;
import stosz.model.http.LoginAnalysis;
import stosz.view.Login;
import stosz.view.client.OrderClient;

public class Main {

    public static void main(String[] args) {


        OrderClient client = new OrderClient();
        client.login();
        OrderModel model = new OrderModel();


        OrderController controller = new OrderController(client,model);
        client.setController(controller);



    }
}
