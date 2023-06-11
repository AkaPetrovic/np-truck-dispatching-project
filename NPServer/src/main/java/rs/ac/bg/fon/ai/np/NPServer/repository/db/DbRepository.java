package rs.ac.bg.fon.ai.np.NPServer.repository.db;

import rs.ac.bg.fon.ai.np.NPServer.repository.Repository;

/**
 * Predstavlja specifikaciju repositorijuma, koja omogucava upravljanje transakcijama u radu sa bazom podataka.
 * 
 * @param <T> Tip podataka za koji ce ovaj osnovne metode za upravljanje transakcijama da budu namenjene.
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public interface DbRepository<T>  extends Repository<T>{
	/**
	 * Uzima konekciju i povezuje se sa bazom podataka.
	 * @throws Exception - U slucaju da dodje do greske prilikom povezivanja sa bazom podataka.
	 */
    default public void connect() throws Exception{
        DbConnectionFactory.getInstance().getConnection();
    }
    
    /**
	 * Uzima konekciju i prekida vezu sa bazom podataka.
	 * @throws Exception - U slucaju da dodje do greske prilikom prekida veze sa bazom podataka.
	 */
    default public void disconnect() throws Exception{
        DbConnectionFactory.getInstance().getConnection().close();
    }
    
    /**
	 * Uzima konekciju i izvrsava commit transakcije (potvrdu prethodno napravljenih promena).
	 * @throws Exception - U slucaju da dodje do greske prilikom commit-ovanja transakcije.
	 */
    default public void commit() throws Exception{
        DbConnectionFactory.getInstance().getConnection().commit();
    }
    
    /**
	 * Uzima konekciju i izvrsava rollback transakcije (ponistavanje prethodno napravljenih promena).
	 * @throws Exception - U slucaju da dodje do greske prilikom rollback-ovanja transakcije.
	 */
    default public void rollback() throws Exception{
        DbConnectionFactory.getInstance().getConnection().rollback();
    }
}
