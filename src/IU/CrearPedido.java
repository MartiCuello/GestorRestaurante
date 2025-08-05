
package IU;

import Vistas.IVistaCliente;
import Logica.Categoria;
import Logica.Dispositivo;
import Logica.Item;
import Logica.Pedido;
import Logica.Servicio;
import Logica.SesionCliente;
import controlers.ControladorCrearPedido;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CrearPedido extends javax.swing.JFrame implements IVistaCliente{

    private ControladorCrearPedido controlador;
    private Dispositivo dispositivo;
    private SesionCliente sesion;
    private Servicio servicio;
    
    public CrearPedido(Dispositivo d) {
        initComponents();
        setLocationRelativeTo(null);
        dispositivo = d;
        controlador = new ControladorCrearPedido(this, dispositivo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputNumCliente = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputComentarios = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnConfirmarPedidos = new javax.swing.JButton();
        btnFinalizarServicio = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        lblMonto = new javax.swing.JLabel();
        labelMensajes = new javax.swing.JLabel();
        inputPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Identificarse");

        btnLogin.setText("Aceptar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("Numero cliente");

        jLabel3.setText("Constraseña");

        jLabel4.setText("Menu");

        lstCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCategorias);

        jLabel5.setText("Categorias");

        jLabel6.setText("Items");

        jScrollPane2.setViewportView(lstItems);

        inputComentarios.setColumns(20);
        inputComentarios.setRows(5);
        jScrollPane3.setViewportView(inputComentarios);

        jLabel7.setText("Comentarios");

        btnAgregarPedido.setText("Agregar pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setText("Eliminar pedido");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        jLabel8.setText("Pedidos del servicio");

        btnConfirmarPedidos.setText("Confirmar pedidos");
        btnConfirmarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidosActionPerformed(evt);
            }
        });

        btnFinalizarServicio.setText("Finalizar servicio");
        btnFinalizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarServicioActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(tblPedidos);

        lblMonto.setText("Monto total: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNumCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPass, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMonto)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(45, 45, 45)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(273, 273, 273)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(168, 168, 168)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAgregarPedido)
                                                .addGap(35, 35, 35)
                                                .addComponent(btnEliminarPedido)))
                                        .addGap(22, 22, 22))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnConfirmarPedidos)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFinalizarServicio))
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNumCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(inputPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(5, 5, 5)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarPedido)
                            .addComponent(btnEliminarPedido))))
                .addGap(78, 78, 78)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarPedidos)
                    .addComponent(btnFinalizarServicio))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMonto)
                .addGap(58, 58, 58)
                .addComponent(labelMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoriasValueChanged
        int indice = lstCategorias.getSelectedIndex();
        if (indice != -1){
            controlador.seleccionarCategoria(indice);
        }
    }//GEN-LAST:event_lstCategoriasValueChanged

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String numCliente = inputNumCliente.getText();
        String pass = inputPass.getText();
        controlador.login(numCliente, pass);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        int indiceI = lstItems.getSelectedIndex();
        if (indiceI == -1) {
            labelMensajes.setText("Debe seleccionar un item.");
        } else {
            int indiceCat = lstCategorias.getSelectedIndex();
            String com = inputComentarios.getText();
            controlador.agregarPedido(servicio, indiceI, indiceCat, com);
        }
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        int fila = tblPedidos.getSelectedRow();
        if (fila == -1){
            labelMensajes.setText("Debe seleccionar un pedido.");
        } else {
            controlador.eliminarPedido(fila);
        }
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnConfirmarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidosActionPerformed
        controlador.confirmarPedidos();
    }//GEN-LAST:event_btnConfirmarPedidosActionPerformed

    private void btnFinalizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarServicioActionPerformed
        controlador.finalizarServicio();
    }//GEN-LAST:event_btnFinalizarServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnConfirmarPedidos;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnFinalizarServicio;
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextArea inputComentarios;
    private javax.swing.JTextField inputNumCliente;
    private javax.swing.JPasswordField inputPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelMensajes;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JList lstCategorias;
    private javax.swing.JList lstItems;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarCategoriasMenu(ArrayList<Categoria> categorias) {
        ArrayList<String> categoriasString = new ArrayList();
        for(Categoria c : categorias){
            categoriasString.add(c.getNombre());
        }
        lstCategorias.setListData(categoriasString.toArray());
    }

    @Override
    public void cargarItems(Categoria c) {
        ArrayList<String> itemsString = new ArrayList();
        for(Item i : c.getItemsDisponibles()){
            itemsString.add(i.getNombre() + "-" + "$"+i.getPrecio());
        }
        lstItems.setListData(itemsString.toArray());
    }

    @Override
    public void ingresar(SesionCliente s) {
        this.sesion = s;
        this.servicio = dispositivo.getServicio();
        this.sesion.setDispositivo(dispositivo);
        this.setTitle("Realizar pedidos " + "-" + " Cliente: " + s.getCliente().getNombreCompleto());
    }    

    @Override
    public void cargarServicio(Servicio servicio) {
        if(servicio == null){
            tblPedidos.setModel(new DefaultTableModel());
        }
        else{
            ArrayList<Pedido> pedidos = servicio.getPedidos();
            DefaultTableModel datos = new DefaultTableModel();
            datos.addColumn("Item");
            datos.addColumn("Comentario");
            datos.addColumn("Estado");
            datos.addColumn("Unidad");
            datos.addColumn("Gestor");
            datos.addColumn("Precio");
            datos.setRowCount(pedidos.size());
            int fila = 0;

            for (Pedido p: pedidos){
                datos.setValueAt(p.getItem().getNombre(),fila,0);
                datos.setValueAt(p.getComentario(),fila,1);
                datos.setValueAt(p.getEstado(),fila,2);
                datos.setValueAt(p.getItem().getUnidadProcesadora().getNombre(),fila,3);

                if(p.getGestor() == null){
                   datos.setValueAt("",fila,4); 
                }else {
                    datos.setValueAt(p.getGestor().getNombreCompleto(),fila,4);
                }

                datos.setValueAt(p.getItem().getPrecio(),fila,5);
                fila++;
            }
            tblPedidos.setModel(datos); 
            lblMonto.setText("Monto total: $" + servicio.getMontoTotal());
        }
    }

    @Override
    public void reiniciarVista() {
    this.sesion = null;
    this.servicio = null;
    this.setTitle("Realizar pedidos");

    tblPedidos.setModel(new DefaultTableModel());

    inputNumCliente.setText("");
    inputPass.setText("");
    inputComentarios.setText("");

    labelMensajes.setText("");
    lblMonto.setText("");
    }

    //MENSAJES
    @Override
    public void mostrarMensaje(String mensaje) {
        labelMensajes.setText(mensaje);
    }
    
    @Override
    public void mostrarError(String message) {
        labelMensajes.setText(message);
    }
    
    @Override
    public void avisoRetiroPedido() {
        JOptionPane.showMessageDialog(this, "Tiene un pedido finalizado puede pasar a retirarlo.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
   
    @Override
    public void mostrarResumenPago(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Resumen de Pago", JOptionPane.INFORMATION_MESSAGE);
    }
}
