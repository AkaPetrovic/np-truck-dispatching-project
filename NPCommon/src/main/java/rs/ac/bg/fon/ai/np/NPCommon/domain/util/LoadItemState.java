package rs.ac.bg.fon.ai.np.NPCommon.domain.util;

/**
 * Predstavlja enumeraciju koja opisuje koja su sva moguca stanja jedne stavke tovara iz liste stavki koja se vezuje za specifican tovar.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public enum LoadItemState {
	/**
	 * Oznacava da stavku treba dodati u odgovarajucu tabelu u okviru baze podataka.
	 */
    INSERT,
    /**
	 * Oznacava da stavku treba obrisati iz odgovarajuce tabele u okviru baze podataka.
	 */
    DELETE,
    /**
	 * Oznacava da stavku ne treba menjati, vec je ostaviti takvu kakva jeste.
	 */
    UNCHANGED,
    /**
	 * Oznacava da stavku iz odgovarajuce tabele u okviru baze podataka treba promeniti na odredjeni nacin.
	 */
    EDITED
}
