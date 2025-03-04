package com.example.tacos.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import com.example.tacos.Taco;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TacoOrder {
	@NotBlank(message="Delivery Name is required")
	private String deliveryName;
	@NotBlank(message="Delivery Street is required")	
	private String deliveryStreet;
	@NotBlank(message="Delivery City is required")
	private String deliveryCity;
	@NotBlank(message="Delivery State is required")
	private String deliveryState;
	@NotBlank(message="Delivery Zip is required")
	private String deliveryZip;
	@CreditCardNumber(message="card No. is required")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",message="Must be formatted MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0,message="CVV is required")
	private String ccCVV;
	
	private List<Taco> tacos = new ArrayList<>();
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}
	

}
