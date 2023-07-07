package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPClient.util.FormValidator;
import rs.ac.bg.fon.ai.np.NPClient.view.form.component.table.LoadTableModel;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPCommon.domain.util.LoadItemState;

/**
 * Predstavlja formu koja je namenjena za vrsenje izmena nad odredjenim tovarima iz baze podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmEditLoad extends javax.swing.JDialog {

	/**
	 * Table model koji se odnosi na tovar sa kojim se radi.
	 */
    private LoadTableModel loadTableModel;
    
    /**
     * Lista stavki tovara koje ne treba menjati u bazi podataka.
     */
    private List<LoadItem> unchangedLoadItems;
    /**
     * Lista stavki tovara koje vec postoje u bazi podataka, a koje treba obrisati.
     */
    private List<LoadItem> deletedLoadItems;
    /**
     * Lista stavki tovara koje treba dodati u bazu podataka i vezati za dati tovar.
     */
    private List<LoadItem> addedLoadItems;
    /**
     * Lista stavki tovara koje se trenutno nalaze u bazi podataka.
     */
    private List<LoadItem> loadItemsCurrentlyInDatabase;
    
    /**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja, kao i upisivanje pocetnih vrednosti.
	 * 
	 * @param parent - JFrame prozor iz kog je pozvan ovaj JDialog prozor.
	 * @param modal - Boolean vrednost koja odredjuje da li je JDialog prozor modalan.
	 * @throws Exception - Ukoliko dodje do greske prilikom pripreme izgleda forme i podataka na njoj.
	 */
    public FrmEditLoad(java.awt.Frame parent, boolean modal) throws Exception {
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
        btnRemoveItem = new javax.swing.JButton();
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
        lblLoadId = new javax.swing.JLabel();
        txtLoadId = new javax.swing.JTextField();
        btnSaveChanges = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit load form");

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

        btnRemoveItem.setText("Remove item");
        btnRemoveItem.setEnabled(false);
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        pnlNewLoadItem.setBorder(javax.swing.BorderFactory.createTitledBorder("New load item"));

        txtItemName.setEnabled(false);

        lblItemName.setText("Item name:");

        lblDangerous.setText("Dangerous:");

        lblFragile.setText("Fragile:");

        checkDangerous.setEnabled(false);

        checkFragile.setEnabled(false);

        lblWeight.setText("Weight (kg):");

        lblVolume.setText("Volume (m^3):");

        txtWeight.setEnabled(false);

        txtVolume.setEnabled(false);

        btnAddItem.setText("Add item");
        btnAddItem.setEnabled(false);
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
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNewLoadItemLayout.createSequentialGroup()
                        .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtVolume, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWeight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                        .addComponent(btnAddItem)))
                .addContainerGap())
        );
        pnlNewLoadItemLayout.setVerticalGroup(
            pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewLoadItemLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlNewLoadItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblLoadId.setText("ID:");

        txtLoadId.setEnabled(false);

        javax.swing.GroupLayout pnlLoadDataLayout = new javax.swing.GroupLayout(pnlLoadData);
        pnlLoadData.setLayout(pnlLoadDataLayout);
        pnlLoadDataLayout.setHorizontalGroup(
            pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoadDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoadDataLayout.createSequentialGroup()
                        .addComponent(spaneLoadItems, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveItem))
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
                        .addComponent(txtIncomePerKilometer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlNewLoadItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(pnlLoadDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoveItem)
                    .addComponent(spaneLoadItems, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNewLoadItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSaveChanges.setText("Save changes");
        btnSaveChanges.setEnabled(false);
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbLoads, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(btnSaveChanges))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChoose)
                        .addGap(12, 12, 12)
                        .addComponent(pnlLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSaveChanges, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }                       

    /**
     * Izbacuje izabranu stavku iz liste stavki tovara i iz tabele za prikaz stavki tovara.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int selectedRow = tableLoadItems.getSelectedRow();
        
        TruckLoad load = loadTableModel.getLoad();
        
        //Creating a copy of the LoadItem object found at the selected row of the table of load items
        Object[] rowData = new Object[tableLoadItems.getColumnCount()];
        for (int i = 0; i < tableLoadItems.getColumnCount(); i++) {
            rowData[i] = tableLoadItems.getValueAt(selectedRow, i);
        }
        LoadItem item = new LoadItem();
        item.setLoadItemName((String) rowData[1]);
        item.setIsDangerous(rowData[2].equals("Yes"));
        item.setIsFragile(rowData[3].equals("Yes"));
        item.setWeight((BigDecimal) rowData[4]);
        item.setVolume((BigDecimal) rowData[5]);

        if(selectedRow >= 0){
            loadTableModel.removeLoadItem(selectedRow);
        }else {
            JOptionPane.showMessageDialog(this, "Load item is not selected!");
        }
        
        item.setLoad(load);
        
        for(int i = 0; i < addedLoadItems.size(); i++){
            if(item.equals(addedLoadItems.get(i))){
                addedLoadItems.remove(item);
                return;
            }
        }
        
        for(int i = 0; i < unchangedLoadItems.size(); i++){
            if(item.equals(unchangedLoadItems.get(i))){
                item.setId(unchangedLoadItems.get(i).getId());
                unchangedLoadItems.remove(item);
                item.setState(LoadItemState.DELETE);
                deletedLoadItems.add(item);
                return;
            }
        }
    }                                             

    /**
     * Ubacuje novu stavku tovara u listu stavki tovara. Nova stavka tovara ce imati vrednosti prethodno unete u odgovarajuca polja u delu za kreiranje stavki tovara.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            validateLoadItemForm();

            LoadItem item = new LoadItem();
            TruckLoad load = loadTableModel.getLoad();

            item.setLoadItemName(txtItemName.getText());
            item.setIsDangerous(checkDangerous.isSelected());
            item.setIsFragile(checkFragile.isSelected());
            item.setWeight(new BigDecimal(txtWeight.getText()));
            item.setVolume(new BigDecimal(txtVolume.getText()));

            loadTableModel.addLoadItem(item);
            
            item.setLoad(load);
            
            for(int i = 0; i < deletedLoadItems.size(); i++){
                if(item.equals(deletedLoadItems.get(i))){
                    deletedLoadItems.remove(item);
                    item.setState(LoadItemState.UNCHANGED);
                    unchangedLoadItems.add(item);
                    return;
                }
            }

            item.setState(LoadItemState.INSERT);
            addedLoadItems.add(item);
            
            System.out.println("\n");
            for(LoadItem item1:load.getLoadItems()){
            	System.out.println(item1.getLoadItemName());
                System.out.println(item1.getState() + "\n");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                          

    /**
     * Cuvanje izmena napravljenih nad tovarom u bazi podataka.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            validateLoadForm();

            TruckLoad load = loadTableModel.getLoad();
            load.setId(Long.valueOf(txtLoadId.getText()));
            
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
            }else if(dMonth > aMonth){
                throw new Exception("Arrival date must be after the departure date");
            }else if(dDay > aDay){
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

            //Fixing the order of ID's in the unchanged list and in the deleted list
            for(LoadItem item:unchangedLoadItems){
                for(LoadItem originalItem:loadItemsCurrentlyInDatabase){
                    if(item.equals(originalItem)){
                        item.setId(originalItem.getId());
                    }
                }
            }
            
            for(LoadItem item:deletedLoadItems){
                for(LoadItem originalItem:loadItemsCurrentlyInDatabase){
                    if(item.equals(originalItem)){
                        item.setId(originalItem.getId());
                    }
                }
            }
            
            Collections.sort(unchangedLoadItems);
            
            System.out.println(unchangedLoadItems);
            System.out.println(addedLoadItems);
            System.out.println(deletedLoadItems);
            
            //Creating a new list of load items based on unchanged, deleted and added lists of load items
            List<LoadItem> newLoadItemList = new ArrayList<>();

            for(LoadItem item:unchangedLoadItems){
                newLoadItemList.add(item);
            }
            
            for(LoadItem item:addedLoadItems){
                boolean addedBeforeTheEnd = false;
                Long newId = 1L;
                for(LoadItem loadItem:newLoadItemList){
                    if(!loadItem.getId().equals(newId)){
                        item.setId(newId);
                        newLoadItemList.add(item);
                        addedBeforeTheEnd = true;
                        Collections.sort(newLoadItemList);
                        break;
                    }
                    newId = 1L + newId;
                }
                if(!addedBeforeTheEnd){
                    item.setId(newId);
                    newLoadItemList.add(item);
                }
            }
            
            for(LoadItem item:deletedLoadItems){
                newLoadItemList.add(item);
            }
            
            boolean hasGaps = false;
            for(int i = 0; i < newLoadItemList.size(); i++){
                if(newLoadItemList.get(i).getId() > i + 1){
                    hasGaps = true;
                    break;
                }
            }
            
            if(hasGaps){
                Long id = 1L;
                for(LoadItem item:newLoadItemList){
                    item.setPreviousId(item.getId());
                    item.setId(id);
                    if(!item.getId().equals(item.getPreviousId())){
                        item.setState(LoadItemState.EDITED);
                    }
                    id = id + 1L;
                }
            }
            
            load.setLoadItems(newLoadItemList);
            System.out.println(load.getLoadItems());
            Communication.getInstance().editLoad(load);

            JOptionPane.showMessageDialog(this, "Load has been edited");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                              

    /**
     * Vrsi pretragu tovara u bazi podataka prema unesenom datumu u polje za pretragu.
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
     * Ucitava podatke o tovaru i njegovim stavkama u odgovarajuca polja na formi i u tabelu.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            TruckLoad load = (TruckLoad)cbLoads.getSelectedItem();
            
            for(LoadItem item:load.getLoadItems()){
            	System.out.println(item.getLoadItemName());
                System.out.println(item.getState() + "\n");
            }
            
            if(load == null){
                throw new Exception("Load data cannot be loaded");
            }
            
            loadItemsCurrentlyInDatabase = new ArrayList<>();
            for(int i = 0; i < load.getLoadItems().size(); i++){
                loadItemsCurrentlyInDatabase.add(new LoadItem(load.getLoadItems().get(i).getId().longValue(), load, load.getLoadItems().get(i).getLoadItemName(), load.getLoadItems().get(i).isDangerous(), load.getLoadItems().get(i).isFragile(), load.getLoadItems().get(i).getWeight(), load.getLoadItems().get(i).getVolume(), load.getLoadItems().get(i).getState()));
            }
            unchangedLoadItems = new ArrayList<>(load.getLoadItems());
            addedLoadItems = new ArrayList<>();
            deletedLoadItems = new ArrayList<>();

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            txtLoadId.setText(String.valueOf(load.getId()));
            txtDepartureDate.setText(sdf.format(load.getStartDate()));
            txtArrivalDate.setText(sdf.format(load.getEndDate()));
            txtDepartureTime.setText(load.getStartTime().format(formatter));
            txtArrivalTime.setText(load.getEndTime().format(formatter));
            txtIncomePerKilometer.setText(String.valueOf(load.getIncomePerKilometer()));
            cbDrivers.setSelectedItem(load.getDriver());

            loadTableModel = new LoadTableModel(load);
            tableLoadItems.setModel(loadTableModel);

            txtDepartureDate.setEnabled(true);
            txtArrivalDate.setEnabled(true);
            txtDepartureTime.setEnabled(true);
            txtArrivalTime.setEnabled(true);
            txtIncomePerKilometer.setEnabled(true);
            cbDrivers.setEnabled(true);
            tableLoadItems.setEnabled(true);
            btnRemoveItem.setEnabled(true);
            txtItemName.setEnabled(true);
            checkDangerous.setEnabled(true);
            checkFragile.setEnabled(true);
            txtWeight.setEnabled(true);
            txtVolume.setEnabled(true);
            btnAddItem.setEnabled(true);
            btnSaveChanges.setEnabled(true);

            JOptionPane.showMessageDialog(this, "Load data has loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                         
    
    /**
     * Dugme za dodavanje nove stavke tovara u listu stavki.
     */
    private javax.swing.JButton btnAddItem;
    /**
     * Dugme za ucitavanje podataka o tovaru i njegovim stavkama u odgovarajuca polja na formi kao i u tabelu.
     */
    private javax.swing.JButton btnChoose;
    /**
     * Dugme za izbacivanje tovara iz liste stavki tovara.
     */
    private javax.swing.JButton btnRemoveItem;
    /**
     * Dugme za cuvanje promena napravljenih nad tovarom i njegovim stavkama u bazi podataka.
     */
    private javax.swing.JButton btnSaveChanges;
    /**
     * Dugme za pretragu tovara prema datumu polaska unesenom u odgovarajuce polje za datum.
     */
    private javax.swing.JButton btnSearchLoads;
    /**
     * Padajuci meni sa vozacima koji se mogu angazovati za prevoz odredjenog tovara.
     */
    private javax.swing.JComboBox<Driver> cbDrivers;
    /**
     * Padajuci meni sa tovarima koji su pronadjeni na osnovu unesenog datuma polaska.
     */
    private javax.swing.JComboBox<TruckLoad> cbLoads;
    /**
     * Polje za oznacavanje odredjene stavke tovara kao opasne.
     */
    private javax.swing.JCheckBox checkDangerous;
    /**
     * Polje za oznacavanje odredjene stavke tovara kao lomljive.
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
     * Labela koja se odnosi na polje za oznacavanje odredjene stavke tovara kao opasne.
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
     * Labela koja se odnosi na padajuci meni za izbor vozaca koji ce vrsiti prevoz tovara na krajnje odrediste.
     */
    private javax.swing.JLabel lblDriver;
    /**
     * Labela koja se odnosi na polje za unos datuma polaska prema kome ce se vrsiti pretraga.
     */
    private javax.swing.JLabel lblEnterStartDate;
    /**
     * Labela koja se odnosi na polje za oznacavanje odredjene stavke tovara kao lomljive.
     */
    private javax.swing.JLabel lblFragile;
    /**
     * Labela koja se odnosi na polje za unos prihoda po predjenom kilometru.
     */
    private javax.swing.JLabel lblIncomePerKilometer;
    /**
     * Labela koja se odnosi na unos naziva stavke tovara.
     */
    private javax.swing.JLabel lblItemName;
    /**
     * Labela koja se odnosi na polje za unos ID vrednosti tovara.
     */
    private javax.swing.JLabel lblLoadId;
    /**
     * Labela koja se odnosi na tabelu u kojoj su prikazane stavke tovara.
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
     * Panel koji obuvata graficke komponente za rad sa tovarom.
     */
    private javax.swing.JPanel pnlLoadData;
    /**
     * Panel koji obuhvata graficke komponente za kreiranje nove stavke tovara.
     */
    private javax.swing.JPanel pnlNewLoadItem;
    /**
     * Scroll pane za tabelu sa stavkama tovara.
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
     * Tekstualno polje za unos naziva stavke tovara.
     */
    private javax.swing.JTextField txtItemName;
    /**
     * Tekstualno polje za unos ID vrednosti tovara. Onemoguceno je unosenje novih vrednosti, vec ovo polje sluzi samo za prikaz ID vrednosti.
     */
    private javax.swing.JTextField txtLoadId;
    /**
     * Tekstualno polje za unos datuma koji ce se koristiti za pretragu tovara u bazi podataka.
     */
    private javax.swing.JTextField txtSearchDate;
    /**
     * Tektualno polje za unos zapremine stavke tovara.
     */
    private javax.swing.JTextField txtVolume;
    /**
     * Tekstualno polje za unos mase stavke tovara.
     */
    private javax.swing.JTextField txtWeight;                 

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

    /**
     * Proverava ispravnost unetih podataka u odgovarajuca polja dela forme koji se odnosi na pojedinacne stavke.
     * @throws Exception - Ukoliko neko polje nije popunjeno ili nije popunjeno na pravi nacin.
     */
    private void validateLoadItemForm() throws Exception {
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
    private void validateLoadForm() throws Exception {
        if(txtDepartureDate.getText().isEmpty() || txtArrivalDate.getText().isEmpty() || txtDepartureTime.getText().isEmpty() || txtArrivalTime.getText().isEmpty() || txtIncomePerKilometer.getText().isEmpty()){
            throw new Exception("You must fill out all the fields on the form");
        }else if(!FormValidator.isPositiveDecimalNumberWithUpTo3DigitsAndUpTo2DecimalSpaces(txtIncomePerKilometer.getText())){
            throw new Exception("Weight must be a whole number with maximum 3 digits and up to 2 decimal spaces");
        }
    }
}
