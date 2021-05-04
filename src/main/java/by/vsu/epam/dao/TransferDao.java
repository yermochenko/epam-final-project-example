package by.vsu.epam.dao;

import java.util.List;

import by.vsu.epam.domain.Transfer;

public interface TransferDao extends Dao<Transfer> {
    List<Transfer> readHistoryOfAccount(Long accountId) throws DaoException;
}
