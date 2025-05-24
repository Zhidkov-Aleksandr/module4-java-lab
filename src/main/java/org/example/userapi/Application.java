package org.example.userapi;

import org.example.userapi.model.Role;
import org.example.userapi.model.User;
import org.example.userapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /** Заполняем таблицу пятью пользователями ‒ по одному на каждую роль. */
    @Bean
    CommandLineRunner initData(UserRepository repo) {
        return args -> {
            if (repo.count() == 0) {     // чтобы не дублировать при перезапуске
                repo.save(new User("Ada",      "Lovelace",   Role.DEVELOPER));
                repo.save(new User("Grace",    "Hopper",     Role.TESTER));
                repo.save(new User("Alan",     "Turing",     Role.SYSTEM_ANALYST));
                repo.save(new User("Barbara",  "Liskov",     Role.TEAM_LEAD));
                repo.save(new User("Margaret", "Hamilton",   Role.ADMIN));
            }
        };
    }
}
