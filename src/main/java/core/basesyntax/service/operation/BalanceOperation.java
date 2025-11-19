package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private FruitsDao fruitsDao = new FruitsDaoImpl();

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        fruitsDao.add(fruitTransaction);
    }
}
