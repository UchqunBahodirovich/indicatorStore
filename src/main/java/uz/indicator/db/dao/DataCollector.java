package uz.indicator.db.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uz.indicator.collections.UserStats;
import uz.indicator.db.dao.Interfaces.*;
import uz.indicator.db.dto.ProductWithWarehouseQtyDTO;
import uz.indicator.db.dto.UniversalCollectionTO;
import uz.indicator.db.dto.WarehouseCountDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataCollector {

    private IncomeDAO incomeDAO;
    private OrderDAO orderDAO;
    private OutgoDAO outgoDAO;
    private PaymentDAO paymentDAO;
    private ReturnProductDAO returnDAO;
    private ProductDAO productDAO;
    private WarehouseDAO warehouseDAO;
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(DataCollector.class);

    public DataCollector(
            IncomeDAO incomeDAO,
            OrderDAO orderDAO,
            OutgoDAO outgoDAO,
            PaymentDAO paymentDAO,
            ReturnProductDAO returnDAO, ProductDAO productDAO, WarehouseDAO warehouseDAO) {
        this.incomeDAO = incomeDAO;
        this.orderDAO = orderDAO;
        this.outgoDAO = outgoDAO;
        this.paymentDAO = paymentDAO;
        this.returnDAO = returnDAO;
        this.productDAO = productDAO;
        this.warehouseDAO = warehouseDAO;
    }

    public UserStats collectStatsForUser(int userId) {
        UserStats userStats = new UserStats();

        userStats.setUserId(userId);
        userStats.setLastPayment(paymentDAO.getLastPaymentForUser(userId));
        userStats.setLastReturn(returnDAO.getLastReturnByCustomer(userId));

        return userStats;
    }

    @Transactional
    public List<ProductWithWarehouseQtyDTO> collectAllProductsAndTheirCounts() {
        List<ProductWithWarehouseQtyDTO> products = new ArrayList<>();

        String QUERY = "SELECT prod.id, prod.name, prod.description,  dwi.quantity, dwi.price, dw.name " +
                        "FROM Products prod " +
                        "LEFT JOIN WarehouseItem dwi on prod.id = dwi.productId " +
                        "LEFT JOIN Warehouse dw on dwi.warehouseId = dw.id " +
                        "ORDER BY prod.id DESC";
        Query query = em.createQuery(QUERY);
        List<Object[]> resultList = query.getResultList();

        int currentId = 0;
        if (resultList.size() > 0) {
            for (Object[] obj : resultList) {
                if ((int) obj[0] != currentId) {
                    ProductWithWarehouseQtyDTO pww = new ProductWithWarehouseQtyDTO();
                    currentId = (int) obj[0];

                    pww.setId((int) obj[0]);
                    pww.setName((String) obj[1]);
                    pww.setDescription((String) obj[2]);
                    pww.setMeasurement((String) obj[3]);
                    
                    try {
                        pww.setWarehouses(new WarehouseCountDTO((String) obj[6], (double) obj[4]));
                        pww.setOverallQuantity((double) obj[4]);
                        pww.setPrice((double) obj[5]);
                    } catch (NullPointerException e) {
//                        continue;
                    }

                    products.add(pww);
                } else {
                    products.get(products.size() - 1).setWarehouses(new WarehouseCountDTO((String) obj[6], (double) obj[4]));
                    products.get(products.size() - 1).setOverallQuantity((double) obj[4]);
                    products.get(products.size() - 1).setPrice((double) obj[5]);
                }
            }
        }

        return products;
    }

    public UniversalCollectionTO getProductsAndWarehouses() {
        return new UniversalCollectionTO(
                productDAO.getAll(),
                warehouseDAO.getAll()
        );
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
