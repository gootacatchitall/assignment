/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package not.git;

import java.awt.Button;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static not.git.NotGit.fileName;
import static not.git.addfile.printtrack;

/**
 *
 * @author Administrator
 */
public class menu extends javax.swing.JFrame {

    private Button add;
    private JButton status;
    private JButton revert;
    static JTextArea window;
    private JScrollPane jScrollPane1;
    private JButton commit;
    private JButton log;
    addfile open;
    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        open = new addfile();
        window.setText("Welcome to not-git\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add = new java.awt.Button();
        status = new javax.swing.JButton();
        revert = new javax.swing.JButton();
        log = new javax.swing.JButton();
        commit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        window = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        add.setLabel("add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        status.setText("status");

        revert.setText("revert");

        log.setText("log");

        commit.setText("commit");
        commit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitActionPerformed(evt);
            }
        });

        window.setColumns(20);
        window.setRows(5);
        jScrollPane1.setViewportView(window);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(revert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(commit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(commit)
                        .addGap(36, 36, 36)
                        .addComponent(status)
                        .addGap(44, 44, 44)
                        .addComponent(revert)
                        .addGap(47, 47, 47)
                        .addComponent(log)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       // printtrack=0;
        
         
        open.setVisible(true);
        
      /* File ng = new File("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\not-git\\console.dat");
        ng.delete();
        open.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if(open.printtrack==1){
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("console.dat"));
                    while (true) {                     
                        window.append((String) ois.readObject() + " is being tracked\n");
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        });   */

    }//GEN-LAST:event_addActionPerformed

    private void commitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitActionPerformed
      checkexist();
        
    }//GEN-LAST:event_commitActionPerformed

    public boolean checkexist(){
        String paths="C:\\Users\\Administrator\\Documents\\Not-git\\";
        String source="C:\\Users\\Administrator\\Documents\\Not-git\\";
        
        try {
            ObjectInputStream obs=new ObjectInputStream(new FileInputStream("console.dat"));
            try{
            while(true){
                source="C:\\Users\\Administrator\\Documents\\";
                paths="C:\\Users\\Administrator\\Documents\\Not-git\\";
               Scanner s=new Scanner(obs.readUTF());
               String check=s.next();
               for(int i=0;i<check.length();i++){
               if(check.charAt(i)=='.')
                   break;
               source+=check.charAt(i);
               paths+=check.charAt(i);
               }
               source+=".txt";
               Path path=Paths.get(paths);
               File file=new File(paths);
               if(!file.exists()){
                   Path sourcepath=Paths.get(source);
                Files.createDirectory(path);
                Files.copy(path,sourcepath,StandardCopyOption.COPY_ATTRIBUTES);
                
               }
               else{
                   
               }
            }
                }
            catch(EOFException e){}
            obs.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(addfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 
    }
    //</editor-fold>

    /* Create and display the form */
    /**
     * @param args the command line arguments
     *

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button add;
    private javax.swing.JButton commit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton log;
    private javax.swing.JButton revert;
    private javax.swing.JButton status;
    protected javax.swing.JTextArea window;
    // End of variables declaration//GEN-END:variables

*/
}
