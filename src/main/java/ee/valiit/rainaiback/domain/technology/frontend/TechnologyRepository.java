package ee.valiit.rainaiback.domain.technology.frontend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    @Query("select t from Technology t where t.packageType.id = ?1 and t.status = ?2")
    List<Technology> findTechnologiesBy(Integer id, String status);






}