package twgl.com.helloAws.domain.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "insert_date", nullable = false)
    private Timestamp insertDate;

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
    
    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }
}