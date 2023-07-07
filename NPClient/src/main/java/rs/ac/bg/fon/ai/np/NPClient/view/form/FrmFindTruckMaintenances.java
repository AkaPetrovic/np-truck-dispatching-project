package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckMaintenance;

/**
 * Predstavlja formu koja je namenjena za pronalazenje servisa kamiona iz baze podataka koji odgovaraju odredjenom kriterijumu.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmFindTruckMaintenances extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmFindTruckMaintenances(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {

        btnSearchMaintenances = new javax.swing.JButton();
        txtSearchDate = new javax.swing.JTextField();
        lblEnterDate = new javax.swing.JLabel();
        pnlTruckServiceData = new javax.swing.JPanel();
        lblDateOfService = new javax.swing.JLabel();
        txtDateOfService = new javax.swing.JTextField();
        lblKmAtService = new javax.swing.JLabel();
        txtKmAtService = new javax.swing.JTextField();
        lblTruckMaintenanceId = new javax.swing.JLabel();
        txtTruckMaintenanceId = new javax.swing.JTextField();
        lblTruck = new javax.swing.JLabel();
        cbTrucks = new javax.swing.JComboBox<>();
        cbTruckMaintenances = new javax.swing.JComboBox<>();
        btnChoose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find truck maintenances form");

        btnSearchMaintenances.setText("Search for truck maintenances");
        btnSearchMaintenances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMaintenancesActionPerformed(evt);
            }
        });

        lblEnterDate.setText("Enter the start date:");

        pnlTruckServiceData.setBorder(javax.swing.BorderFactory.createTitledBorder("Truck maintenance data"));
        pnlTruckServiceData.setName(""); // NOI18N

        lblDateOfService.setText("Date of service:");

        txtDateOfService.setEnabled(false);

        lblKmAtService.setText("Kilometers at service:");

        txtKmAtService.setEnabled(false);

        lblTruckMaintenanceId.setText("ID:");

        txtTruckMaintenanceId.setEnabled(false);

        lblTruck.setText("Truck:");

        cbTrucks.setEnabled(false);

        javax.swing.GroupLayout pnlLoadDataLayout = new javax.swing.GroupLayout(pnlTruckServiceData);
        pnlTruckServiceData.setLayout(pnlLoadDataLayout);
        pnlLoadDataLayout.setHorizontalGroup(
            pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoadDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTrucks, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlLoadDataLayout.createSequentialGroup()
                        .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlLoadDataLayout.createSequentialGroup()
                                    .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDateOfService)
                                        .addComponent(lblTruckMaintenanceId))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDateOfService, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTruckMaintenanceId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlLoadDataLayout.createSequentialGroup()
                                    .addComponent(lblKmAtService)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtKmAtService, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblTruck))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlLoadDataLayout.setVerticalGroup(
            pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoadDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTruckMaintenanceId)
                    .addComponent(txtTruckMaintenanceId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateOfService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateOfService))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKmAtService)
                    .addComponent(txtKmAtService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTruck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(432, 432, 432))
        );

        cbTruckMaintenances.setEnabled(false);

        btnChoose.setText("Choose");
        btnChoose.setEnabled(false);
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTruckServiceData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTruckMaintenances, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchMaintenances))
                            .addComponent(lblEnterDate)
                            .addComponent(btnChoose))
                        .addGap(0, 1055, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnterDate)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchMaintenances))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTruckMaintenances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoose)
                .addGap(18, 18, 18)
                .addComponent(pnlTruckServiceData, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                       

    /**
     * Pretrazuje servise na osnovu datuma unesenog u polje za pretragu.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSearchMaintenancesActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        try {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                Date searchDate = sdf.parse(txtSearchDate.getText());

                TruckMaintenance truckMaintenance = new TruckMaintenance();
                truckMaintenance.setDateOfService(searchDate);

                List<TruckMaintenance> truckMaintenances = Communication.getInstance().getTruckMaintenances(truckMaintenance);

                cbTruckMaintenances.removeAllItems();
                for(TruckMaintenance tm:truckMaintenances){
                    cbTruckMaintenances.addItem(tm);
                }
                cbTruckMaintenances.setEnabled(true);
                btnChoose.setEnabled(true);

                JOptionPane.showMessageDialog(this, "Truck maintenances have been found.");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Search date is not in the correct format.\nThe correct format is dd.MM.yyyy.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                                     

    /**
     * Ucitava podatke o servisu u odgovarajuca polja na formi.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            TruckMaintenance truckMaintenance = (TruckMaintenance)cbTruckMaintenances.getSelectedItem();

            if(truckMaintenance == null){
                throw new Exception("Truck maintenances data cannot be loaded");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

            txtTruckMaintenanceId.setText(String.valueOf(truckMaintenance.getId()));
            txtDateOfService.setText(sdf.format(truckMaintenance.getDateOfService()));
            txtKmAtService.setText(String.valueOf(truckMaintenance.getKmAtService()));
            cbTrucks.setSelectedItem(truckMaintenance.getTruck());

            JOptionPane.showMessageDialog(this, "Truck maintenance data has loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                         
    
    /**
     * Dugme za upisivanje podataka o izabranom servisu u odgovarajuca polja na formi.
     */
    private javax.swing.JButton btnChoose;
    /**
     * Dugme za pretragu servisa prema datumu unesenom u polju za pretragu.
     */
    private javax.swing.JButton btnSearchMaintenances;
    /**
     * Padajuci meni sa listom pronadjenih servisa u bazi podataka prema datumu za pretragu.
     */
    private javax.swing.JComboBox<TruckMaintenance> cbTruckMaintenances;
    /**
     * Padajuci meni sa listom svih kamiona gde je selektovani kamion onaj za koji je servis odradjen.
     */
    private javax.swing.JComboBox<Truck> cbTrucks;
    /**
     * Labela koja se odnosi na polje za unos datuma servisa.
     */
    private javax.swing.JLabel lblDateOfService;
    /**
     * Labela koja se odnosi na polje za unos datuma za potrebe procesa pretrage.
     */
    private javax.swing.JLabel lblEnterDate;
    /**
     * Labela koja se odnosi na polje za unos kilometraze prilikom servisa.
     */
    private javax.swing.JLabel lblKmAtService;
    /**
     * Labela koja se odnosi na padajuci meni sa listom kamiona.
     */
    private javax.swing.JLabel lblTruck;
    /**
     * Labela koja se odnosi na polje za unos ID vrednosti servisa.
     */
    private javax.swing.JLabel lblTruckMaintenanceId;
    /**
     * Panel sa grafickim komponentama za rad sa servisima kamiona.
     */
    private javax.swing.JPanel pnlTruckServiceData;
    /**
     * Tekstualno polje za unos datuma servisa.
     */
    private javax.swing.JTextField txtDateOfService;
    /**
     * Tekstualno polje za unos kilometraze u trenutku servisa.
     */
    private javax.swing.JTextField txtKmAtService;
    /**
     * Tekstualno polje za unos datuma za proces pretrage.
     */
    private javax.swing.JTextField txtSearchDate;
    /**
     * Tekstualno polje za unos ID vrednosti servisa.
     */
    private javax.swing.JTextField txtTruckMaintenanceId;
    
    /**
     * Preuzima listu kamiona i elemente te liste ubacuje u padajuci meni sa kamionima.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste kamiona iz baze podataka.
     */
    private void prepareView() throws Exception {
        List<Truck> trucks = Communication.getInstance().getAllTrucks(new Truck());
        
        for(Truck truck:trucks){
            cbTrucks.addItem(truck);
        }
    }
}
