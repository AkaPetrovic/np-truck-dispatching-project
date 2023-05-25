package rs.ac.bg.fon.ai.np.NPServer.form;

import java.io.IOException;

import rs.ac.bg.fon.ai.np.NPServer.server.Server;

public class FrmMain extends javax.swing.JFrame {

    private Server server;
    
    public FrmMain() {
        initComponents();
    }
                          
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

    private void jmiSettingsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new FrmSettings(this, true).setVisible(true);
    }                                           

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {                                               
        server = new Server();
        server.start();
        btnStartServer.setEnabled(false);
        btnStopServer.setEnabled(true);
    }                                              

    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            server.stopServer();
            btnStartServer.setEnabled(true);
            btnStopServer.setEnabled(false);
        } catch (IOException ex) {
            System.out.println("Greska: " + ex.getMessage());
        }
    }                                             
                    
    private javax.swing.JButton btnStartServer;
    private javax.swing.JButton btnStopServer;
    private javax.swing.JMenu jmAbout;
    private javax.swing.JMenu jmServer;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiAboutSoftware;
    private javax.swing.JMenuItem jmiSettings;                 
}
