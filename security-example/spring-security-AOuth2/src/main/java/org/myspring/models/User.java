package org.myspring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	protected Long id;
	
	@NotNull
	@Pattern(regexp="^[a-z0-9]*$")
	@Size(min=1,max=50)
	@Column(name="user_name",length=50,unique=true,nullable=false)
	private String userName;
	
	@NotNull
	@Size(min=8,max=60)
	@Column(name="password",length=60)
	private String password;
	
	@Email
	@Column(nullable=false,unique=true)
	private String email;
	

}
