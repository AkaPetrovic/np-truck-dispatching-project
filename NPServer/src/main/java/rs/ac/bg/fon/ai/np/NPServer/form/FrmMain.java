package rs.ac.bg.fon.ai.np.NPServer.form;

import java.io.IOException;

import rs.ac.bg.fon.ai.np.NPServer.server.Server;

/**
 * Predstavlja graficki korisnicki interfejs za pokretanje i zaustavljanje servera, kao i pristup formi za upravljanje podacima za pristup bazi podatka.
 * 
 * Sadrzi podatak o serveru, kako bi u toku rada mogla da se pokrece i zaustavlja serverska aplikacija.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmMain extends javax.swing.JFrame {

	/**
	 * Serverska aplikacija koja obavlja svoju funkciju u pozadini.
	 */
    private Server server;
    
    /**
     * Konstruktor koji vrsi pocetno kreiranje i konfigurisanje elemenata forme.
     */
    public FrmMain() {
        initComponents();
    }
         
    /**
     * Kreira graficke komponente i postavlja i podesava njihov izgled, poziciju i ponasanje.
     */
    private void initComponents() {

        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();
        jmbMain = new javax.swing.JMenuBar();
        jmServer = new javax.swing.JMenu();
        jmiSettings = new javax.swing.JMenuItem();
        jmAbout = new javax.swing.JMenu();
        jmiAboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Dashboard");

        btnStartServer.setText("Start Server");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setText("Stop Server");
        btnStopServer.setEnabled(false);
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        jmServer.setText("Server");

        jmiSettings.setText("Settings");
        jmiSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSettingsActionPerformed(evt);
            }
        });
        jmServer.add(jmiSettings);

        jmbMain.add(jmServer);

        jmAbout.setText("About");

        jmiAboutSoftware.setText("About Software");
        jmAbout.add(jmiAboutSoftware);

        jmbMain.add(jmAbout);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(btnStartServer)
                .addGap(18, 18, 18)
                .addComponent(btnStopServer)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }                        

    /**
     * Otvara formu za podesavanje parametara za pristup bazi podataka kada se klikne na "Settings" opciju iz padajuceg menija koji se otvara klikom na karticu "Server"
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom padajuceg menija (klik).
     */
    private void jmiSettingsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
			new FrmSettings(this, true).setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }                                           

    /**
     * Pokrece serversku aplikaciju.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {                                               
        server = new Server();
        server.start();
        btnStartServer.setEnabled(false);
        btnStopServer.setEnabled(true);
    }                                              

    /**
     * Zaustavlja serversku aplikaciju.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            server.stopServer();
            btnStartServer.setEnabled(true);
            btnStopServer.setEnabled(false);
        } catch (IOException ex) {
            System.out.println("Greska: " + ex.getMessage());
        }
    }                                             
    
    /**
     * Dugme za pokretanje servera.
     */
    private javax.swing.JButton btnStartServer;
    /**
     * Dugme za zaustavljanje servera.
     */
    private javax.swing.JButton btnStopServer;
    /**
     * Stavka menija za otvaranje padajuceg menija koji moze korisniku pruziti vise informacija o aplikaciji.
     */
    private javax.swing.JMenu jmAbout;
    /**
     * Stavka menija za otvaranje padajuceg menija koji moze korisniku pruziti pristup podesavanjima parametara servera.
     */
    private javax.swing.JMenu jmServer;
    /**
     * Glavni meni u okviru prozora.
     */
    private javax.swing.JMenuBar jmbMain;
    /**
     * Stavka padajuceg menija za pristup formi sa informacijama o serverskoj aplikaciji.
     */
    private javax.swing.JMenuItem jmiAboutSoftware;
    /**
     * Stavka padajuceg menija za pristup formi za podesavanje pristupnih parametara za bazu podataka.
     */
    private javax.swing.JMenuItem jmiSettings;                 
}
