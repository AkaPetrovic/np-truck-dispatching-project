package rs.ac.bg.fon.ai.np.NPClient.view.form;

import javax.swing.JFrame;

public class FrmMainManager extends javax.swing.JFrame {

    public FrmMainManager() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
                          
    private void initComponents() {

        jMenuBar = new javax.swing.JMenuBar();
        jMenuDriver = new javax.swing.JMenu();
        jmiAddDriver = new javax.swing.JMenuItem();
        jmiEditDriver = new javax.swing.JMenuItem();
        jmiDeleteDriver = new javax.swing.JMenuItem();
        jmiFindDriver = new javax.swing.JMenuItem();
        jMenuTruck = new javax.swing.JMenu();
        jmiAddTruck = new javax.swing.JMenuItem();
        jmiEditTruck = new javax.swing.JMenuItem();
        jMenuMaintenance = new javax.swing.JMenu();
        jmiFindTruckMaintenances = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PS Project - Manager Dashboard");

        jMenuDriver.setText("Driver");

        jmiAddDriver.setText("Add");
        jmiAddDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddDriverActionPerformed(evt);
            }
        });
        jMenuDriver.add(jmiAddDriver);

        jmiEditDriver.setText("Edit");
        jmiEditDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditDriverActionPerformed(evt);
            }
        });
        jMenuDriver.add(jmiEditDriver);

        jmiDeleteDriver.setText("Delete");
        jmiDeleteDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeleteDriverActionPerformed(evt);
            }
        });
        jMenuDriver.add(jmiDeleteDriver);

        jmiFindDriver.setText("Find");
        jmiFindDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFindDriverActionPerformed(evt);
            }
        });
        jMenuDriver.add(jmiFindDriver);

        jMenuBar.add(jMenuDriver);

        jMenuTruck.setText("Truck");

        jmiAddTruck.setText("Add");
        jmiAddTruck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTruckActionPerformed(evt);
            }
        });
        jMenuTruck.add(jmiAddTruck);

        jmiEditTruck.setText("Edit");
        jmiEditTruck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditTruckActionPerformed(evt);
            }
        });
        jMenuTruck.add(jmiEditTruck);

        jMenuBar.add(jMenuTruck);

        jMenuMaintenance.setText("Maintenance");

        jmiFindTruckMaintenances.setText("Find");
        jmiFindTruckMaintenances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFindTruckMaintenancesActionPerformed(evt);
            }
        });
        jMenuMaintenance.add(jmiFindTruckMaintenances);

        jMenuBar.add(jMenuMaintenance);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                        

    private void jmiAddDriverActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            (new FrmAddDriver(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                            

    private void jmiAddTruckActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            (new FrmAddTruck(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           

    private void jmiEditTruckActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            (new FrmEditTruck(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                            

    private void jmiEditDriverActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            (new FrmEditDriver(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                             

    private void jmiDeleteDriverActionPerformed(java.awt.event.ActionEvent evt) {                                                
        try {
            (new FrmDeleteDriver(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                               

    private void jmiFindDriverActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            (new FrmFindDrivers(this, true)).setVisible(true);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }                                             

    private void jmiFindTruckMaintenancesActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        try {
            (new FrmFindTruckMaintenances(this, true)).setVisible(true);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }                                                        
                   
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuDriver;
    private javax.swing.JMenu jMenuMaintenance;
    private javax.swing.JMenu jMenuTruck;
    private javax.swing.JMenuItem jmiAddDriver;
    private javax.swing.JMenuItem jmiAddTruck;
    private javax.swing.JMenuItem jmiDeleteDriver;
    private javax.swing.JMenuItem jmiEditDriver;
    private javax.swing.JMenuItem jmiEditTruck;
    private javax.swing.JMenuItem jmiFindDriver;
    private javax.swing.JMenuItem jmiFindTruckMaintenances;
}
