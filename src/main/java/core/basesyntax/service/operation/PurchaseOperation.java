package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private FruitsDao fruitsDao = new FruitsDaoImpl();

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        FruitTransaction fruitBalance = fruitsDao.get(fruitTransaction);

        Integer quantity = fruitBalance.getQuantity() - fruitTransaction.getQuantity();

        fruitBalance.setQuantity(quantity);

        fruitsDao.set(fruitBalance);
    }
}
