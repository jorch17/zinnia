package models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class ModelCliente {

    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private String sql;
    
    private int id_cliente;
    private String nombre;
    private String apellido_pa;
    private String apellido_ma;
    private String telefono;
    private String calle;
    private String colonia;
    private String numero;
    private String ciudad;
    private String estado;
    private String email;
    
    
    public int getId_cliente(){
        return id_cliente;
    }
    
    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pa() {
        return apellido_pa;
    }

    public void setApellido_pa(String apellido_pa) {
        this.apellido_pa = apellido_pa;
    }

    public String getApellido_ma() {
        return apellido_ma;
    }

    public void setApellido_ma(String apellido_ma) {
        this.apellido_ma = apellido_ma;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void Conectar(){ //conectar con la base de datos
        try{
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/zinnia","root","151617");                     
            st=conexion.createStatement(); 
            seleccionarTodo();
            //rs=st.executeQuery("Select * from cliente");
            
            System.out.println("Conexion correcta a la BASE DE DATOS ZINNIA");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 101 conexion a BD  "+ex.getMessage());
        }
    }// termina conectar
    
    public void llenarValores(){
        try{
            setId_cliente(rs.getInt("id_cliente"));
            setNombre(rs.getString("nombre"));
            setApellido_pa(rs.getString("apellido_pa"));
            setApellido_ma(rs.getString("apellido_ma"));
            setTelefono(rs.getString("telefono"));
            setCalle(rs.getString("calle"));
            setColonia(rs.getString("colonia"));
            setNumero(rs.getString("numero"));
            setCiudad(rs.getString("ciudad"));
            setEstado(rs.getString("estado"));
            setEmail(rs.getString("email"));     
            System.out.println("llenando todos los campos de cliente");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 102 llenado de valores "+ex.getMessage());
        }
    }//termina llenado de valores
    
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
            System.out.println("boton activado mover primero cliente ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 103 mover Primer value "+ex.getMessage());
        }
    }//mover primero
    
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
            System.out.println("boton activado mover ultimo cliente ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 104 mover ultimo value "+ex.getMessage());
        }
    }//mover ultimo
    
    public void moverSiguiente(){
        try{
            if(rs.last() == false){
                rs.next();
                llenarValores();
                System.out.println("boton activado mover siguiente cliente ");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 105 mover siguiente value "+ex.getMessage());
        }
    }//mover siguente
    
    public void moverAnterior(){
        try{
            if(rs.first() == false){
                rs.previous();
                llenarValores();
                System.out.println("boton activado mover anterior cliente ");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 106 mover anterior value "+ex.getMessage());
        }
    }//mover anterior
    
    public void seleccionarTodo(){
        try{
            sql="Select * from cliente;";
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            moverPrimero();
            System.out.println("seleccionando todo personas ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 107 seleccionar todo "+ex.getMessage());
        }
    }// seleccionar todo

            
    public void insertar(String nombre,String apellido_pa,String apellido_ma,String telefono,String calle,
            String colonia,String numero,String ciudad,String estado,String email){
        try{
            sql="insert into cliente(nombre,apellido_pa,apellido_ma,telefono,calle,colonia,numero,ciudad,estado,email) values(?,?,?,?,?,?,?,?,?,?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2,apellido_pa);
            ps.setString(3,apellido_ma);
            ps.setString(4,telefono);
            ps.setString(5,calle);
            ps.setString(6,colonia);
            ps.setString(7,numero);
            ps.setString(8,ciudad);
            ps.setString(9,estado);
            ps.setString(10,email);
            ps.executeUpdate();
            moverPrimero();
            
            System.out.println("insertando datos personas ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 108 insertar datos "+ex.getMessage());
        }
    }// insertando datos
    
    public void borrar(int id_cliente){
        try{
            sql="delete from cliente where id_cliente= ?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(1,id_cliente);
            ps.executeUpdate();
            moverPrimero();
            System.out.println("dato borrado personas ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 109 Borrar datos "+ ex.getMessage());
        }
    }//borrar datos
    
  
}
