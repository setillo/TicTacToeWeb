package es.art83.ticTacToe.controller.ejb;

import javax.faces.bean.ManagedBean;

import es.art83.ticTacToe.controller.Login;
import es.art83.ticTacToe.model.dao.DAOFactory;
import es.art83.ticTacToe.model.entities.User;

@ManagedBean(name = "login")
public class LoginEJB implements Login {

    @Override
    public boolean read(User user) {
        User userBD = DAOFactory.getFactory().getUserDAO().read(user.getUser());
        if (userBD == null) {
            return false;
        } else {
            return userBD.getPassword().equals(user.getPassword());
        }
    }

    @Override
    public boolean create(User user) {
        User userBD = DAOFactory.getFactory().getUserDAO().read(user.getUser());
        if (userBD != null) {
            return false;
        } else {
            DAOFactory.getFactory().getUserDAO().create(user);
            return true;
        }
    }

}
