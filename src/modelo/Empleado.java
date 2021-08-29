/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author joseg
 */
public class Empleado extends Persona{
    private int id_empleado, id_puesto;
    private String codigo;
    static Conexion cn;

    public Empleado(){}
    
    public Empleado(int id_empleado, int id_puesto, String codigo, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id_empleado = id_empleado;
        this.id_puesto = id_puesto;
        this.codigo = codigo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    ///////////////////////////////////////
    @Override
    public void agregar()
    {
        String puesto=String.valueOf(getId_puesto());
        String codigosql;
        try
        {
            PreparedStatement parametro;
            codigosql="Insert into db_empresa.empleados (id_puesto, codigo, nombres, apellidos, direccion, telefono, fecha_nacimiento) values (?,?,?,?,?,?,?)";
            cn.abrir_conexion();
            parametro=(PreparedStatement)cn.conexionBD.prepareStatement(codigosql);
            //parametro.setMaxRows(getId_puesto());
            parametro.setInt(1,getId_puesto());
            parametro.setString(2,getCodigo());
            parametro.setString(3,getNombres());
            parametro.setString(4,getApellidos());
            parametro.setString(5,getDireccion());
            parametro.setString(6,getTelefono());
            parametro.setString(7,getFecha_nacimiento());
            int ejecutar=parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null, "Registro Agregado","Agergar",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex)
        {
            System.out.println("Error.... "+ex.getMessage());
        }
    }
    
    ///////////////////////////////////////
    public DefaultTableModel mostrar()
    {
        DefaultTableModel tabla= new DefaultTableModel();
        try
        { 
            cn=new Conexion();
            cn.abrir_conexion();
            String codigosql;
            codigosql="select e.id_empleado, e.codigo, e.nombres, e.apellidos, e.direccion, e.telefono, e.fecha_nacimiento, p.puesto from db_empresa.empleados as e INNER JOIN db_empresa.puestos as p on e.id_puesto=p.id_puesto ORDER BY id_empleado";
            ResultSet consulta= cn.conexionBD.createStatement().executeQuery(codigosql);
            String encabezado[]={"id","Codigo","nombres","apellidos","direccion","telefono","fecha_nacimiento","puesto"};
            tabla.setColumnIdentifiers(encabezado);
            String obj_datos[]=new String[8];
            while(consulta.next())
            {
                obj_datos[0]=consulta.getString("e.id_empleado");
                obj_datos[1]=consulta.getString("e.codigo");
                obj_datos[2]=consulta.getString("e.nombres");
                obj_datos[3]=consulta.getString("e.apellidos");
                obj_datos[4]=consulta.getString("e.direccion");
                obj_datos[5]=consulta.getString("e.telefono");
                obj_datos[6]=consulta.getString("e.fecha_nacimiento");
                obj_datos[7]=consulta.getString("p.puesto");
                tabla.addRow(obj_datos);
            }
            cn.cerrar_conexion();
        }catch(SQLException ex)
        {
            cn.cerrar_conexion();
            System.out.println("Error ....... "+ex.getMessage());
        }
            
        return tabla;
    }
    
    ///////////////////////////////////////
    public void actualizar()
    {
        String puesto=String.valueOf(getId_puesto());
        try
        {
            PreparedStatement parametro;
            String query="Update db_empresa.empleados set id_puesto=?, codigo=?,nombres=?,apellidos=?,direccion=?,telefono=?,fecha_nacimiento=? where id_empleado=?;";
            cn = new Conexion();
            cn.abrir_conexion();
            parametro=(PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId_puesto());
            parametro.setString(2,getCodigo());
            parametro.setString(3, getNombres());
            parametro.setString(4, getApellidos());
            parametro.setString(5, getDireccion());
            parametro.setString(6, getTelefono());
            parametro.setString(7, getFecha_nacimiento());
            parametro.setInt(8,getId_empleado());
            int ejecutar=parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null, Integer.toString(ejecutar)+"Update exitoso","Modificar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex)
        {
            System.out.println("error........"+ex.getMessage());
        }
    }
    
    ///////////////////////////////////////
    public void eliminar()
    {
        String codigosql;
        try
        {
            PreparedStatement parametro;
            codigosql="delete from db_empresa.empleados where id_empleado=?";
            cn = new Conexion();
            cn.abrir_conexion();
            parametro=(PreparedStatement)cn.conexionBD.prepareStatement(codigosql);
            parametro.setInt(1,getId_empleado());
            int execute=parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null, Integer.toString(execute)+"Delete exitoso","Eliminar",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(HeadlessException | SQLException ex)
        {
            System.out.println("error........ "+ex.getMessage());
        }
        cn.cerrar_conexion();
    }
    
    
    public static ArrayList<String> cmb_puesto()
    {
        ArrayList<String> puestos = new ArrayList<String>();
        String codigosql;
        try
        {
        codigosql="select id_puesto, puesto from  db_empresa.puestos";
            cn = new Conexion();
            cn.abrir_conexion();
        ResultSet consulta= cn.conexionBD.createStatement().executeQuery(codigosql);
        //System.out.println("Nice");
        while(consulta.next())
        {
            //puestos.add(consulta.getString("id_puesto"));
            puestos.add(consulta.getString("puesto"));
        }
        }catch(SQLException ex)
        {
            System.out.println("error........ "+ex.getMessage());
        }
        return puestos;
    }
    
    public int comparar(String puesto)
    {
        int id=0;
        String codigosql;
        PreparedStatement parametro;
        try
        {
            codigosql="select id_puesto from  db_empresa.puestos where puesto=?";
            cn = new Conexion();
            cn.abrir_conexion();
            parametro=(PreparedStatement)cn.conexionBD.prepareStatement(codigosql);
            ResultSet rs;
            parametro.setString(1,puesto);
            rs=parametro.executeQuery();
            while(rs.next()) 
            {
                id=rs.getInt("id_puesto");
            }
            
            cn.cerrar_conexion();
        }catch(SQLException ex)
        {
            System.out.println("error........ "+ex.getMessage());
        }
        System.out.println(id);
        return id;
    }
}
