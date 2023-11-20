package com.bbva.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill implements Serializable {
	
	private Integer id;
	
	private Date date_bill;
	
	private User user_id;
	
	private Integer value;
	
	private Integer type;
	
	private String observation;
}
