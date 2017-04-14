package application_trafic;

import GestionSocket.GestionSocket;
import JFC.Histogramme;
import JFC.Lineaire;
import JFC.NuagePoint;
import JFC.PieChart;
import JavaLibrary.Crypto.Chiffrement;
import JavaLibrary.Crypto.Cle;
import JavaLibrary.Crypto.CleImpl.CleDES;
import JavaLibrary.Crypto.CryptoManager;
import JavaLibrary.Crypto.DiffieHellman.DiffieHellman;
import JavaLibrary.Crypto.SecurePassword.SecurePasswordSha256;
import JavaLibrary.Network.CipherGestionSocket;
import JavaLibrary.Network.NetworkPacket;
import RequestResponseDISMAP.IDISMAP;
import RequestResponseDISMAP.RequestDISMAP;
import RequestResponseDISMAP.ResponseDISMAP;
import Serializator.KeySerializator;
import ServeurCle.SC_CST;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import main.Exemple_ClientCle;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Bob
 */
public class ClientGUI extends javax.swing.JFrame implements IDISMAP 
{
    public static String HOST="localhost";
    public static int PORT=6001;
    public static String KEY_TYPE="DES";
    public static String USERNAME="julien";
    public static String PWD="test";
    public static String SAVING_DIR=System.getProperty("user.home")+
            System.getProperty("file.separator")+"client_cle"+
            System.getProperty("file.separator")+"exemple_cle.key";
    private boolean connect = false;
    private GestionSocket GSocket = null;
    //DefaultCategoryDataset ds;
    ChartPanel cp ;
    JFreeChart chart;
    JPanel graph_JP = new JPanel() ; 

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
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Graph_CB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        TABLES_CB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

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

        Login_Bouton.setText("Get Long Term Key from SK");
        Login_Bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_BoutonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Connexion au serveur.");

