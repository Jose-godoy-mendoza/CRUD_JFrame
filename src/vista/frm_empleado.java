/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;

/**
 *
 * @author joseg
 */
public class frm_empleado extends javax.swing.JFrame {

    /**
     * Creates new form frm_empleado
     */
    Empleado empleado=new Empleado();
    public frm_empleado() {
        initComponents();
        btn_agregar.setEnabled(false);
        validaciones();
        empleado=new Empleado();
        tbl_empleados.setModel(empleado.mostrar());
        ArrayList<String>tablapuestos= new ArrayList<String>();
        tablapuestos=empleado.cmb_puesto();
        for(int i=0;i<tablapuestos.size();i++)
        {
            cmb_puestos.addItem(tablapuestos.get(i));
        }
    
    }
    
    public void validaciones()
    {
        //Validacion para codigo
        if(txt_codigo.getText().isEmpty())
        {
            lbl_codigo.setForeground(Color.red);
            lbl_codigo.setText("Codigo con 1 letra seguido de 3 numeros");
        } else if(! txt_codigo.getText().matches("[A-Z]{1}[0-9]{3}"))
        {
            lbl_codigo.setForeground(Color.red);
            lbl_codigo.setText("Codigo Invalido");
        } else 
        {  
            lbl_codigo.setForeground(Color.green);
            lbl_codigo.setText("Correcto");  
        }
        
        //Validacion para Nombres
        if(txt_nombres.getText().isEmpty())
        {
            lbl_nombres.setForeground(Color.red);
            lbl_nombres.setText("Campo Requerido");
        } else if(!txt_nombres.getText().matches("[A-Z]{1}[a-z]{2,9}([ ][A-Z]{1}[a-z]{2,9})?"))
        {
            lbl_nombres.setForeground(Color.red);
            lbl_nombres.setText("Nombre No valido");
        }
        else
        {
            lbl_nombres.setForeground(Color.green);
            lbl_nombres.setText("Correcto");
        }
        
        //Validacion para Apellidos
        if(txt_apellidos.getText().isEmpty())
        {
            lbl_apellidos.setForeground(Color.red);
            lbl_apellidos.setText("Campo Requerido");
        } else if(!txt_apellidos.getText().matches("[A-Z]{1}[a-z]{2,9}[ ][A-Z]{1}[a-z]{2,9}([ ][A-Z]{1}[a-z]{2,9})?"))
        {
            lbl_apellidos.setForeground(Color.red);
            lbl_apellidos.setText("Apellido No valido");
        }
        else
        {
            lbl_apellidos.setForeground(Color.green);
            lbl_apellidos.setText("Correcto");
        }
        
        //Validaciones para Direccion
        if(txt_direccion.getText().isEmpty())
        {
            lbl_direccion.setForeground(Color.red);
            lbl_direccion.setText("Campo Requerido");
        } else if(!txt_direccion.getText().matches("[A-Z]{1}[a-z]{2,15}([ ][A-Z]{1}[.]{1})?([ ][A-Z]{1}[a-z]{2,9})?"))
        {
            lbl_direccion.setForeground(Color.red);
            lbl_direccion.setText("Direccion No valida");
        }
        else
        {
            lbl_direccion.setForeground(Color.green);
            lbl_direccion.setText("Correcto");
        }
        
        //Validaciones del telefono
        if(txt_telefono.getText().isEmpty())
        {
            lbl_telefono.setForeground(Color.red);
            lbl_telefono.setText("#### ####");
        }
        //No uso el siguiente codigo ya que en la base de datos "Telefono" tiene longitud de 8, asi que no puedo usar este codigo, 
        //solo si modifico la base de datos pero no se si seria valido
        
        //else if(!txt_telefono.getText().matches("[+]{1}[0-9]{1,4}[ ][1-9]{4,10}[ ][1-9]{4,10}"))
        else if(!txt_telefono.getText().matches("[0-9]{3,8}"))
        {
            lbl_telefono.setForeground(Color.red);
            lbl_telefono.setText("Telefono no valido");
        }
        else
        {
            lbl_telefono.setForeground(Color.green);
            lbl_telefono.setText("Correcto");
        }
        
        //Validaciones del Fecha de Nacimiento
        if(txt_fn.getText().isEmpty())
        {
            lbl_nacimiento.setForeground(Color.red);
            lbl_nacimiento.setText("Anio-Mes-Dia");
        }
        else if(!txt_fn.getText().matches("[0-9]{4}[-][0-9]{1,2}[-][0-9]{1,2}"))
        {
            lbl_nacimiento.setForeground(Color.red);
            lbl_nacimiento.setText("Fecha no valida");
        }
        else
        {
            lbl_nacimiento.setForeground(Color.green);
            lbl_nacimiento.setText("Correcto");
        }
        
        
        if(txt_codigo.getText().isEmpty() || txt_nombres.getText().isEmpty() || txt_apellidos.getText().isEmpty() || txt_direccion.getText().isEmpty() || txt_telefono.getText().isEmpty() || txt_fn.getText().isEmpty()
                || lbl_codigo.getText().equals("Codigo Invalido") || lbl_nombres.getText().equals("Nombre No valido") || lbl_apellidos.getText().equals("Apellido No valido") 
                || lbl_direccion.getText().equals("Direccion No valida") || lbl_telefono.getText().equals("Telefono no valido") || lbl_nacimiento.getText().equals("Fecha no valida"))
        {
            btn_agregar.setEnabled(false);
        }
        else
        {
            btn_agregar.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_idempleado = new javax.swing.JLabel();
        lbl_cod = new javax.swing.JLabel();
        lbl_nom = new javax.swing.JLabel();
        lbl_ape = new javax.swing.JLabel();
        lbl_dir = new javax.swing.JLabel();
        lbl_tel = new javax.swing.JLabel();
        lbl_fn = new javax.swing.JLabel();
        lbl_puesto = new javax.swing.JLabel();
        cmb_puestos = new javax.swing.JComboBox<>();
        txt_fn = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_empleados = new javax.swing.JTable();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_codigo = new javax.swing.JLabel();
        lbl_nombres = new javax.swing.JLabel();
        lbl_apellidos = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_nacimiento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_idempleado.setText("ID");

        lbl_cod.setText("Codigo");

        lbl_nom.setText("Nombres");

        lbl_ape.setText("Apellidos");

        lbl_dir.setText("Direccion");

        lbl_tel.setText("Telefono");

        lbl_fn.setText("Nacimiento");

        lbl_puesto.setText("Puesto");

        txt_fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_fnKeyReleased(evt);
            }
        });

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyReleased(evt);
            }
        });

        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_direccionKeyReleased(evt);
            }
        });

        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyReleased(evt);
            }
        });

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombresKeyReleased(evt);
            }
        });

        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoKeyReleased(evt);
            }
        });

        tbl_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_empleadosMouseClicked(evt);
            }
        });
        tbl_empleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_empleadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_empleados);

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        lbl_codigo.setForeground(new java.awt.Color(255, 0, 51));

        lbl_nombres.setForeground(new java.awt.Color(255, 0, 51));

        lbl_apellidos.setForeground(new java.awt.Color(255, 0, 51));

        lbl_direccion.setForeground(new java.awt.Color(255, 0, 51));

        lbl_telefono.setForeground(new java.awt.Color(255, 0, 51));

        lbl_nacimiento.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_idempleado)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_cod)
                                .addGap(40, 40, 40)
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_puesto)
                                    .addComponent(lbl_fn)
                                    .addComponent(lbl_tel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmb_puestos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txt_telefono)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_fn))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_dir)
                                .addGap(29, 29, 29)
                                .addComponent(txt_direccion))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_ape)
                                    .addComponent(lbl_nom))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txt_apellidos))))
                        .addGap(69, 69, 69)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lbl_direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_nombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(265, 265, 265))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_idempleado)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_cod)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nom)
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ape)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_nombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_dir)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_tel)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_fn)
                            .addComponent(txt_fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_puesto)
                    .addComponent(cmb_puestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_eliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void select_empleados()
    {
        int fila = tbl_empleados.getSelectedRow();
        lbl_idempleado.setText(tbl_empleados.getValueAt(fila, 0).toString());
        txt_codigo.setText(tbl_empleados.getValueAt(fila,1).toString());
        txt_nombres.setText(tbl_empleados.getValueAt(fila, 2).toString());
        txt_apellidos.setText(tbl_empleados.getValueAt(fila, 3).toString());
        txt_direccion.setText(tbl_empleados.getValueAt(fila, 4).toString());
        txt_telefono.setText(tbl_empleados.getValueAt(fila, 5).toString());
        txt_fn.setText(tbl_empleados.getValueAt(fila, 6).toString());
        cmb_puestos.setSelectedItem(tbl_empleados.getValueAt(fila, 7).toString());
        //cmb_puestos.getSelectedItem(tbl_empleados.getValueAt(fila, 7).toString());
    }
    
    private void tbl_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_empleadosMouseClicked
        // TODO add your handling code here:
        select_empleados();
    }//GEN-LAST:event_tbl_empleadosMouseClicked

    private void tbl_empleadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_empleadosKeyReleased
        // TODO add your handling code here:
        select_empleados();
    }//GEN-LAST:event_tbl_empleadosKeyReleased

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        int opcion=JOptionPane.showConfirmDialog(null, "Desea eliminar el registro", "opcion", JOptionPane.YES_NO_OPTION);
        if(opcion==0)
        {
        empleado=new Empleado();
        empleado.setId_empleado(Integer.valueOf(lbl_idempleado.getText()));
        empleado.eliminar();
        tbl_empleados.setModel(empleado.mostrar());
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        String comparar=(cmb_puestos.getSelectedItem().toString());
        int puesto=empleado.comparar(comparar);
        empleado= new Empleado(0,puesto,txt_codigo.getText(),txt_nombres.getText(),txt_apellidos.getText(),txt_direccion.getText(),txt_telefono.getText(),txt_fn.getText());
        empleado.agregar();
        tbl_empleados.setModel(empleado.mostrar());
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        String comparar=(cmb_puestos.getSelectedItem().toString());
        int puesto=empleado.comparar(comparar);
        empleado=new Empleado(Integer.valueOf(lbl_idempleado.getText()),puesto,txt_codigo.getText(),txt_nombres.getText(),txt_apellidos.getText(),txt_direccion.getText(),txt_telefono.getText(),txt_fn.getText());
        empleado.actualizar();
        tbl_empleados.setModel(empleado.mostrar());
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void txt_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyReleased
        // TODO add your handling code here:
        validaciones();
    }//GEN-LAST:event_txt_codigoKeyReleased

    private void txt_nombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyReleased
        // TODO add your handling code here:
        validaciones();
    }//GEN-LAST:event_txt_nombresKeyReleased

    private void txt_apellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyReleased
        // TODO add your handling code here:
        validaciones();
    }//GEN-LAST:event_txt_apellidosKeyReleased

    private void txt_direccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyReleased
        // TODO add your handling code here:
        validaciones();
    }//GEN-LAST:event_txt_direccionKeyReleased

    private void txt_telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyReleased
        // TODO add your handling code here:
        validaciones();
    }//GEN-LAST:event_txt_telefonoKeyReleased

    private void txt_fnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fnKeyReleased
        // TODO add your handling code here:
        validaciones();
    }//GEN-LAST:event_txt_fnKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_puestos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ape;
    private javax.swing.JLabel lbl_apellidos;
    private javax.swing.JLabel lbl_cod;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_dir;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_fn;
    private javax.swing.JLabel lbl_idempleado;
    private javax.swing.JLabel lbl_nacimiento;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_nombres;
    private javax.swing.JLabel lbl_puesto;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JTable tbl_empleados;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_fn;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
