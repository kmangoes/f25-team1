package com.example.demo.backend;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    @Query("SELECT a FROM Events a WHERE a.eventName LIKE %?1%")
    List<Events> getEventByName(String eventName);
@Query("""
    SELECT e FROM Events e
    WHERE 
        :user NOT MEMBER OF e.attendees
    AND (
        e.creator IS NULL 
        OR e.creator.userId <> :uid
    )
""")
List<Events> findAllWhereUserNotAttending(@Param("user") User user, @Param("uid") Long uid);

}
