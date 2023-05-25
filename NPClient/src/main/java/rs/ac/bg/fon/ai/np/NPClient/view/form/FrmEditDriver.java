package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;

public class FrmEditDriver extends javax.swing.JDialog {

    public FrmEditDriver(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
    
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
        btnSaveChanges = new javax.swing.JButton();
        lblEnterDriversName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit driver form");

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

        btnSaveChanges.setText("Save changes");
        btnSaveChanges.setEnabled(false);
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
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
                        .addComponent(btnSaveChanges))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadDrivers))
                            .addComponent(btnChoose)
                            .addComponent(lblEnterDriversName))
                        .addGap(0, 444, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChanges)
                .addContainerGap())
        );

        pack();
    }                       

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {                                               
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
                driver.setId(Long.valueOf(txtId.getText()));
                driver.setName(txtName.getText());
                driver.setSurname(txtSurname.getText());
                driver.setTruck((Truck)cbTrucks.getSelectedItem());
                
                Communication.getInstance().editDriver(driver);
                JOptionPane.showMessageDialog(this, "Driver successfully edited.");
                this.dispose();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                              

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
            txtName.setEnabled(true);
            txtSurname.setEnabled(true);
            txtBirthday.setEnabled(true);
            cbTrucks.setEnabled(true);
            btnSaveChanges.setEnabled(true);

            JOptionPane.showMessageDialog(this, "Driver data has loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage()); 
        }
    }                                         
                  
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnLoadDrivers;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<Driver> cbDrivers;
    private javax.swing.JComboBox<Truck> cbTrucks;
    private javax.swing.JPanel jpnlDriverData;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblEnterDriversName;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTruck;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtSurname;                  

    private void prepareView() throws Exception {
        List<Truck> trucks = Communication.getInstance().getAllTrucks(new Truck());
        
        for(Truck truck:trucks){
            cbTrucks.addItem(truck);
        }
    }

    private boolean validateForm() {
        if(txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtBirthday.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You must fill out all the fields on the form");
            return false;
        }else{
            return true;
        }
    }
}
