package Login.login.demo.controller;

import Login.login.demo.entity.User;
import Login.login.demo.repository.UserRepository;
import Login.login.demo.security.JwtTokenUtil;
import Login.login.demo.security.Token;
import Login.login.demo.security.UserMaxsus;
import Login.login.demo.security.UserProvider;
import Login.login.demo.service.dto.UserDTO;
import Login.login.demo.service.vm.UserParolVM;
import Login.login.demo.service.vm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    UserProvider userProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/authenticate")
    public ResponseEntity<Token> login(@RequestBody UserMaxsus userMaxsus) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userMaxsus.getUsername(), userMaxsus.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        UserDetails userDetails = userProvider.loadUserByUsername(userMaxsus.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails, true);
        return ResponseEntity.ok(new Token(token));

    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody User userDTO) {
        if (userDTO.getId() != null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @GetMapping()
    public ResponseEntity<UserDTO> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO) {
        User current = userService.getCurrentUserEntity();
        current.setIsm(userDTO.getIsm());
        current.setFamiliya(userDTO.getFamiliya());


        return userService.update(current);
    }

    @PutMapping("/password")
    public ResponseEntity<?> updatePassword(@RequestBody UserParolVM parol) {

        User current = userService.getCurrentUserEntity();
        if (current.getParol().equals(encoder.encode((parol.getEskiParol())))) {
            current.setParol(encoder.encode(parol.getYangiParol()));
            return ResponseEntity.ok(userService.update(current));

        }
        return ResponseEntity.badRequest().build();
    }
}