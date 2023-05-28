package rs.ac.bg.fon.ai.np.NPServer.repository.db;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DbConnectionFactory {

    private Connection connection;
    private static DbConnectionFactory instance;

    private DbConnectionFactory() {
    }

    public static DbConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DbConnectionFactory();
        }
        return instance;
    }

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
