package Login.login.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booknews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate years;

    private String authoris;

    public String getAuthoris() {
        return authoris;
    }

    public void setAuthoris(String authoris) {
        this.authoris = authoris;
    }

    public Booknews () {

    }

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

    public LocalDate getYears() {
        return years;
    }

    public void setYears(LocalDate years) {
        this.years = years;
    }


}
