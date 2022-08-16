package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int Id;
    @Column(name = "UserName")
    @NotEmpty(message = "Не может быть пустым")
    @Size(min = 1, max = 15, message = "Не более 15 символов")
    private String Name;
    @Column(name = "UserAge")
    @Min(value = 0, message = "Должно быть больше нуля")
    private int Age;

    public User() {
    }

    public User(String name, int age) {
        this.Name = name;
        this.Age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }
}
