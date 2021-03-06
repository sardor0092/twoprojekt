package Login.login.demo;
import Login.login.demo.entity.Lavozim;
import Login.login.demo.entity.User;
import Login.login.demo.repository.UserRepository;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;


@SpringBootApplication
public class LoginDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(LoginDemoApplication.class, args);}







    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Optional<User> uk = userRepository.findByLogin("admin123");
        if(!uk.isPresent()){
            User u = new User();
            u.setIsm("admin");
            u.setFamiliya("Admin");
            u.setLogin("admin123");
            u.setParol(passwordEncoder.encode("admin123"));
            u.setAktiv(true);
            HashSet<Lavozim> adn =  new HashSet<Lavozim>();
            adn.add(Lavozim.ADMIN);
            u.setLavozimlar(adn);
            userRepository.save(u);
        }
    }
    }

