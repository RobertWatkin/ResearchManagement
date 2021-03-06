/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement.accounts;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import researchmanagement.Audit;
import researchmanagement.Dashboard;
import researchmanagement.Database;
import researchmanagement.Login;
import researchmanagement.models.Account;


/**
 *
 * @author robert.watkin
 */
public class AccountManagement extends javax.swing.JFrame implements ActionListener {

    private Account loggedIn;
    private Account selectedAccount;
    private ArrayList<Account> accounts;
    
    
    /**
     * Creates new form AccountManagement
     */
    public AccountManagement(Account loggedIn) {
        // Check for an invalid access to this form
        if (loggedIn.getId() == -1){
            this.dispose();
        }
        initComponents();
        
        loadAccounts();
        
        this.loggedIn = loggedIn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dashboardButton = new javax.swing.JButton();
        allAccountsPanel = new javax.swing.JPanel();
        newAccountButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DOBLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        editAccountButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Account Management");

        dashboardButton.setText("Dashboard");
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(467, 467, 467)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        allAccountsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("All Accounts"));
        allAccountsPanel.setLayout(new javax.swing.BoxLayout(allAccountsPanel, javax.swing.BoxLayout.Y_AXIS));

        newAccountButton.setText("New Account");
        newAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAccountButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Name");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nameLabel.setText("null");

        roleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        roleLabel.setText("null");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Role");

        DOBLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DOBLabel.setText("null");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Date of Birth");

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        emailLabel.setText("null");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Email");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DOBLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(DOBLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(emailLabel)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        editAccountButton.setText("Edit");
        editAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountButtonActionPerformed(evt);
            }
        });

        deleteAccountButton.setText("Delete");
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(allAccountsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allAccountsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newAccountButton)
                    .addComponent(editAccountButton)
                    .addComponent(deleteAccountButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        // open dashboard
        Dashboard d = new Dashboard(loggedIn);
        d.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void editAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccountButtonActionPerformed
        // Check if an account has been selected
        if (selectedAccount == null){
            JOptionPane.showMessageDialog(this, "You must select an account to edit it.\n\nPlease try again");
            return;
        }
        
        // Open edit account page
        EditAccount ec = new EditAccount(loggedIn, selectedAccount);
        ec.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editAccountButtonActionPerformed

    private void deleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountButtonActionPerformed
        // Check if an account has been selected
        if (selectedAccount == null){
            JOptionPane.showMessageDialog(this, "You must select an account to delete it.\n\nPlease try again");
            return;
        }
        
        // Get confirmation from the user to delete the account
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?\n\nThis cannot be undone!", "Warning!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                // Sql string to delete account
                String sqlDeleteAccount = "DELETE FROM tbl_accounts WHERE AccountID=?";

                // establish DB connection
                Connection conn = Database.Connect();

                // Create a prepared statement to delete the account
                PreparedStatement ps = conn.prepareStatement(sqlDeleteAccount);
                ps.setInt(1, selectedAccount.getId());

                // run the sql
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "The account has been deleted successfully");
            } catch (Exception e){
                return;
            }
            Audit.Update("tbl_accounts", loggedIn.getId(), loggedIn.getFirstName(), "Delete");
        }
        loadAccounts();
    }//GEN-LAST:event_deleteAccountButtonActionPerformed

    private void newAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAccountButtonActionPerformed
        // Open new account page
        NewAccount na = new NewAccount(loggedIn);
        na.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newAccountButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountManagement(new Account(-1, null, null, null, null, null)).setVisible(true);
            }
        });
    }
    
    private void loadAccounts() {
        // Refresh/create array list to store all accounts
        accounts = new ArrayList<Account>();
        
        
        // Sql string
        String sqlGetAccounts = "SELECT * FROM tbl_accounts";
        
        // try catch to handle database querying
        try (Connection conn = Database.Connect();
                PreparedStatement ps = conn.prepareStatement(sqlGetAccounts)){
            
            // Store results from query in a resultset
            ResultSet rs = ps.executeQuery();
            
            // loop through all results and store the account in the accountlist
            while (rs.next()){
                Account account = new Account(rs.getInt("AccountID"), rs.getString("FirstName"), rs.getString("LastName"),rs.getString("Email"), rs.getString("Role"), rs.getString("DOB"));
                accounts.add(account);
            }
            
            // close resultset and preparedstatment
            rs.close();
        } catch (Exception e){
            // display error message
            JOptionPane.showMessageDialog(this,"An error has occured!\n\n" + e);
 
            // relaunch login page
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
        Audit.Update("tbl_accounts", loggedIn.getId(), loggedIn.getFirstName(), "Select");
            
        // clear the panel
        allAccountsPanel.removeAll();
        System.out.println(accounts.size() + " accounts found");

        if (accounts.size() == 0){
            JLabel notice = new JLabel("There are currently 0 accounts");
            allAccountsPanel.add(notice);
        } else {
            for(Account account : accounts){
                // create a new row
                JPanel row = new JPanel(new GridLayout(1,2));
                row.setMaximumSize(new Dimension(500,30));              


                // name label to hold the accounts name
                JLabel name = new JLabel(account.getFirstName() + " " + account.getLastName(), SwingConstants.LEFT);
                name.setSize(200, 20);

                // Button to select the account
                JButton select = new JButton("Select");
                select.setActionCommand(Integer.toString(account.getId()));
                select.addActionListener(this);

                // Add elements to the row
                row.add(name);
                row.add(select);
                allAccountsPanel.add(row);
            }
        }
        allAccountsPanel.validate();
        allAccountsPanel.repaint();
        allAccountsPanel.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JPanel allAccountsPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JButton editAccountButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newAccountButton;
    private javax.swing.JLabel roleLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
            String action = ae.getActionCommand();
            System.out.println("Button pressed");
            
            // SQL string
            String sqlGetAccount = "SELECT * FROM tbl_accounts WHERE AccountID=?";
                
            try (Connection conn = Database.Connect();
                PreparedStatement ps = conn.prepareStatement(sqlGetAccount)){
                int accountId = Integer.parseInt(action);
                
                ps.setInt(1, accountId);
                
                ResultSet rs = ps.executeQuery();

                if (rs.next()){
                    selectedAccount = new Account(rs.getInt("AccountID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Email"),rs.getString("Role"),rs.getString("DOB"));
                    nameLabel.setText(selectedAccount.getFirstName() + " " + selectedAccount.getLastName());
                    roleLabel.setText(selectedAccount.getRole());
                    emailLabel.setText(selectedAccount.getEmail());
                    DOBLabel.setText(selectedAccount.getDOB());
                } else{
                    JOptionPane.showMessageDialog(this, "There has been a problem retrieving this account\n\nPlease try again");
                }
                
                // close resultset
                rs.close();
            } catch (Exception e){
                // display error message
                JOptionPane.showMessageDialog(this,"An error has occured!\n\n" + e);
                
                // relaunch login page
                Login l = new Login();
                l.setVisible(true);
                this.dispose();
            }
            Audit.Update("tbl_accounts", loggedIn.getId(), loggedIn.getFirstName(), "Select");
    }
}
