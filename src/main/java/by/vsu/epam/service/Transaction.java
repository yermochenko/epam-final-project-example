package by.vsu.epam.service;

import by.vsu.epam.service.exception.TransactionException;

public interface Transaction {
    void start() throws TransactionException;

    void commit() throws TransactionException;

    void rollback() throws TransactionException;
}
