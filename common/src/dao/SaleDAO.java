package dao;

import dto.SaleDTO;
import dto.SoldProductDTO;
import model.Sale;
import model.enums.SaleState;
import java.util.List;

public interface SaleDAO {

    void save(Sale sale);

    List<SaleDTO> getByBuyerId(int buyerId);

    List<SoldProductDTO> getOrderInfo(int saleId);

    List<SaleDTO> list();

    void updateState(int saleId, SaleState state);

}
