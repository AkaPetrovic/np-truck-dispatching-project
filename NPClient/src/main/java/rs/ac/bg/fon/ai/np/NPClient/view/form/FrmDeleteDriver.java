package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;

/**
 * Predstavlja formu koja je namenjena za brisanje odredjenog kamiona iz baze podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmDeleteDriver extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmDeleteDriver(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {

        txtNameSearch = new javax.swing.JTextField();
        btnLoadDrivers = new javax.swing.JButton();
        btnChoose = new javax.swing.JButton();
        jpnlDriverData = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblTruck = new javax.swing.JLabel();
        cbTrucks = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        cbDrivers = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        lblEnterDriversName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete driver form");

        btnLoadDrivers.setText("Load drivers");
        btnLoadDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDriversActionPerformed(evt);
            }
        });

        btnChoose.setText("Choose");
        btnChoose.setEnabled(false);
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        jpnlDriverData.setBorder(javax.swing.BorderFactory.createTitledBorder("Driver data"));

        lblId.setText("ID");

        lblName.setText("Name");

        lblSurname.setText("Surname");

        lblBirthday.setText("Birthday");

        lblTruck.setText("Truck");

        cbTrucks.setEnabled(false);

        txtId.setEnabled(false);

        txtName.setEnabled(false);

        txtSurname.setEnabled(false);

        txtBirthday.setEnabled(false);

        javax.swing.GroupLayout jpnlDriverDataLayout = new javax.swing.GroupLayout(jpnlDriverData);
        jpnlDriverData.setLayout(jpnlDriverDataLayout);
        jpnlDriverDataLayout.setHorizontalGroup(
            jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDriverDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTrucks, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnlDriverDataLayout.createSequentialGroup()
                        .addGroup(jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(lblName)
                            .addComponent(lblSurname)
                            .addComponent(lblBirthday)
                            .addComponent(lblTruck))
                        .addGap(33, 33, 33)
                        .addGroup(jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtSurname)
                            .addGroup(jpnlDriverDataLayout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBirthday))))
                .addContainerGap())
        );
        jpnlDriverDataLayout.setVerticalGroup(
            jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDriverDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnlDriverDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthday)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTruck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbDrivers.setEnabled(false);

        btnDelete.setText("Delete driver");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblEnterDriversName.setText("Enter a driver's name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlDriverData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDrivers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadDrivers))
                            .addComponent(btnChoose)
                            .addComponent(lblEnterDriversName))
                        .addGap(0, 336, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnterDriversName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadDrivers))
                .addGap(22, 22, 22)
                .addComponent(cbDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlDriverData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap())
        );

        pack();
    }                        

    /**
     * Trazi vozace prema imenu upisanom u polje za pretragu.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnLoadDriversActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            Driver driver = new Driver();
            driver.setName(txtNameSearch.getText());

            List<Driver> drivers = Communication.getInstance().getDrivers(driver);

            cbDrivers.removeAllItems();
            for(Driver dr:drivers){
                cbDrivers.addItem(dr);
            }

            cbDrivers.setEnabled(true);
            btnChoose.setEnabled(true);
            
            JOptionPane.showMessageDialog(this, "Drivers have been found in the database.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                              

    /**
     * Ucitava podatke o vozacu u odgovarajuca polja na formi.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            Driver selectedDriver = (Driver)cbDrivers.getSelectedItem();

            if(selectedDriver == null){
                throw new Exception("Driver data cannot be loaded");
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

            txtId.setText(String.valueOf(selectedDriver.getId()));
            txtName.setText(selectedDriver.getName());
            txtSurname.setText(String.valueOf(selectedDriver.getSurname()));
            txtBirthday.setText(sdf.format(selectedDriver.getBirthday()));
            cbTrucks.setSelectedItem(selectedDriver.getTruck());
            btnDelete.setEnabled(true);

            JOptionPane.showMessageDialog(this, "Driver data has loaded.");   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage()); 
        }
    }                                         

    /**
     * Pokrece proces brisanja vozaca iz baze podataka sa odgovarajucom ID vrednoscu.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try{
            Driver driver = new Driver();
            driver.setId(Long.valueOf(txtId.getText()));

            Communication.getInstance().deleteDriver(driver);
            JOptionPane.showMessageDialog(this, "Driver successfully deleted.");
            this.dispose();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                         
    
    /**
     * Dugme za upisivanje podataka o izabranom vozacu u polja na formi.
     */
    private javax.swing.JButton btnChoose;
    /**
     * Dugme za brisanje datog vozaca iz baze podataka.
     */
    private javax.swing.JButton btnDelete;
    /**
     * Dugme za pretragu vozaca prema imenu unesenom u odgovarajuce polje za pretragu.
     */
    private javax.swing.JButton btnLoadDrivers;
    /**
     * Padajuci meni sa vozacima koji se nalaze u bazi i cije se ime poklapa sa imenom unesenim u polje za pretragu.
     */
    private javax.swing.JComboBox<Driver> cbDrivers;
    /**
     * Padajuci meni sa listom kamiona, gde je selektovani kamion upravo onaj koji se vezuje za datog vozaca. Onemoguceno na formi za brisanje.
     */
    private javax.swing.JComboBox<Truck> cbTrucks;
    /**
     * Panel koji obuhvata komponente za rad sa podacima vezanim za vozaca.
     */
    private javax.swing.JPanel jpnlDriverData;
    /**
     * Labela koja se odnosi na polje za unos datuma rodjenja vozaca.
     */
    private javax.swing.JLabel lblBirthday;
    /**
     * Labela koja se odnosi na polje za unos imena vozaca za potrebe pretrage.
     */
    private javax.swing.JLabel lblEnterDriversName;
    /**
     * Labela koja se odnosi na polje za unos ID vrednosti vozaca.
     */
    private javax.swing.JLabel lblId;
    /**
     * Labela koja se odnosi na polje za unos imena vozaca.
     */
    private javax.swing.JLabel lblName;
    /**
     * Labela koja se odnosi na polje za unos prezimena vozaca.
     */
    private javax.swing.JLabel lblSurname;
    /**
     * Labela koja se odnosi na padajuci meni za izbor kamiona koji ce se vezivati za vozaca.
     */
    private javax.swing.JLabel lblTruck;
    /**
     * Polje za unos datuma rodjena vozaca. Onemoguceno na formi za brisanje.
     */
    private javax.swing.JTextField txtBirthday;
    /**
     * Polje za unos ID vrednosti vozaca. Onemoguceno na formi za brisanje.
     */
    private javax.swing.JTextField txtId;
    /**
     * Polje za unos imena vozaca. Onemoguceno na formi za brisanje.
     */
    private javax.swing.JTextField txtName;
    /**
     * Polje za unos imena vozaca za potrebe pretrage.
     */
    private javax.swing.JTextField txtNameSearch;
    /**
     * Polje za unos prezimena vozaca. Onemoguceno na formi za brisanje.
     */
    private javax.swing.JTextField txtSurname;                  

    /**
     * Preuzima listu kamiona iz baze podataka i postavlja elemente te liste u okviru padajuceg menija sa kamionima koji mogu biti vezani za vozaca.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste kamiona iz baze podataka.
     */
    private void prepareView() throws Exception {
        List<Truck> trucks = Communication.getInstance().getAllTrucks(new Truck());
        
        for(Truck truck:trucks){
            cbTrucks.addItem(truck);
        }
    }
}
