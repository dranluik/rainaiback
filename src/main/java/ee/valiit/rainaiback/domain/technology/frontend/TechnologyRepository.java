package ee.valiit.rainaiback.domain.technology.frontend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

    Technology getReferenceById(Integer id);

    @Query("select t from Technology t where t.packageType.id = ?1")
    Technology findByPackageTypeId(Integer id);

}