package JDBC101.serviceImpl;

import JDBC101.model.Manager;
import JDBC101.service.managerService;
import JDBC101.daoImpl.managerDaoImp;
import java.util.List;
import java.util.Optional;

public class ManagerServiceImpl implements managerService {
    private managerDaoImp managerDao = new managerDaoImp();
    @Override
    public void addManager(Manager Manager) {
managerDao.saveManager(Manager);
    }

    @Override
    public Manager fetchManagerById(long id_manager) {
        return managerDao.getManager(id_manager);
    }

    @Override
    public void deleteManagerById(Manager manager) {
managerDao.deleteManager(manager);
    }



    @Override
    public List<Manager> getAllManagers() {
        managerDaoImp managerDaoImp = new managerDaoImp();
        return managerDaoImp.getAllManager();
    }
}
