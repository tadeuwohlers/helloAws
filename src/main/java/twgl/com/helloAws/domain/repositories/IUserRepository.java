package twgl.com.helloAws.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import twgl.com.helloAws.domain.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> { 
    
    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    User findByUsername(@Param("userName") String userName);

}