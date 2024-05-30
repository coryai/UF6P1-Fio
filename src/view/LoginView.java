package view;

import exception.LimitLoginException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Employee;

public class LoginView extends javax.swing.JFrame {

    private Object btnLogin;
    private int loginAttempts = 0;

    public LoginView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        JLabelPass = new javax.swing.JLabel();
        JButtonAcceder = new javax.swing.JButton();
        JLabelNumeroEmpleado = new javax.swing.JLabel();
        JTextFieldNumeroEmpleado = new javax.swing.JTextField();
        JTextFieldPass = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLabelPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JLabelPass.setText("Password");

        JButtonAcceder.setBackground(new java.awt.Color(204, 204, 255));
        JButtonAcceder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JButtonAcceder.setText("Acceder");
        JButtonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAccederActionPerformed(evt);
            }
        });

        JLabelNumeroEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JLabelNumeroEmpleado.setText("Número de empleado");

        JTextFieldNumeroEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldNumeroEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addComponent(JButtonAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLabelPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabelNumeroEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(JTextFieldNumeroEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(JTextFieldPass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(JLabelNumeroEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTextFieldNumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JLabelPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTextFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(JButtonAcceder)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>                        

    private void JButtonAccederActionPerformed(java.awt.event.ActionEvent evt) {                                               

        try{ 
            int employeeId = Integer.parseInt(JTextFieldNumeroEmpleado.getText());
            String password = JTextFieldPass.getText();
            Employee employee = new Employee(employeeId, password);
            if(employee.login(employeeId, password) == true){
                 ShopView shopView = new ShopView();
                 shopView.setVisible(true);
                 this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "No se puede abrir la tienda.", "Error", JOptionPane.ERROR_MESSAGE);
                loginAttempts ++;
                if (loginAttempts == 3){
                    throw new LimitLoginException();
                }
            }
            
        }catch(LimitLoginException lle){
            JOptionPane.showMessageDialog(this, "Número máximo de intentos de inicio de sesión alcanzado. La aplicación se cerrará.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
           
    }                                              

    private void JTextFieldNumeroEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton JButtonAcceder;
    private javax.swing.JLabel JLabelNumeroEmpleado;
    private javax.swing.JLabel JLabelPass;
    private javax.swing.JTextField JTextFieldNumeroEmpleado;
    private javax.swing.JTextField JTextFieldPass;
    // End of variables declaration                   

 
    
}



