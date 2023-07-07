package rs.ac.bg.fon.ai.np.NPClient.view.form.component.table;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.np.NPCommon.domain.LoadItem;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;

/**
 * Predstavlja specifican table model koji je prilagodjen za rad sa tovarima.
 * 
 * Nasledjuje klasu AbstractTableModel.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class LoadTableModel extends AbstractTableModel {

	/**
	 * Tovar sa cijim sadrzajem ce table model raditi.
	 */
    private final TruckLoad load;
    /**
     * Niz stringova koji predstavlja nazive kolona u tabeli.
     */
    private final String[] columnNames = new String[]{"Number", "Name", "Dangerous", "Fragile", "Weight", "Volume"};

    /**
     * Konstruktor koji obezbedjuje da se pri kreiranju instance ove klase postavi vrednost za tovar ciji podaci ce se prikazivati u tabeli.
     * @param load - Tovar koji ce se vezati za instancu ove klase pri kreiranju.
     */
    public LoadTableModel(TruckLoad load) {
        this.load = load;
    }
    
    @Override
    /**
     * Vraca broj redova u tabeli na osnovu broja stavki tovara ukoliko je postavljena instanca tovara sa kojom radi table model, u suprotnom vraca 0.
     */
    public int getRowCount() {
        if(load != null){
            return load.getLoadItems().size();
        }
        return 0;
    }

    @Override
    /**
     * Vraca broj kolona na osnovu velicine niza naziva kolona.
     */
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    /**
     * Vraca naziv kolone na osnovu rednog broja kolone.
     */
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    /**
     * Vraca vrednost iz odgovarajuceg polja u tabeli na osnovu rednog broja reda i kolone.
     */
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
    
    /**
     * Dodeljuje odgovarajucu ID vrednost stavki tovara i dodaje je u listu stavki tovara sa kojim radi table model.
     * @param item - Stavka tovara koju treba dodati u listu.
     */
    public void addLoadItem(LoadItem item){
        item.setLoad(load);
        item.setId(Long.valueOf(load.getLoadItems().size() + 1));
        
        load.getLoadItems().add(item);
        
        fireTableRowsInserted(load.getLoadItems().size() - 1, load.getLoadItems().size() - 1);
    }
    
    /**
     * Izbacuje stavku tovara iz liste stavki na osnovu selektovanog reda u tabeli.
     * @param rowIndex - Redni broj reda u tabeli koji predstavlja stavku koju treba izbaciti iz liste
     */
    public void removeLoadItem(int rowIndex){
        load.getLoadItems().remove(rowIndex);
        fixNumbers();
        fireTableRowsDeleted(load.getLoadItems().size() - 1, load.getLoadItems().size() - 1);
    }
    
    /**
     * Popravlja ID vrednosti stavki tovara nakon sto je izbacena stavka iz liste.
     */
    private void fixNumbers() {
        int number = 0;
        for (LoadItem item : load.getLoadItems()) {
            item.setId(Long.valueOf(++number));
        }
    }
    
    /**
     * Vraca tovar sa kojim table model radi.
     * @return load - Tovar sa kojim table model radi.
     */
    public TruckLoad getLoad() {
        return load;
    }
}
