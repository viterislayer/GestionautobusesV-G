/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto1;

/**
 *
 * @author vieri
 */
import java.awt.Component;
import javax.swing.*;

public class CompraBoletosGUI extends javax.swing.JFrame {

    private String nombreUsuario;
    private String direccionUsuario;

    private javax.swing.JButton jButtonComprar;
    private javax.swing.JComboBox<String> jComboBoxHorarios;
    private javax.swing.JLabel jLabelHorario;
    private final String nitUsuario;

    public CompraBoletosGUI() {
     
        

this.nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese su nombre:", "Registro de Usuario", JOptionPane.PLAIN_MESSAGE);
if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
    nombreUsuario = "Cliente";
}

// Pedir NIT
this.nitUsuario = JOptionPane.showInputDialog(null, "Ingrese su NIT:", "Registro Tributario", JOptionPane.PLAIN_MESSAGE);
if (nitUsuario == null || nitUsuario.trim().isEmpty()) {
   
}

// Pedir dirección
this.direccionUsuario = JOptionPane.showInputDialog(null, "Ingrese su dirección:", "Registro de Dirección", JOptionPane.PLAIN_MESSAGE);
if (direccionUsuario == null || direccionUsuario.trim().isEmpty()) {
    direccionUsuario = "Sin dirección";
}


java.util.List<String[]> facturas = new java.util.ArrayList<>();

initComponents();
jLabelHorario = new javax.swing.JLabel();
jComboBoxHorarios = new javax.swing.JComboBox<>();
jButtonComprar = new javax.swing.JButton();
        JButton jButtonExportar = new javax.swing.JButton(); 

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setTitle("Capa UI Compra de Boletos - " + nombreUsuario);

jLabelHorario.setText("Selecciona horario:");
jComboBoxHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
    "06:00 AM", "08:00 AM", "10:00 AM", "12:00 PM", "02:00 PM", "04:00 PM", "06:00 PM"
}));

jButtonComprar.setText("Comprar Boleto");
jButtonComprar.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonComprarActionPerformed(evt);
    }
});


jButtonExportar.setText("Exportar a Excel");
jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonExportarActionPerformed(evt);
    }
});


javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelHorario)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonComprar)
                .addGap(18, 18, 18)
                .addComponent(jButtonExportar)))  
        .addContainerGap(40, Short.MAX_VALUE))
);
layout.setVerticalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGap(50, 50, 50)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabelHorario)
            .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(30, 30, 30)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jButtonComprar)
            .addComponent(jButtonExportar))  
        .addContainerGap(50, Short.MAX_VALUE))
);

pack();
}


private static int contadorFacturas = 1;


private java.util.List<String[]> facturas = new java.util.ArrayList<>();


private void jButtonComprarActionPerformed(java.awt.event.ActionEvent evt) {
    String horarioSeleccionado = jComboBoxHorarios.getSelectedItem().toString();
    int precioBoleto = 20; // Costo en quetzales
    
    
    int numeroFactura = contadorFacturas++;
    int numeroBus = new java.util.Random().nextInt(10) + 1;
    int numeroAsiento = new java.util.Random().nextInt(40) + 1;
    
    
    facturas.add(new String[]{
        String.valueOf(numeroFactura),
        nitUsuario,
        nombreUsuario,
        direccionUsuario,
        horarioSeleccionado,
        String.valueOf(numeroBus),
        String.valueOf(numeroAsiento),
        "Q" + precioBoleto + ".00"
    });
    
    
    JOptionPane.showMessageDialog(this,
        "Factura de Transportes V&G\n\n" +
        "No. Factura: " + numeroFactura + "\n" +
        "NIT: " + nitUsuario + "\n" +
        "Cliente: " + nombreUsuario + "\n" +
        "Dirección: " + direccionUsuario + "\n" +
        "Horario: " + horarioSeleccionado + "\n" +
        "Bus: " + numeroBus + "\n" +
        "Asiento: " + numeroAsiento + "\n" +
        "Total: Q" + precioBoleto + ".00\n\n" +
        "¡Gracias por su compra Feliz viaje!",
        "Confirmación de Boleto",
        JOptionPane.INFORMATION_MESSAGE
    );
}


private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {
    if (facturas.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay facturas para exportar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        
        java.io.File file = new java.io.File("reporte_facturas.csv");
        java.io.FileWriter writer = new java.io.FileWriter(file);
        
        
        writer.write("No. Factura,NIT,Cliente,Dirección,Horario,Bus,Asiento,Total\n");
        
         
        for (String[] factura : facturas) {
            writer.write(String.join(",", factura) + "\n");
        }
        
        writer.close();
        
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop.getDesktop().open(file);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Archivo exportado en: " + file.getAbsolutePath(), 
                "Exportación Exitosa", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al exportar: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(CompraBoletosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompraBoletosGUI().setVisible(true);
            }
        });
    }
}

