package com.restservices.model;

import java.util.List;

public class VehicleType {
	private String id;
	private String name;
	private String description;
	private List<String> features;

	public VehicleType() {

	}

	public VehicleType(String id, String name, String description, List<String> features) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.features = features;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public List<String> getFeatures() {
		return features;
	}

	@Override
	public String toString() {
		return String.format(
				"VehicleType [id=%s, name=%s, description=%s, steps=%s]", id, name,
				description, features);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleType other = (VehicleType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
