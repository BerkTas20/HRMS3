package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


@Service
public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllActives();

    DataResult<List<JobAdvertisement>> getAllActivesSortedByDate(int sortDirection);

    DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployer_Id(int employerId);

    Result add(JobAdvertisement jobAdvertisement);

    Result updateActivationStatus(boolean isActive, int id);
}
