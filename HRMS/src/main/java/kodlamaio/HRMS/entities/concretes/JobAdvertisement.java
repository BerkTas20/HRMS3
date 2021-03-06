package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

	    @Id
	    @Column(name = "id")
	    private int id;

	    @ManyToOne
	    @JoinColumn(name = "employer_id")
	    private Employer employer;

	    @ManyToOne
	    @JoinColumn(name = "position_id")
	    private Position position;

	    @Column(name = "job_description")
	    private String jobDescription;

	    @ManyToOne
	    @JoinColumn(name = "city_id")
	    private City city;

	    @JsonIgnore
	    @Column(name = "min_salary")
	    private double minSalary;

	    @JsonIgnore
	    @Column(name = "max_salary")
	    private double maxSalary;

	    @Column(name = "number_of_people_to_be_hired")
	    private short numberOfPeopleToBeHired;

	    @Column(name = "application_deadline")
	    private LocalDate applicationDeadline;

	    @JsonIgnore
	    @Column(name = "is_active")
	    private boolean activationStatus;

	    @JsonIgnore
	    @Column(name = "created_at")
	    private LocalDate createdAt;

	
}
