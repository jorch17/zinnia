package controllers;
//import models.ModelMain;
import views.ViewMain;
//import models.ModelCliente;
import views.ViewCliente;
//import models.ModelProducto;
//import views.ViewProducto;



public class ControllerMain {
    private ViewMain view_main;
    private ViewCliente view_cliente;
    //private ViewProducto view_producto;
    private ControllerCliente controller_cliente;
    //private ControllerProducto controller_porducto;
    
    public ControllerMain(/*Objet models[]*/Object views[],Object controllers[]){
        
        view_main=(ViewMain)views[0];
        view_cliente=(ViewCliente)views[1];
        //view_producto=(ViewProducto)views[2];
        
        controller_cliente=(ControllerCliente)controllers[0];
        //controller_producto=(ControllerProducto)controllers[1];
        
        initView();
        view_main.jmi_cliente.addActionListener(event -> jmi_cliente_click());
        //view_main.jmi_producto.addActionListener(event -> jmi_producto_click());
        view_main.jmi_salir.addActionListener(event -> jmi_salir_click());
        
        
    }
    
    public void jmi_cliente_click(){
        view_main.setContentPane(view_cliente);
        view_main.revalidate();
        view_main.repaint();
    }// menu personas
    
    /*public void jmi_producto_click(){
        view_main.setContentPane(view_producto);
        view_main.revalidate();
        view_main.repaint();
    }//menu direcciones
    */
    
    public void jmi_salir_click(){
        System.exit(0);
    }// menu salir
    
    public void initView(){
            view_main.setTitle("ZINNIA");
            view_main.setLocationRelativeTo(null);
            view_main.setVisible(true);
        
    }// vista inicial
    
}
