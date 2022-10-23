


// Només un MAIN

// JFrame FrmPrincipal
public class FrmPrincipal extends javax.swing.JFrame {
    
    private Controlador control;

    public FrmPrincipal() {
        initComponents();
        control = new Controlador();
    }

 // Com cridar un JFrame des d'un JFrame
     private void btnFrame1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        FrmFrame1 formFrame1 = new FrmFrame1(control);
        formFrame1.pack();
        formFrame1.setVisible(true);
    } 
	
// JFrame FrmFrame1
public class FrmFrame1 extends javax.swing.JFrame {
    private Controlador control;            // Atribut del controlador
    public FrmFrame1(Controlador control) {
        initComponents();
        this.control = control;
        omplirLlistaClients();              // Mètode per a omplir la llista
        this.setDefaultCloseOperation(0);   // Desactiva la X de tancar finestra
    }
	
// Com cridar a un JDialog des d'un JFrame
 private void btnAfegirClientActionPerformed(java.awt.event.ActionEvent evt) {                                                
        try {
            FrmDialog1 formDialog1 = new FrmDialog1(this, true, control);
            formDialog1.pack();
            formDialog1.setVisible(true);

        } catch (Exception ex) {
			// Crida a un JDialog des d'un altre JDialog
            FrmException formExceptio = new FrmException(new javax.swing.JDialog(), true, ex.getMessage());
            formExceptio.pack();
            formExceptio.setVisible(true);
        }   
    }   
	
// JDialog FrmDialog1
public class FrmDialog1 extends javax.swing.JDialog {
    private Controlador control;
    private java.awt.Frame parent;
    public FrmDialog1(java.awt.Frame parent, boolean modal, Controlador control) {
        super(parent, modal);
        this.control = control;
        this.parent = parent;
        initComponents();
    }

// Com actualitzar des d'un JDialog al un JList del JFrame pare
private void btnAcceptarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            // Cridar al mètode afegir client del controlador
            FrmFrame1 formFrame1 = (FrmFrame1) parent;
            formFrame1.omplirLlistaClients();
        } catch (Exception ex) {

// Com fer el constructor dun JDialog que és cridat des d'un JDialog
public class FrmException extends javax.swing.JDialog {
public FrmException(javax.swing.JDialog parent, boolean modal, String missatge) {
        super(parent, modal);
        initComponents();
        this.etMiissatge.setText(missatge);
    }	
	
// Com tancar un JFrame o un JDialog
private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.dispose();
    } 	
	
// Com omplir un JList
void omplirLlistaClients() {
        DefaultListModel model = new DefaultListModel();
        for (String item : control.recuperaClients()) {
            model.addElement(item);
        }
        this.liLlistaClients.setModel(model);

    }