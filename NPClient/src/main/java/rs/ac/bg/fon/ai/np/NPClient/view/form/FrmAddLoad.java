package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPClient.util.FormValidator;
import rs.ac.bg.fon.ai.np.NPClient.view.form.component.table.LoadTableModel;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;

/**
 * Predstavlja formu koja je namenjena za dodavanje novog tovara u bazu podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmAddLoad extends javax.swing.JDialog {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmAddLoad(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {
        lblDepartureDate = new javax.swing.JLabel();
        txtDepartureDate = new javax.swing.JTextField();
        lblArrivalDate = new javax.swing.JLabel();
        txtArrivalDate = new javax.swing.JTextField();
        lblDepartureTime = new javax.swing.JLabel();
        txtDepartureTime = new javax.swing.JTextField();
        lblArrivalTime = new javax.swing.JLabel();
        txtArrivalTime = new javax.swing.JTextField();
        lblIncomePerKilometer = new javax.swing.JLabel();
        txtIncomePerKilometer = new javax.swing.JTextField();
        spaneLoadItems = new javax.swing.JScrollPane();
        tableLoadItems = new javax.swing.JTable();
        lblLoadItems = new javax.swing.JLabel();
        pnlNewLoadItem = new javax.swing.JPanel();
        txtItemName = new javax.swing.JTextField();
        lblItemName = new javax.swing.JLabel();
        lblDangerous = new javax.swing.JLabel();
        lblFragile = new javax.swing.JLabel();
        checkDangerous = new javax.swing.JCheckBox();
        checkFragile = new javax.swing.JCheckBox();
        lblWeight = new javax.swing.JLabel();
        lblVolume = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        txtVolume = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblDriver = new javax.swing.JLabel();
        cbDrivers = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add load form");

        lblDepartureDate.setText("Departure date:");

        lblArrivalDate.setText("Arrival date:");

        lblDepartureTime.setText("Departure time:");

        lblArrivalTime.setText("Arrival time:");

        lblIncomePerKilometer.setText("Income per kilometer:");

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
        spaneLoadItems.setViewportView(tableLoadItems);

        lblLoadItems.setText("Load items:");

        pnlNewLoadItem.setBorder(javax.swing.BorderFactory.createTitledBorder("New load item"));

        lblItemName.setText("Item name:");

        lblDangerous.setText("Dangerous:");

        lblFragile.setText("Fragile:");

        lblWeight.setText("Weight (kg):");

        lblVolume.setText("Volume (m^3):");

        btnAddItem.setText("Add item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNewLoadItemLayout = new javax.swing.GroupLayout(pnlNewLoadItem);
        pnlNewLoadItem.setLayout(pnlNewLoadItemLayout);
        pnlNewLoadItemLayout.setHorizontalGroup(
            pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewLoadItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItemName)
                    .addComponent(lblDangerous)
                    .addComponent(lblWeight)
                    .addComponent(lblFragile)
                    .addComponent(lblVolume))
                .addGap(22, 22, 22)
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkFragile)
                    .addComponent(checkDangerous)
                    .addGroup(pnlNewLoadItemLayout.createSequentialGroup()
                        .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnAddItem))
                    .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtVolume, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtWeight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        pnlNewLoadItemLayout.setVerticalGroup(
            pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewLoadItemLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDangerous)
                    .addComponent(checkDangerous))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFragile)
                    .addComponent(checkFragile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVolume)
                    .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        btnRemoveItem.setText("Remove item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblDriver.setText("Driver:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlNewLoadItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spaneLoadItems, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btnRemoveItem))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDepartureDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblArrivalDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtArrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDepartureTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblArrivalTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIncomePerKilometer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIncomePerKilometer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblLoadItems)
                            .addComponent(lblDriver)
                            .addComponent(cbDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartureDate)
                    .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArrivalDate)
                    .addComponent(txtArrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartureTime)
                    .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArrivalTime)
                    .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIncomePerKilometer)
                    .addComponent(txtIncomePerKilometer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDriver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(lblLoadItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRemoveItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(spaneLoadItems, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlNewLoadItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }                      

    /**
     * Brise red iz tabele koja sadrzi stavke tovara, a samim tim i izbacuje stavku tovara iz liste stavki koje se vezuju za taj tovar.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int selectedRow = tableLoadItems.getSelectedRow();
        LoadTableModel model = (LoadTableModel)tableLoadItems.getModel();
        
        if(selectedRow >= 0){
            model.removeLoadItem(selectedRow);
        }else {
            JOptionPane.showMessageDialog(this, "Load item is not selected!");
        }
    }                                             

    /**
     * Dodaje novi red u tabelu koja sadrzi stavke tovara, a samim tim i dodaje stavku tovara u listu stavki koje se vezuju za taj tovar.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            validateLoadItemForm();
            
            LoadItem item = new LoadItem();
        
            item.setLoadItemName(txtItemName.getText());
            item.setIsDangerous(checkDangerous.isSelected());
            item.setIsFragile(checkFragile.isSelected());
            item.setWeight(new BigDecimal(txtWeight.getText()));
            item.setVolume(new BigDecimal(txtVolume.getText()));
        
            LoadTableModel model = (LoadTableModel)tableLoadItems.getModel();
            model.addLoadItem(item);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                          

    /**
     * Preuzima podatke unete na formi, proverava da li su uneti na ispravan nacin i na kraju pokrece proces dodavanja novog tovara u bazu podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            validateLoadForm();
            
            LoadTableModel model = (LoadTableModel)tableLoadItems.getModel();
            TruckLoad load = model.getLoad();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            try {
                load.setStartDate(sdf.parse(txtDepartureDate.getText()));
            } catch (ParseException e) {
                throw new Exception("Departure date is not in the correct format.\nThe correct format is dd.MM.yyyy.");
            }
            try {
                load.setEndDate(sdf.parse(txtArrivalDate.getText()));
            } catch (ParseException e) {
                throw new Exception("Arrival date is not in the correct format.\nThe correct format is dd.MM.yyyy.");
            }
            try {
                load.setStartTime(LocalTime.parse(txtDepartureTime.getText(), formatter));
            } catch (Exception e) {
                throw new Exception("Departure time is not in the correct format.\nThe correct format is HH:mm");
            }
            try {
                load.setEndTime(LocalTime.parse(txtArrivalTime.getText(), formatter));
            } catch (Exception e) {
                throw new Exception("Arrival time is not in the correct format.\nThe correct format is HH:mm");
            }
            
            
            Calendar calendar = Calendar.getInstance();
            
            calendar.setTime(load.getStartDate());
            int dDay = calendar.get(Calendar.DAY_OF_MONTH);
            int dMonth = calendar.get(Calendar.MONTH) + 1;
            int dYear = calendar.get(Calendar.YEAR);
            
            calendar.setTime(load.getEndDate());
            int aDay = calendar.get(Calendar.DAY_OF_MONTH);
            int aMonth = calendar.get(Calendar.MONTH) + 1;
            int aYear = calendar.get(Calendar.YEAR);
            
            int dHours = load.getStartTime().getHour();
            int dMinutes = load.getStartTime().getMinute();
            int aHours = load.getEndTime().getHour();
            int aMinutes = load.getEndTime().getMinute();
            
            if(dYear > aYear){
                throw new Exception("Arrival date must be after the departure date");
            }else if(dYear == aYear && dMonth > aMonth){
                throw new Exception("Arrival date must be after the departure date");
            }else if(dYear == aYear && dMonth == aMonth && dDay > aDay){
                throw new Exception("Arrival date must be after the departure date");
            }else if(dYear == aYear && dMonth == aMonth && dDay == aDay){
                if(dHours > aHours){
                    throw new Exception("If the departure date and the arrival date are the same, arrival time must be after the departure time");
                }else if(dHours == aHours && dMinutes > aMinutes){
                    throw new Exception("If the departure date and the arrival date are the same, arrival time must be after the departure time");
                }else if(dHours == aHours && dMinutes == aMinutes){
                    throw new Exception("Departure and arrival dates and times cannot be same");
                }
            }
            
            load.setIncomePerKilometer(new BigDecimal(txtIncomePerKilometer.getText()));
            load.setDriver((Driver)cbDrivers.getSelectedItem());
            
            Communication.getInstance().saveLoad(load);
            
            JOptionPane.showMessageDialog(this, "Load has been saved");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                       
    
    /**
     * Dugme za dodavanje nove stavke tovara u listu stavki, kao i dodavanje novog reda u tabeli.
     */
    private javax.swing.JButton btnAddItem;
    /**
     * Dugme za brisanje stavke tovara iz liste stavki, kao i brisanje odredjenog reda iz tabele stavki tovara.
     */
    private javax.swing.JButton btnRemoveItem;
    /**
     * Dugme za dodavanje novog tovara u bazu podataka.
     */
    private javax.swing.JButton btnSave;
    /**
     * Padajuci meni sa listom vozaca koji se mogu angazovati za prevoz novog tovara.
     */
    private javax.swing.JComboBox<Driver> cbDrivers;
    /**
     * Polje koje predstavlja da li je stavka tovara opasna.
     */
    private javax.swing.JCheckBox checkDangerous;
    /**
     * Polje koje predstavlja da li je stavka tovara lomljiva.
     */
    private javax.swing.JCheckBox checkFragile;
    /**
     * Labela koja se odnosi na polje za unos datuma dolaska.
     */
    private javax.swing.JLabel lblArrivalDate;
    /**
     * Labela koja se odnosi na polje za unos vremena dolaska.
     */
    private javax.swing.JLabel lblArrivalTime;
    /**
     * Labela koja se odnosi na polje za oznacavanje stavke kao opasne.
     */
    private javax.swing.JLabel lblDangerous;
    /**
     * Labela koja se odnosi na polje za unos datuma polaska.
     */
    private javax.swing.JLabel lblDepartureDate;
    /**
     * Labela koja se odnosi na polje za unos vremena polaska.
     */
    private javax.swing.JLabel lblDepartureTime;
    /**
     * Labela koja se odnosi na padajuci meni za izbor vozaca koji ce biti angazovan za prevoz novog tovara.
     */
    private javax.swing.JLabel lblDriver;
    /**
     * Labela koja se odnosi na polje za oznacavanje stavke kao lomljive.
     */
    private javax.swing.JLabel lblFragile;
    /**
     * Labela koja se odnosi na polje za unos prihoda koji se ostvaruje po predjenom kilometru.
     */
    private javax.swing.JLabel lblIncomePerKilometer;
    /**
     * Labela koja se odnosi na polje za unos imena stavke tovara.
     */
    private javax.swing.JLabel lblItemName;
    /**
     * Labela koja se odnosi na tabelu sa trenutnim stavkama tovara koje se vezuju za njega.
     */
    private javax.swing.JLabel lblLoadItems;
    /**
     * Labela koja se odnosi na polje za unos zapremine stavke tovara.
     */
    private javax.swing.JLabel lblVolume;
    /**
     * Labela koja se odnosi na polje za unos mase stavke tovara.
     */
    private javax.swing.JLabel lblWeight;
    /**
     * Panel koji obuhvata komponente na formi koje se odnose na pojedinacne stavke tovara.
     */
    private javax.swing.JPanel pnlNewLoadItem;
    /**
     * Scroll pane koji predstavlja neophodnu komponentu za ispravno funkcionisanje tabele.
     */
    private javax.swing.JScrollPane spaneLoadItems;
    /**
     * Tabela za prikaz trenutnog stanja liste stavki tovara.
     */
    private javax.swing.JTable tableLoadItems;
    /**
     * Polje za unos datuma dolaska.
     */
    private javax.swing.JTextField txtArrivalDate;
    /**
     * Polje za unos vremena dolaska.
     */
    private javax.swing.JTextField txtArrivalTime;
    /**
     * Polje za unos datuma polaska.
     */
    private javax.swing.JTextField txtDepartureDate;
    /**
     * Polje za unos vremena polaska.
     */
    private javax.swing.JTextField txtDepartureTime;
    /**
     * Polje za unos prihoda po predjenom kilometru.
     */
    private javax.swing.JTextField txtIncomePerKilometer;
    /**
     * Polje za unos imena stavke tovara.
     */
    private javax.swing.JTextField txtItemName;
    /**
     * Polje za unos zapremine stavke tovara.
     */
    private javax.swing.JTextField txtVolume;
    /**
     * Polje za unos mase stavke tovara.
     */
    private javax.swing.JTextField txtWeight;                

    /**
     * Kreira table model za rad sa tovarom, preuzima listu vozaca iz baze podataka i postavlja elemente te liste u padajuci meni koji sadrzi vozace koji su na raspolaganju za angazovanje za potrebe prevoza tovara.
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

    /**
     * Proverava ispravnost unetih podataka u odgovarajuca polja dela forme koji se odnosi na pojedinacne stavke.
     * @throws Exception - Ukoliko neko polje nije popunjeno ili nije popunjeno na pravi nacin.
     */
    private void validateLoadItemForm() throws Exception{
        if(txtItemName.getText().isEmpty() || txtVolume.getText().isEmpty() || txtWeight.getText().isEmpty()){
            throw new Exception("You must fill out all the fields on the form");
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo4DigitsAndUpTo2DecimalSpaces(txtWeight.getText())){
            throw new Exception("Weight must be a whole number with maximum 3 digits and up to 2 decimal spaces");
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo3DigitsAndUpTo2DecimalSpaces(txtVolume.getText())){
            throw new Exception("Volume must be a whole number with maximum 3 digits and up to 2 decimal spaces");
        }
    }

    /**
     * Proverava ispravnost unetih podataka u odgovarajuca polja dela forme koji se odnosi na sam novi tovar koji se kreira.
     * @throws Exception - Ukoliko neko polje nije popunjeno ili nije popunjeno na pravi nacin.
     */
    private void validateLoadForm() throws Exception{
        if(txtDepartureDate.getText().isEmpty() || txtArrivalDate.getText().isEmpty() || txtDepartureTime.getText().isEmpty() || txtArrivalTime.getText().isEmpty() || txtIncomePerKilometer.getText().isEmpty()){
            throw new Exception("You must fill out all the fields on the form");
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo3DigitsAndUpTo2DecimalSpaces(txtIncomePerKilometer.getText())){
            throw new Exception("Weight must be a whole number with maximum 3 digits and up to 2 decimal spaces");
        }
    }
}

