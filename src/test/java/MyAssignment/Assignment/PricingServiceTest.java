package MyAssignment.Assignment;
/**
 * @author venu
 * 	
 */
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.DataAccess;
import com.PricingService;
import com.PricingServiceImpl;

public class PricingServiceTest extends TestCase {
	private static final String SKU = "3283947";
	private static final String BAD_SKU = "-9999993434";
	DataAccess access;
	private PricingService pricingService;
	
	@Before
	public void setUp() {
		access = mock(DataAccess.class);
		pricingService = new PricingServiceImpl();
		pricingService.setDataAccess(access);
	}
	@Test
	public void testgetPrice() throws Exception {
		System.out.println("testing value");
		stub(access.getPriceBySku(SKU)).toReturn(new BigDecimal(100));
		BigDecimal price = pricingService.getPrice(SKU);
		assertNotNull(price);
		verify(access).getPriceBySku(SKU);
	}
	
	

}
