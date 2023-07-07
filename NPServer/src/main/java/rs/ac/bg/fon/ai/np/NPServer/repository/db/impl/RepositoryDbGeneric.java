package rs.ac.bg.fon.ai.np.NPServer.repository.db.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.GenericEntity;
import rs.ac.bg.fon.ai.np.NPServer.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.ai.np.NPServer.repository.db.DbRepository;

/**
 * Predstavlja genericku implementaciju repositorijuma za izvrsavanje operacija nad bazom podataka. Sadrzi metode za dodavanje, brisanje, izmenu, kao i izlistavanje podataka iz baze.
 * 
 * S obzirom da se radi o generickoj implementaciji metode ove klase ce raditi za bilo koju domensku klasu koja implementira interfejs GenericEntity.
 * 
 * Implementira interfejs DbRepository pri cemu postavlja tip na GenericEntity
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class RepositoryDbGeneric implements DbRepository<GenericEntity> {

    @Override
    public void add(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "INSERT INTO " + entity.getTableName() + " (" + entity.getColumnNamesForInsert() + ") VALUES (" + entity.getInsertValues() + ")";
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
            }
            
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        List<GenericEntity> entities = new ArrayList<>();
        
        Connection connection = DbConnectionFactory.getInstance().getConnection();
        String query = "SELECT * FROM " + param.getTableName();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        Method getColumnNamesForSelect = param.getClass().getMethod("getColumnNamesForSelect");
        String[] columnNames = (String[]) getColumnNamesForSelect.invoke(param);
        
        Field[] fields = param.getClass().getDeclaredFields();
        
        while (rs.next()) {
            GenericEntity entity = param.getClass().newInstance();
            for (int i = 0; i < columnNames.length; i++) {
                String fieldName = fields[i].getName();
                Method setterMethod = param.getClass().getMethod("set" + ((fields[i].getType() == boolean.class) ? "Is" : "") + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), fields[i].getType());
                
                if(columnNames[i].endsWith("_id")){
                    Object helperEntity = fields[i].getType().newInstance();
                    Method setIdMethod = helperEntity.getClass().getMethod("setId", Long.class);
                    setIdMethod.invoke(helperEntity, rs.getClass().getMethod(param.getResultSetMethods()[i], String.class).invoke(rs, columnNames[i]));
                    setterMethod.invoke(entity, helperEntity);
                }else if(fields[i].getType() == Date.class){
                    setterMethod.invoke(entity, new Date(((Date) rs.getClass().getMethod(param.getResultSetMethods()[i], String.class).invoke(rs, columnNames[i])).getTime()));
                }else if(fields[i].getType() == LocalTime.class){
                    setterMethod.invoke(entity, ((java.sql.Time) rs.getClass().getMethod(param.getResultSetMethods()[i], String.class).invoke(rs, columnNames[i])).toLocalTime());
                }else{
                    setterMethod.invoke(entity, rs.getClass().getMethod(param.getResultSetMethods()[i], String.class).invoke(rs, columnNames[i]));
                }
            }
            entities.add(entity);
        }
        rs.close();
        statement.close();
        
        return entities;
    }

    @Override
    public void edit(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "UPDATE " + param.getTableName() + " SET " + param.getUpdateValues() + " WHERE " + param.getWhereConditionEditOperation();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void delete(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "DELETE FROM " + param.getTableName() + " WHERE " + param.getWhereCondition();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
