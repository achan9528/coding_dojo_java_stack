package com.codingdojo.countries.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.codingdojo.countries.models.Language.IsOfficial;

@Entity
@Table(name="cities")
public class City {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name;
	private String country_code;
	private String district;
	private int population;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
}
