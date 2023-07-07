package rs.ac.bg.fon.ai.np.NPClient.view.form;

import javax.swing.JFrame;

/**
 * Predstavlja formu koja je namenjena korisnicima sa ulogom menadzera.
 * 
 * Sadrzi meni sa opcijama za pozivanje razlicitih drugih formi za rad sa vozacima i kamionima, kao i vodjenjem evidencije o servisima kamiona.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmMainManager extends javax.swing.JFrame {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja.
	 */
    public FrmMainManager() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
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

    /**
     * Otvara formu za dodavanje novog vozaca.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiAddDriverActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            (new FrmAddDriver(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                            

    /**
     * Otvara formu za dodavanje novog kamiona.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiAddTruckActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            (new FrmAddTruck(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           

    /**
     * Otvara formu za izmenu odredjenog kamiona.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiEditTruckActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            (new FrmEditTruck(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                            

    /**
     * Otvara formu za izmenu odredjenog vozaca.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiEditDriverActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            (new FrmEditDriver(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                             

    /**
     * Otvara formu za brisanje odredjenog vozaca.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiDeleteDriverActionPerformed(java.awt.event.ActionEvent evt) {                                                
        try {
            (new FrmDeleteDriver(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                               

    /**
     * Otvara formu za pretragu vozaca.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiFindDriverActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            (new FrmFindDrivers(this, true)).setVisible(true);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }                                             

    /**
     * Otvara formu za pretragu servisa kamiona.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiFindTruckMaintenancesActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        try {
            (new FrmFindTruckMaintenances(this, true)).setVisible(true);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }                                                        
    
    /**
     * Meni sa karticama koje pruzaju opcije za otvaranje razlicitih prozora i dalje obavljanje razlicitih operacija koje su u nadleznosti menadzera.
     */
    private javax.swing.JMenuBar jMenuBar;
    /**
     * Padajuci meni sa opcijama za otvaranje prozora za rad sa vozacima.
     */
    private javax.swing.JMenu jMenuDriver;
    /**
     * Padajuci meni sa opcijama za otvaranje prozora za rad sa servisima kamiona.
     */
    private javax.swing.JMenu jMenuMaintenance;
    /**
     * Padajuci meni sa opcijama za otvaranje prozora za rad sa kamionima.
     */
    private javax.swing.JMenu jMenuTruck;
    /**
     * Stavka padajuceg menija za rad sa vozacima koja otvara prozor za dodavanje novog vozaca.
     */
    private javax.swing.JMenuItem jmiAddDriver;
    /**
     * Stavka padajuceg menija za rad sa kamionima koja otvara prozor za dodavanje novog kamiona.
     */
    private javax.swing.JMenuItem jmiAddTruck;
    /**
     * Stavka padajuceg menija za rad sa vozacima koja otvara prozor za brisanje vozaca.
     */
    private javax.swing.JMenuItem jmiDeleteDriver;
    /**
     * Stavka padajuceg menija za rad sa vozacima koja otvara prozor za izmenu odgovarajuceg vozaca.
     */
    private javax.swing.JMenuItem jmiEditDriver;
    /**
     * Stavka padajuceg menija za rad sa kamionima koja otvara prozor za izmenu odgovarajuceg kamiona.
     */
    private javax.swing.JMenuItem jmiEditTruck;
    /**
     * Stavka padajuceg menija za rad sa vozacima koja otvara prozor za pronalazenje zeljenog vozaca.
     */
    private javax.swing.JMenuItem jmiFindDriver;
    /**
     * Stavka padajuceg menija za rad sa servisima koja otvara prozor za dodavanje novog servisa kamiona.
     */
    private javax.swing.JMenuItem jmiFindTruckMaintenances;
}
