package rs.ac.bg.fon.ai.np.NPClient.view.form;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import rs.ac.bg.fon.ai.np.NPClient.communication.Communication;
import rs.ac.bg.fon.ai.np.NPCommon.domain.User;

/**
 * Predstavlja formu za prijavu korisnika u okviru aplikacije.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmLogin extends javax.swing.JFrame {

	/**
	 * Konstruktor koji sluzi za kreiranje komponenti forme, njihovo inicijalno pozicioniranje i postavljanje njihovog ponasanja.
	 */
    public FrmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        prepareForm();
    }
    
    /**
     * Kreira komponente koje ce biti postavljene na formu i vrsi njihovo inicijalno podesavanje.
     */
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblUsernameError = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblUsernameError.setForeground(new java.awt.Color(255, 51, 51));

        lblPasswordError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lblUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(lblPasswordError)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }                       

    /**
     * Preuzima tekst unesen u username i password polja na formi i prijavljuje korisnika na aplikaciju.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            String username = txtUsername.getText().trim();
            String password = String.copyValueOf(txtPassword.getPassword());

            User user = Communication.getInstance().login(username, password);

            JOptionPane.showMessageDialog(this, "Login success. Welcome " + user.getUsername());
            
            if(user.getRole().equals("manager")){
                (new FrmMainManager()).setVisible(true);
            }else if(user.getRole().equals("dispatcher")){
                (new FrmMainDispatcher()).setVisible(true);
            }
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                        
    
    /**
     * Dugme za logovanje korisnika.
     */
    private javax.swing.JButton btnLogin;
    /**
     * Labela koja se odnosi na polje za lozinku korisnika.
     */
    private javax.swing.JLabel lblPassword;
    /**
     * Labela za ispisivanje teksta ukoliko je polje za lozinku prazno.
     */
    private javax.swing.JLabel lblPasswordError;
    /**
     * Labela koja se odnosi na polje za username korisnika.
     */
    private javax.swing.JLabel lblUsername;
    /**
     * Labela za ispisivanje teksta ukoliko je polje za korisnicko ime prazno.
     */
    private javax.swing.JLabel lblUsernameError;
    /**
     * Polje za unos lozinke prilikom prijave korisnika.
     */
    private javax.swing.JPasswordField txtPassword;
    /**
     * Polje za unos korisnickog imena priikom prijave korisnika.
     */
    private javax.swing.JTextField txtUsername;       

    /**
     * Postavljanje osluskivaca, koji ce pratiti da li je polja za username ili password korisnika prazno i ispisati odredjeni tekst ispod odgovarajuceg polja.
     */
    private void prepareForm() {
        txtUsername.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                validate();
            }
            public void removeUpdate(DocumentEvent e) {
                validate();
            }
            public void insertUpdate(DocumentEvent e) {
                validate();
            }
            
            public void validate() {
                if (!txtUsername.getText().isEmpty()){
                    lblUsernameError.setText("");
                }else{
                    lblUsernameError.setText("Username cannot be empty!");
                }
            }
        });
        
        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                validate();
            }
            public void removeUpdate(DocumentEvent e) {
                validate();
            }
            public void insertUpdate(DocumentEvent e) {
                validate();
            }
            
            public void validate() {
                if (!String.copyValueOf(txtPassword.getPassword()).isEmpty()){
                    lblPasswordError.setText("");
                }else{
                    lblPasswordError.setText("Password cannot be empty!");
                }
            }
        });
    }
}
