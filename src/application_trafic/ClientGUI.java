package application_trafic;

import GestionSocket.GestionSocket;
import RequestResponseDISMAP.IDISMAP;
import RequestResponseDISMAP.RequestDISMAP;
import RequestResponseDISMAP.ResponseDISMAP;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Bob
 */
public class ClientGUI extends javax.swing.JFrame implements IDISMAP 
{

    private boolean connect = false;
    private GestionSocket GSocket = null;
    //DefaultCategoryDataset ds;
    ChartPanel cp ;
    JFreeChart chart;

    /**
     * Creates new form ClientGUI
     */
    public ClientGUI() {
        initComponents();
        this.jPanel5.setLayout(new BorderLayout());
        init();
        //showHistogram();
        this.GSocket = new GestionSocket();
    }
    public void init()
    {
        this.jPanel5.setLayout(new BorderLayout());
        cp =  new ChartPanel(chart);
    }
    public GestionSocket getGSocket() {
        return GSocket;
    }

    public void setGSocket(GestionSocket GSocket) {
        this.GSocket = GSocket;
    }

    public JButton getConnect_Bouton() {
        return Connect_Bouton;
    }

    public void setConnect_Bouton(JButton Connect_Bouton) {
        this.Connect_Bouton = Connect_Bouton;
    }

    public JButton getDeconnect_Bouton() 
    {
        return Deconnect_Bouton;
    }

    public void setDeconnect_Bouton(JButton Deconnect_Bouton) {
        this.Deconnect_Bouton = Deconnect_Bouton;
    }

    public JLabel getLB_machine() {
        return LB_machine;
    }

    public void setLB_machine(JLabel LB_machine) {
        this.LB_machine = LB_machine;
    }

    public JLabel getLB_port() {
        return LB_port;
    }

    public void setLB_port(JLabel LB_port) {
        this.LB_port = LB_port;
    }

    public JButton getLogin_Bouton() {
        return Login_Bouton;
    }

    public void setLogin_Bouton(JButton Login_Bouton) {
        this.Login_Bouton = Login_Bouton;
    }

    public JTextField getPort_TextField() {
        return Port_TextField;
    }

    public void setPort_TextField(JTextField Port_TextField) {
        this.Port_TextField = Port_TextField;
    }

    public JTextField getServeur_TextField() {
        return Serveur_TextField;
    }

    public void setServeur_TextField(JTextField Serveur_TextField) {
        this.Serveur_TextField = Serveur_TextField;
    }

    public JTextField getTF_user() {
        return TF_user;
    }

    public void setTF_user(JTextField TF_user) {
        this.TF_user = TF_user;
    }

    public JPanel getTabConnexion() {
        return TabConnexion;
    }

    public void setTabConnexion(JPanel TabConnexion) {
        this.TabConnexion = TabConnexion;
    }

    public JTabbedPane getTabs() {
        return Tabs;
    }

    public void setTabs(JTabbedPane Tabs) {
        this.Tabs = Tabs;
    }


    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Tabs = new javax.swing.JTabbedPane();
        TabConnexion = new javax.swing.JPanel();
        LB_machine = new javax.swing.JLabel();
        Serveur_TextField = new javax.swing.JTextField();
        LB_port = new javax.swing.JLabel();
        Port_TextField = new javax.swing.JTextField();
        Connect_Bouton = new javax.swing.JButton();
        Deconnect_Bouton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TF_user = new javax.swing.JTextField();
        TF_password = new javax.swing.JTextField();
        Login_Bouton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Graph_CB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Appareil_CB = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client CheckIn");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Tabs.setToolTipText("");

        LB_machine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LB_machine.setText("Serveur : ");

        Serveur_TextField.setText("127.0.0.1");

        LB_port.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LB_port.setText("Port : ");

        Port_TextField.setText("2000");

