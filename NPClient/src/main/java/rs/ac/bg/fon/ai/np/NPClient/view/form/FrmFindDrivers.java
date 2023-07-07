package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;

/**
 * Predstavlja formu koja je namenjena za pronalazenje vozaca iz baze podataka koji odgovaraju odredjenom kriterijumu.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmFindDrivers extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmFindDrivers(java.awt.Frame parent, boolean modal) throws Exception {
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
        cbDrivers = new javax.swing.JComboBox<>();
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
        lblEnterDriversName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find drivers form");

        btnLoadDrivers.setText("Load drivers");
        btnLoadDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDriversActionPerformed(evt);
            }
        });

        cbDrivers.setEnabled(false);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadDrivers))
                            .addComponent(btnChoose)
                            .addComponent(lblEnterDriversName))
                        .addGap(0, 404, Short.MAX_VALUE)))
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
                .addGap(20, 20, 20)
                .addComponent(cbDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChoose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlDriverData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                       

    /**
     * Pretrazuje vozace na osnovu imena unesenog u polje za pretragu.
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

            JOptionPane.showMessageDialog(this, "Driver data has loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage()); 
        }
    }                                         
    
    /**
     * Dugme za upisivanje podataka o izabranom vozacu u odgovarajuca polja na formi.
     */
    private javax.swing.JButton btnChoose;
    /**
     * Dugme za pretragu vozaca prema imenu unesenom u polju za pretragu.
     */
    private javax.swing.JButton btnLoadDrivers;
    /**
     * Padajuci meni sa vozacima koji su pronadjeni na osnovu unesenog imena.
     */
    private javax.swing.JComboBox<Driver> cbDrivers;
    /**
     * Padajuci meni kamiona koji se mogu dodeliti vozacu.
     */
    private javax.swing.JComboBox<Truck> cbTrucks;
    /**
     * Panel koji sadrzi graficke komponente za rad sa vozacima.
     */
    private javax.swing.JPanel jpnlDriverData;
    /**
     * Labela koja se odnosi na polje za unos datuma rodjenja vozaca.
     */
    private javax.swing.JLabel lblBirthday;
    /**
     * Labela koja se odnosi na polje za unos imena koje predstavlja parametar za pretragu vozaca.
     */
    private javax.swing.JLabel lblEnterDriversName;
    /**
     * Labela koja se odnosi na polje za ID vrednost vozaca.
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
     * Labela koja se odnosi na padajuci meni sa kamionima koji se mogu dodeliti vozacu.
     */
    private javax.swing.JLabel lblTruck;
    /**
     * Tekstualno polje za unos datuma rodjenja vozaca.
     */
    private javax.swing.JTextField txtBirthday;
    /**
     * Tekstualno polje za unos ID vrednosti vozaca. Onemogucen je unos novih vrednosti, vec se moze koristiti samo za prikaz.
     */
    private javax.swing.JTextField txtId;
    /**
     * Tekstualno polje za unos imena vozaca.
     */
    private javax.swing.JTextField txtName;
    /**
     * Tekstualno polje za unos imena koje ce se koristiti za pretragu vozaca.
     */
    private javax.swing.JTextField txtNameSearch;
    /**
     * Tekstualno polje za unos prezimena vozaca.
     */
    private javax.swing.JTextField txtSurname;               

    /**
     * Preuzima listu kamiona i elemente te liste ubacuje u padajuci meni sa kamionima.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste kamiona iz baze podataka.
     */
    private void prepareView() throws Exception{
        try {
            List<Truck> trucks = Communication.getInstance().getAllTrucks(new Truck());
            
            for(Truck truck:trucks){
                cbTrucks.addItem(truck);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Server is not running at the moment\nPlease restart the application after the server is up and running again");
            throw ex;
        }
    }
}
