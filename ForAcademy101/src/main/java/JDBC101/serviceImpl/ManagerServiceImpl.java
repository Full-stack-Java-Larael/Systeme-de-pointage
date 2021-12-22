package JDBC101.serviceImpl;

import JDBC101.model.Manager;
import JDBC101.service.managerService;

import java.util.List;
import java.util.Optional;

public class ManagerServiceImpl implements managerService {
    @Override
    public void addManager(Manager Manager) {

    }

    @Override
    public Optional<Manager> fetchManagerById(int id_manager) {
        return Optional.empty();
    }

    @Override
    public void deleteManagerById(Manager id_manager) {

    }

    @Override
    public void updateManagerPasswordById(String newPassword, String[] id_manager) {

    }

    @Override
    public List<Manager> getAllManagers() {
        return null;
    }
}
