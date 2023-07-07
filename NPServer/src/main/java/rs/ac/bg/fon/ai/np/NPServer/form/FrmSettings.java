package rs.ac.bg.fon.ai.np.NPServer.form;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Predstavlja graficki korisnicki interfejs za upravljanje podacima za pristup bazi podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FrmSettings extends javax.swing.JDialog {

	/**
	 * Konstruktor koji ima za cilj da izvrsi inicijalizaciju komponenti koje se nalaze na formi i pripremi podatke potrebne za rad sa formom.
	 * @param parent - Forma koja predstavlja "roditelja" ove forme
	 * @param modal - Boolean vrednost koja oznacava da li je ovaj prozor modalan ili nije (da li se moze istovremeno raditi sa drugim delovima program dok je ovaj prozor otvoren).
	 * @throws IOException - U slucaju da dodje do greske prilikom prikupljanja podataka za pristup bazi iz fajla.
	 */
    public FrmSettings(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        prepareView();
    }
    
    /**
     * Kreira graficke komponente i postavlja i podesava njihov izgled, poziciju i ponasanje.
     */
    private void initComponents() {

        lblUrl = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");

        lblUrl.setText("URL:");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword)
                            .addComponent(lblUrl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUrl)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrl)
                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                       

    /**
     * Prikuplja podatke vezane za URL, username i password za pristup bazi i cuva ih u dbconfig.json fajl.
     * @param evt - Predstavlja dogadjaj koji se desio nad dugmetom (klik).
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String url = txtUrl.getText();
        String user = txtUser.getText();
        String password = String.copyValueOf(txtPassword.getPassword());
        
        JsonObject dbConfig = new JsonObject();

	    dbConfig.addProperty("url", url);
	    dbConfig.addProperty("username", user);
	    dbConfig.addProperty("password", password);

	    Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    String json = gson.toJson(dbConfig);

	    try (FileWriter writer = new FileWriter("src/main/resources/dbconfig.json")) {
	         writer.write(json);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
        
        this.dispose();
    }                                       
    
    /**
     * Dugme za cuvanje promena izvrsenih nad parametrima za pristup bazi podataka u dbconfig.json fajlu.
     */
    private javax.swing.JButton btnSave;
    /**
     * Labela neposredno pored polja za unos URL parametra za pristup bazi podataka.
     */
    private javax.swing.JLabel lblUrl;
    /**
     * Labela nepostredno pored polja za unos username parametra za pristup bazi podataka.
     */
    private javax.swing.JLabel lblUsername;
    /**
     * Labela neposredno pored polja za unos password parametra za pristup bazi podataka.
     */
    private javax.swing.JLabel lblPassword;
    /**
     * Polje za unos password parametra za pristup bazi podataka. Tekst koji se unosi je maskiran.
     */
    private javax.swing.JPasswordField txtPassword;
    /**
     * Polje za unos URL parametra za pristup bazi podataka.
     */
    private javax.swing.JTextField txtUrl;
    /**
     * Polje za unos username parametra za pristup bazi podataka.
     */
    private javax.swing.JTextField txtUser;                 

    /**
     * Pronalazi fajl dbconfig.json i cita podatke iz tog fajla i upisuje ih u odgovarajuca polja na formi.
     * @throws IOException - U slucaju da dodje do greske prilikom prikupljanja podataka za pristup bazi iz fajla.
     */
    private void prepareView() throws IOException {
    	try (FileReader fr = new FileReader("src/main/resources/dbconfig.json")) {
        	Gson gson = new Gson();
        	
        	JsonObject jsonObject = gson.fromJson(fr, JsonObject.class);
        	
        	String url = jsonObject.get("url").getAsString();
            String username = jsonObject.get("username").getAsString();
            String password = jsonObject.get("password").getAsString();
            
            txtUrl.setText(url);
            txtUser.setText(username);
            txtPassword.setText(password);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

