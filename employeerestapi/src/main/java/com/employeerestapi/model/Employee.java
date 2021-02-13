package com.employeerestapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data//to get the getters and setters
@NoArgsConstructor
@Entity
@Table(name = "employees")//for table
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;//for employee id
	@NotBlank(message = "first name should not be blank")
	private String firstName;//for employee first name
	@NotBlank(message = "last name should not be blank")
	private String lastName;//for employee last name
	@NotBlank(message = "email should not be blank")
	@Email(message = "email should be valid")
	private String emailId;//for employee email id
	public Employee(@NotBlank(message = "first name should not be blank") String firstName,
			@NotBlank(message = "last name should not be blank") String lastName,
			@NotBlank(message = "email should not be blank") @Email(message = "email should be valid") String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	
}