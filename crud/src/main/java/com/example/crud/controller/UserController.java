package com.example.crud.controller;
import com.example.crud.dto.LoginDTO;
import com.example.crud.model.BitacoraModel;
import com.example.crud.model.UserModel;
import com.example.crud.repository.IBitacoraRepository;
import com.example.crud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBitacoraRepository bitacoraRepository;

    @GetMapping
    public List<UserModel> listOfUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public UserModel saveUser( @RequestBody UserModel user) {
        return userRepository.save(user);
    }

    @GetMapping("/login")
    public boolean getUserByEmail(@RequestBody LoginDTO loginDTO) {
        UserModel userModel = userRepository.findByEmailAndPwd(loginDTO.getEmail(), loginDTO.getPassword()).orElse(null);
        if (userModel != null){
            BitacoraModel bitacora = new BitacoraModel();
            bitacora.setFechaIngreso(LocalDate.now());
            bitacora.setUser(userModel);
            bitacora.setIsLog(true);
            bitacoraRepository.save(bitacora);
            return true;
        }
        return false;
    }

    @PutMapping("/logout/{id}")
    public String logOut(@PathVariable Long id) {
        BitacoraModel bitacora = bitacoraRepository.findById(id).orElseThrow();

        bitacora.setFechaSalida(LocalDate.now());
        bitacora.setIsLog(false);

        if (bitacora.getIsLog()){
            bitacoraRepository.save(bitacora);
            return "sesion abandonada";
        }
        return "sesion inactiva";
    }

}
