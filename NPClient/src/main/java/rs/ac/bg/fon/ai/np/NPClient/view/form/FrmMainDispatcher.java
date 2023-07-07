package rs.ac.bg.fon.ai.np.NPClient.view.form;

import javax.swing.JFrame;

/**
 * Predstavlja formu koja je namenjena korisnicima sa ulogom dispecera.
 * 
 * Sadrzi meni sa opcijama za pozivanje razlicitih drugih formi za rad sa tovarima.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmMainDispatcher extends javax.swing.JFrame {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja.
	 */
    public FrmMainDispatcher() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
       
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
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

    /**
     * Otvara formu za dodavanje novog tovara.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiAddLoadActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            (new FrmAddLoad(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Otvara formu za izmenu odredjenog tovara.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiEditLoadActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            (new FrmEditLoad(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           

    /**
     * Otvara formu za brisanje odredjenog tovara.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiDeleteLoadActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            (new FrmDeleteLoad(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                             

    /**
     * Otvara formu za pretragu tovara.
     * @param evt - Predstavlja dogadjaj koji se desio nad stavkom menija (klik).
     */
    private void jmiFindLoadActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            (new FrmFindLoads(this, true)).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           
    
    /**
     * Meni sa karticama koje pruzaju opcije za otvaranje razlicitih prozora i dalje obavljanje razlicitih operacija koje su u nadleznosti dispecera.
     */
    private javax.swing.JMenuBar jMenuBar;
    /**
     * Padajuci meni sa opcijama za otvaranje prozora za rad sa tovarima.
     */
    private javax.swing.JMenu jMenuLoad;
    /**
     * Stavka padajuceg menija za rad sa tovarima koja otvara prozor za dodavanje novog tovara.
     */
    private javax.swing.JMenuItem jmiAddLoad;
    /**
     * Stavka padajuceg menija za rad sa tovarima koja otvara prozor za brisanje odredjenog tovara.
     */
    private javax.swing.JMenuItem jmiDeleteLoad;
    /**
     * Stavka padajuceg menija za rad sa tovarima koja otvara prozor za izmenu odgovarajuceg tovara.
     */
    private javax.swing.JMenuItem jmiEditLoad;
    /**
     * Stavka padajuceg menija za rad sa tovarima koja otvara prozor za pronalazenje zeljenog tovara.
     */
    private javax.swing.JMenuItem jmiFindLoad;                
}
