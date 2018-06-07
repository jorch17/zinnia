package controllers;

import models.ModelProducto;
import views.ViewProducto;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ControllerProducto {
    
    private ModelProducto model_producto;
    private ViewProducto view_producto;
    
    public ControllerProducto(ModelProducto model_producto,ViewProducto view_producto){
        
        this.model_producto = model_producto;
        this.view_producto = view_producto;
        initView();
        view_producto.jbtn_primero.addActionListener(event -> jbtn_moverPrimero_click());
        view_producto.jbtn_anterior.addActionListener(event -> jbtn_moverAnterior_click());
        view_producto.jbtn_siguiente.addActionListener(event -> jbtn_moverSiguiente_click());
        view_producto.jbtn_ultimo.addActionListener(event -> jbtn_moverUltimo_click());
        view_producto.jbtn_insertar.addActionListener(event -> jbtn_insertar_click());
        view_producto.jbtn_eliminar.addActionListener(event -> jbtn_eliminar_click());
     
        
       
        
        
    }
    
    public void getValores(){
        view_producto.jtf_id_producto.setText(""+model_producto.getId_producto());
        view_producto.jtf_descripcion.setText(""+model_producto.getDescripcion());
        view_producto.jtf_categoria.setText(""+model_producto.getId_categoria());
        //view_producto.jcb_categoria.setSelectedItem(""+model_producto.getId_categoria());
        view_producto.jtf_existencia.setText(""+model_producto.getExistencia());
        view_producto.jtf_precio.setText(""+model_producto.getPrecio_producto());
        view_producto.jtf_salida.setText(""+model_producto.getId_salida());
        //view_producto.jcb_salida.setSelectedItem(""+model_producto.getId_salida());

    }//get valores
    
    public void setValores(){
        model_producto.setId_producto(Integer.parseInt(view_producto.jtf_id_producto.getText()));
        model_producto.setDescripcion(view_producto.jtf_descripcion.getText());
        model_producto.setId_categoria(Integer.parseInt(view_producto.jtf_categoria.getText()));
        //model_producto.setId_categoria(Integer.parseInt(view_producto.jcb_categoria.getSelectedItem().toString()));
        model_producto.setExistencia(Integer.parseInt(view_producto.jtf_existencia.getText()));
        model_producto.setPrecio_producto(Integer.parseInt(view_producto.jtf_precio.getText()));
        model_producto.setId_salida(Integer.parseInt(view_producto.jtf_salida.getText()));
        //model_producto.setId_salida(Integer.parseInt(view_producto.jcb_salida.getSelectedItem().toString()));     
    }//set valores
    
    public void jbtn_moverPrimero_click(){
        model_producto.moverPrimero();
        getValores();
    }//boton mover primero
        
    public void jbtn_moverUltimo_click(){
        model_producto.moverUltimo();
        getValores();
    }//boton mover ultimo
    
    public void jbtn_moverAnterior_click(){
        model_producto.moverAnterior();
        getValores();
    }//boton mover aterior
    
    public void jbtn_moverSiguiente_click(){
        model_producto.moverSiguiente();
        getValores();
    }//boton mover siguiente
    
    public void jbtn_insertar_click(){
        setValores();
        model_producto.insertar(model_producto.getDescripcion(),model_producto.getId_categoria(),model_producto.getExistencia(),
        model_producto.getPrecio_producto(),model_producto.getId_salida());
        getValores();
    }// boton insertar
    
    public void jbtn_eliminar_click(){
        setValores();
        model_producto.eliminar(model_producto.getId_producto());
        getValores();
    }//boton borrar
    
    
    
    
    public void initView(){
        model_producto.Conectar();
        view_producto.setVisible(true);
        model_producto.moverPrimero();
        getValores();
    }//vista de inicio 
    
    
}
