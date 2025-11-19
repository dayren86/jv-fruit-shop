package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        new SupplyOperation().transaction(fruitTransaction);
    }
}
