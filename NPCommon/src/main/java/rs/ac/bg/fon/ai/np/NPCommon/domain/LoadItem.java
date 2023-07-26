package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.util.Objects;
import rs.ac.bg.fon.ai.np.NPCommon.domain.util.LoadItemState;

/**
 * Predstavlja stavku tovara koji prevozi kamion.
 * 
 * Sadrzi ID, ime, prezime, datum rodjenja i podatak o tome koji kamion vozi.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class LoadItem implements GenericEntity, Comparable<LoadItem>{
	/**
	 * ID stavke tovara u vidu Long vrednosti (ceo broj).
	 */
    private Long id;
    /**
     * Tovar klase TruckLoad za koji se stavka vezuje.
     */
    private TruckLoad load;
    /**
     * Naziv stavke tovara kao String.
     */
    private String loadItemName;
    /**
     * Boolean atribut stavke tovara koji oznacava da li je stavka opasna.
     */
    private boolean dangerous;
    /**
     * Boolean atribut stavke tovara koji oznacava da li je stavka lomljiva.
     */
    private boolean fragile;
    /**
     * Masa stavke tovara kao decimalan broj.
     */
    private BigDecimal weight;
    /**
     * Zapremina stavke tovara kao decimalan broj.
     */
    private BigDecimal volume;
    
    /**
     * Stanje stavke tovara u smislu potrebne operacije nad bazom podataka.
     */
    private LoadItemState state;
    /**
     * Pomocna vrednost koja sluzi da sacuva podatak o prethodnoj vrednosti id atributa u vidu celog broja.
     */
    private Long previousId;

    /**
     * Prazan konstruktor za kreiranje jedne instance stavke tovara sa podrazumevanim vrednostima za njena polja.
     */
    public LoadItem() {
        state = LoadItemState.UNCHANGED;
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance stavke tovara sa specificnim vrednostima za njena polja.
     * @param id - ID vrednost stavke tovara koja joj se dodeljuje prilikom kreiranja.
     * @param load - Tovar za koji se stavka vezuje, dodeljuje se u ovom slucaju prilikom kreiranja.
     * @param loadItemName - Naziv stavke tovara koji se dodeljuje stavci prilikom njenog kreiranja.
     * @param isDangerous - Boolean vrednost koja odredjuje da li je stavka tovara opasna ili ne, dodeljuje se u ovom slucaju prilikom kreiranja.
     * @param fragile - Boolean vrednost koja odredjuje da li je stavka tovara lomljiva ili ne i dodeljuje se prilikom kreiranja.
     * @param weight - Decimalna vrednost mase stavke tovara koja joj se dodeljuje prilikom kreiranja.
     * @param volume - Decimalna vrednost zapremine tovara koja joj se dodeljuje prilikom kreiranja.
     * @param state - Pocetno stanje stavke tovara u smislu operacije koja je potrebna da se izvrsi nad bazom podataka.
     */
    public LoadItem(Long id, TruckLoad load, String loadItemName, boolean isDangerous, boolean fragile, BigDecimal weight, BigDecimal volume, LoadItemState state) {
        setId(id);
        setLoad(load);
        setLoadItemName(loadItemName);
        setIsDangerous(isDangerous);
        setIsFragile(fragile);
        setWeight(weight);
        setVolume(volume);
        setState(state);
    }

    /**
     * Vraca ID stavke tovara.
     * @return id - ID stavke tovara kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vraca tovar za koji se vezuje stavka tovara.
     * @return load - Tovar za koji se vezuje stavka tovara klase TruckLoad.
     */
    public TruckLoad getLoad() {
        return load;
    }

    /**
     * Postavlje novu vrednost za atribut load stavke tovara.
     * @param load - Nova vrednost za atribut load.
     */
    public void setLoad(TruckLoad load) {
        this.load = load;
    }

    /**
     * Vraca naziv stavke tovara.
     * @return loadItemName - Naziv stavke tovara kao String.
     */
    public String getLoadItemName() {
        return loadItemName;
    }

    /**
     * Postavlje novu vrednost za atribut loadItemName stavke tovara.
     * @param loadItemName - Nova vrednost za atribut loadItemName.
     */
    public void setLoadItemName(String loadItemName) {
        this.loadItemName = loadItemName;
    }

    /**
     * Vraca boolean vrednost o opasnosti stavke tovara.
     * @return dangerous - Opasnost stavke tovara kao boolean vrednost.
     */
    public boolean isDangerous() {
        return dangerous;
    }

    /**
     * Postavlje novu vrednost za atribut dangerous stavke tovara.
     * @param dangerous - Nova vrednost za atribut dangerous.
     */
    public void setIsDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    /**
     * Vraca boolean vrednost o lomljivosti stavke tovara.
     * @return fragile - Lomljivost stavke tovara kao boolean vrednost.
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * Postavlje novu vrednost za atribut fragile stavke tovara.
     * @param fragile - Nova vrednost za atribut fragile.
     */
    public void setIsFragile(boolean fragile) {
        this.fragile = fragile;
    }

    /**
     * Vraca masu stavke tovara.
     * @return weight - Masa stavke tovara kao decimalan broj.
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * Postavlje novu vrednost za atribut weight stavke tovara.
     * @param weight - Nova vrednost za atribut weight.
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * Vraca zapreminu stavke tovara.
     * @return volume - Zapremina stavke tovara kao decimalan broj.
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * Postavlje novu vrednost za atribut volume stavke tovara.
     * @param volume - Nova vrednost za atribut volume.
     */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }
    
    /**
     * Vraca stanje stavke tovara.
     * @return state - Stanje stavke tovara u pogledu operacije nad bazom koja treba da se izvrsi.
     */
    public LoadItemState getState() {
        return state;
    }

    /**
     * Postavlje novu vrednost za atribut state stavke tovara.
     * @param state - Nova vrednost za atribut state.
     */
    public void setState(LoadItemState state) {
        this.state = state;
    }
    
    /**
     * Vraca prethodnu ID vrednost stavke tovara.
     * @return previousId - Prethodna ID vrednost stavke tovara kao Long vrednost (ceo broj).
     */
    public Long getPreviousId() {
        return previousId;
    }

    /**
     * Postavlje novu vrednost za atribut previousId stavke tovara.
     * @param previousId - Nova vrednost za atribut previousId.
     */
    public void setPreviousId(Long previousId) {
        this.previousId = previousId;
    }

    /**
	 * Racuna hash code na osnovu svih atributa stavke tovara osim ID vrednosti, prethodne ID vrednosti i stanja stavke tovara.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa vozaca.
	 */
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

    /**
	 * Poredi dve stavke tovara prema svim atributima osim ID vrednosti, prethodne ID vrednosti i stanja stavke tovara.
	 * 
	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca stavke tovara nad kojom je pozvana metoda equals().
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase LoadItem ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
	 * </ul>
	 */
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

    /**
     * Vraca String reprezentaciju stavke tovara na osnovu svih atributa.
     * 
     * @return loadItem - String reprezentacija stavke tovara u odgovarajucem formatu.
     */
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
