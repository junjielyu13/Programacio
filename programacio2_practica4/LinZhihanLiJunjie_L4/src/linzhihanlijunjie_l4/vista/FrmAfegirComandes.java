/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linzhihanlijunjie_l4.vista;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import linzhihanlijunjie_l4.controlador.Controlador;
/**
 *
 * @author zhihan Lin i Junjie Li
 */
public class FrmAfegirComandes extends javax.swing.JDialog {

    /**
     * Creates new form FrmAfegirComandes
     */
    private Controlador controlador;
    private java.awt.Frame parent;
    public FrmAfegirComandes(java.awt.Frame parent, boolean modal,Controlador controlador) {
        super(parent, modal);
        ImageIcon icon =new ImageIcon("images\\Icono.png");
        this.setIconImage(icon.getImage());
        this.controlador = controlador;
        this.parent = parent;
        initComponents();
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

        jLabel2 = new javax.swing.JLabel();
        label_QuantitatArticle = new javax.swing.JLabel();
        jCheckBox_ComandaUrgent = new javax.swing.JCheckBox();
        label_títolAfegirComandes = new javax.swing.JLabel();
        jButton_Acceptar = new javax.swing.JButton();
        btnCancelarOfPanel = new javax.swing.JButton();
        jComboBoxLlistaClient = new javax.swing.JComboBox<>();
        jComboBox_LlistaArticle = new javax.swing.JComboBox<>();
        jSpinner_QuantitatArticle = new javax.swing.JSpinner();
        label_LlistaClient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 540));
        setSize(new java.awt.Dimension(700, 540));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Llista Article:");

        label_QuantitatArticle.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label_QuantitatArticle.setText("Quantitat d'article: ");

        jCheckBox_ComandaUrgent.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jCheckBox_ComandaUrgent.setText("Comanda Urgent");
        jCheckBox_ComandaUrgent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBox_ComandaUrgentKeyPressed(evt);
            }
        });

        label_títolAfegirComandes.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        label_títolAfegirComandes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_títolAfegirComandes.setText("Afegir Comandes");
        label_títolAfegirComandes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton_Acceptar.setText("Acceptar");
        jButton_Acceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AcceptarActionPerformed(evt);
            }
        });

        btnCancelarOfPanel.setText("Cancel·lar");
        btnCancelarOfPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOfPanelActionPerformed(evt);
            }
        });

        jComboBoxLlistaClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxLlistaClientKeyPressed(evt);
            }
        });

        jComboBox_LlistaArticle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox_LlistaArticleKeyPressed(evt);
            }
        });

        jSpinner_QuantitatArticle.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinner_QuantitatArticle.setToolTipText("");
        jSpinner_QuantitatArticle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        label_LlistaClient.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label_LlistaClient.setText("Llista Clients: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(label_títolAfegirComandes, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jButton_Acceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(83, 83, 83)
                                    .addComponent(jCheckBox_ComandaUrgent, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_QuantitatArticle)
                                    .addGap(18, 18, 18)
                                    .addComponent(jSpinner_QuantitatArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnCancelarOfPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxLlistaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_LlistaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox_LlistaArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(label_títolAfegirComandes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(label_LlistaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxLlistaClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_LlistaArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_QuantitatArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_QuantitatArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_ComandaUrgent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Acceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarOfPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Mètode que accepta de afegir una comanda quan pulsem el butó acceptar
     * @param evt ActionEvent
     */
    private void jButton_AcceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AcceptarActionPerformed
        int PosArticle = jComboBox_LlistaArticle.getSelectedIndex();
        int PosClient =  jComboBoxLlistaClient.getSelectedIndex();
        int quantitatArticle = (int)jSpinner_QuantitatArticle.getValue();
        boolean ComandaUrgent = jCheckBox_ComandaUrgent.isSelected();
        try{
            controlador.AfegirComanda(PosArticle,PosClient,quantitatArticle,ComandaUrgent);
            FrmGestioComandes frmGestioComandes = (FrmGestioComandes)parent;
            
            if(frmGestioComandes.LlistaComandesUrgentsisSelected()){
                frmGestioComandes.omplirLlistaComandesUrgents();
            }else{
                frmGestioComandes.omplirLlistaComandes();
            }
            
            this.dispose();
        }catch(MercatException ex){
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_AcceptarActionPerformed
    /**
     * mètode que sortir de la finestra quan pulsem el butó cancel·lar
     * @param evt 
     */
    private void btnCancelarOfPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOfPanelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarOfPanelActionPerformed
/**
 * Mètode que quan pulsem el teclat es clicarà automàticament el butó
 * @param evt el teclat que pulsem
 */
    private void jComboBoxLlistaClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxLlistaClientKeyPressed
        PressKeyToClickButton(evt);
    }//GEN-LAST:event_jComboBoxLlistaClientKeyPressed
/**
 * Mètode que quan pulsem el teclat es clicarà automàticament el butó
 * @param evt el teclat que pulsem
 */
    private void jComboBox_LlistaArticleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_LlistaArticleKeyPressed
        PressKeyToClickButton(evt);
    }//GEN-LAST:event_jComboBox_LlistaArticleKeyPressed
/**
 * Mètode que quan pulsem el teclat es clicarà automàticament el butó
 * @param evt el teclat que pulsem
 */
    private void jCheckBox_ComandaUrgentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox_ComandaUrgentKeyPressed
        PressKeyToClickButton(evt);
    }//GEN-LAST:event_jCheckBox_ComandaUrgentKeyPressed
/**
 * Mètode de suport que actualitza la llista dels clients i omplir en el comboBox
 */    
    void omplirComboBoxClients() {
        for(String s :controlador.recuperaClients()){
            jComboBoxLlistaClient.addItem(s);
        }
    }
    
/**
 * Mètode de suport que actualitza la llista dels articles i omplir en el comboBox
 */  
    void omplirComboBoxArticles() {
        for(String s :controlador.recuperaArticles()){
           this.jComboBox_LlistaArticle.addItem(s);   
        }
    } 

/**
 * Mètode de suport que quan pulsem el teclat es clicarà automàticament el butó
 * @param evt el teclat que pulsem
 */
    private void PressKeyToClickButton(java.awt.event.KeyEvent evt){
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            jButton_Acceptar.doClick();
        }else if(evt.getKeyChar() == KeyEvent.VK_ESCAPE){
            btnCancelarOfPanel.doClick();
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarOfPanel;
    private javax.swing.JButton jButton_Acceptar;
    private javax.swing.JCheckBox jCheckBox_ComandaUrgent;
    private javax.swing.JComboBox<String> jComboBoxLlistaClient;
    private javax.swing.JComboBox<String> jComboBox_LlistaArticle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner jSpinner_QuantitatArticle;
    private javax.swing.JLabel label_LlistaClient;
    private javax.swing.JLabel label_QuantitatArticle;
    private javax.swing.JLabel label_títolAfegirComandes;
    // End of variables declaration//GEN-END:variables
}