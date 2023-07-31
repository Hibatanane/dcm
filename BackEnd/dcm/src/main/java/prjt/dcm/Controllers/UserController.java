package prjt.dcm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prjt.dcm.Dao.UserDao;
import prjt.dcm.Services.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/connexion")
    ResponseEntity<String> login(@RequestParam String email,@RequestParam String mdp) {
        String rep = userService.login(email,mdp);
        System.out.println("email : "+email+" mdp : "+mdp);
        if (rep.equals("Utilisateur introuvable"))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else if (rep.equals("Mdp incorrect"))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        else
            return ResponseEntity.status(HttpStatus.OK).build();
    }

}
