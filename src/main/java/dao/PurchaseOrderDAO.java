package dao;

import java.util.List;
import model.PurchaseOrder;

public interface PurchaseOrderDAO {
	public List<PurchaseOrder> findAllPurchaseOrders();

	public List<PurchaseOrder> findAllPurchaseOrdersByUsername(String username);
}
