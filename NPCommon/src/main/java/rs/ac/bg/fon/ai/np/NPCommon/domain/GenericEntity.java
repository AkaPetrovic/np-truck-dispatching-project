package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;

public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();
    
    String[] getColumnNamesForSelect();

    String getInsertValues();
    
    String[] getResultSetMethods();
    
    String getUpdateValues();
    
    String getWhereCondition();
    
    String getWhereConditionEditOperation();

    void setId(Long id);
}
