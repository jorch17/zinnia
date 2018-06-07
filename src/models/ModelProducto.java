package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import views.ViewProducto;

public class ModelProducto {

    private ViewProducto view_producto;
    
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private String sql;
    
    private int id_producto;
    private String descripcion;
    private int id_categoria;
    private int existencia;
    private int precio_producto;
    private int id_salida;
    
   
    public int getId_producto() {
        return id_producto;
    }
    
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
    }
    
    public void Conectar(){ //conectar con la base de datos
        try{
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/zinnia","root","1234");                     
            st=conexion.createStatement(); 
            seleccionarTodo();
            
            rs=st.executeQuery("select * from producto;");
            rs.next();   
            System.out.println("Conexion correcta a la BASE DE DATOS ZINNIA");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 101 conexion a BD  "+ex.getMessage());
        }
    }// termina conectar
    
    public void llenarValores(){
        try{
            setId_producto(rs.getInt("id_producto"));
            setDescripcion(rs.getString("descripcion"));
            //view_producto.jcb_categoria.setSelectedItem(getId_categoria());
            setId_categoria(rs.getInt("id_categoria"));  
            setExistencia(rs.getInt("existencia"));
            setPrecio_producto(rs.getInt("precio_producto"));
            setId_salida(rs.getInt("id_salida"));
            
            System.out.println("llenando todos los campos de producto");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 102 llenado de valores "+ex.getMessage());
        }
    }//termina llenado de valores}
    
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
            System.out.println("boton activado mover primero producto ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 103 mover Primer value "+ex.getMessage());
        }
    }//mover primero
    
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
            System.out.println("boton activado mover ultimo producto ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 104 mover ultimo value "+ex.getMessage());
        }
    }//mover ultimo
    
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false){
                rs.next();
                llenarValores();
                System.out.println("boton activado mover siguiente producto ");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 105 mover siguiente value "+ex.getMessage());
        }
    }//mover siguente
    
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false){
                rs.previous();
                llenarValores();
                System.out.println("boton activado mover anterior producto ");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 106 mover anterior value "+ex.getMessage());
        }
    }//mover anterior
    
    public void seleccionarTodo(){
        try{
            sql="select * from producto;";
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            moverPrimero();
            System.out.println("seleccionando todo producto ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 107 seleccionar todo "+ex.getMessage());
        }
    }// seleccionar todo
    
    public void insertar(String descripcion,int id_categoria,int existencia,int precio_producto,int id_salida){
        try{
            sql="insert into producto(descripcion,id_categoria,existencia,precio_producto,id_salida)"
               + " values(?,?,?,?,?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,descripcion);
            ps.setInt(2,id_categoria);
            ps.setInt(3,existencia);
            ps.setInt(4,precio_producto);
            ps.setInt(5,id_salida);
            ps.executeUpdate();
            moverPrimero();
            
            System.out.println("producto insertado ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 108 insertar datos "+ex.getMessage());
        }
    }// insertando datos
    
    public void eliminar(int id_producto){
        try{
            sql="delete from producto where id_producto= ?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(1,id_producto);
            ps.executeUpdate();
            moverPrimero();
            System.out.println("producto borrados");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 109 Borrar datos "+ ex.getMessage());
        }
    }//borrar datos
    
    
    public void llenarCategoria(){
        try{
        sql= "select * from categoria;";
         rs=st.executeQuery(sql);             
         view_producto.jcb_categoria.removeAllItems();
         
        while(rs.next()){
            
            view_producto.jcb_categoria.addItem(rs.getString("nombre"));
        }
        System.out.println("llenado combox");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 110 no llenado el combo "+ ex.getMessage());
        }
    }//llenado de categoria
   
}
