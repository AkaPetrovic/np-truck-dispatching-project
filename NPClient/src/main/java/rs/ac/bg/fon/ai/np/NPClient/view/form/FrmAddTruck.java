package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPClient.util.FormValidator;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog kamiona u bazu podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmAddTruck extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmAddTruck(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {

        lblModel = new javax.swing.JLabel();
        lblManufacturer = new javax.swing.JLabel();
        lblPower = new javax.swing.JLabel();
        lblKilometersTravelled = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblCarryingCapacity = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        cbManufacturers = new javax.swing.JComboBox<>();
        txtModel = new javax.swing.JTextField();
        txtPower = new javax.swing.JTextField();
        txtKilometersTravelled = new javax.swing.JTextField();
        txtCarryingCapacity = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        lblTruckType = new javax.swing.JLabel();
        cbTruckTypes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add truck form");

        lblModel.setText("Model");

        lblManufacturer.setText("Manufacturer");

        lblPower.setText("Power (HP)");

        lblKilometersTravelled.setText("Kilometers travelled");

        lblYear.setText("Year");

        lblCarryingCapacity.setText("Carrying capacity (t)");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblTruckType.setText("Truck type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblYear)
                            .addComponent(lblModel)
                            .addComponent(lblPower)
                            .addComponent(lblKilometersTravelled)
                            .addComponent(lblCarryingCapacity)
                            .addComponent(lblTruckType)
                            .addComponent(lblManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTruckTypes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtYear)
                            .addComponent(cbManufacturers, 0, 238, Short.MAX_VALUE)
                            .addComponent(txtModel)
                            .addComponent(txtPower)
                            .addComponent(txtKilometersTravelled)
                            .addComponent(txtCarryingCapacity))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManufacturer)
                    .addComponent(cbManufacturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTruckType)
                    .addComponent(cbTruckTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPower)
                    .addComponent(txtPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKilometersTravelled)
                    .addComponent(txtKilometersTravelled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYear)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarryingCapacity)
                    .addComponent(txtCarryingCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
    }                        

    /**
     * Preuzima tekst podatke unete u odgovarajuca polja prilikom popunjavanja forme, proverava da li su uneti na pravi nacin i pokrece proces dodavanja kamiona u bazu podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try{
            if(validateForm()){
                Truck truck = new Truck();
                truck.setModel(txtModel.getText());
                truck.setPower(Integer.parseInt(txtPower.getText()));
                truck.setKmTravelled(new BigDecimal(txtKilometersTravelled.getText()));
                truck.setYear(Integer.parseInt(txtYear.getText()));
                truck.setCarryingCapacity(new BigDecimal(txtCarryingCapacity.getText()));
                truck.setManufacturer((Manufacturer)cbManufacturers.getSelectedItem());
                truck.setTruckType((TruckType)cbTruckTypes.getSelectedItem());
                
                Communication.getInstance().saveTruck(truck);
                
                JOptionPane.showMessageDialog(this, "Truck successfully saved.");
                this.dispose();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                       
    
    /**
     * Dugme za dodavanje kamiona u bazu podataka.
     */
    private javax.swing.JButton btnSave;
    /**
     * Padajuci meni sa listom proizvodjaca kamiona, koji se mogu vezati za novi kamion.
     */
    private javax.swing.JComboBox<Manufacturer> cbManufacturers;
    /**
     * Padajuci meni sa listom tipova kamiona, koji se mogu vezati za novi kamion.
     */
    private javax.swing.JComboBox<TruckType> cbTruckTypes;
    /**
     * Labela koja se odnosi na polje za unos nosivosti kamiona.
     */
    private javax.swing.JLabel lblCarryingCapacity;
    /**
     * Labela koja se odnosi na polje za unos kilometraze kamiona.
     */
    private javax.swing.JLabel lblKilometersTravelled;
    /**
     * Labela koja se odnosi na polje za padajuci meni sa proizvodjacima kamiona.
     */
    private javax.swing.JLabel lblManufacturer;
    /**
     * Labela koja se odnosi na polje za unos modela kamiona.
     */
    private javax.swing.JLabel lblModel;
    /**
     * Labela koja se odnosi na polje za unos snage kamiona.
     */
    private javax.swing.JLabel lblPower;
    /**
     * Labela koja se odnosi na padajuci meni sa tipovima kamiona.
     */
    private javax.swing.JLabel lblTruckType;
    /**
     * Labela koja se odnosi na polje za unos godine proizvodnje kamiona.
     */
    private javax.swing.JLabel lblYear;
    /**
     * Polje za unos nosivosti kamiona.
     */
    private javax.swing.JTextField txtCarryingCapacity;
    /**
     * Polje za unos kilometraze kamiona.
     */
    private javax.swing.JTextField txtKilometersTravelled;
    /**
     * Polje za unos modela kamiona.
     */
    private javax.swing.JTextField txtModel;
    /**
     * Polje za unos snage kamiona.
     */
    private javax.swing.JTextField txtPower;
    /**
     * Polje za unos godine proizvodnje kamiona.
     */
    private javax.swing.JTextField txtYear;             

    /**
     * Preuzima listu proizvodjaca i tipova kamiona i postavlja elemente tih listi u odgovarajuce padajuce menije za izbor koji ce se koristiti prilikom kreiranja novog kamiona.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste proizvodjaca ili tipova kamiona iz baze podataka.
     */
    private void prepareView() throws Exception {
        List <Manufacturer> manufacturers = Communication.getInstance().getAllManufactures(new Manufacturer());
        List <TruckType> truckTypes = Communication.getInstance().getAllTruckTypes(new TruckType());
        for(Manufacturer manufacturer:manufacturers){
            cbManufacturers.addItem(manufacturer);
        }
        for(TruckType truckType:truckTypes){
            cbTruckTypes.addItem(truckType);
        }
    }
    
    /**
     * Proverava ispravnost unetih podataka u odgovarajuca polja.
     * @throws Exception - Ukoliko neko polje nije popunjeno ili nije popunjeno na pravi nacin.
     */
    private boolean validateForm() {
        if(txtModel.getText().isEmpty() || txtPower.getText().isEmpty() || txtCarryingCapacity.getText().isEmpty() || txtKilometersTravelled.getText().isEmpty() || txtYear.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You must fill out all the fields on the form");
            return false;
        }else if(!FormValidator.isPositiveNumberWithUpTo3Digits(txtPower.getText())){
            JOptionPane.showMessageDialog(this, "Power must be a whole number with maximum 3 digits");
            return false;
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo7DigitsAndUpTo2DecimalSpaces(txtKilometersTravelled.getText())){
            JOptionPane.showMessageDialog(this, "Kilometers travelled must be a positive decimal number with up to 7 digits and up to 2 decimal spaces");
            return false;
        }else if(!FormValidator.isPositiveNumberWith4Digits(txtYear.getText())){
            JOptionPane.showMessageDialog(this, "Year number must contain exactly 4 digits");
            return false;
        }else if(Integer.parseInt(txtYear.getText()) < 1990){
            JOptionPane.showMessageDialog(this, "Year must be a number greater than 1990");
            return false;
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo3DigitsAndUpTo2DecimalSpaces(txtCarryingCapacity.getText())){
            JOptionPane.showMessageDialog(this, "Carrying capacity must be a positive decimal number with up to 3 digits and up to 2 decimal spaces");
            return false;
        }else{
            return true;
        }
    }
}
