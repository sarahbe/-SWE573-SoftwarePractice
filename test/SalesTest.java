import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.foodcoop.dao.SaleDao;
import com.foodcoop.dao.SaleDetailDao;
import com.foodcoop.services.SaleService;
import com.foodcoop.services.SaleServiceImpl;

import static org.mockito.Mockito.mock;


public class SalesTest {
	
	private SaleDao saledao;
	private SaleDetailDao saledetaildao;
	
	private SaleService saleService;
	
	@Before 
	public void doSetup() {
		saledao = mock(SaleDao.class);
		saledetaildao = mock(SaleDetailDao.class);
		saleService = new SaleServiceImpl(saledao,saledetaildao);
	}


	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
