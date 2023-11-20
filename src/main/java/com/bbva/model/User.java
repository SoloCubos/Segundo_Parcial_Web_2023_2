package com.bbva.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	
	private Integer id;
	
	private String username;
	
	private String pass;
	
	private String email;

	
	
}
