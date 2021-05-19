
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package researchmanagement;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import researchmanagement.accounts.AccountManagement;
import researchmanagement.customers.CustomerManagement;
import researchmanagement.invoices.InvoiceManagement;
import researchmanagement.models.Account;
import researchmanagement.models.Project;
import researchmanagement.models.Task;
import researchmanagement.projects.EditProject;
import researchmanagement.projects.NewProject;
import researchmanagement.tasks.NewTask;
import researchmanagement.tasks.ViewTask;

// TODO display project status and allow the status to be changed appropriately

/**
 *
 * @author robert.watkin
 */
public class Dashboard extends javax.swing.JFrame implements ActionListener{

    private Account loggedIn;
    
    private ArrayList<Project> projects;
    private int selectedProject = -1;
    private JButton selectedProjectButton;
    
    private ArrayList<Task> tasks;
    private int selectedTask = -1;
    private JButton selectedTaskButton;
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard(Account acc) {
        // If the dashboard is opened without a succesful login attempt
        if (acc.getId() == -1){
            this.dispose();
        }
        
        initComponents();
        
        // Set the logged in user to the account passed through
        loggedIn = acc;
        
        // display logged in user name
        nameLabel.setText("Hello, " + loggedIn.getFirstName() + " (" + loggedIn.getRole() + ")");
     
        // Load projects        
        if (loggedIn.getRole().equals("Head Researcher") || loggedIn.getRole().equals("System Administrator")){
            loadProjects();
        } else {
            JLabel notice = new JLabel("You can only view projects as a Head Researcher or System Admin");
            yourProjectsPanel.add(notice);
        }
         
        
        loadTasks();
        loadQuote();
    }

