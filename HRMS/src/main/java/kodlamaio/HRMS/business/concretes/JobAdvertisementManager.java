package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private final JobAdvertisementDao jobAdvertisementDao;
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<>(jobAdvertisementDao.findAll(),"All job advertisements have been listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActives() {
		return new SuccessDataResult<>(jobAdvertisementDao.findAllByActivationStatusTrue(),"Job Advertisements Have Listed.");
	}

	
	@Override
    public DataResult<List<JobAdvertisement>> getAllActivesSortedByDate(int sortDirection) {
        Sort sort;
        if (sortDirection < 0) {
            sort = Sort.by(Sort.Direction.DESC, "createdAt");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "createdAt");
        }
        return new SuccessDataResult<>(jobAdvertisementDao.findAllByActivationStatusTrue(sort),"Job Advertisements Have Sorted By Date.");
        
    }
	@Override
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployer_Id(int employerId) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByActivationStatusTrueAndEmployer_Id(employerId),"Success");
    }
	
	@Override
    public Result add(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Advertisement has been added successfully.");
    }

	@Override
    public Result updateActivationStatus(boolean isActive, int jobAdvertisementId) {
        jobAdvertisementDao.updateActivationStatus(isActive, jobAdvertisementId);
        return new SuccessResult("Advertisement's activation status has been updated successfully");
    }
}
