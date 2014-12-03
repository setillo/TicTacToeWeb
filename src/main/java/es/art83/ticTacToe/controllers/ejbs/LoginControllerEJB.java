package es.art83.ticTacToe.controllers.ejbs;

import javax.faces.bean.ManagedBean;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.UserEntity;

@ManagedBean(name = "loginController")
public class LoginControllerEJB implements LoginController {

    @Override
    public boolean read(UserEntity user) {
        UserEntity userBD = DAOFactory.getFactory().getUserDAO().read(user.getUser());
        if (userBD == null) {
            return false;
        } else {
            return userBD.getPassword().equals(user.getPassword());
        }
    }

    @Override
    public boolean create(UserEntity user) {
        UserEntity userBD = DAOFactory.getFactory().getUserDAO().read(user.getUser());
        if (userBD != null) {
            return false;
        } else {
            DAOFactory.getFactory().getUserDAO().create(user);
            return true;
        }
    }

}
