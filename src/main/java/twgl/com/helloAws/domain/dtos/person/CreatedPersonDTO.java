package twgl.com.helloAws.domain.dtos.person;

import java.sql.Timestamp;

public class CreatedPersonDTO {
    private Long id;    
    private String name;
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
