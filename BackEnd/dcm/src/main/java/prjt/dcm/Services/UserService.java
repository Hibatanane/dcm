package prjt.dcm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjt.dcm.Entities.User;
import prjt.dcm.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String login(String email, String mdp) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            return "Utilisateur introuvable";
        } else if (!user.getMdp().equals(mdp)) {
            return "Mdp incorrect";
        }
        return "succes";
    }

}
