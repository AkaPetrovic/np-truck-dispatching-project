package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog vozaca u bazu podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmAddDriver extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmAddDriver(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblTruck = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        cbTrucks = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add driver form");

        lblName.setText("Name");

        lblSurname.setText("Surname");

        lblBirthday.setText("Birthday");

        lblTruck.setText("Truck");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTrucks, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBirthday)
                                .addGap(46, 46, 46)
                                .addComponent(txtBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSurname)
                                .addGap(43, 43, 43)
                                .addComponent(txtSurname))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTruck)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(58, 58, 58)
                                .addComponent(txtName))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthday)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(lblTruck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
    }                      

    /**
     * Preuzima tekst podatke unete u odgovarajuca polja prilikom popunjavanja forme, proverava da li su uneti na pravi nacin i pokrece proces dodavanja vozaca u bazu podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try{
            if(validateForm()){
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                Driver driver = new Driver();
                try {
                    Date birthday = sdf.parse(txtBirthday.getText());
                    driver.setBirthday(birthday);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(this, "Birthday is not in the correct format.\nThe correct format is dd.MM.yyyy.");
                }
                driver.setName(txtName.getText());
                driver.setSurname(txtSurname.getText());
                driver.setTruck((Truck)cbTrucks.getSelectedItem());
                
                Communication.getInstance().saveDriver(driver);
                JOptionPane.showMessageDialog(this, "Driver successfully saved.");
                this.dispose();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                       

    
    /**
     * Dugme za dodavanje vozaca.
     */
    private javax.swing.JButton btnSave;
    /**
     * Padajuci meni sa listom kamiona koji su na raspolaganju da se dodele vozacu.
     */
    private javax.swing.JComboBox<Truck> cbTrucks;
    /**
     * Labela koja se odnosi na polje za datum rodjenja vozaca.
     */
    private javax.swing.JLabel lblBirthday;
    /**
     * Labela koja se odnosi na polje za unos imena vozaca.
     */
    private javax.swing.JLabel lblName;
    /**
     * Labela koja se odnosi na polje za unos prezimena vozaca.
     */
    private javax.swing.JLabel lblSurname;
    /**
     * Labela koja se odnosi na padajuci meni sa listom kamiona koji se mogu dodeliti vozacu.
     */
    private javax.swing.JLabel lblTruck;
    /**
     * Polje za unos datuma rodjenja vozaca.
     */
    private javax.swing.JTextField txtBirthday;
    /**
     * Polje za unos imena vozaca.
     */
    private javax.swing.JTextField txtName;
    /**
     * Polje za unos prezimena vozaca.
     */
    private javax.swing.JTextField txtSurname;                

    /**
     * Pomocna metoda za validaciju polja forme. Proverava da li je neko od polja prazno.
     * @return true - Ukoliko su sva polja popunjena, false u suprotnom.
     */
    private boolean validateForm() {
        if(txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtBirthday.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You must fill out all the fields on the form");
            return false;
        }else{
            return true;
        }
    }

    /**
     * Uzima listu kamiona iz baze podataka i postavlja elemente te liste kao moguce opcije prilikom izbora kamiona koji ce se dodeliti novom vozacu.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste kamiona iz baze podataka.
     */
    private void prepareView() throws Exception {
        List<Truck> trucks = Communication.getInstance().getAllTrucks(new Truck());
        for(Truck truck:trucks){
            cbTrucks.addItem(truck);
        }
    }
}

