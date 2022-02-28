package Login.login.demo.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TopBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String authoris;
    private LocalDate years;

    public TopBooks() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthoris() {
        return authoris;
    }

    public void setAuthoris(String authoris) {
        this.authoris = authoris;
    }

    public LocalDate getYears() {
        return years;
    }

    public void setYears(LocalDate years) {
        this.years = years;
    }
}
