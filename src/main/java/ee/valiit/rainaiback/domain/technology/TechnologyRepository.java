package ee.valiit.rainaiback.domain.technology;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    @Query("select (count(t) > 0) from Technology t where t.name = ?1")
    boolean existsByName(String name);
    @Query("select t from Technology t where (t.packageType.id = ?1 or ?1 = 0) and t.status = ?2")
    List<Technology> findTechnologiesBy(Integer id, String status);








}