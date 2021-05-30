package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> findAllByActivationStatusTrue();

    List<JobAdvertisement> findAllByActivationStatusTrue(Sort sort);

    List<JobAdvertisement> getByActivationStatusTrueAndEmployer_Id(int employerId);

    @Query("Update JobAdvertisement Set activationStatus =: activationStatus where id =: jobAdvertisementId")
    void updateActivationStatus(boolean activationStatus, int jobAdvertisementId);

}