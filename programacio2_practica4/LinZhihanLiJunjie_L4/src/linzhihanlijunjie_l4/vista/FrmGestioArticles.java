/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linzhihanlijunjie_l4.vista;

import java.lang.String;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import linzhihanlijunjie_l4.controlador.Controlador;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public class FrmGestioArticles extends javax.swing.JFrame {

    /**
     * Creates new form FrmGestioArticles
     */
    private Controlador controlador;
    public FrmGestioArticles(Controlador controlador) {
        initComponents();
        ImageIcon icon =new ImageIcon("images\\Icono.png");
        this.setIconImage(icon.getImage());
        this.controlador = controlador;
        omplirLlistaArticles();
        this.setDefaultCloseOperation(0);
        setLocationRelativeTo(null);
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
        list_VisualitzarArticles = new javax.swing.JList<>();
        label_gestióArticles = new javax.swing.JLabel();
        btnAfegirArticle = new javax.swing.JButton();
        btnSortir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 540));

        jScrollPane1.setViewportView(list_VisualitzarArticles);

        label_gestióArticles.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        label_gestióArticles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_gestióArticles.setText("Gestió Articles");
        label_gestióArticles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnAfegirArticle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAfegirArticle.setText("Afegir Article");
        btnAfegirArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirArticleActionPerformed(evt);
            }
        });

        btnSortir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSortir.setText("Salir");
        btnSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnAfegirArticle, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(160, 160, 160)
                .addComponent(btnSortir, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(label_gestióArticles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label_gestióArticles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAfegirArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * mètode que surt del finestra quan cliquem el butó cancel·lar
 * @param evt ActionEvent
 */
    private void btnSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSortirActionPerformed

    /**
     * mètode que s'obre un JDialog per afegir un article quan pulsem el butó
     * @param evt ActionEvent
     */
    private void btnAfegirArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirArticleActionPerformed
       try {
            FrmAfegirArticle frmAfegirArticle = new FrmAfegirArticle(this, true, controlador);
            frmAfegirArticle.setTitle("Dades Article");
            frmAfegirArticle.pack();
            frmAfegirArticle.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_btnAfegirArticleActionPerformed

/**
 * Mètode de suport que actualitza la llista dels articles
 */     
    void omplirLlistaArticles() {
        DefaultListModel model = new DefaultListModel();
        for(String s :controlador.recuperaArticles()){
            model.addElement(s);
        }
        this.list_VisualitzarArticles.setModel(model);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfegirArticle;
    private javax.swing.JButton btnSortir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_gestióArticles;
    private javax.swing.JList<String> list_VisualitzarArticles;
    // End of variables declaration//GEN-END:variables
}
