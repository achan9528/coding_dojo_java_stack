package com.codingdojo.countries.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.codingdojo.countries.models.Country.Continent;

@Entity
@Table(name="languages")
public class Language {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String country_code;
	private String language;
	private IsOfficial is_official;
	private double percentage;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
	public enum IsOfficial{
		T, F
	}
	
}
