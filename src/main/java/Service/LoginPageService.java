package Service;

import Model.Entity.LoginDetails;
import Repository.LoginPageRepository;

import java.sql.SQLException;

public class LoginPageService {
    private LoginPageRepository loginPageRepository;
    public String loginCheck(String text) throws SQLException {
        LoginDetails loginDetails=loginPageRepository.searchLogin(text);
        return loginDetails.getPassword();
    }
}
