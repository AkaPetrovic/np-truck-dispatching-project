package rs.ac.bg.fon.ai.np.NPClient.view.form.component.table;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;

public class LoadTableModel extends AbstractTableModel {

    private final TruckLoad load;
    private final String[] columnNames = new String[]{"Number", "Name", "Dangerous", "Fragile", "Weight", "Volume"};

    public LoadTableModel(TruckLoad load) {
        this.load = load;
    }
    
    @Override
    public int getRowCount() {
        if(load != null){
            return load.getLoadItems().size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LoadItem item = load.getLoadItems().get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return item.getId();
            case 1:
                return item.getLoadItemName();
            case 2:
                if(item.isDangerous())
                    return "Yes";
                return "No";
            case 3:
                if(item.isFragile())
                    return "Yes";
                return "No";
            case 4:
                return item.getWeight();
            case 5:
                return item.getVolume();
            default:
                return "n/a";
        }
    }
    
    public void addLoadItem(LoadItem item){
        item.setLoad(load);
        item.setId(Long.valueOf(load.getLoadItems().size() + 1));
        
        load.getLoadItems().add(item);
        
        fireTableRowsInserted(load.getLoadItems().size() - 1, load.getLoadItems().size() - 1);
    }
    
    public void removeLoadItem(int rowIndex){
        load.getLoadItems().remove(rowIndex);
        fixNumbers();
        fireTableRowsDeleted(load.getLoadItems().size() - 1, load.getLoadItems().size() - 1);
    }
    
    private void fixNumbers() {
        int number = 0;
        for (LoadItem item : load.getLoadItems()) {
            item.setId(Long.valueOf(++number));
        }
    }
    
    public TruckLoad getLoad() {
        return load;
    }
}
