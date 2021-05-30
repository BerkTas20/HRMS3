package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(name = "api/job-advertisements")
public class JobAdvertisementsController {
	private final JobAdvertisementService jobAdvertisementService;

    @GetMapping("getAll")
    DataResult<List<JobAdvertisement>> getAll() {
        return jobAdvertisementService.getAll();
    }

    @GetMapping("getAllActives")
    DataResult<List<JobAdvertisement>> getAllActives() {
        return jobAdvertisementService.getAllActives();
    }

    @GetMapping("getAllActivesSortedByDate")
    DataResult<List<JobAdvertisement>> getAllActivesSortedByDate(@RequestParam int sortDirection) {
        return jobAdvertisementService.getAllActivesSortedByDate(sortDirection);
    }

    @GetMapping("getByActivationStatusAndEmployerId")
    DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployer_Id(@RequestParam int employerId) {
        return jobAdvertisementService.getByActiveTrueAndEmployer_Id(employerId);
    }

    @PostMapping("add")
    Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return jobAdvertisementService.add(jobAdvertisement);
    }

    @PostMapping("updateActivationStatus")
    Result updateActivationStatus(@RequestParam boolean isActive, @RequestParam int jobAdvertisementId) {
        return jobAdvertisementService.updateActivationStatus(isActive, jobAdvertisementId);
    }

}

