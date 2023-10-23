/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.Conexao;
import dao.PedidoAux;
import dao.PedidosDAO;
import model.Cliente;

/**
 *
 * @author leope
 */
public class AcompanharPedido extends javax.swing.JFrame {

    private Cliente cliente;
    private ArrayList<PedidoAux> pedidoAuxs;

    /**
     * Creates new form AcompanharPedido
     * @throws SQLException
     */
    public AcompanharPedido(Cliente cliente) throws SQLException {
        initComponents();
        this.cliente = cliente;

        Connection conexao = new Conexao().getConnection();
        PedidosDAO pedidosDAO = new PedidosDAO(conexao);

        this.pedidoAuxs = pedidosDAO.selectProdutoCliente(cliente.getId());
        readJtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        produtoRecebido = new javax.swing.JButton();
        cancelaProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id produto", "cnpj vendedor", "quantidade selecionada", "pre�o", "id cliente", "email cliente", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tabelaProdutosComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        produtoRecebido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        produtoRecebido.setText("Produto Recebido");
        produtoRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    produtoRecebidoActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        cancelaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelaProduto.setText("Cancelar Pedido de Produto");
        cancelaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cancelaProdutoActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(865, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produtoRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(357, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(produtoRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(457, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaProdutosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabelaProdutosComponentAdded

    }//GEN-LAST:event_tabelaProdutosComponentAdded

    private void produtoRecebidoActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_produtoRecebidoActionPerformed
        int id_produto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do produto recebido:"));
        Connection conexao = new Conexao().getConnection();
        PedidosDAO pedidosDAO = new PedidosDAO(conexao);

        pedidosDAO.updateStatus(cliente.getId(), id_produto, "RECEBIDO");

        JOptionPane.showMessageDialog(null, "Status atualzado!");

        ArrayList<PedidoAux> pedidoAuxs = pedidosDAO.selectProdutoCliente(cliente.getId());
        this.pedidoAuxs = pedidoAuxs;
        readJtable();

    }//GEN-LAST:event_produtoRecebidoActionPerformed

    private void cancelaProdutoActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_cancelaProdutoActionPerformed
        int id_produto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do produto recebido:"));
        
        for (int i = 0; i < pedidoAuxs.size(); i++) {
            if (pedidoAuxs.get(i).getId_produto()==id_produto) {
                if (pedidoAuxs.get(i).getStatus()!="RECEBIDO") {
                    Connection conexao = new Conexao().getConnection();
                    PedidosDAO pedidosDAO = new PedidosDAO(conexao);

                    pedidosDAO.updateStatus(cliente.getId(), id_produto, "CANCELADO");

                    // colocar esse pedido no historico do cliente como cancelado
                    // remover do banco de dados o pedido cancelado

                    JOptionPane.showMessageDialog(null, "Status atualzado!");

                    ArrayList<PedidoAux> pedidoAuxs = pedidosDAO.selectProdutoCliente(cliente.getId());
                    this.pedidoAuxs = pedidoAuxs;
                    readJtable();
                } else{
                    JOptionPane.showConfirmDialog(null, "Pedido já recebido! Troque-o");
                }
            }
        }
    }//GEN-LAST:event_cancelaProdutoActionPerformed

    public void readJtable(){
        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        model.setRowCount(0);
        pedidoAuxs.forEach(ped -> {
            model.addRow(new Object[]{
                ped.getId_produto(),
                ped.getCnpj_vendedor(),
                ped.getQuant_selecionada(),
                ped.getPreco_produto(),
                ped.getId_cliente(),
                ped.getEmail_cliente(),
                ped.getStatus()
            });
        });
        
    }

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
            java.util.logging.Logger.getLogger(AcompanharPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcompanharPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcompanharPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcompanharPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AcompanharPedido(null).setVisible(true);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelaProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton produtoRecebido;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}
