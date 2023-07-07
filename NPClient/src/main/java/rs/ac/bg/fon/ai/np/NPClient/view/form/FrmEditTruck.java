package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPClient.util.FormValidator;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;

/**
 * Predstavlja formu koja je namenjena za vrsenje izmena nad odredjenim kamionom iz baze podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmEditTruck extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmEditTruck(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {

        cbManufacturers = new javax.swing.JComboBox<>();
        btnLoadTrucks = new javax.swing.JButton();
        cbTrucks = new javax.swing.JComboBox<>();
        btnChoose = new javax.swing.JButton();
        jpnlTruckData = new javax.swing.JPanel();
        lblCarryingCapacity = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblKilometersTravelled = new javax.swing.JLabel();
        lblPower = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblManufacturer = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtPower = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        txtKilometersTravelled = new javax.swing.JTextField();
        txtCarryingCapacity = new javax.swing.JTextField();
        cbManufacturersEdit = new javax.swing.JComboBox<>();
        lblTruckType = new javax.swing.JLabel();
        cbTruckTypes = new javax.swing.JComboBox<>();
        btnSaveChanges = new javax.swing.JButton();
        lblChooseManufacturerFromTheList = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit truck form");

        btnLoadTrucks.setText("Load trucks");
        btnLoadTrucks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTrucksActionPerformed(evt);
            }
        });

        cbTrucks.setEnabled(false);

        btnChoose.setText("Choose");
        btnChoose.setEnabled(false);
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        jpnlTruckData.setBorder(javax.swing.BorderFactory.createTitledBorder("Truck data"));

        lblCarryingCapacity.setText("Carrying capacity");

        lblYear.setText("Year");

        lblKilometersTravelled.setText("Kilometers travelled");

        lblPower.setText("Power (HP)");

        lblModel.setText("Model");

        lblManufacturer.setText("Manufacturer");

        lblId.setText("ID");

        txtModel.setEnabled(false);

        txtId.setEnabled(false);

        txtPower.setEnabled(false);

        txtYear.setEnabled(false);

        txtKilometersTravelled.setEnabled(false);

        txtCarryingCapacity.setEnabled(false);

        cbManufacturersEdit.setEnabled(false);

        lblTruckType.setText("Truck type");

        cbTruckTypes.setEnabled(false);

        javax.swing.GroupLayout jpnlTruckDataLayout = new javax.swing.GroupLayout(jpnlTruckData);
        jpnlTruckData.setLayout(jpnlTruckDataLayout);
        jpnlTruckDataLayout.setHorizontalGroup(
            jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTruckDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModel)
                    .addComponent(lblPower)
                    .addComponent(lblKilometersTravelled)
                    .addComponent(lblManufacturer)
                    .addComponent(lblCarryingCapacity)
                    .addComponent(lblYear)
                    .addComponent(lblId)
                    .addComponent(lblTruckType))
                .addGap(71, 71, 71)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtYear)
                    .addComponent(txtKilometersTravelled, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(txtCarryingCapacity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(txtPower)
                    .addComponent(txtModel)
                    .addGroup(jpnlTruckDataLayout.createSequentialGroup()
                        .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbManufacturersEdit, 0, 154, Short.MAX_VALUE)
                            .addComponent(cbTruckTypes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlTruckDataLayout.setVerticalGroup(
            jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTruckDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManufacturer)
                    .addComponent(cbManufacturersEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTruckType)
                    .addComponent(cbTruckTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPower)
                    .addComponent(txtPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKilometersTravelled)
                    .addComponent(txtKilometersTravelled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYear)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlTruckDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarryingCapacity)
                    .addComponent(txtCarryingCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnSaveChanges.setText("Save changes");
        btnSaveChanges.setEnabled(false);
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        lblChooseManufacturerFromTheList.setText("Choose a manufacturer from the list:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlTruckData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTrucks, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveChanges))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChoose)
                            .addComponent(lblChooseManufacturerFromTheList)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbManufacturers, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadTrucks)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChooseManufacturerFromTheList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbManufacturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadTrucks))
                .addGap(18, 18, 18)
                .addComponent(cbTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChoose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlTruckData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveChanges)
                .addContainerGap())
        );

        pack();
    }                        

    /**
     * Pretrazuje kamione na osnovu selektovanog proizvodjaca iz liste proizvodjaca koji postoje u bazi podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnLoadTrucksActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            Manufacturer manufacturer = (Manufacturer)cbManufacturers.getSelectedItem();
            Truck truck = new Truck();
            truck.setManufacturer(manufacturer);
            
            List<Truck> trucks = Communication.getInstance().getTrucks(truck);
            
            cbTrucks.removeAllItems();
            for(Truck tr:trucks){
                cbTrucks.addItem(tr);
            }
            
            cbTrucks.setEnabled(true);
            btnChoose.setEnabled(true);
            
            JOptionPane.showMessageDialog(this, "Trucks have been found in the database.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                             

    /**
     * Ucitava podatke o kamionu u odgovarajuca polja na formi.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            Truck selectedTruck = (Truck)cbTrucks.getSelectedItem();
            
            if(selectedTruck == null){
                throw new Exception("Truck data cannot be loaded");
            }
            
            txtId.setText(String.valueOf(selectedTruck.getId()));
            txtModel.setText(selectedTruck.getModel());
            txtPower.setText(String.valueOf(selectedTruck.getPower()));
            txtYear.setText(String.valueOf(selectedTruck.getYear()));
            txtCarryingCapacity.setText(df.format(Double.parseDouble(selectedTruck.getCarryingCapacity().toString())).replace(',', '.'));
            txtKilometersTravelled.setText(df.format(Double.parseDouble(selectedTruck.getKmTravelled().toString())).replace(',', '.'));
            cbManufacturersEdit.setSelectedItem(selectedTruck.getManufacturer());
            cbTruckTypes.setSelectedItem(selectedTruck.getTruckType());
            txtModel.setEnabled(true);
            txtPower.setEnabled(true);
            txtYear.setEnabled(true);
            txtCarryingCapacity.setEnabled(true);
            txtKilometersTravelled.setEnabled(true);
            cbManufacturersEdit.setEnabled(true);
            cbTruckTypes.setEnabled(true);
            btnSaveChanges.setEnabled(true);

            JOptionPane.showMessageDialog(this, "Truck data has loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage()); 
        }
    }                                         

    /**
     * Cuva promene napravljene nad kamionom u bazi podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try{
            if(validateForm()){
                Truck truck = new Truck();
                truck.setId(Long.valueOf(txtId.getText()));
                truck.setModel(txtModel.getText());
                truck.setPower(Integer.parseInt(txtPower.getText()));
                truck.setYear(Integer.parseInt(txtYear.getText()));
                truck.setKmTravelled(new BigDecimal(txtKilometersTravelled.getText()));
                truck.setManufacturer((Manufacturer)cbManufacturersEdit.getSelectedItem());
                truck.setTruckType((TruckType)cbTruckTypes.getSelectedItem());
                truck.setCarryingCapacity(new BigDecimal(txtCarryingCapacity.getText()));
                
                Communication.getInstance().editTruck(truck);
                
                JOptionPane.showMessageDialog(this, "Truck successfully edited.");
                this.dispose();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                              
    
    /**
     * Dugme za upisivanje podataka o izabranom vozacu u odgovarajuca polja na formi.
     */
    private javax.swing.JButton btnChoose;
    /**
     * Dugme za pretragu kamiona prema proizvodjacu selektovanom u okviru padajuceg menija.
     */
    private javax.swing.JButton btnLoadTrucks;
    /**
     * Dugme za cuvanje promena napravljenih nad kamionom u bazi podataka.
     */
    private javax.swing.JButton btnSaveChanges;
    /**
     * Padajuci meni sa proizvodjacima kamiona koji sluzi za odredjivanje parametara za proces pretrage kamiona.
     */
    private javax.swing.JComboBox<Manufacturer> cbManufacturers;
    /**
     * Padajuci meni sa proizvodjacima kamiona koji se koristi kako bi se odredjeni proizvodjac vezao za odredjeni kamion.
     */
    private javax.swing.JComboBox<Manufacturer> cbManufacturersEdit;
    /**
     * Padajuci meni sa tipovima kamiona.
     */
    private javax.swing.JComboBox<TruckType> cbTruckTypes;
    /**
     * Padajuci meni sa kamionima koji predstavljaju rezultat pretrage na osnovu selektovanog proizvodjaca.
     */
    private javax.swing.JComboBox<Truck> cbTrucks;
    /**
     * Panel koji sadrzi graficke komponente za rad sa kamionom.
     */
    private javax.swing.JPanel jpnlTruckData;
    /**
     * Labela koja se odnosi na polje za unos nosivosti kamiona.
     */
    private javax.swing.JLabel lblCarryingCapacity;
    /**
     * Labela koja se odnosi na padajuci meni sa proizvodjacima kamiona.
     */
    private javax.swing.JLabel lblChooseManufacturerFromTheList;
    /**
     * Labela koja se odnosi na polje za unos ID vrednosti kamiona.
     */
    private javax.swing.JLabel lblId;
    /**
     * Labela koja se odnosi na polje za unos broja predjenjih kilometara.
     */
    private javax.swing.JLabel lblKilometersTravelled;
    /**
     * Labela koja se odnosi na padajuci meni za proizvodjacima kamiona.
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
     * Labela koja se odnosi na padajuci meni tipova kamiona.
     */
    private javax.swing.JLabel lblTruckType;
    /**
     * Labela koja se odnosi na polje za unos godine proizvodnje kamiona.
     */
    private javax.swing.JLabel lblYear;
    /**
     * Tekstualno polje za unos nosivosti kamiona.
     */
    private javax.swing.JTextField txtCarryingCapacity;
    /**
     * Tekstualno polje za unos ID vrednosti kamiona. Onemoguceno je unosenje novih vrednosti, vec je moguc samo prikaz.
     */
    private javax.swing.JTextField txtId;
    /**
     * Tekstualno polje za unos broja predjenih kilometara kamiona.
     */
    private javax.swing.JTextField txtKilometersTravelled;
    /**
     * Tekstualno polje za unos modela kamiona.
     */
    private javax.swing.JTextField txtModel;
    /**
     * Tekstualno polje za unos snage kamiona.
     */
    private javax.swing.JTextField txtPower;
    /**
     * Tekstualno polje za unos godine proizvodnje kamiona.
     */
    private javax.swing.JTextField txtYear;            

    /**
     * Preuzima listu proizvodjaca kamiona i listu tipova kamiona iz baze podataka i elemente te liste ubacuje u odgovarajuce padajuce menije.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja neke od listi iz baze podataka.
     */
    private void prepareView() throws Exception {
        List <Manufacturer> manufacturers = Communication.getInstance().getAllManufactures(new Manufacturer());
        List <TruckType> truckTypes = Communication.getInstance().getAllTruckTypes(new TruckType());
        
        for(Manufacturer manufacturer:manufacturers){
            cbManufacturers.addItem(manufacturer);
        }
        
        for(Manufacturer manufacturer:manufacturers){
            cbManufacturersEdit.addItem(manufacturer);
        }
        
        for(TruckType truckType:truckTypes){
            cbTruckTypes.addItem(truckType);
        }
    }

    /**
     * Proverava da li je forma ispravno popunjena.
     * 
     * Polja ne smeju biti prazna. Kilometraza i  nosivost kamiona mogu biti decimalni brojevi sa maksimalno 2 decimalna mesta. Snaga i nosivost su maksimalno trocifreni, kilometraza je maksimalno sedmocifren broj.
     * 
     * @return true - Ukoliko je forma ispravno popunjena / false - Ukoliko forma nije ispravno popunjena.
     */
    private boolean validateForm() {
        if(txtModel.getText().isEmpty() || txtPower.getText().isEmpty() || txtCarryingCapacity.getText().isEmpty() || txtKilometersTravelled.getText().isEmpty() || txtYear.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You must fill out all the fields on the form");
            return false;
        }else if(!FormValidator.isPositiveNumberWithUpTo3Digits(txtPower.getText())){
            JOptionPane.showMessageDialog(this, "Power must be a whole number with maximum 3 digits");
            return false;
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo7DigitsAndUpTo2DecimalSpaces(txtKilometersTravelled.getText())){
            JOptionPane.showMessageDialog(this, "Kilometers travelled must be a positive decimal number with up to 7 digits and up to 2 decimal spaces (use '.' and not ',')");
            return false;
        }else if(!FormValidator.isPositiveNumberWith4Digits(txtYear.getText())){
            JOptionPane.showMessageDialog(this, "Year number must contain exactly 4 digits");
            return false;
        }else if(Integer.parseInt(txtYear.getText()) < 1990){
            JOptionPane.showMessageDialog(this, "Year must be a number greater than 1990");
            return false;
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo3DigitsAndUpTo2DecimalSpaces(txtCarryingCapacity.getText())){
            JOptionPane.showMessageDialog(this, "Carrying capacity must be a positive decimal number with up to 3 digits and up to 2 decimal spaces (use '.' and not ',')");
            return false;
        }else{
            return true;
        }
    }
}
