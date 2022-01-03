package JDBC101.serviceImpl;

import JDBC101.daoImpl.adminDaoImp;
import JDBC101.model.Admin;
import JDBC101.service.adminService;

import java.util.List;


public class AdminServiceImpl implements adminService {
    private adminDaoImp admin = new adminDaoImp();
    @Override
    public void addAdmin(Admin Admin) {
        admin.saveAdmin(Admin);
    }

    @Override
    public Admin fetchAdminById(long id_admin) {



        return admin.getAdmin(id_admin);
    }

    @Override
    public void deleteAdminById(Admin id_admin) {

        // !! variable name

       admin.deleteAdmin(id_admin);




    }

    @Override
    public void updateAdminPasswordById(String newPassword, long id_admin) {

      Admin adminUpdated =   admin.getAdmin(id_admin);

      adminUpdated.setPassword(newPassword);

      admin.updateAdmin(adminUpdated);

    }

    @Override
    public List<Admin> getAllAdmins() {


        return admin.getAllAdmin();
    }
}
