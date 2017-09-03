package stosz.view.client;

import stosz.controller.OrderController;
import stosz.view.Index;
import stosz.view.Login;

import javax.swing.*;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by yu on 2017/8/15.
 */
public class OrderClient{

    private JFrame mJFrame;
    private JPanel mJPanel;
    private Login login;
    private Index index;
    private JMenuBar menuBar;

    public void setController(OrderController controller) {
        this.controller = controller;
    }

    private OrderController controller;

    public OrderClient() {
        init ();
    }

    private void init (){
        menuBar = new JMenuBar();
        login = new Login();
        index = new Index();
        mJFrame = new JFrame();
        mJFrame.setTitle("订单审核系统");
        mJFrame.setSize(400,300);
        mJFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mJFrame.setVisible(true);
    }


    public void login() {
        mJFrame.setContentPane(login.getPanel());
        login.getPanel().updateUI();
    }

    public void index() {

        JMenu menu = new JMenu("DF订单管理");
        JMenuItem menuItem1 = new JMenuItem("订单列表");
        menu.add(new JMenuItem("未处理订单"));
        menu.add(new JMenuItem("已处理订单"));
        menu.add(new JMenuItem("待审核订单"));
        menu.add(new JMenuItem("无效订单"));
        menu.add(new JMenuItem("每日统计"));
        menu.add(new JMenuItem("物流状态统计"));
        menuBar.add(menu);
        mJFrame.setSize(800,600);
        mJFrame.setContentPane(index.getIndexJPanel());
        mJFrame.setJMenuBar(menuBar);
        index.getIndexJPanel().updateUI();

    }


}
