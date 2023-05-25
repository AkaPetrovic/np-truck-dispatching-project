package rs.ac.bg.fon.ai.np.NPClient.view.form;

import javax.swing.JFrame;

public class FrmMainDispatcher extends javax.swing.JFrame {

    public FrmMainDispatcher() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
                         
    private void initComponents() {

        jMenuBar = new javax.swing.JMenuBar();
        jMenuLoad = new javax.swing.JMenu();
        jmiAddLoad = new javax.swing.JMenuItem();
        jmiEditLoad = new javax.swing.JMenuItem();
        jmiDeleteLoad = new javax.swing.JMenuItem();
        jmiFindLoad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PS Project - Dispatcher Dashboard");

        jMenuLoad.setText("Load");

        jmiAddLoad.setText("Add");
        jmiAddLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddLoadActionPerformed(evt);
            }
        });
        jMenuLoad.add(jmiAddLoad);

        jmiEditLoad.setText("Edit");
        jmiEditLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditLoadActionPerformed(evt);
            }
        });
        jMenuLoad.add(jmiEditLoad);

        jmiDeleteLoad.setText("Delete");
        jmiDeleteLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeleteLoadActionPerformed(evt);
            }
        });
        jMenuLoad.add(jmiDeleteLoad);

        jmiFindLoad.setText("Find");
        jmiFindLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFindLoadActionPerformed(evt);
            }
        });
        jMenuLoad.add(jmiFindLoad);

        jMenuBar.add(jMenuLoad);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                        

    private void jmiAddLoadActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            (new FrmAddLoad(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    private void jmiEditLoadActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            (new FrmEditLoad(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           

    private void jmiDeleteLoadActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            (new FrmDeleteLoad(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                             

    private void jmiFindLoadActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            (new FrmFindLoads(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           
                   
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuLoad;
    private javax.swing.JMenuItem jmiAddLoad;
    private javax.swing.JMenuItem jmiDeleteLoad;
    private javax.swing.JMenuItem jmiEditLoad;
    private javax.swing.JMenuItem jmiFindLoad;                
}
