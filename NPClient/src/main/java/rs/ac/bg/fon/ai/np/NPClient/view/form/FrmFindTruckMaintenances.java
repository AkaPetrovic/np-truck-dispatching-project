package rs.ac.bg.fon.ai.np.NPClient.view.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckMaintenance;

public class FrmFindTruckMaintenances extends javax.swing.JDialog {

    public FrmFindTruckMaintenances(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        prepareView();
    }
                        
    private void initComponents() {

        btnSearchMaintenances = new javax.swing.JButton();
        txtSearchDate = new javax.swing.JTextField();
        lblEnterDate = new javax.swing.JLabel();
        pnlLoadData = new javax.swing.JPanel();
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

        pnlLoadData.setBorder(javax.swing.BorderFactory.createTitledBorder("Truck maintenance data"));
        pnlLoadData.setName(""); // NOI18N

        lblDateOfService.setText("Date of service:");

        txtDateOfService.setEnabled(false);

        lblKmAtService.setText("Kilometers at service:");

        txtKmAtService.setEnabled(false);

        lblTruckMaintenanceId.setText("ID:");

        txtTruckMaintenanceId.setEnabled(false);

        lblTruck.setText("Truck:");

        cbTrucks.setEnabled(false);

        javax.swing.GroupLayout pnlLoadDataLayout = new javax.swing.GroupLayout(pnlLoadData);
        pnlLoadData.setLayout(pnlLoadDataLayout);
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
                    .addComponent(pnlLoadData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(pnlLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                       

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
               
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnSearchMaintenances;
    private javax.swing.JComboBox<TruckMaintenance> cbTruckMaintenances;
    private javax.swing.JComboBox<Truck> cbTrucks;
    private javax.swing.JLabel lblDateOfService;
    private javax.swing.JLabel lblEnterDate;
    private javax.swing.JLabel lblKmAtService;
    private javax.swing.JLabel lblTruck;
    private javax.swing.JLabel lblTruckMaintenanceId;
    private javax.swing.JPanel pnlLoadData;
    private javax.swing.JTextField txtDateOfService;
    private javax.swing.JTextField txtKmAtService;
    private javax.swing.JTextField txtSearchDate;
    private javax.swing.JTextField txtTruckMaintenanceId;
    
    private void prepareView() throws Exception {
        List<Truck> trucks = Communication.getInstance().getAllTrucks(new Truck());
        
        for(Truck truck:trucks){
            cbTrucks.addItem(truck);
        }
    }
}
