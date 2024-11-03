package registrodealumnos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author david
 */
public class RegistroAlumnos extends javax.swing.JFrame {
    DefaultTableModel modelo=new DefaultTableModel();
    ArrayList<Alumno> listaAlumnos=new ArrayList<Alumno>();
    private Connection conexion;
    
    public RegistroAlumnos() {
        initComponents();
        this.setTitle("REGISTRO DE ALUMNOS");
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        
        // Inicializar las columnas del modelo
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CARRERA");
        modelo.addColumn("GRUPO");
        modelo.addColumn("SEMESTRE");
        modelo.addColumn("PROMEDIO");
        
        refrescarTabla();
        conectarBaseDatos();
        cargarDatos();  // Cargar datos después de conectar a la base de datos
        
        txtNombreAlumno.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent evt) {
            // Verifica si el texto supera los 100 caracteres
            if (txtNombreAlumno.getText().length() >= 50) {
                evt.consume(); // Evita que el usuario pueda escribir más caracteres
            }
        }
        });
    }
    
    private void cargarDatos() {
    try {
        Statement statement = conexion.createStatement();
        String query = "SELECT * FROM alumnos"; // Reemplaza con tu consulta
        ResultSet resultSet = statement.executeQuery(query);
        
        // Limpiar la tabla antes de rellenar
        modelo.setRowCount(0);  // Eliminar filas existentes en la tabla

        // Recorrer el ResultSet y agregar datos al modelo de tabla
        while (resultSet.next()) {
                int dni = resultSet.getInt("dni");  // Recuperar el DNI como entero
                String nombre = resultSet.getString("nombre");
                String carrera = resultSet.getString("carrera");
                int grupo = resultSet.getInt("grupo");
                String semestre = resultSet.getString("semestre");
                double promedio = resultSet.getDouble("promedio");

            // Agregar la fila al modelo de la tabla
                modelo.addRow(new Object[]{dni, nombre, carrera, grupo, semestre, promedio});
        }

        // Cerrar el ResultSet y el Statement
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los datos de la base de datos.");
        e.printStackTrace();
    }
}
    
    private void conectarBaseDatos() {
        try {
            String url = "jdbc:mysql://localhost:3306/gestion_alumnos";
            String usuario = "root";
            String contraseña = "";
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos.");
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    
    public void refrescarTabla(){
        //Borrar todos los elementos del modelo
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        for (Alumno alumno : listaAlumnos) {
            Object a[]=new Object[6];
            a[0]=alumno.getDni();
            a[1]=alumno.getNombre();
            a[2]=alumno.getCarrera();
            a[3]=alumno.getGrupo();
            a[4]=alumno.getSemestre();
            a[5]=alumno.getPromedio();
            modelo.addRow(a);
        }
                        
        tblRegistroAlumnos.setModel(modelo);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistroAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDniAlumno = new javax.swing.JTextField();
        cboSemestre = new javax.swing.JComboBox<>();
        cboCarreraAlumno = new javax.swing.JComboBox<>();
        cboGrupoAlumno = new javax.swing.JComboBox<>();
        spnPromedioAlumno = new javax.swing.JSpinner();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        btnBuscarAlumno = new javax.swing.JButton();
        btnBorrarAlumno = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRegistroAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRegistroAlumnos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 570, 164));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("DNI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Carrera");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Grupo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Semestre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Promedio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        txtDniAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniAlumnoActionPerformed(evt);
            }
        });
        txtDniAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniAlumnoKeyTyped(evt);
            }
        });
        getContentPane().add(txtDniAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, 30));

        cboSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primero", "Segundo", "Tercero", "Cuarto", " ", " " }));
        cboSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSemestreActionPerformed(evt);
            }
        });
        getContentPane().add(cboSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 110, 30));

        cboCarreraAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Programacion", "Ventas", "Maquinas" }));
        cboCarreraAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCarreraAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(cboCarreraAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 200, -1));

        cboGrupoAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "101", "102", "103", "104", "105", "106", " " }));
        cboGrupoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGrupoAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(cboGrupoAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 110, 30));

        spnPromedioAlumno.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 20.0d, 0.5d));
        getContentPane().add(spnPromedioAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon("E:\\Java\\Registrodealumnos\\src\\assets\\limpieza-de-datos.png")); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 120, 40));

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon("E:\\Java\\Registrodealumnos\\src\\assets\\guardar-carpeta.png")); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 130, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Nombre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        txtNombreAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 360, 30));

        btnBuscarAlumno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarAlumno.setIcon(new javax.swing.ImageIcon("E:\\Java\\Registrodealumnos\\src\\assets\\buscar.png")); // NOI18N
        btnBuscarAlumno.setText("Buscar");
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 130, 40));

        btnBorrarAlumno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBorrarAlumno.setText("Borrar");
        btnBorrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 120, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("REGISTRO DE ESTUDIANTES");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSemestreActionPerformed

    private void cboCarreraAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCarreraAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCarreraAlumnoActionPerformed

    private void cboGrupoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGrupoAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGrupoAlumnoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtDniAlumno.setText("");
        txtNombreAlumno.setText("");
        cboCarreraAlumno.setSelectedIndex(0);
        cboGrupoAlumno.setSelectedIndex(0);
        cboSemestre.setSelectedIndex(0);
        spnPromedioAlumno.setValue(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtDniAlumno.getText().isEmpty() || txtNombreAlumno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.");
            return;
        }
        try {
            Alumno alumno = new Alumno();
            alumno.setDni(Integer.parseInt(txtDniAlumno.getText())); // Convertir el valor a int
            alumno.setNombre(txtNombreAlumno.getText());
            alumno.setCarrera(cboCarreraAlumno.getSelectedItem().toString());
            alumno.setGrupo(Integer.parseInt(cboGrupoAlumno.getSelectedItem().toString()));
            alumno.setSemestre(cboSemestre.getSelectedItem().toString());
            alumno.setPromedio(Double.parseDouble(spnPromedioAlumno.getValue().toString()));
            
            listaAlumnos.add(alumno);
            refrescarTabla();
            
            // Guardar en la base de datos
            String sql = "INSERT INTO alumnos (dni, nombre, carrera, grupo, semestre, promedio) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, alumno.getDni());
            stmt.setString(2, alumno.getNombre());
            stmt.setString(3, alumno.getCarrera());
            stmt.setInt(4, alumno.getGrupo());
            stmt.setString(5, alumno.getSemestre());
            stmt.setDouble(6, alumno.getPromedio());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Alumno agregado correctamente.");

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al agregar alumno a la base de datos.");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL AGREGAR ALUMNO");
        }  
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDniAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniAlumnoActionPerformed

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        try {
            int dniBusqueda = Integer.parseInt(txtDniAlumno.getText());
            String sql = "SELECT * FROM alumnos WHERE dni = ?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, dniBusqueda);
        
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                txtNombreAlumno.setText(rs.getString("nombre"));
                cboCarreraAlumno.setSelectedItem(rs.getString("carrera"));
                cboGrupoAlumno.setSelectedItem(String.valueOf(rs.getInt("grupo")));
                cboSemestre.setSelectedItem(rs.getString("semestre"));
                spnPromedioAlumno.setValue(rs.getDouble("promedio"));
                JOptionPane.showMessageDialog(this, "Alumno encontrado.");
            } else {
                JOptionPane.showMessageDialog(this, "Alumno no encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar alumno en la base de datos.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un DNI válido.");
        }
    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void btnBorrarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAlumnoActionPerformed
        try {
            int dniBorrar = Integer.parseInt(txtDniAlumno.getText());
            String sql = "DELETE FROM alumnos WHERE dni = ?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, dniBorrar);
        
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                // Limpiamos los campos después de eliminar al alumno
                txtNombreAlumno.setText("");
                cboCarreraAlumno.setSelectedIndex(0);
                cboGrupoAlumno.setSelectedIndex(0);
                cboSemestre.setSelectedIndex(0);
                spnPromedioAlumno.setValue(0.0);
                JOptionPane.showMessageDialog(this, "Alumno eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Alumno no encontrado. No se eliminó ningún registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el alumno en la base de datos.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un DNI válido.");
        }
    }//GEN-LAST:event_btnBorrarAlumnoActionPerformed

    private void txtDniAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniAlumnoKeyTyped
        if(txtDniAlumno.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_txtDniAlumnoKeyTyped

    private void txtNombreAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAlumnoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrarAlumno;
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboCarreraAlumno;
    private javax.swing.JComboBox<String> cboGrupoAlumno;
    private javax.swing.JComboBox<String> cboSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnPromedioAlumno;
    private javax.swing.JTable tblRegistroAlumnos;
    private javax.swing.JTextField txtDniAlumno;
    private javax.swing.JTextField txtNombreAlumno;
    // End of variables declaration//GEN-END:variables
}
