package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;

public class ReportGeneratorImpl implements ReportGenerator {
    private FruitsDao fruitsDao;
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";

    public ReportGeneratorImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER).append(System.lineSeparator());

        for (FruitTransaction fruitTransaction : fruitsDao.getAll()) {
            stringBuilder.append(fruitTransaction.getName())
                    .append(COMMA)
                    .append(fruitTransaction.getQuantity())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
