
package IU;

import Logica.Gestor;
import Logica.Pedido;
import Logica.SesionGestor;
import controlers.ControladorProcesarPedido;
import Vistas.IVistaProcesarPedido;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcesarPedido extends javax.swing.JDialog implements IVistaProcesarPedido{

    private ControladorProcesarPedido controlador;
    private SesionGestor sesion;
    private Gestor gestor;
    
    public ProcesarPedido(java.awt.Frame parent, boolean modal, SesionGestor sg) {
        super(parent, modal);
        initComponents();
        this.setTitle("Procesar pedidos");
        setLocationRelativeTo(null);
        sesion = sg;
        gestor = sg.getGestor();
        controlador = new ControladorProcesarPedido(this, gestor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDatosGestor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPedidos = new javax.swing.JList();
        btnTomarPedido = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidosTomados = new javax.swing.JTable();
        btnFinalizarPedido = new javax.swing.JButton();
        btnEntregarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setToolTipText("");

        jScrollPane1.setViewportView(lstPedidos);

        btnTomarPedido.setText("Tomar pedido");
        btnTomarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarPedidoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(tblPedidosTomados);

        btnFinalizarPedido.setText("Finalizar pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        btnEntregarPedido.setText("Entregar Pedido");
        btnEntregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFinalizarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(btnEntregarPedido))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDatosGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnTomarPedido)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(lblDatosGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTomarPedido)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarPedido)
                    .addComponent(btnEntregarPedido))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean cerrar = controlador.finalizarVista(sesion);
        if (cerrar) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarPedidoActionPerformed
        int indice = lstPedidos.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            controlador.tomarPedido(indice);
        }
    }//GEN-LAST:event_btnTomarPedidoActionPerformed

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
        int fila = tblPedidosTomados.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            controlador.finalizarPedido(fila);
        }   
    }//GEN-LAST:event_btnFinalizarPedidoActionPerformed

    private void btnEntregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarPedidoActionPerformed
       int fila = tblPedidosTomados.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            controlador.entregarPedido(fila);
        }   
    }//GEN-LAST:event_btnEntregarPedidoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntregarPedido;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnTomarPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDatosGestor;
    private javax.swing.JList lstPedidos;
    private javax.swing.JTable tblPedidosTomados;
    // End of variables declaration//GEN-END:variables


    @Override
    public void cargarDatosGestor() {
        lblDatosGestor.setText("Gestor: " + gestor.getNombreCompleto() + " | Unidad Procesadora: " + gestor.getUnidadProcesadora().getNombre());
    }

    @Override
    public void cargarPedidos(ArrayList<Pedido> pedidosDe) {
        ArrayList<String> pedidosString = new ArrayList();
        for(Pedido p : pedidosDe){
            pedidosString.add(p.getItem().getNombre() + p.getCliente().getNombreCompleto() + p.getHoraPedido());
        }
        lstPedidos.setListData(pedidosString.toArray());
    }

    @Override
    public void cargarPedidosTomados(ArrayList<Pedido> pedidosTomadoDe) {
      DefaultTableModel datos = new DefaultTableModel();
        datos.addColumn("Nombre de Item");
        datos.addColumn("Descripcion");
        datos.addColumn("Cliente");
        datos.addColumn("FechaHora");
        datos.addColumn("Estado");
        datos.setRowCount(pedidosTomadoDe.size());
        int fila = 0;
        
        for (Pedido p: pedidosTomadoDe){
            datos.setValueAt(p.getItem().getNombre(),fila,0);
            datos.setValueAt(p.getComentario(),fila,1);
            datos.setValueAt(p.getCliente().getNombreCompleto(),fila,2);
            datos.setValueAt(p.getHoraPedido(),fila,3);
            datos.setValueAt(p.getEstado(),fila,4);
            fila++;
        }
        tblPedidosTomados.setModel(datos); 
    }

    @Override
    public void mostrarMensaje(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }  
}