        jButton3.setText("Get Session Key from KDC_Kerberos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel16)
                        .addGap(256, 256, 256)))
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Login_Bouton)
                        .addGap(118, 118, 118))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(Login_Bouton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(37, 37, 37))
        );

        Tabs.addTab("Login", jPanel1);

        jButton2.setText("Draw");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Graphique : ");

        Graph_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HISTOGRAMME", "SECTORIEL", "LINEAIRE", "NUAGE" }));

        jLabel2.setText("Type : ");

        TABLES_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "APPAREILS", "PERSONNEL" }));

        jLabel3.setText("Echantillon : ");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(8, 1, 100, 1));
        jSpinner1.setValue(10);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Graph_CB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TABLES_CB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner1))
                .addContainerGap(692, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Graph_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TABLES_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addContainerGap(183, Short.MAX_VALUE))
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
       try {
            SecurePasswordSha256 sp=new SecurePasswordSha256(PWD);
            
            //SC doit écouter sur le port 6001
            Socket s=new Socket(HOST, PORT);
            System.out.println("[CLIENT] connected to server: sending Init ");
            DiffieHellman dh=new DiffieHellman();
            GestionSocket gsocket=new GestionSocket(s);
            
            //envoit demande de DiffieHellman avec sa partie publique
            NetworkPacket r=new NetworkPacket(SC_CST.INIT);
            r.add(SC_CST.USERNAME,USERNAME);
            r.add(SC_CST.SALT, sp.getSalt());
            r.add(SC_CST.PWD, sp.getHashedPassword());
            gsocket.Send(r);
            
            r=(NetworkPacket) gsocket.Receive();
            if(r.getType()==SC_CST.YES) {
                System.out.printf("[CLIENT]User %s is connected\n", USERNAME);
            } else {
                System.out.printf("[CLIENT]User %s is NOT connected\n",USERNAME);
            }
            
            //envoi sa clé publique
            System.out.println("[CLIENT]Sending public key");
            r=new NetworkPacket(SC_CST.DHPK);
            r.add(SC_CST.PK, dh.getPublicKey().getEncoded());
            gsocket.Send(r);
            System.out.println("[CLIENT]Server public key received");
            
            //lit la partie publique du serveur
            r=(NetworkPacket) gsocket.Receive();
            if(r.getType()==SC_CST.YES) {
                byte[] serverPK=(byte[]) r.get(SC_CST.PK);
                dh.setPublicKey(serverPK);
            } else {
                //erreur
                System.out.printf("ERROR: received %d type!\n",r.getType());
                System.exit(-1);
            }
            
            //la DJH est fait: faut demander la clé Long Terme du serveur AS
            Chiffrement chDHKey=(Chiffrement) CryptoManager.newInstance("DES");
            chDHKey.init(new CleDES(dh.getSecretKey()));
            //grâce à CipherGestionSocket la transition entre flux chiffré ou non se fait
            //simplement via un changement de type de GestionSocket
            CipherGestionSocket ciphergs=new CipherGestionSocket(s, chDHKey);
            System.out.println("[CLIENT]Sending Get KEY ");
            r=new NetworkPacket(SC_CST.GETKEY);
            r.add(SC_CST.USERNAME, USERNAME);
            ciphergs.Send(r);
            
            //recevoir la clé
            r=(NetworkPacket) ciphergs.Receive();
            System.out.println("[CLIENT]Answer received");
            if(r.getType()==SC_CST.YES) 
            {
                System.out.println("[CLIENT]Answer is yes");
                //récupère la clé & la sauvegarde dans SAVING_DIR
                Cle cle=(Cle) r.get(SC_CST.SECRETKEY);
                KeySerializator.saveKey(SAVING_DIR, cle);
                
                //test à comparer avec le serveur_clé
                Chiffrement chLongTermKey=(Chiffrement) CryptoManager.newInstance("DES");
                chLongTermKey.init(cle);
                String ciphertext=chLongTermKey.crypte("Test nananan");
                System.out.printf("texte chiffré: %s\n", Arrays.toString(ciphertext.getBytes()));
                String plainText=chLongTermKey.decrypte(ciphertext);
                System.out.printf("text déchiffré: %s\n", Arrays.toString(plainText.getBytes()));
                System.out.printf("text déchiffré: %s\n", plainText);
            } else {
                System.out.println("[CLIENT]Answer is no");
                System.out.printf("ERROR: received %d type!\n",r.getType());
            }
        } catch (IOException | InvalidParameterSpecException | NoSuchAlgorithmException | 
                InvalidAlgorithmParameterException | NoSuchProviderException | 
                InvalidKeySpecException | InvalidKeyException ex) {
            Logger.getLogger(Exemple_ClientCle.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e) {
            System.out.printf("[CLIENT]EXCEPTION: %s: %s\n",e.getClass(), e.getMessage());
            Logger.getLogger(Exemple_ClientCle.class.getName()).log(Level.SEVERE, null, e);
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
        List<Double> donnees = new ArrayList<>();
        List<String> listCategorie = new ArrayList<>();
        List<String> listSerie = new ArrayList<>();
        // Ajout du type des données (typeappareil, appareil,...)
        VList.add(TABLES_CB.getSelectedItem()); // la table sur laquelle faire des stats
        VList.add(Graph_CB.getSelectedItem());    // le genre de graphique à générerer
        VList.add(jSpinner1.getValue());
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

                this.jPanel5.remove(graph_JP);
                this.jPanel5.revalidate();
                this.repaint();
                System.out.println("Il y avait déjà un graphique affiché... Je supprime...");

            
            List<String> mois = new ArrayList<>(Arrays.asList("JANVIER", "FEVRIER", "MARS","AVRIL","MAI","JUIN","JUILLET","AOUT","SEPTEMBRE","OCTOBRE","NOVEMBRE","DECEMBRE"));
                                    
            switch (Graph_CB.getSelectedItem().toString())
            {
                case "HISTOGRAMME": // Histogramme
 
                                    if(TABLES_CB.getSelectedItem() == "APPAREILS")
                                    {
                                       
                                        Vector data = (Vector) rep.getChargeUtile();
                                        listSerie.add("0"); // il n'y a qu'une série par catégorie
                                        
                                        
                                        //Construire les listes suivant la réponse du serveur. Les listes servant à la classe Histogramme.
                                        for(int i=0;i<data.size();i++)
                                        {
                                            //création de la liste des catégories
                                            listCategorie.add(mois.get(Integer.valueOf(data.get(i).toString())-1));
                                            System.out.println("MOIS = " + mois.get(Integer.valueOf(data.get(i).toString())));
                                            //creation des données
                                            donnees.add(Double.valueOf(data.get(i+1).toString()));
                                            i++;
                                        }

                                        Histogramme g = new Histogramme("Bar char", "Mois", "Chiffre d'affaire (en euros)", donnees, Color.white, listSerie, listCategorie, true);
                                        graph_JP = g;
                                        this.jPanel5.add(graph_JP,BorderLayout.EAST);
                                      
                                    }
                                    else if (TABLES_CB.getSelectedItem() == "PERSONNEL")
                                    {
                                        //10-20 2 
                                        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
                                        Vector data = (Vector) rep.getChargeUtile();
                                        listSerie.add("0"); // il n'y a qu'une série par catégorie
                                        for(int i=0;i<data.size();i++)
                                        {
                                            listCategorie.add(data.get(i).toString());
                                            donnees.add((double)((Integer)data.get(i+1)).intValue());
                                            //dcd.addValue((int)data.get(i+1), "AGE", data.get(i).toString());
                                            i++;
                                        }
                                      System.out.println("donnees pour HISTROGRAMME = " + data);
                                        
                                        Histogramme g = new Histogramme("Nombres de personnes par classes d'ages(echantillon="+jSpinner1.getValue(), "Classe d'âge", "Nb de ", donnees, Color.white, listSerie, listCategorie, true);
                                        graph_JP=g;
                                        this.jPanel5.add(graph_JP,BorderLayout.EAST);
                                        //chart = ChartFactory.createBarChart("Nombres de personnes par classes d'ages(echantillon="+jSpinner1.getValue(), "Classe d'âge", "Nb de ", dcd, PlotOrientation.VERTICAL, true, true, false);
                                        //this.jPanel5.setLayout(new java.awt.BorderLayout());
                                        //cp = new ChartPanel(chart);
                                        //this.getContentPane().add(cp);
                                        
                                        
                                    }
                                    break;
                case "LINEAIRE": // Linéaire
                                  
                                    if(TABLES_CB.getSelectedItem() == "APPAREILS")
                                    {
                                        DefaultCategoryDataset dcdl = new DefaultCategoryDataset();
                                        Vector dataL = (Vector) rep.getChargeUtile();
                                        listSerie.add("0");
                                        for(int i=0;i<dataL.size();i++)
                                        {
                                            System.out.println("MOIS = " + mois.get(Integer.valueOf(dataL.get(i).toString())));
                                            donnees.add((double)Integer.parseInt(dataL.get(i+1).toString()));
                                            listCategorie.add(mois.get(Integer.valueOf(dataL.get(i).toString())));
                                            //dcdl.addValue(Integer.valueOf(dataL.get(i+1).toString()), "JOURS", mois.get(Integer.valueOf(dataL.get(i).toString())).toString());
                                            i++;
                                        }
                                        System.out.println("donnees pour HISTROGRAMME = " + dataL);
                                        Lineaire line  = new Lineaire("Graphique linéaire", "Mois", "Chiffre d'affaire (en euros)", donnees, Color.white, listSerie, listCategorie, true);
                                        graph_JP=line;
                                        this.jPanel5.add(graph_JP,BorderLayout.EAST);
//                                        chart = ChartFactory.createLineChart("Graphique linéaire", "Mois", "Chiffre d'affaire (en euros)", dcdl, PlotOrientation.VERTICAL, true, true, false);
//                                        this.jPanel5.setLayout(new java.awt.BorderLayout());
//                                        cp = new ChartPanel(chart);
//                                        //this.getContentPane().add(cp);
//                                        this.jPanel5.add(cp, BorderLayout.EAST);
                                    }
                                    break;

                case "SECTORIEL" : 
                                    if(TABLES_CB.getSelectedItem() == "APPAREILS")
                                    {
                                        // Sectoriel : repartition des types d'appareils existants en % (combien d'APE blanc par rapport à AGE noir par exemple)
                                        DefaultPieDataset ds = new DefaultPieDataset();
                                        // Récupérer les données

                                        Vector data = (Vector) rep.getChargeUtile();
                                        System.out.println("donnees pour SECTORIEL = " + data);
                                        
                                        //compter le nombre d'appareil pour l'affichage en %
                                        double nbAppareiltotal=0;
                                        for(int i=0 ; i< data.size();i++)
                                        {
                                            i++;
                                            nbAppareiltotal =nbAppareiltotal + (double)data.get(i);
                                        }
                                        System.out.println("Nb appareil vendu total : " + nbAppareiltotal);
                                        
                                        
                                        for(int i=0 ; i< data.size();i++)
                                        {
                                            //récupérer nom appareil
                                            String TypeName = data.get(i).toString();
                                            i++;
                                            
                                            double nbAppareil = (double)data.get(i);
                                            double pourCent = (nbAppareil/nbAppareiltotal)*100;
                                            listCategorie.add(TypeName);
                                            donnees.add(pourCent);
                                            //ds.setValue(TypeName, pourCent);
                                        }
                                        PieChart line  = new PieChart("Graphique linéaire", donnees, listCategorie, true);
                                        graph_JP=line;
                                        this.jPanel5.add(graph_JP,BorderLayout.EAST);    
                                        //Se fournir un JFreeChart
//                                        chart = ChartFactory.createPieChart ("Répartitions des types d'appareils", ds, true, true, true);
//                                        cp = new ChartPanel(chart);

//                                        this.jPanel5.add(cp, BorderLayout.EAST);
                                    }
                                    break;
                case "NUAGE"   :
                                    System.out.println("Graphique nuage de points...");
                                    if(TABLES_CB.getSelectedItem() == "PERSONNEL")
                                    {

                                        Vector data = (Vector) rep.getChargeUtile();
                                        System.out.println("donnees pour NUAGES = " + data);
                                        XYSeries serieObs = new XYSeries("Relation vision-dextérité");
                                        
                                        List<Double> valeurs=new ArrayList<>();
	
                                        List<Double> valeurs1=new ArrayList<>();

                                        for(int i=0 ; i< data.size();i=i+2)
                                        {
                                            valeurs.add((double)data.get(i));
                                            valeurs1.add((double)data.get(i+1));
                                            //serieObs.add((double)data.get(i),(double)data.get(i+1)); //xi,yi
                                        }
//                                        XYSeriesCollection dsxy = new XYSeriesCollection();
//                                        dsxy.addSeries(serieObs);
                                        //Se fournir un JFreeChart
//                                        chart = ChartFactory.createScatterPlot ("Perception + dextérité manuelle", "réponse à un stimulus visuel", "dextérité manuelle",dsxy,PlotOrientation.VERTICAL ,true, true,false);
//                                        cp = new ChartPanel(chart);
                                        NuagePoint line  = new NuagePoint("Graphique linéaire", valeurs, valeurs1, true);
                                        graph_JP=line;
                                        this.jPanel5.add(graph_JP,BorderLayout.EAST);    

                                        //this.jPanel5.add(cp, BorderLayout.EAST);
                                    }
                                    
                                    break;

            }
            System.out.println("JE quitte le case...");
         
        }
        else
        {
//            this.jPanel5.remove(cp);
//            this.jPanel5.revalidate();
//            this.repaint();
            JOptionPane.showMessageDialog(this, "Aucune données..., désolé... !", "Client CheckIn", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

   

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
    private javax.swing.JButton Connect_Bouton;
    private javax.swing.JButton Deconnect_Bouton;
    private javax.swing.JComboBox Graph_CB;
    private javax.swing.JLabel LB_machine;
    private javax.swing.JLabel LB_port;
    private javax.swing.JButton Login_Bouton;
    private javax.swing.JTextField Port_TextField;
    private javax.swing.JTextField Serveur_TextField;
    private javax.swing.JComboBox TABLES_CB;
    private javax.swing.JTextField TF_password;
    private javax.swing.JTextField TF_user;
    private javax.swing.JPanel TabConnexion;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
