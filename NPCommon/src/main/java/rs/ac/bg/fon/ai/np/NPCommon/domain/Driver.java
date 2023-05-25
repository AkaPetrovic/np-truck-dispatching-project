package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class Driver implements GenericEntity{
    private Long id;
    private String name;
    private String surname;
    private Date birthday;
    private Truck truck;

    public Driver() {
    }

    public Driver(Long id, String name, String surname, Date birthday, Truck truck) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.truck = truck;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.birthday);
        hash = 97 * hash + Objects.hashCode(this.truck);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Driver other = (Driver) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return Objects.equals(this.truck, other.truck);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        return id + " | " + name + " " + surname + " | Birthday: " + sdf.format(birthday)
                  + " // Truck: " + truck.toString().substring(4, truck.toString().indexOf('|', 4)).trim();
    }

    @Override
    public String getTableName() {
        return "driver";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, surname, birthday, truck_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "name", "surname", "birthday", "truck_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
        return "'" + name + "'" + ", " + "'" + surname + "'" + ", " + "'" + sqlDate + "'" + ", " + truck.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getDate", "getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
        return "name = '" + name + "', " + "surname = '" + surname + "', " + "birthday = '" + sqlDate + "', " + "truck_id = " + truck.getId();
    }

    @Override
    public String getWhereCondition() {
        return "id = " + id;
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "id = " + id;
    }
}
