package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.util.Objects;
import rs.ac.bg.fon.ai.np.NPCommon.domain.util.LoadItemState;

public class LoadItem implements GenericEntity, Comparable<LoadItem>{
    private Long id;
    private TruckLoad load;
    private String loadItemName;
    private boolean dangerous;
    private boolean fragile;
    private BigDecimal weight;
    private BigDecimal volume;
    
    private LoadItemState state;
    private Long previousId;

    public LoadItem() {
        state = LoadItemState.UNCHANGED;
    }

    public LoadItem(Long id, TruckLoad load, String loadItemName, boolean isDangerous, boolean fragile, BigDecimal weight, BigDecimal volume, LoadItemState state) {
        this.id = id;
        this.load = load;
        this.loadItemName = loadItemName;
        this.dangerous = isDangerous;
        this.fragile = fragile;
        this.weight = weight;
        this.volume = volume;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TruckLoad getLoad() {
        return load;
    }

    public void setLoad(TruckLoad load) {
        this.load = load;
    }

    public String getLoadItemName() {
        return loadItemName;
    }

    public void setLoadItemName(String loadItemName) {
        this.loadItemName = loadItemName;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public void setIsDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setIsFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }
    
    public LoadItemState getState() {
        return state;
    }

    public void setState(LoadItemState state) {
        this.state = state;
    }
    
    public Long getPreviousId() {
        return previousId;
    }

    public void setPreviousId(Long previousId) {
        this.previousId = previousId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.load);
        hash = 89 * hash + Objects.hashCode(this.loadItemName);
        hash = 89 * hash + (this.dangerous ? 1 : 0);
        hash = 89 * hash + (this.fragile ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.weight);
        hash = 89 * hash + Objects.hashCode(this.volume);
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
        final LoadItem other = (LoadItem) obj;
        if (this.dangerous != other.dangerous) {
            return false;
        }
        if (this.fragile != other.fragile) {
            return false;
        }
        if (!Objects.equals(this.loadItemName, other.loadItemName)) {
            return false;
        }
        if (!Objects.equals(this.load, other.load)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        return Objects.equals(this.volume, other.volume);
    }

    @Override
    public int compareTo(LoadItem o) {
        return this.id.compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "LoadItem{" + "id=" + id + ", load=" + load + ", loadItemName=" + loadItemName + ", dangerous=" + dangerous + ", fragile=" + fragile + ", weight=" + weight + ", volume=" + volume + ", state=" + state + ", previousId=" + previousId + '}';
    }

    @Override
    public String getTableName() {
        return "load_item";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, truck_load_id, load_type, dangerous, fragile, weight, volume";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "truck_load_id", "load_type", "dangerous", "fragile", "weight", "volume"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return id + ", " + load.getId() + ", " + "'" + loadItemName + "'" + ", " + dangerous + ", " + fragile + ", " + weight + ", " + volume;
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getLong", "getString", "getBoolean", "getBoolean", "getBigDecimal", "getBigDecimal"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        return "id = " + id + ", " + "truck_load_id = " + load.getId() + ", " + "load_type = '" + loadItemName + "', " + "dangerous = " + dangerous + ", " + "fragile = " + fragile + ", " + "weight = " + weight + ", " + "volume = " + volume;
    }

    @Override
    public String getWhereCondition() {
        return "truck_load_id = " + load.getId() + " AND id = " + id;
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "truck_load_id = " + load.getId() + " AND id = " + previousId;
    }
}
