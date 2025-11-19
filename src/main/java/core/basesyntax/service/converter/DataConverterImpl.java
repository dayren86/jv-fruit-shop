package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertFruitTransactions(List<String> listTransactionFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (String string : listTransactionFromFile) {
            String[] split = string.split(",");

            FruitTransaction.Operation operation = convertOperation(split[0]);

            FruitTransaction fruitTransaction = new FruitTransaction(
                    operation, split[1], Integer.parseInt(split[2]));
            fruitTransactions.add(fruitTransaction);
        }

        return fruitTransactions;
    }

    private FruitTransaction.Operation convertOperation(String operation) {
        return switch (operation) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            default -> FruitTransaction.Operation.RETURN;
        };
    }
}
