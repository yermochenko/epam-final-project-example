package by.vsu.epam.service.logic;

import by.vsu.epam.service.Transaction;

abstract public class BaseService {
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
