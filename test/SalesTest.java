
import org.junit.Before;
import org.junit.Test;

import com.foodcoop.dao.SaleDao;
import com.foodcoop.dao.SaleDetailDao;
import com.foodcoop.domain.Sale;
import com.foodcoop.domain.SaleDetail;
import com.foodcoop.services.SaleService;
import com.foodcoop.services.SaleServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
		Sale sale = new Sale();
		ArrayList<SaleDetail> detailList = new ArrayList<SaleDetail>();
		SaleDetail detail = new SaleDetail();
		detail.setQuantity(1);
		detail.setPrice(5);
		detailList.add(detail);
		sale.setSaleDetail(detailList);		
		saleService.calculateSale(sale);
//		assertEquals(sale.getTotal(),5.0);
		
	}

}
