package GUI;

import GestionSocket.GestionSocket;
import JFC.Histogramme;
import JFC.Lineaire;
import JFC.NuagePoint;
import JFC.PieChart;
import JavaLibrary.Crypto.ChiffreImpl.ChiffreDES;
import JavaLibrary.Crypto.Chiffrement;
import JavaLibrary.Crypto.Cle;
import JavaLibrary.Crypto.CleImpl.CleDES;
import JavaLibrary.Crypto.CryptoManager;
import JavaLibrary.Crypto.DiffieHellman.DiffieHellman;
import JavaLibrary.Crypto.HMAC.HMAC;
import JavaLibrary.Crypto.NoSuchChiffrementException;
import JavaLibrary.Crypto.SecurePassword.SecurePasswordSha256;
import JavaLibrary.Network.CipherGestionSocket;
import JavaLibrary.Network.NetworkPacket;
import JavaLibrary.Utils.ByteUtils;
import Kerberos.AuthenticatorCS;
import Kerberos.KAS_CST;
import Kerberos.KS_CST;
import Kerberos.KTGS_CST;
import static RequestResponseDISMAP.IDISMAP.GRAPH_OPERATION;
import RequestResponseKERBEROS.IKERBEROS;
import RequestResponseDISMAP.RequestDISMAP;
import RequestResponseDISMAP.ResponseDISMAP;
import RequestResponseKERBEROS.RequestKERBEROS;
import RequestResponseKERBEROS.ResponseKERBEROS;
import Serializator.KeySerializator;
import ServeurCle.SC_CST;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Bob
 */
public final class ClientGUI extends javax.swing.JFrame implements IKERBEROS
{

    // VARIABLE MEMBRES POUR CLI,SERVEUR_CLE
    public static String HOST = "localhost";
    public static int PORT = 6001;
    public static String KEY_TYPE = "DES";
    public static String USERNAME;
    public static String PWD;
    public static String SAVING_DIR = System.getProperty("user.home") + System.getProperty("file.separator") + "client_cle" + System.getProperty("file.separator") + "exemple_cle.key";
    private boolean connect = false;
    private GestionSocket GSocket = null;
    JPanel graph_JP = new JPanel();

    // VARIABLES MEMBRES POUR KERBEROS(KDC,TGS,CLI,SER)
    public static int PORT_AS = 6002, PORT_TGS = 6003;
    public static String //PWD="", //debug pour créer une erreur
            TGS_NAME = "default",
            SERVER = "default";
        //TGS_NAME="echec"; //debug pour créer une erreur

    //à mettre dans configuration     
    public static String ENCODING = "UTF-8",
            LDF_PATTERN = "dd/MM/yyyy HH:00",
            ALGORITHM = "DES";

    public static String KEY_DIR = System.getProperty("user.home") + System.getProperty("file.separator")
            + "client_cle" + System.getProperty("file.separator") + "exemple_cle.key";

    static Chiffrement chKc, chKctgs;
    static Cle Kc, Kctgs, Kcs;
    static JavaLibrary.Network.GestionSocket gsocket_AS, gsocket_TGS;
    static Socket s;
    static Cipher cipher;
    static NetworkPacket paramAS, paramTGS, paramServer;
    static boolean isASAuthentified=false,isTGSOK=false;
    public ClientGUI()
    {
        initComponents();

        init();
        this.GSocket = new GestionSocket();
 
    }