        Connect_Bouton.setText("Connect");
        Connect_Bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Connect_BoutonActionPerformed(evt);
            }
        });

        Deconnect_Bouton.setText("Disconnect");
        Deconnect_Bouton.setEnabled(false);
        Deconnect_Bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Deconnect_BoutonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Connexion au serveur.");

        javax.swing.GroupLayout TabConnexionLayout = new javax.swing.GroupLayout(TabConnexion);
        TabConnexion.setLayout(TabConnexionLayout);
        TabConnexionLayout.setHorizontalGroup(
            TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabConnexionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(TabConnexionLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel15)
                        .addGap(0, 665, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabConnexionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Connect_Bouton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Deconnect_Bouton)))
                .addContainerGap())
            .addGroup(TabConnexionLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LB_machine)
                    .addComponent(LB_port))
                .addGap(18, 18, 18)
                .addGroup(TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Port_TextField)
                    .addComponent(Serveur_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabConnexionLayout.setVerticalGroup(
            TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabConnexionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_machine)
                    .addComponent(Serveur_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Port_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_port))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addGroup(TabConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Deconnect_Bouton)
                    .addComponent(Connect_Bouton))
                .addContainerGap())
        );

        Tabs.addTab("Connexion", TabConnexion);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nom");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mot de passe");

        TF_user.setText("mastrobo");

        TF_password.setText("456789");
        TF_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_passwordActionPerformed(evt);
            }
        });

        Login_Bouton.setText("get long term key");
        Login_Bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_BoutonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Connexion au serveur.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel16)
                        .addGap(256, 256, 256)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Login_Bouton)
                .addGap(93, 93, 93))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF_password)
                    .addComponent(TF_user, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TF_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(TF_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(Login_Bouton)
                .addGap(19, 19, 19))
        );

        Tabs.addTab("Login", jPanel1);

        jButton2.setText("Draw");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Graphique : ");

        Graph_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HISTOGRAMME", "SECTORIEL", "LINEAIRE" }));

        jLabel2.setText("Type : ");

        Appareil_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "APPAREILS" }));

        jButton1.setText("Remove graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Appareil_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Graph_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(702, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Graph_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Appareil_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        Tabs.addTab("Graph", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabs))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if (isConnect()) {
        closeConnection();
    }
}//GEN-LAST:event_formWindowClosing

    private void BT_verifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_verifierActionPerformed

    }//GEN-LAST:event_BT_verifierActionPerformed

    private void Login_BoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_BoutonActionPerformed
        //Récupération des informations

        Vector vLogin = new Vector();
        vLogin.add(TF_user.getText());
        vLogin.add(TF_password.getText());

        RequestDISMAP req = new RequestDISMAP(LOGIN_REQUEST, vLogin);
        GSocket.Send(req);
        System.out.println("Apres la requete");
        //Attente de reponse du serveur
        RequestDISMAP rep = (RequestDISMAP) GSocket.Receive();
        System.out.println("Apres la réponse du serveur");

        if (rep.getCodeRetour() == YES) {
            JOptionPane.showMessageDialog(this, "Login réalisée avec succès !", "Client CheckIn", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, "Login échouée !", "Client CheckIn", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_Login_BoutonActionPerformed

    private void TF_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_passwordActionPerformed

    private void Deconnect_BoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Deconnect_BoutonActionPerformed

        closeConnection();
        Connect_Bouton.setEnabled(true);
        Deconnect_Bouton.setEnabled(false);
    }//GEN-LAST:event_Deconnect_BoutonActionPerformed

    private void Connect_BoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Connect_BoutonActionPerformed

        System.out.println("Tentative de connexion au serveur Reservation ...");
        GSocket.ConnectServeur(Serveur_TextField.getText(), Integer.parseInt(Port_TextField.getText()));
        System.out.println("Connexion au serveur Reservation réalisé !");

        JOptionPane.showMessageDialog(this, "Connexion réalisée avec succès !", "Client Login", JOptionPane.INFORMATION_MESSAGE, null);

        Connect_Bouton.setEnabled(false);
        Deconnect_Bouton.setEnabled(true);
        Login_Bouton.setEnabled(true);
        connect = true;
    }//GEN-LAST:event_Connect_BoutonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Vector VList = new Vector();

        // Ajout du type des données (typeappareil, appareil,...)
        VList.add(Appareil_CB.getSelectedItem()); // la table sur laquelle faire des stats
        VList.add(Graph_CB.getSelectedItem());    // le genre de graphique à générerer
        System.out.println("VLIST = " + VList);
        // Créer la requête
        RequestDISMAP req = new RequestDISMAP(GRAPH_OPERATION, VList);
        System.out.println(" j'ai envoyé la requete GRAPH");
        GSocket.Send(req);
        System.out.println(" j'ai envoyé la requete GRAPH-----aprés le send");
        //Attente de reponse du serveur
        ResponseDISMAP rep = (ResponseDISMAP) GSocket.Receive();

        if (rep.getCodeRetour() == YES)
        {
            System.out.println("yesss");

            //supprimer le graphique si déjà présent

                this.jPanel5.remove(cp);
                this.jPanel5.revalidate();
                this.repaint();
                System.out.println("Il y avait déjà un graphique affiché... Je supprime...");

            
            Vector mois = new Vector<String>(Arrays.asList("JANVIER", "FEVRIER", "MARS","AVRIL","MAI","JUIN","JUILLET","AOUT","SEPTEMBRE","OCTOBRE","NOVEMBRE","DECEMBRE"));
                                    
            switch (Graph_CB.getSelectedItem().toString())
            {
                case "HISTOGRAMME": // Histogramme

                                    DefaultCategoryDataset dcd = new DefaultCategoryDataset();
                                    Vector data = (Vector) rep.getChargeUtile();
                                    int indice = 0;
                                    for(int i=0;i<data.size();i++)
                                    {
                                        System.out.println("MOIS = " + mois.get(Integer.valueOf(data.get(i).toString())).toString());
                                        dcd.addValue(Integer.valueOf(data.get(i+1).toString()), "JOURS", mois.get(Integer.valueOf(data.get(i).toString())).toString());
                                        i++;
                                    }
                                    System.out.println("donnees pour HISTROGRAMME = " + data);

                                    chart = ChartFactory.createBarChart("Bar char", "Mois", "Chiffre d'affaire (en euros)", dcd, PlotOrientation.VERTICAL, true, true, false);
                                    //this.jPanel5.setLayout(new java.awt.BorderLayout());
                                    cp = new ChartPanel(chart);
                                    this.getContentPane().add(cp);
                                    this.jPanel5.add(cp, BorderLayout.EAST);
                                    break;
                case "LINEAIRE": // Linéaire

                                    DefaultCategoryDataset dcdl = new DefaultCategoryDataset();
                                    Vector dataL = (Vector) rep.getChargeUtile();
                                    for(int i=0;i<dataL.size();i++)
                                    {
                                        System.out.println("MOIS = " + mois.get(Integer.valueOf(dataL.get(i).toString())).toString());
                                        dcdl.addValue(Integer.valueOf(dataL.get(i+1).toString()), "JOURS", mois.get(Integer.valueOf(dataL.get(i).toString())).toString());
                                        i++;
                                    }
                                    System.out.println("donnees pour HISTROGRAMME = " + dataL);

                                    chart = ChartFactory.createLineChart("Graphique linéaire", "Mois", "Chiffre d'affaire (en euros)", dcdl, PlotOrientation.VERTICAL, true, true, false);
                                    //this.jPanel5.setLayout(new java.awt.BorderLayout());
                                    cp = new ChartPanel(chart);
                                    this.getContentPane().add(cp);
                                    this.jPanel5.add(cp, BorderLayout.EAST);
                                    break;

                case "SECTORIEL" : // Sectoriel : repartition des types d'appareils existants en % (combien d'APE blanc par rapport à AGE noir par exemple)
                                    DefaultPieDataset ds = new DefaultPieDataset();
                                    // Récupérer les données

                                    Vector donnees = (Vector) rep.getChargeUtile();
                                    System.out.println("donnees pour SECTORIEL = " + donnees);
                                    for(int i=0 ; i< donnees.size();i++)
                                    {
                                        //récupérer nom appareil
                                        String TypeName = donnees.get(i).toString();
                                        i++;
                                        double nbAppareil = (double)donnees.get(i);
                                        ds.setValue(TypeName, nbAppareil);
                                    }

                                    //Se fournir un JFreeChart
                                    chart = ChartFactory.createPieChart ("Répartitions des types d'appareils", ds, true, true, true);
                                    cp = new ChartPanel(chart);

                                    this.jPanel5.add(cp, BorderLayout.EAST);
                                    break;

            }
         
        }
        else
        {
//            this.jPanel5.remove(cp);
//            this.jPanel5.revalidate();
//            this.repaint();
            JOptionPane.showMessageDialog(this, "Aucune données..., désolé... !", "Client CheckIn", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jPanel5.remove(cp);
            this.jPanel5.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

   

    public JTextField getTF_password() {
        return TF_password;
    }

    public void setTF_password(JTextField TF_password) {
        this.TF_password = TF_password;
    }

 

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

  

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }



    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public void setjSeparator3(JSeparator jSeparator3) {
        this.jSeparator3 = jSeparator3;
    }

    public JSeparator getjSeparator4() {
        return jSeparator4;
    }

    public void setjSeparator4(JSeparator jSeparator4) {
        this.jSeparator4 = jSeparator4;
    }

 

    public void closeConnection() {
        RequestDISMAP req = new RequestDISMAP(LOGOUT, null);
        GSocket.Send(req);
        GSocket.Close();

        Connect_Bouton.setEnabled(true);
        Deconnect_Bouton.setEnabled(false);
        connect = false;
    }

    public void sendPortTimeOut(Object obj) {
        GSocket.Send(obj);
    }

    private boolean isConnect() {
        return connect;
    }

    private void showHistogram() 
    {
        String mois = "Janvier";
        String nomSociete;
        String destination;

        double mouvements = 10;
        DefaultPieDataset ds = new DefaultPieDataset();
        //ds.addValue(mouvements, "Mois", mois);

        //JFreeChart jfc = ChartFactory.createBarChart("Attends critères...", "...", "...", ds, PlotOrientation.VERTICAL, true, true, false);

       // cp = new ChartPanel(jfc);
        //this.jPanel5.add(cp, BorderLayout.EAST);
        //
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Appareil_CB;
    private javax.swing.JButton Connect_Bouton;
    private javax.swing.JButton Deconnect_Bouton;
    private javax.swing.JComboBox Graph_CB;
    private javax.swing.JLabel LB_machine;
    private javax.swing.JLabel LB_port;
    private javax.swing.JButton Login_Bouton;
    private javax.swing.JTextField Port_TextField;
    private javax.swing.JTextField Serveur_TextField;
    private javax.swing.JTextField TF_password;
    private javax.swing.JTextField TF_user;
    private javax.swing.JPanel TabConnexion;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}