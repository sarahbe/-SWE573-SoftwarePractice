import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.foodcoop.dao.SaleDao;
import com.foodcoop.dao.SaleDetailDao;
import com.foodcoop.domain.Sale;
import com.foodcoop.services.SaleService;
import com.foodcoop.services.SaleServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

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
	public void testGetAllSaleList(){
		saleService.getSaleList();
		verify(saledao,times(1)).getSaleList();
	}
	
	
	@Test
	public void testCalculationSale() {
		
		
	}

}
