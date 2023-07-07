package rs.ac.bg.fon.ai.np.NPServer.repository.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Predstavlja klasu za kreiranje konekcija sa bazom. Implementira singleton patern.
 * 
 * @author Aleksa Petrovic
 * @since 1.2.0
 *
 */
public class DbConnectionFactory {
	/**
	 * Konekcija na bazu podataka.
	 */
    private Connection connection;
    /**
     * Jedinstvena instanca DbConnectionFactory klase.
     */
    private static DbConnectionFactory instance;

    /**
     * Privatni konstruktor koji se poziva samo pri inicijalnom kreiranje jedinstvene instance ove klase.
     */
    private DbConnectionFactory() {
    }

    /**
     * Kreira instancu klase DbConnectionFactory ukoliko ona ne postoji, u suprotnom vraca postojecu instancu.
     * @return instance - Upravo kreirana ili postojeca instanca klase DbConnectionFactory
     */
    public static DbConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DbConnectionFactory();
        }
        return instance;
    }

    /**
     * Vraca konekciju koja postoji sa bazom podataka ili ako ne postoji kreira je na osnovu parametara koji se nalaze u fajlu dbconfig.json.
     * @return connection - Konekcija sa bazom podataka.
     * @throws Exception - U slucaju da nastane greska prilikom ostvarivanja konekcije sa bazom podataka.
     */
    public Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            try (FileReader fr = new FileReader("src/main/resources/dbconfig.json")) {
            	Gson gson = new Gson();
            	
            	JsonObject jsonObject = gson.fromJson(fr, JsonObject.class);
            	
            	String url = jsonObject.get("url").getAsString();
                String username = jsonObject.get("username").getAsString();
                String password = jsonObject.get("password").getAsString();
                
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return connection;
    }
}
