package ee.valiit.rainaiback.domain.technology.frontend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    @Query("select t from Technology t where t.status = ?1")
    List<Technology> findTechnologiesBy(String status);





}