    public void init()
    {
        DRAW_OK.setEnabled(false);
        this.jPanel5.setLayout(new BorderLayout());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

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
        DRAW_OK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Graph_CB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        TABLES_CB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client CheckIn");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
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
        Connect_Bouton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Connect_BoutonActionPerformed(evt);
            }
        });

        Deconnect_Bouton.setText("Disconnect");
        Deconnect_Bouton.setEnabled(false);
        Deconnect_Bouton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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

        TF_user.setText("bob");

        TF_password.setText("bob");
        TF_password.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TF_passwordActionPerformed(evt);
            }
        });

        Login_Bouton.setText("Get Long Term Key from SK");
        Login_Bouton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Login_BoutonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Connexion au serveur.");

        jButton3.setText("Get Access to Serveur_Analyse");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

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
                        .addComponent(Login_Bouton)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(107, 107, 107))))
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

        DRAW_OK.setText("Draw");
        DRAW_OK.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DRAW_OKActionPerformed(evt);
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
                    .addComponent(DRAW_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(DRAW_OK)
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
    if (isConnect())
    {
        closeConnection();
    }
}//GEN-LAST:event_formWindowClosing

    private void BT_verifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_verifierActionPerformed

    }//GEN-LAST:event_BT_verifierActionPerformed

    private void Login_BoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_BoutonActionPerformed
        try
        {
            USERNAME = TF_user.getText();
            PWD = TF_password.getText();
            Security.addProvider(new BouncyCastleProvider());
            SecurePasswordSha256 sp = new SecurePasswordSha256(PWD);

            //SC doit écouter sur le port 6001
            Socket s = new Socket(HOST, PORT);
            System.out.println("[CLIENT] connected to server: sending Init ");
            DiffieHellman dh = new DiffieHellman();
            GestionSocket gsocket = new GestionSocket(s);

            //envoit demande de DiffieHellman avec sa partie publique
            NetworkPacket r = new NetworkPacket(SC_CST.INIT);
            r.add(SC_CST.USERNAME, USERNAME);
            r.add(SC_CST.SALT, sp.getSalt());
            r.add(SC_CST.PWD, sp.getHashedPassword());
            gsocket.Send(r);

            r = (NetworkPacket) gsocket.Receive();
            if (r.getType() == SC_CST.YES)
            {
                System.out.printf("[CLIENT]User %s is connected\n", USERNAME);
            }
            else
            {
                System.out.printf("[CLIENT]User %s is NOT connected\n", USERNAME);
            }

            //envoi sa clé publique
            System.out.println("[CLIENT]Sending public key");
            r = new NetworkPacket(SC_CST.DHPK);
            r.add(SC_CST.PK, dh.getPublicKey().getEncoded());
            gsocket.Send(r);
            System.out.println("[CLIENT]Server public key received");

            //lit la partie publique du serveur
            r = (NetworkPacket) gsocket.Receive();
            if (r.getType() == SC_CST.YES)
            {
                byte[] serverPK = (byte[]) r.get(SC_CST.PK);
                dh.setPublicKey(serverPK);
            }
            else
            {
                //erreur
                System.out.printf("ERROR: received %d type!\n", r.getType());
                System.exit(-1);
            }

            //la DJH est fait: faut demander la clé Long Terme du serveur AS
            Chiffrement chDHKey = (Chiffrement) CryptoManager.newInstance("DES");
            chDHKey.init(new CleDES(dh.getSecretKey()));
            //grâce à CipherGestionSocket la transition entre flux chiffré ou non se fait
            //simplement via un changement de type de GestionSocket
            CipherGestionSocket ciphergs = new CipherGestionSocket(s, chDHKey);
            System.out.println("[CLIENT]Sending Get KEY ");
            r = new NetworkPacket(SC_CST.GETKEY);
            r.add(SC_CST.USERNAME, USERNAME);
            ciphergs.Send(r);

            //recevoir la clé
            r = (NetworkPacket) ciphergs.Receive();
            System.out.println("[CLIENT]Answer received");
            if (r.getType() == SC_CST.YES)
            {

                System.out.println("[CLIENT]Answer is yes");
                //récupère la clé & la sauvegarde dans SAVING_DIR
                Cle cle = (Cle) r.get(SC_CST.SECRETKEY);
                KeySerializator.saveKey(SAVING_DIR, cle);
                JOptionPane.showMessageDialog(this, "Long-term Key received & stored ! = " + cle.ToString(), "Client Login", JOptionPane.INFORMATION_MESSAGE, null);
//                //test à comparer avec le serveur_clé
//                Chiffrement chLongTermKey = (Chiffrement) CryptoManager.newInstance("DES");
//                chLongTermKey.init(cle);
//                String ciphertext = chLongTermKey.crypte("Test nananan");
//                System.out.printf("texte chiffré: %s\n", Arrays.toString(ciphertext.getBytes()));
//                String plainText = chLongTermKey.decrypte(ciphertext);
//                System.out.printf("text déchiffré: %s\n", Arrays.toString(plainText.getBytes()));
//                System.out.printf("text déchiffré: %s\n", plainText);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Long-term key failed to receive... ", "Client Login", JOptionPane.INFORMATION_MESSAGE, null);
                System.out.println("[CLIENT]Answer is no");
                System.out.printf("ERROR: received %d type!\n", r.getType());
            }
        }
        catch (IOException | InvalidParameterSpecException | NoSuchAlgorithmException |
                InvalidAlgorithmParameterException | NoSuchProviderException |
                InvalidKeySpecException | InvalidKeyException ex)
        {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e)
        {
            System.out.printf("[CLIENT]EXCEPTION: %s: %s\n", e.getClass(), e.getMessage());
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, e);
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

    private void DRAW_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DRAW_OKActionPerformed

        /*Variable*/
        Vector VList = new Vector();
        List<Double> donnees = new ArrayList<>();
        List<String> listCategorie = new ArrayList<>();
        List<String> listSerie = new ArrayList<>();

        // Ajout du type des données (typeappareil, appareil,...)
        VList.add(TABLES_CB.getSelectedItem()); // la table sur laquelle faire des stats
        VList.add(Graph_CB.getSelectedItem());  // le genre de graphique à générerer
        VList.add(jSpinner1.getValue());        // le nb d'échantillon

        // Créer la requête
        RequestDISMAP req = new RequestDISMAP(GRAPH_OPERATION, VList);
        GSocket.Send(req);

        //Attente de reponse du serveur
        ResponseDISMAP rep = (ResponseDISMAP) GSocket.Receive();

        if (rep.getCodeRetour() == YES)
        {
            // Retirer le graphique s'il est déjà affiché
            this.jPanel5.remove(graph_JP);
            this.jPanel5.revalidate();
            this.repaint();

            List<String> mois = new ArrayList<>(Arrays.asList("JANVIER", "FEVRIER", "MARS", "AVRIL", "MAI", "JUIN", "JUILLET", "AOUT", "SEPTEMBRE", "OCTOBRE", "NOVEMBRE", "DECEMBRE"));

            //Graphique selectionné ? 
            switch (Graph_CB.getSelectedItem().toString())
            {
                case "HISTOGRAMME":

                    if (TABLES_CB.getSelectedItem() == "APPAREILS")
                    {
                        Vector data = (Vector) rep.getChargeUtile();
                        listSerie.add("0"); // il n'y a qu'une série par catégorie.

                        // Construire les listes suivant la réponse du serveur. Les listes servant à la classe Histogramme.
                        for (int i = 0; i < data.size(); i++)
                        {
                            // Création de la liste des catégories
                            listCategorie.add(mois.get(Integer.valueOf(data.get(i).toString()) - 1));
                            // Creation des données
                            donnees.add(Double.valueOf(data.get(i + 1).toString()));
                            i++;
                        }

                        //Création de l'histogramme à l'aide de la classe histogramme
                        Histogramme g = new Histogramme("Bar char", "Mois", "Chiffre d'affaire (en euros)", donnees, Color.white, listSerie, listCategorie, true);
                        graph_JP = g;  // toutes les classes du package JFC sont des JPannel. Un JPannel "graph_JP" de référence est utilisé pour garder en mémoire le Jpanel à des fins de suppression.

                        this.jPanel5.add(graph_JP, BorderLayout.EAST);

                    }
                    else if (TABLES_CB.getSelectedItem() == "PERSONNEL")
                    {
                        Vector data = (Vector) rep.getChargeUtile();
                        listSerie.add("0"); // il n'y a qu'une série par catégorie
                        for (int i = 0; i < data.size(); i++)
                        {
                            listCategorie.add(data.get(i).toString());
                            donnees.add((double) ((Integer) data.get(i + 1)).intValue()); //intValue car pas possible de caster Integer en Double.
                            i++;
                        }
                        System.out.println("donnees pour HISTROGRAMME = " + data);

                        Histogramme g = new Histogramme("Nombres de personnes par classes d'ages(echantillon=" + jSpinner1.getValue(), "Classe d'âge", "Nb de ", donnees, Color.white, listSerie, listCategorie, true);
                        graph_JP = g;
                        this.jPanel5.add(graph_JP, BorderLayout.EAST);

                    }
                    break;
                case "LINEAIRE": // Linéaire

                    if (TABLES_CB.getSelectedItem() == "APPAREILS")
                    {
                        Vector dataL = (Vector) rep.getChargeUtile();
                        listSerie.add("0");
                        for (int i = 0; i < dataL.size(); i++)
                        {
                            donnees.add((double) Integer.parseInt(dataL.get(i + 1).toString()));
                            listCategorie.add(mois.get(Integer.valueOf(dataL.get(i).toString())));
                            i++;
                        }
                        Lineaire line = new Lineaire("Graphique linéaire", "Mois", "Chiffre d'affaire (en euros)", donnees, Color.white, listSerie, listCategorie, true);
                        graph_JP = line;
                        this.jPanel5.add(graph_JP, BorderLayout.EAST);
                    }
                    break;

                case "SECTORIEL":
                    if (TABLES_CB.getSelectedItem() == "APPAREILS")
                    {
                        // Sectoriel : repartition des types d'appareils existants en % (combien d'APE blanc par rapport à AGE noir par exemple)
                        DefaultPieDataset ds = new DefaultPieDataset();

                        // Récupérer les données
                        Vector data = (Vector) rep.getChargeUtile();

                        // Compter le nombre d'appareil pour l'affichage en %
                        double nbAppareiltotal = 0;
                        for (int i = 0; i < data.size(); i++)
                        {
                            i++;
                            nbAppareiltotal = nbAppareiltotal + (double) data.get(i);
                        }

                        // Construire les deux listes pour la classe PieChart
                        for (int i = 0; i < data.size(); i++)
                        {
                            //récupérer nom appareil
                            String TypeName = data.get(i).toString();
                            i++;

                            double nbAppareil = (double) data.get(i);
                            double pourCent = (nbAppareil / nbAppareiltotal) * 100;
                            listCategorie.add(TypeName);
                            donnees.add(pourCent);
                        }
                        PieChart line = new PieChart("Graphique linéaire", donnees, listCategorie, true);
                        graph_JP = line;
                        this.jPanel5.add(graph_JP, BorderLayout.EAST);

                    }
                    break;
                case "NUAGE":
                    if (TABLES_CB.getSelectedItem() == "PERSONNEL")
                    {

                        Vector data = (Vector) rep.getChargeUtile();
                        System.out.println("donnees pour NUAGES = " + data);

                        List<Double> valeurs = new ArrayList<>();  // liste xi
                        List<Double> valeurs1 = new ArrayList<>(); // liste yi

                        // Construire les listes xi et yi pour la classe NuagePoint
                        for (int i = 0; i < data.size(); i = i + 2)
                        {
                            valeurs.add((double) data.get(i));
                            valeurs1.add((double) data.get(i + 1));
                        }

                        NuagePoint line = new NuagePoint("Graphique linéaire", valeurs, valeurs1, true);
                        graph_JP = line;
                        this.jPanel5.add(graph_JP, BorderLayout.EAST);

                    }

                    break;

            }

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Aucune données..., désolé... !", "Client CheckIn", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_DRAW_OKActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        try
        {
            Security.addProvider(new BouncyCastleProvider());
            
            USERNAME = TF_user.getText();
            PWD = TF_password.getText();
            //lire la clé utilisateur long terme, ici dans un fichier, en vrai reçue du serveur clé
            Kc = KeySerializator.loadKey(KEY_DIR, ALGORITHM);
            chKctgs = (Chiffrement) CryptoManager.newInstance(ALGORITHM);
            chKc = (Chiffrement) CryptoManager.newInstance(ALGORITHM);
            chKc.init(Kc);
            s = new Socket(HOST, PORT_AS);
            gsocket_AS = new JavaLibrary.Network.GestionSocket(s);
            System.out.printf("[CLIENT]Connected to server %s:%d\n", HOST, PORT_AS);

            //test KerberosAS
            ASAuthentication();
            gsocket_AS.Close();
            
            if(isASAuthentified)
            {
                System.out.println("[CLIENT]Attaquons le serveur KerberosTGS");
                //test KerberosTGS
                SendSecondPacket();
                accessRequestServer();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "User/password denied..., désolé... !", "Client CheckIn", JOptionPane.ERROR_MESSAGE, null);
            }
            
            


            
        }
        catch (IOException | ClassNotFoundException | NoSuchAlgorithmException |
                InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex)
        {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
 
        }
        catch (NoSuchProviderException | NoSuchChiffrementException ex)
        {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
   
    private static void ASAuthentication() throws NoSuchAlgorithmException, IOException, InvalidKeyException, IllegalBlockSizeException, ClassNotFoundException, BadPaddingException, NoSuchProviderException, NoSuchChiffrementException
    {
        //pour ne pas que le PWD passe en clair!
        SecurePasswordSha256 sp = new SecurePasswordSha256(PWD);

        //construit la liste des paramètres et envoyer
        NetworkPacket np = new NetworkPacket(KAS_CST.INIT);
        np.add(KAS_CST.USERNAME, USERNAME);
        np.add(KAS_CST.SALT, sp.getSalt());
        np.add(KAS_CST.PWD, sp.getHashedPassword());
        np.add(KAS_CST.INTERFACE, InetAddress.getLocalHost().getHostAddress());
        np.add(KAS_CST.TGSNAME, TGS_NAME);
        np.add(KAS_CST.DATETIME, LocalDate.now());
        System.out.printf("[CLIENT]Local Host: %s\n",
                InetAddress.getLocalHost().getHostAddress());
        gsocket_AS.Send(np);

        //Lire la réponse. De +, on est en partiellement chiffré donc pas de CipherGestionSocket
        paramAS = (NetworkPacket) gsocket_AS.Receive();
        //Avec une socket null, CGS permet de (dé)chiffrer simplement
        CipherGestionSocket cgs = new CipherGestionSocket(null, chKc);
        if (paramAS.getType() == KAS_CST.YES)
        {
            //OK
            System.out.printf("[CLIENT]User %s connecté!\n", USERNAME);
            chKc.init(Kc);

            //Envoie le paquet chiffré avec Kctgs
            Kctgs = (Cle) ByteUtils.toObject(cgs.decrypte(paramAS.get(KAS_CST.KCTGS)));
            int version = (Integer) ByteUtils.toObject(cgs.decrypte(paramAS.get(KAS_CST.VERSION)));
            String tgServerAddr = (String) ByteUtils.toObject(cgs.decrypte(paramAS.get(KAS_CST.TGSNAME)));;

            System.out.printf("[CLIENT]KerberosAS est de version %d, le nom du TGS est: %s\n",
                    version, tgServerAddr);

            //quitter la connexion au KerberosAS
            NetworkPacket response = new NetworkPacket(KAS_CST.QUIT);
            gsocket_AS.Send(response);
            gsocket_AS.Close();
            isASAuthentified=true;
//            //test
//            Chiffrement chKctgs_test = (Chiffrement) CryptoManager.newInstance(ALGORITHM);
//            chKctgs_test.init(Kctgs);
//            String ciphertext = chKctgs_test.crypte("Charbon");
//            System.out.printf("texte chiffré: %s\n", Arrays.toString(ciphertext.getBytes()));
//            String plainText = chKctgs_test.decrypte(ciphertext);
//            System.out.printf("text déchiffré: %s\n", Arrays.toString(plainText.getBytes()));
//            System.out.printf("text déchiffré: %s\n", plainText);
        }
        else
        {   
            //pas ok: si clé pas trouvée ?
            System.out.printf("[CLIENT]Message received: %s\n",((String) paramAS.get(KAS_CST.MSG)));
            isASAuthentified=false;
            //stop();
           //TransferLongTermKey();

        }
    }

    //si serveur ne connaît pas la clé long terme du client, il faut lui transférer
    private static void TransferLongTermKey()
    {
        try
        {
            System.out.println("Il faut générer un Diffie Hellman pour transmettre la clé long terme");
            //Réaliser un DH
            NetworkPacket request = new NetworkPacket(KAS_CST.TRANSFER_KEY);
            DiffieHellman dh = new DiffieHellman();
            request.add(KAS_CST.PK, dh.getPublicKey().getEncoded()); //envoit sa partie publique
            System.out.println("Diffie Hellman généré, on l'envoie au serveur");
            gsocket_AS.Send(request);

            NetworkPacket answer = (NetworkPacket) gsocket_AS.Receive();
            if (answer.getType() == KAS_CST.YES)
            { //reçoit la partie publique du serveur
                dh.setPublicKey((byte[]) answer.get(KAS_CST.PK));
            }
            else
            { //erreur
                System.out.printf("[CLIENT]Message received: %s\n",
                        ((String) answer.get(KAS_CST.MSG)));
                stop();
            }
            //envoyer que tout est OK de notre côté
            NetworkPacket response = new NetworkPacket(KAS_CST.YES);
            gsocket_AS.Send(response);

            //chiffrer la connexion
            ChiffreDES tmpCh = (ChiffreDES) CryptoManager.newInstance(ALGORITHM);
            tmpCh.init(new CleDES(dh.getSecretKey()));
            CipherGestionSocket cgs = new CipherGestionSocket(null, tmpCh);

            //envoyer la clé long terme
            NetworkPacket longTermKeyPacket = new NetworkPacket(KAS_CST.TRANSFER_KEY);
            longTermKeyPacket.add(KAS_CST.KC, cgs.crypte(Kc));
            longTermKeyPacket.add(KAS_CST.USERNAME, cgs.crypte(USERNAME));
            gsocket_AS.Send(longTermKeyPacket);

            NetworkPacket answer2 = (NetworkPacket) gsocket_AS.Receive();
            if (answer2.getType() == KAS_CST.FAIL)
            {//si erreur
                System.out.printf("[CLIENT]Message received: %s\n",
                        ((String) answer2.get(KAS_CST.MSG)));
            }
            else
            { //OK

                ASAuthentication();
            }
        }
        catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidParameterSpecException |
                InvalidAlgorithmParameterException | IOException | InvalidKeyException |
                IllegalBlockSizeException | ClassNotFoundException | BadPaddingException |
                NoSuchChiffrementException | InvalidKeySpecException | InvalidParameterException ex)
        {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Communication avec le TGS
    private static void SendSecondPacket() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, UnknownHostException, ClassNotFoundException
    {
        //Connexion au serveur TGS
        Socket s = new Socket(HOST, PORT_TGS);

        //Le paquet en entier n'est pas chiffré, juste le ticket!
        //TGS à besoin du ticket pour récupérer la clé de session
        //le ticket est chiffré avec la clé long terme de TGS
        gsocket_TGS = new JavaLibrary.Network.GestionSocket(s);

        //crée le paquet et l'envoit! Eenvoie du tc,tgs qu'il a obtenu du KDC(AS), c'est un ticket déjà crypté
        NetworkPacket tgsReq = new NetworkPacket(KTGS_CST.SEND_AUTHENTICATOR);
        tgsReq.add(KTGS_CST.TGS, (byte[]) paramAS.get(KAS_CST.TICKETGS)); //tgs déjà chiffré
        gsocket_TGS.Send(tgsReq);

        //lire réponse
        NetworkPacket ticketReponse = (NetworkPacket) gsocket_TGS.Receive();

        if (ticketReponse.getType() != KTGS_CST.YES)
        { //erreur
            System.out.printf("[CLIENT]Erreur lors du SEND TICKET: %s\n",
                    ticketReponse.get(KTGS_CST.MSG));
            gsocket_TGS.Close();
            System.exit(-1);
        }
        else
        { //ok
            System.out.printf("[CLIENT]Serveur TGS ok\n");
        }

        //la communication est maintenant chiffrée par kc,tgs: une clé temporaire( clé d'entrée en session avec tgs)
        //entre le client et le serveur TGS
        chKctgs.init(Kctgs);
        //gsocket_TGS=(GestionSocket) new CipherGestionSocket(gsocket_TGS.ois, gsocket_TGS.oos, chKctgs);

        //on doit ensuite envoyer l'ACS: on le prépare donc
        HMAC hmac = new HMAC();
        hmac.generate(((CleDES) Kctgs).getCle(), USERNAME + LocalDate.now().toString());
        AuthenticatorCS acs = new AuthenticatorCS(USERNAME, LocalDate.now(), hmac);

        //préparer le paquet avec l'ACS à envoyer
        NetworkPacket tgsParam = new NetworkPacket(KTGS_CST.SEND_TICKET);
        tgsParam.add(KTGS_CST.ACS, acs);
        tgsParam.add(KTGS_CST.USERNAME, USERNAME); //nom du client
        gsocket_TGS.Send(tgsParam);

        //lit la réponse    
        paramTGS = (NetworkPacket) gsocket_TGS.Receive();
        if (paramTGS.getType() == KTGS_CST.YES)
        {
            System.out.println("Infos bien recu du serveur TGS");
        }
        else
        {
            System.out.printf("[CLIENT]Something went wrong: %s\n",
                    (String) paramTGS.get(KTGS_CST.MSG));
        }

    }

    private void accessRequestServer() throws IOException, NoSuchChiffrementException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException
    {
        // on récupère les infos recues par le serveur TGS à savoir : la clé de session KCS,version,ns que l'on doit décrypter avec 
        // la clé de session kc,tgs

        Chiffrement chKCTGS = (Chiffrement) CryptoManager.newInstance(ALGORITHM);
        chKCTGS.init(Kctgs);
        CipherGestionSocket cgs = new CipherGestionSocket(null, chKCTGS);
        Kcs = (Cle) ByteUtils.toObject(cgs.decrypte(paramTGS.get(KTGS_CST.KCS)));
        int version = (Integer) ByteUtils.toObject(cgs.decrypte(paramTGS.get(KTGS_CST.VERSION)));
        System.out.println("version  =  " + version);
        String nomServeur = (String) ByteUtils.toObject(cgs.decrypte(paramTGS.get(KTGS_CST.SERVER_NAME)));
        System.out.println("nomServeur = " + nomServeur);
        String ldt = (String) ByteUtils.toObject(cgs.decrypte(paramTGS.get((KTGS_CST.DATETIME)))).toString();
        System.out.println("temps = " + ldt);

        // INITIALISATION DU CHIFFREMENT CLIENT-SER on a récupéré la clé KCS, maintenant on l'utilise pour crypter les infos pour le serveur analyse
        Chiffrement chKCS = (Chiffrement) CryptoManager.newInstance(ALGORITHM);
        chKCS.init(Kcs);
        cgs = new CipherGestionSocket(null, chKCS);

        // Envoie du ticket TCS afin que le serveur en extrait la clé de session KCS et puisse décrypter l'authentificateur...
        //crée le paquet et l'envoit! Eenvoie du tc,tgs qu'il a obtenu du KDC(AS), c'est un ticket déjà crypté
        /* Variable à envoyer au serveur analyse */
        Vector VList = new Vector();

        // Créer la requête pour serveur analyse
        RequestKERBEROS req = new RequestKERBEROS(ACCESS_REQUEST_KERBEROS, VList);

        NetworkPacket SerReq = new NetworkPacket(KS_CST.SEND_TICKET);
        SerReq.add(KS_CST.TICKET_SERVER, (byte[]) paramTGS.get(KS_CST.TICKET_SERVER)); //ticket serveur déjà chiffré avec KTGS,KS
        // Ajouter (Encapsuler le NetworkPacket) dans la charge utile de la RequestKERBEROS
        VList.add(SerReq); // position 0

        // Fabrication d'un ACS pour le serveur
        HMAC hmac = new HMAC();
        hmac.generate(((CleDES) Kcs).getCle(), USERNAME + LocalDate.now().toString());
        AuthenticatorCS acs = new AuthenticatorCS(USERNAME, LocalDate.now(), hmac);

        //préparer le paquet avec l'ACS crypté à envoyer
        NetworkPacket ACS_CLIENT = new NetworkPacket(KS_CST.SEND_AUTHENTICATOR);
        ACS_CLIENT.add(KS_CST.ACS, cgs.crypte(acs));
        ACS_CLIENT.add(KS_CST.USERNAME, cgs.crypte(USERNAME)); //nom du client
        VList.add(ACS_CLIENT);

        GSocket.Send(req);

        //Attente de reponse du serveur
        ResponseKERBEROS rep = (ResponseKERBEROS) GSocket.Receive();

        if (rep.getCodeRetour() == YES)
        {
            System.out.println("ACS accepté -> accès autorisé au serveur analyse...");
            JOptionPane.showMessageDialog(this, "Accès autorisé au serveur analyse..., Bienvenu ... !", "ACS ACCEPTED", JOptionPane.ERROR_MESSAGE, null);

            DRAW_OK.setEnabled(true);
        }
        else if (rep.getCodeRetour() == ACS_FAILED)
        {
            System.out.printf("[CLIENT]Le serveur analyse n'a pas accepté l'ACS... %s\n");
            JOptionPane.showMessageDialog(this, "Accès denied au serveur analyse..., Désolé ... !", "ACS FAILED", JOptionPane.ERROR_MESSAGE, null);

            DRAW_OK.setEnabled(false);
        }
    }

    private static void stop()
    {
        try
        {
            NetworkPacket r = new NetworkPacket(KAS_CST.QUIT);
            gsocket_AS.Send(r);
            s.close();
            System.exit(-1);

        }
        catch (IOException ex)
        {
            Logger.getLogger(ClientGUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection()
    {
        RequestKERBEROS req = new RequestKERBEROS(LOGOUT, null);
        GSocket.Send(req);
        GSocket.Close();

        Connect_Bouton.setEnabled(true);
        Deconnect_Bouton.setEnabled(false);
        connect = false;
    }

    public void sendPortTimeOut(Object obj)
    {
        GSocket.Send(obj);
    }

    private boolean isConnect()
    {
        return connect;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ClientGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connect_Bouton;
    private javax.swing.JButton DRAW_OK;
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
