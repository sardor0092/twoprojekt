package Login.login.demo.service.Impl;

import Login.login.demo.entity.Lavozim;
import Login.login.demo.entity.User;
import Login.login.demo.repository.UserRepository;
import Login.login.demo.service.dto.UserDTO;
import Login.login.demo.service.vm.UserParolVM;
import Login.login.demo.service.vm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public List<UserDTO> getAll() {

        return userRepository.findAllByLavozimlarContains(Lavozim.MANAGER).
                stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getById(Long id) {
        return userRepository.findById(id).map(UserDTO::new);
    }



    @Override
    public Optional<User> getByIdEntity(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getCurrentUserEntity(){
        String username = getPrincipal();
        if (username != null)
            return userRepository.findByLogin(username).orElse(null);
        return null;
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }



    @Override
    public UserDTO create(User user) {
        user.setParol(encoder.encode(user.getParol()));
        HashSet<Lavozim> hs = new HashSet<>();
        hs.add(Lavozim.MANAGER);
        user.setLavozimlar(hs);
        return new UserDTO(userRepository.save(user));

    }

    @Override
    public UserDTO update(User user) {

        return new UserDTO(userRepository.save(user));

    }


    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }
    @Override
    public void changePassword(UserParolVM userParolVM) {
        Optional<User> user = userRepository.findByLogin(userParolVM.getLogin());
        if(user.isPresent() && user.get().getParol().equals(userParolVM.getEskiParol())){
            user.get().setParol(userParolVM.getYangiParol());
            userRepository.save(user.get());
        } else {
            throw new RuntimeException("xatolik ro'y berdi");
        }

    }

    @Override
    public UserDTO getCurrentUser(){
        String username = getPrincipal();
        if (username != null)
            return userRepository.findByLogin(username).map(UserDTO::new).orElse(null);
        return null;
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public String getCurrentLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}