package org.example.servermodule.Repository;

import org.example.servermodule.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface userRepo extends JpaRepository<User, Long>{

    @Query(value = "select * from user where id = ?1", nativeQuery = true)
    User findById(long id);

    @Query(value = "delete from user where id = ?1", nativeQuery=true)
    int deleteById(long id);

    @Modifying
    @Query(value = "update user set name= :name, phno= :phno, email= :email, mode= :mode, date= :date where  id = :id",
    nativeQuery = true)
    int findByUser(@Param("id") Long id,@Param("name")
                    String name, @Param("phno")
                    Long phno, @Param("email") String email,
                   @Param("mode") String mode,
                   @Param("date") LocalDate date);


}
