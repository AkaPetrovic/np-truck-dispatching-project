package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPClient.view.form.component.table.LoadTableModel;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;

/**
 * Predstavlja formu koja je namenjena za pronalazenje tovara iz baze podataka koji odgovaraju odredjenom kriterijumu.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmFindLoads extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmFindLoads(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {

        txtSearchDate = new javax.swing.JTextField();
        btnSearchLoads = new javax.swing.JButton();
        lblEnterStartDate = new javax.swing.JLabel();
        cbLoads = new javax.swing.JComboBox<>();
        btnChoose = new javax.swing.JButton();
        pnlLoadData = new javax.swing.JPanel();
        lblDepartureDate = new javax.swing.JLabel();
        txtDepartureDate = new javax.swing.JTextField();
        lblArrivalDate = new javax.swing.JLabel();
        txtArrivalDate = new javax.swing.JTextField();
        txtArrivalTime = new javax.swing.JTextField();
        lblArrivalTime = new javax.swing.JLabel();
        txtDepartureTime = new javax.swing.JTextField();
        lblDepartureTime = new javax.swing.JLabel();
        lblIncomePerKilometer = new javax.swing.JLabel();
        txtIncomePerKilometer = new javax.swing.JTextField();
        lblDriver = new javax.swing.JLabel();
        cbDrivers = new javax.swing.JComboBox<>();
        lblLoadItems = new javax.swing.JLabel();
        spaneLoadItems = new javax.swing.JScrollPane();
        tableLoadItems = new javax.swing.JTable();
        lblLoadId = new javax.swing.JLabel();
        txtLoadId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find loads form");

        btnSearchLoads.setText("Search loads");
        btnSearchLoads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchLoadsActionPerformed(evt);
            }
        });

        lblEnterStartDate.setText("Enter the start date:");

        cbLoads.setEnabled(false);

        btnChoose.setText("Choose");
        btnChoose.setEnabled(false);
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        pnlLoadData.setBorder(javax.swing.BorderFactory.createTitledBorder("Load data"));

        lblDepartureDate.setText("Departure date:");

        txtDepartureDate.setEnabled(false);

        lblArrivalDate.setText("Arrival date:");

        txtArrivalDate.setEnabled(false);

        txtArrivalTime.setEnabled(false);

        lblArrivalTime.setText("Arrival time:");

        txtDepartureTime.setEnabled(false);

        lblDepartureTime.setText("Departure time:");

        lblIncomePerKilometer.setText("Income per kilometer:");

        txtIncomePerKilometer.setEnabled(false);

        lblDriver.setText("Driver:");

        cbDrivers.setEnabled(false);

        lblLoadItems.setText("Load items:");

        tableLoadItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableLoadItems.setEnabled(false);
        spaneLoadItems.setViewportView(tableLoadItems);

        lblLoadId.setText("ID:");

        txtLoadId.setEnabled(false);

        javax.swing.GroupLayout pnlLoadDataLayout = new javax.swing.GroupLayout(pnlLoadData);
        pnlLoadData.setLayout(pnlLoadDataLayout);
        pnlLoadDataLayout.setHorizontalGroup(
            pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoadDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spaneLoadItems, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlLoadDataLayout.createSequentialGroup()
                            .addComponent(lblDepartureTime)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblArrivalTime)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlLoadDataLayout.createSequentialGroup()
                            .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDepartureDate)
                                .addComponent(lblLoadId))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDepartureDate, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(txtLoadId))
                            .addGap(18, 18, 18)
                            .addComponent(lblArrivalDate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtArrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDriver)
                    .addComponent(lblLoadItems)
                    .addGroup(pnlLoadDataLayout.createSequentialGroup()
                        .addComponent(lblIncomePerKilometer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIncomePerKilometer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLoadDataLayout.setVerticalGroup(
            pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoadDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoadId)
                    .addComponent(txtLoadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArrivalDate)
                    .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartureDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArrivalTime)
                    .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartureTime))
                .addGap(8, 8, 8)
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIncomePerKilometer)
                    .addComponent(txtIncomePerKilometer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblDriver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblLoadItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spaneLoadItems, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLoadData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbLoads, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchLoads))
                            .addComponent(lblEnterStartDate)
                            .addComponent(btnChoose))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEnterStartDate)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchLoads))
                .addGap(18, 18, 18)
                .addComponent(cbLoads, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }                       

    /**
     * Pretrazuje tovare na osnovu datuma polaska unesenog u polje za pretragu.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSearchLoadsActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                Date searchDate = sdf.parse(txtSearchDate.getText());

                TruckLoad load = new TruckLoad();
                load.setStartDate(searchDate);

                List<TruckLoad> loads = Communication.getInstance().getLoads(load);

                cbLoads.removeAllItems();
                for(TruckLoad ld:loads){
                    cbLoads.addItem(ld);
                }
                cbLoads.setEnabled(true);
                btnChoose.setEnabled(true);

                JOptionPane.showMessageDialog(this, "Truck loads have been found.");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Search date is not in the correct format.\nThe correct format is dd.MM.yyyy.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                              

    /**
     * Ucitava podatke o tovaru u odgovarajuca polja na formi.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            TruckLoad load = (TruckLoad)cbLoads.getSelectedItem();

            if(load == null){
                    throw new Exception("Load data cannot be loaded");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            txtLoadId.setText(String.valueOf(load.getId()));
            txtDepartureDate.setText(sdf.format(load.getStartDate()));
            txtArrivalDate.setText(sdf.format(load.getEndDate()));
            txtDepartureTime.setText(load.getStartTime().format(formatter));
            txtArrivalTime.setText(load.getEndTime().format(formatter));
            txtIncomePerKilometer.setText(String.valueOf(load.getIncomePerKilometer()));
            cbDrivers.setSelectedItem(load.getDriver());

            LoadTableModel model = new LoadTableModel(load);
            tableLoadItems.setModel(model);

            JOptionPane.showMessageDialog(this, "Load data has loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                         
    
    /**
     * Dugme za upisivanje podataka o izabranom tovaru u odgovarajuca polja na formi.
     */
    private javax.swing.JButton btnChoose;
    /**
     * Dugme za pretragu tovara prema datumu polaska unesenom u polje za pretragu.
     */
    private javax.swing.JButton btnSearchLoads;
    /**
     * Padajuci meni sa vozacima u okviru koga je selektovani vozac angazovan za prevoz datog tovara.
     */
    private javax.swing.JComboBox<Driver> cbDrivers;
    /**
     * Padajuci meni sa tovarima pronadjenim na osnovu parametara pretrage.
     */
    private javax.swing.JComboBox<TruckLoad> cbLoads;
    /**
     * Labela koja se odnosi na polje za unos datuma dolaska.
     */
    private javax.swing.JLabel lblArrivalDate;
    /**
     * Labela koja se odnosi na polje za unos vremena dolaska.
     */
    private javax.swing.JLabel lblArrivalTime;
    /**
     * Labela koja se odnosi na polje za unos datuma polaska.
     */
    private javax.swing.JLabel lblDepartureDate;
    /**
     * Labela koja se odnosi na polje za unos vremena polaska.
     */
    private javax.swing.JLabel lblDepartureTime;
    /**
     * Labela koja se odnosi na padajuci meni sa vozacima.
     */
    private javax.swing.JLabel lblDriver;
    /**
     * Labela koja se odnosi na polje za unos datuma na osnovu koga ce se vrsiti pretraga.
     */
    private javax.swing.JLabel lblEnterStartDate;
    /**
     * Labela koja se odnosi na polje za unos prihoda po predjenom kilometru.
     */
    private javax.swing.JLabel lblIncomePerKilometer;
    /**
     * Labela koja se odnosi na polje za unos ID vrednosti tovara.
     */
    private javax.swing.JLabel lblLoadId;
    /**
     * Labela koja se odnosi na tabelu za prikaz stavki tovara.
     */
    private javax.swing.JLabel lblLoadItems;
    /**
     * Panel koji sadrzi graficke komponente za rad sa tovarima
     */
    private javax.swing.JPanel pnlLoadData;
    /**
     * Scroll pane koji pripada tabeli za prikaz stavki tovara.
     */
    private javax.swing.JScrollPane spaneLoadItems;
    /**
     * Tabela za prikaz stavki tovara.
     */
    private javax.swing.JTable tableLoadItems;
    /**
     * Tekstualno polje za unos datuma dolaska.
     */
    private javax.swing.JTextField txtArrivalDate;
    /**
     * Tekstualno polje za unos vremena dolaska.
     */
    private javax.swing.JTextField txtArrivalTime;
    /**
     * Tekstualno polje za unos datuma polaska.
     */
    private javax.swing.JTextField txtDepartureDate;
    /**
     * Tekstualno polje za unos vremena polaska.
     */
    private javax.swing.JTextField txtDepartureTime;
    /**
     * Tekstualno polje za unos prihoda po predjenom kilometru.
     */
    private javax.swing.JTextField txtIncomePerKilometer;
    /**
     * Tekstualno polje za unos ID vrednosti tovara. Onemogucen je unos novih vrednosti, vec ovo polje sluzi samo za prikaz ID vrednosti sacuvane u bazi podataka.
     */
    private javax.swing.JTextField txtLoadId;
    /**
     * Tekstualno polje za unos datuma za potrebe procesa pretrage.
     */
    private javax.swing.JTextField txtSearchDate;
    
    /**
     * Kreira table model za rad sa tovarima, a takodje i preuzima listu vozaca iz baze podataka i elemente te liste ubacuje u padajuci meni sa vozacima.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste vozaca iz baze podataka.
     */
    private void prepareView() throws Exception {
        LoadTableModel model = new LoadTableModel(new TruckLoad());
        tableLoadItems.setModel(model);
        
        List<Driver> drivers = Communication.getInstance().getAllDrivers(new Driver());
        
        for(Driver driver:drivers){
            cbDrivers.addItem(driver);
        }
    }
}
