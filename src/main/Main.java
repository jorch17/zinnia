package main;

//import models.ModelMain;
import views.ViewMain;
import controllers.ControllerMain;

import models.ModelCliente;
import views.ViewCliente;
import controllers.ControllerCliente;

//import models.ModelProducto;
//import views.ViewProducto;
//import controllers.ControllerProducto;

public class Main {


    public static void main(String[] jla) {
        
        ModelCliente model_cliente = new ModelCliente();
        ViewCliente view_cliente = new ViewCliente();
        ControllerCliente controller_cliente = new ControllerCliente(model_cliente,view_cliente);
        
        /*ModelProducto model_producto = new ModelProducto();
        ViewProducto view_producto = new ViewProducto();
        ControllerProducto controller_producto = new Controllerproducto(model_producto,view_producto);
        */

        //ModelMain model_main = new ModelMain();
        ViewMain view_main = new ViewMain();
        Object views[] = new Object[2];
        
        views[0]= view_main;
        views[1]= view_cliente;
        //views[2]= view_producto;
        
        Object controllers[] = new Object[1];
        controllers[0]= controller_cliente;
        //controllers[1]= controller_producto;
        
        ControllerMain controller_main = new ControllerMain(views,controllers);
    }
    
}
