package stosz.controller;

import stosz.model.OrderModel;
import stosz.view.client.OrderClient;

/**
 * Created by yu on 2017/8/18.
 */
public class OrderController {

    private OrderClient client;
    private OrderModel model;

    public OrderController(OrderClient client, OrderModel model) {
        this.client = client;
        this.model = model;
    }




}