    public Dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        nameLabel = new javax.swing.JLabel();
        quoteLabel = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        yourProjectsPanel = new javax.swing.JPanel();
        newProjectButton = new javax.swing.JButton();
        editProjectButton = new javax.swing.JButton();
        deleteProjectButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        accountManagementButton = new javax.swing.JButton();
        customerManagementButton = new javax.swing.JButton();
        invoiceManagementButton = new javax.swing.JButton();
        completedTasksButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        yourTasksPanel = new javax.swing.JPanel();
        newTaskButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 200));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameLabel.setText("Hello, Robert (System Administrator)");

        quoteLabel.setEditable(false);
        quoteLabel.setBackground(new java.awt.Color(200, 200, 200));
        quoteLabel.setColumns(20);
        quoteLabel.setLineWrap(true);
        quoteLabel.setRows(5);
        quoteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        quoteLabel.setMaximumSize(new java.awt.Dimension(164, 94));
        quoteLabel.setMinimumSize(new java.awt.Dimension(164, 94));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quoteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(quoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(394, 432));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Your Projects");

        yourProjectsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        yourProjectsPanel.setLayout(new javax.swing.BoxLayout(yourProjectsPanel, javax.swing.BoxLayout.Y_AXIS));

        newProjectButton.setText("New Project");
        newProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectButtonActionPerformed(evt);
            }
        });

        editProjectButton.setText("Edit Project");
        editProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProjectButtonActionPerformed(evt);
            }
        });

        deleteProjectButton.setText("Delete Project");
        deleteProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProjectButtonActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        accountManagementButton.setText("Account Management");
        accountManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountManagementButtonActionPerformed(evt);
            }
        });

        customerManagementButton.setText("Customer Management");
        customerManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerManagementButtonActionPerformed(evt);
            }
        });

        invoiceManagementButton.setText("Invoice Management");
        invoiceManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceManagementButtonActionPerformed(evt);
            }
        });

        completedTasksButton.setText("Completed Tasks");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(invoiceManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(completedTasksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountManagementButton)
                    .addComponent(customerManagementButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceManagementButton)
                    .addComponent(completedTasksButton)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(yourProjectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(editProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteProjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(newProjectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourProjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProjectButton)
                    .addComponent(deleteProjectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Your Tasks");

        yourTasksPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        yourTasksPanel.setLayout(new javax.swing.BoxLayout(yourTasksPanel, javax.swing.BoxLayout.Y_AXIS));

        newTaskButton.setText("New Task");
        newTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTaskButtonActionPerformed(evt);
            }
        });

        signOutButton.setText("Sign Out");
        signOutButton.setToolTipText("");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yourTasksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(newTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(signOutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTaskButton)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourTasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signOutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectButtonActionPerformed
        // Load new project page
        NewProject np = new NewProject(loggedIn);
        this.dispose();
    }//GEN-LAST:event_newProjectButtonActionPerformed

    private void editProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectButtonActionPerformed
        if (selectedProject == -1){
            JOptionPane.showMessageDialog(this, "You must select a project to delete it.\n\nPlease try again");
            return;
        }
        
        EditProject ep = new EditProject(loggedIn, selectedProject);
        this.dispose();
    }//GEN-LAST:event_editProjectButtonActionPerformed

    private void deleteProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProjectButtonActionPerformed
        if (selectedProject == -1){
            JOptionPane.showMessageDialog(this, "You must select a project to delete it.\n\nPlease try again");
            return;
        }
       
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete project this project?\n\nThis cannot be undone!", "Warning!", JOptionPane.YES_NO_OPTION);
        
        if (reply == JOptionPane.YES_OPTION) {
            // Sql string to delete project
            boolean projectDeleted = false;
            String sqlDeleteProject = "DELETE FROM tbl_projects WHERE ProjectID=?";

            // try with resource to update database
            try (Connection conn = Database.Connect();
                    PreparedStatement ps = conn.prepareStatement(sqlDeleteProject)){
                
                ps.setInt(1, selectedProject);
                ps.executeUpdate();
                
                projectDeleted = true;
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
            
            // get task ID for deleting notes
            int[] taskIds = {};
            String sqlGetTaskID = "SELECT TaskID FROM tbl_tasks WHERE ProjectID=?";

            try (Connection conn = Database.Connect();
                    PreparedStatement ps = conn.prepareStatement(sqlGetTaskID)){
                
                ps.setInt(1, selectedProject);
                ResultSet rs = ps.executeQuery();
                
                boolean isTasks = false;
                // check if resultset is empty
                if (rs.isBeforeFirst()){
                    isTasks = true;
                }
                
                // get all task IDs
                if (isTasks){
                    while (rs.next()){
                        taskIds = Arrays.copyOf(taskIds, taskIds.length + 1);
                        taskIds[taskIds.length - 1] = rs.getInt("TaskID"); 
                    }
                }
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
            // delete tasks
            boolean tasksDeleted = false;
            String sqlDeleteTasks = "DELETE FROM tbl_tasks WHERE ProjectID=?";

            try (Connection conn = Database.Connect();
                    PreparedStatement ps = conn.prepareStatement(sqlDeleteTasks)){
                
                ps.setInt(1, selectedProject);

                ps.executeUpdate();
                
                tasksDeleted = true;
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
            // delete task notse
            if (tasksDeleted){
                for (int id : taskIds){
                    String sqlDeleteNote = "DELETE FROM tbl_notes WHERE TaskID=?";

                    try (Connection conn = Database.Connect();
                            PreparedStatement ps = conn.prepareStatement(sqlDeleteNote)){

                        ps.setInt(1, id);

                        ps.executeUpdate();
                        
                        
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            
            if (projectDeleted){
                JOptionPane.showMessageDialog(this, "The project has been deleted successfully");
            }
        }
        selectedProject = -1;
        loadProjects();
        loadTasks();
    }//GEN-LAST:event_deleteProjectButtonActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
        // Remove the logged in account
        loggedIn = null;
        
        // Create a new login form
        Login l = new Login();
        l.setVisible(true);
        
        // dispose this current form
        this.dispose();
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void newTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTaskButtonActionPerformed
        NewTask nt = new NewTask(loggedIn);
        this.dispose();
    }//GEN-LAST:event_newTaskButtonActionPerformed

    private void customerManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerManagementButtonActionPerformed
        // open customer management page
        CustomerManagement cm = new CustomerManagement(loggedIn);
        cm.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_customerManagementButtonActionPerformed

    private void accountManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountManagementButtonActionPerformed
        // open account management page
        AccountManagement am = new AccountManagement(loggedIn);
        am.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_accountManagementButtonActionPerformed

    private void invoiceManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceManagementButtonActionPerformed
        // Open invoice management page
        InvoiceManagement im = new InvoiceManagement(loggedIn);
        im.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_invoiceManagementButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(new Account(-1, null, null, null, null, null)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountManagementButton;
    private javax.swing.JButton completedTasksButton;
    private javax.swing.JButton customerManagementButton;
    private javax.swing.JButton deleteProjectButton;
    private javax.swing.JButton editProjectButton;
    private javax.swing.JButton invoiceManagementButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newProjectButton;
    private javax.swing.JButton newTaskButton;
    private javax.swing.JTextArea quoteLabel;
    private javax.swing.JButton signOutButton;
    private javax.swing.JPanel yourProjectsPanel;
    private javax.swing.JPanel yourTasksPanel;
    // End of variables declaration//GEN-END:variables

    private void loadProjects() {
        // Refresh/create array list to store all accounts
        projects = new ArrayList<Project>();
        String sqlGetProjects = "";
        
        // allow for ALL projects to be shown to system admins
        if (loggedIn.getRole().equals("System Administrator")){
              // Sql string
            sqlGetProjects = "SELECT * FROM tbl_projects";
        } else{
            // Sql string
            sqlGetProjects = "SELECT * FROM tbl_projects WHERE HeadResearcherID=?";
        }
        
     
        // try catch to handle database querying
        try (Connection conn = Database.Connect();
                PreparedStatement ps = conn.prepareStatement(sqlGetProjects)){
            
            if (!loggedIn.getRole().equals("System Administrator")){
                ps.setInt(1, loggedIn.getId());
            }
            
            // Store results from query in a resultset
            ResultSet rs = ps.executeQuery();
            
            // loop through all results and store the account in the accountlist
            while (rs.next()){
                Project project = new Project(rs.getInt("ProjectID"), rs.getString("Name"), rs.getString("Status"),rs.getInt("CustomerID"), rs.getInt("HeadResearcherID"));
                projects.add(project);
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
            
        // clear the panel
        yourProjectsPanel.removeAll();
        System.out.println(projects.size() + " projects found");
        
        if (projects.size() == 0){
            JLabel notice = new JLabel("You currently have 0 projects");
            yourProjectsPanel.add(notice);
        } else {
            for(Project project : projects){
                // create a new row
                JPanel row = new JPanel(new GridLayout(1,2));
                row.setMaximumSize(new Dimension(500,30));              


                // name label to hold the accounts name
                JLabel name = new JLabel(project.getName(), SwingConstants.LEFT);
                name.setSize(200, 20);

                // Button to select the account
                JButton select = new JButton("Select");
                select.setActionCommand(Integer.toString(project.getId()));
                select.addActionListener(this);

                // Add elements to the row
                row.add(name);
                row.add(select);
                yourProjectsPanel.add(row);
            }
        }
        yourProjectsPanel.validate();
        yourProjectsPanel.repaint();
        yourProjectsPanel.setVisible(true);
    }

    
    private void loadTasks() {
        // Refresh/create array list to store all accounts
        tasks = new ArrayList<Task>();
        
        String sqlGetTasks = "";
        
        if (loggedIn.getRole().equals("System Administrator")){
             // Sql string
             sqlGetTasks = "SELECT * FROM tbl_tasks";
        } else {
            // Sql string
             sqlGetTasks = "SELECT * FROM tbl_tasks WHERE AccountID=?";
        }
        
        
        // try catch to handle database querying
        try (Connection conn = Database.Connect();
                PreparedStatement ps = conn.prepareStatement(sqlGetTasks)){
            
            if (!loggedIn.getRole().equals("System Administrator")){
                ps.setInt(1, loggedIn.getId());
            }
            
            // Store results from query in a resultset
            ResultSet rs = ps.executeQuery();
            
            // loop through all results and store the account in the accountlist
            while (rs.next()){
                Task task = new Task(rs.getInt("TaskID"), rs.getString("Name"), rs.getString("Status"),rs.getInt("ProjectID"), rs.getInt("AccountID"));
                tasks.add(task);
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
            
        // clear the panel
        yourTasksPanel.removeAll();
        System.out.println(tasks.size() + " tasks found");
        
        // if there are 0 tasks
        if (tasks.size() == 0){
            // Display 0 tasks to the user
            JLabel notice = new JLabel("You currently have 0 tasks");
            yourTasksPanel.add(notice);
        } else {
            // Loop through all tasks
            for(Task task : tasks){
                // create a new row
                JPanel row = new JPanel(new GridLayout(1,2));
                row.setMaximumSize(new Dimension(500,30));              


                // name label to hold the accounts name
                JLabel name = new JLabel(task.getName(), SwingConstants.LEFT);
                name.setSize(200, 20);

                // Button to select the account
                JButton view = new JButton("View");
                view.setActionCommand("-"+task.getId());
                view.addActionListener(this);

                // Add elements to the row
                row.add(name);
                row.add(view);
                yourTasksPanel.add(row);
            }
        }
        // Refresh the panel holding the tasks
        yourTasksPanel.validate();
        yourTasksPanel.repaint();
        yourTasksPanel.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
            String action = ae.getActionCommand();
            System.out.println("Button pressed");
            
            int val = Integer.parseInt(action);
            System.out.println(val);
            
            if (val > 0){
                selectedProject = val;

                // if there is already a selected button
                if (selectedProjectButton != null){
                    // allow the user to select this button again
                    selectedProjectButton.setText("Select");
                    selectedProjectButton.setEnabled(true);
                }

                // prevent the user from selecting this button again
                selectedProjectButton = (JButton) ae.getSource();
                selectedProjectButton.setText("Selected");
                selectedProjectButton.setEnabled(false);
            } else {
                int taskId = val*-1;
                
                ViewTask vt = new ViewTask(loggedIn, taskId);
                this.dispose();
            }
            
    }

    private void loadQuote() {
        String resourceName = "quotes.json";
        InputStream is = Dashboard.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        
        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        
        Random rand = new Random();
        JSONArray quotes = object.getJSONArray("quotes");
        
        int quoteNum = rand.nextInt(quotes.length());        
        JSONObject j = (JSONObject) quotes.get(quoteNum);
        
        quoteLabel.setText("Quote of the Day: \""+j.getString("quote")+'"');
       
    }
}
