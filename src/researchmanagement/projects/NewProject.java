/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement.projects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import researchmanagement.Audit;
import researchmanagement.Dashboard;
import researchmanagement.Database;
import researchmanagement.Login;
import researchmanagement.models.Account;
import researchmanagement.models.ComboBoxItem;
/**
 *
 * @author robert.watkin
 */
public class NewProject extends javax.swing.JFrame {

    private Account loggedIn;
    private DefaultComboBoxModel customerModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel headResearcherModel = new DefaultComboBoxModel();
    
    /**
     * Creates new form NewAccount
     */
    public NewProject(Account acc) {
        initComponents();
        this.setVisible(true);
        
        // check for unauthorised login
        if (acc.getId() == -1){
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
        loggedIn = acc;
        
        setValues();
    }
    
    // Sets the values for the combo boxes
    private void setValues(){
        
        // SQL string to get all customers
        String sqlGetCustomers = "SELECT * FROM tbl_customers";
        
        // Try with resource for database query
        try (Connection conn = Database.Connect();
                // prepare statement to run
                PreparedStatement ps = conn.prepareStatement(sqlGetCustomers)){
                
                // result set to store customers
                ResultSet rs = ps.executeQuery();
                
                // remove all from the combo box
                this.customerSelection.removeAll();
                
                // Check for 0 customers
                if (!rs.isBeforeFirst()){
                    // Display error message
                    JOptionPane.showMessageDialog(this, "Cannot create project as there are no customers\n\nReturning to Dashboard");

                    // return to dashboard screen
                    Dashboard d = new Dashboard(loggedIn);
                    d.setVisible(true);
                    this.dispose();
                    return;
                }
                
                // loop through projects and add to model
                while (rs.next()){
                    customerModel.addElement(new ComboBoxItem(rs.getInt("CustomerId"), rs.getString("FirstName") + " " + rs.getString("LastName")));
                }
                
                // add model to the combo box
                this.customerSelection.setModel(customerModel);
        } catch (Exception e){
            // Display error message
            JOptionPane.showMessageDialog(this, "An error has occured while retrieving customers\n\n" + e);
            
            // return to dashboard screen
            Dashboard d = new Dashboard(loggedIn);
            d.setVisible(true);
            this.dispose();
        }
        Audit.Update("tbl_customers", loggedIn.getId(), loggedIn.getFirstName(), "Select");
            
        // SQL string to get all accounts that are head admins
        String sqlGetAccounts = "SELECT * FROM tbl_accounts WHERE role = 'Head Researcher'";
        
        // Try with resource for database query
        try (Connection conn = Database.Connect();
                // prepare statement to run
                PreparedStatement ps = conn.prepareStatement(sqlGetAccounts)){
                
                // result set to store customers
                ResultSet rs = ps.executeQuery();
                
                // remove all from the combo box
                this.headResearcherSelection.removeAll();
                
                // Check for 0 projects
                if (!rs.isBeforeFirst()){
                    // Display error message
                    JOptionPane.showMessageDialog(this, "Cannot create project as there are no head researchers\n\nReturning to Dashboard");

                    // return to dashboard screen
                    Dashboard d = new Dashboard(loggedIn);
                    d.setVisible(true);
                    this.dispose();
                }
                
                // loop through projects and add to model
                while (rs.next()){
                    headResearcherModel.addElement(new ComboBoxItem(rs.getInt("AccountID"), rs.getString("FirstName") + " " + rs.getString("LastName")));
                }
                
                // add model to the combo box
                this.headResearcherSelection.setModel(headResearcherModel);
        } catch (Exception e){
            // Display error message
            JOptionPane.showMessageDialog(this, "An error has occured while retrieving projects\n\n" + e);
            
            // return to dashboard screen
            Dashboard d = new Dashboard(loggedIn);
            d.setVisible(true);
            this.dispose();
        }   
        Audit.Update("tbl_accounts", loggedIn.getId(), loggedIn.getFirstName(), "Select");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        customerSelection = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        headResearcherSelection = new javax.swing.JComboBox<>();
        nameField = new javax.swing.JTextField();
        createProjectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Date of Birth");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 350));
        setPreferredSize(new java.awt.Dimension(300, 350));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("New Project");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Customer");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Project Name");

        customerSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectionActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Head Researcher");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customerSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headResearcherSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 151, Short.MAX_VALUE))
            .addComponent(nameField)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headResearcherSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        createProjectButton.setText("Create Project");
        createProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createProjectButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // return to dashboard screen
        Dashboard d = new Dashboard(loggedIn);
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void customerSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSelectionActionPerformed
        // not used
    }//GEN-LAST:event_customerSelectionActionPerformed

    private void createProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectButtonActionPerformed
        ComboBoxItem headResearcher = (ComboBoxItem) headResearcherSelection.getSelectedItem();

        // check head researcher has no more than 3 projects assigned already
        String sqlGetProjectCount = "SELECT COUNT(*) FROM tbl_projects WHERE HeadResearcherID=? AND status<>?";
        
        try (Connection conn = Database.Connect();
                PreparedStatement ps = conn.prepareStatement(sqlGetProjectCount);){

            // Prepare statement with head researcherID  input
            ps.setInt(1, headResearcher.getId());
            ps.setString(2, "Signed Off");
            
            // execute sql
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){ // if there are any results
                int count = rs.getInt(1); // get the count of the results
                rs.close();
                
                // if count >= 1 then the email has been taken and the user cannot sign up
                if (count >= 3){
                    JOptionPane.showMessageDialog(this, "The head researcher already has the maximum of 3 projects assigned to them\n\nPlease choose a different head researcher");

                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "An error has occured.\n\n Please try again");
                return;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "An error has occured.\n\n Please try again");
            return;
        }
        Audit.Update("tbl_projects", loggedIn.getId(), loggedIn.getFirstName(), "Select (Count)");

        // prepare sql string
        String sqlInsert = "INSERT INTO tbl_projects (Name, Status, CustomerID, HeadResearcherID) VALUES (?, ?, ?, ?)";               
        
        // Insert the customer into the database
        try (Connection conn = Database.Connect();
                PreparedStatement insertPs = conn.prepareStatement(sqlInsert)){

            System.out.println(nameField.getText());
            
            // prepare sql with values
            insertPs.setString(1, nameField.getText());
            insertPs.setString(2, "In Progress");
            
            // retrieve selected customer and head researcher
            ComboBoxItem customer = (ComboBoxItem) customerSelection.getSelectedItem();
            
            // add IDs to prepared statement
            insertPs.setInt(3, customer.getId()); 
            insertPs.setInt(4, headResearcher.getId());
            
            // execute the sql query
            int row = insertPs.executeUpdate();
            System.out.println("Project inserted into row " + row);
                  
            JOptionPane.showMessageDialog(null, "Create Successful!\n\nReturning to Dashboard");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot save customer!\n\nError: " + e);
        }
        Audit.Update("tbl_projects", loggedIn.getId(), loggedIn.getFirstName(), "Insert");
        
        // return to dashboard screen
        Dashboard d = new Dashboard(loggedIn);
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createProjectButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // not used
    }//GEN-LAST:event_nameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewProject(new Account(-1, null, null, null, null, null)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createProjectButton;
    private javax.swing.JComboBox<String> customerSelection;
    private javax.swing.JComboBox<String> headResearcherSelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
