/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import main.Shop;

/**
 *
 * @author fiore
 */
public class ProductView extends javax.swing.JDialog {

    private Shop shop;
    private int option;
 
    public ProductView(int option, Shop shop) {
        initComponents();
        this.shop = shop;
        this.option = option;
        
        switch(option){
            case 2:
                setTitle("Añadir Producto");
                break;
            case 3:
                setTitle("Añadir Stock");
                jTextFieldPrecio.setVisible(false);
                jLabelPrecio.setVisible(false);
                
                break;
            case 9:
                setTitle("Eliminar Producto");
                jLabelStock.setVisible(false);
                jTextFieldStock.setVisible(false);
                jLabelPrecio.setVisible(false);
                jTextFieldPrecio.setVisible(false);
                
                break;
            default:
                //setVisible(false);
                break;
                
        }
    }
    
    
    public void openProductView(int option, Shop shop){
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabelProducto = new javax.swing.JLabel();
        jLabelStock = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jTextFieldProducto = new javax.swing.JTextField();
        jTextFieldStock = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelProducto.setText("Nombre producto:");

        jLabelStock.setText("Stock  producto:");

        jLabelPrecio.setText("Precio producto:");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProducto)
                    .addComponent(jLabelStock)
                    .addComponent(jLabelPrecio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldProducto)
                    .addComponent(jTextFieldStock)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButtonOk)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProducto)
                    .addComponent(jTextFieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStock)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.dispose();
    }                                             

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        if (this.option == 2){
            String nombre = jTextFieldProducto.getText();
            int stock = Integer.parseInt(jTextFieldStock.getText());
            int precio = Integer.parseInt(jTextFieldPrecio.getText());
            if(shop.addProduct(nombre, stock, precio) == false){
                JOptionPane.showMessageDialog(this,
                "El producto ya existe",
                "Error", JOptionPane.ERROR_MESSAGE
                );
            }else{
                this.dispose();
            }
        }else if(this.option==3){
            String nombre = jTextFieldProducto.getText();
            int stock = Integer.parseInt(jTextFieldStock.getText());
            if(shop.addStock(nombre, stock) == false){
                JOptionPane.showMessageDialog(this,
                "El Producto no existe",
                "Error", JOptionPane.ERROR_MESSAGE
                );
            }else{
                this.dispose();
            }
            
        }else if(this.option==9){
            String nombre = jTextFieldProducto.getText();
            if(shop.deleteProduct(nombre) == false){
                JOptionPane.showMessageDialog(this,
                "No se ha podido realizar la petición",
                "Error", JOptionPane.ERROR_MESSAGE
                );
            }else{
                this.dispose();
            }
            
        }
    }                                         

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldProducto;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration                   
}
