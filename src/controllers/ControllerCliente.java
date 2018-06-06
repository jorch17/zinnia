package controllers;
import models.ModelCliente;
import views.ViewCliente;

public class ControllerCliente {
 
    private ModelCliente model_cliente;
    private ViewCliente  view_cliente;
    
    public ControllerCliente (ModelCliente model_cliente,ViewCliente  view_cliente){
        this.model_cliente = model_cliente;
        this.view_cliente = view_cliente;
        initView();
        view_cliente.jbtn_primero.addActionListener(event -> jbtn_moverPrimero_click());
        view_cliente.jbtn_anterior.addActionListener(event -> jbtn_moverAnterior_click());
        view_cliente.jbtn_siguiente.addActionListener(event -> jbtn_moverSiguiente_click());
        view_cliente.jbtn_ultimo.addActionListener(event -> jbtn_moverUltimo_click());
        view_cliente.jbtn_insertar.addActionListener(event -> jbtn_insertar_click());
        view_cliente.jbtn_eliminar.addActionListener(event -> jbtn_eliminar_click());
        
}
     public void getValores(){
        view_cliente.jtf_id_cliente.setText(""+model_cliente.getId_cliente());
        view_cliente.jtf_nombre.setText(""+model_cliente.getNombre());
        view_cliente.jtf_apellido_pa.setText(""+model_cliente.getApellido_pa());
        view_cliente.jtf_apellido_ma.setText(""+model_cliente.getApellido_ma());
        view_cliente.jtf_telefono.setText(""+model_cliente.getTelefono());
        view_cliente.jtf_calle.setText(""+model_cliente.getCalle());
        view_cliente.jtf_colonia.setText(""+model_cliente.getColonia());
        view_cliente.jtf_numero.setText(""+model_cliente.getNumero());
        view_cliente.jtf_ciudad.setText(""+model_cliente.getCiudad());
        view_cliente.jtf_estado.setText(""+model_cliente.getEstado());
        view_cliente.jtf_email.setText(""+model_cliente.getEmail());
    }//get valores
    
    public void setValores(){
        model_cliente.setId_cliente(Integer.parseInt(view_cliente.jtf_id_cliente.getText()));
        model_cliente.setNombre(view_cliente.jtf_nombre.getText());
        model_cliente.setApellido_pa(view_cliente.jtf_apellido_pa.getText());
        model_cliente.setApellido_ma(view_cliente.jtf_apellido_ma.getText());
        model_cliente.setTelefono(view_cliente.jtf_telefono.getText());
        model_cliente.setCalle(view_cliente.jtf_calle.getText());
        model_cliente.setColonia(view_cliente.jtf_colonia.getText());
        model_cliente.setNumero(view_cliente.jtf_numero.getText());
        model_cliente.setCiudad(view_cliente.jtf_ciudad.getText());
        model_cliente.setEstado(view_cliente.jtf_estado.getText());
        model_cliente.setEmail(view_cliente.jtf_email.getText());      
    }//set valores
    
    public void jbtn_moverPrimero_click(){
        model_cliente.moverPrimero();
        getValores();
    }//boton mover primero
        
    public void jbtn_moverUltimo_click(){
        model_cliente.moverUltimo();
        getValores();
    }//boton mover ultimo
    
    public void jbtn_moverAnterior_click(){
        model_cliente.moverAnterior();
        getValores();
    }//boton mover aterior
    
    public void jbtn_moverSiguiente_click(){
        model_cliente.moverSiguiente();
        getValores();
    }//boton mover siguiente
    
    public void jbtn_insertar_click(){
        setValores();
        model_cliente.insertar(model_cliente.getNombre(),model_cliente.getApellido_pa(),model_cliente.getApellido_ma(),
        model_cliente.getTelefono(),model_cliente.getCalle(),model_cliente.getColonia(),model_cliente.getNumero(),
        model_cliente.getCiudad(),model_cliente.getEstado(),model_cliente.getEmail());
        getValores();
    }// boton insertar
    
    public void jbtn_eliminar_click(){
        setValores();
        model_cliente.eliminar(model_cliente.getId_cliente());
        getValores();
    }//boton borrar
    
    
    
    public void initView(){
        model_cliente.Conectar();
        view_cliente.setVisible(true);
        model_cliente.moverPrimero();
        getValores();
    }//vista de inicio  
}
