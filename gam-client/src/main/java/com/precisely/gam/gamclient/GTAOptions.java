package com.precisely.gam.gamclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GTAOptions {

	private String expandedRangeUnit;
	private String searchType;
	private String compressedAreaResult;
	private String searchunitInformation;
	private String returnParsedInput;
	private String fallbacktoWorld;
	private String preferPOBoxOverStreet;
	private String keyPostalCodeOverride;
	private String addressCasing;

	public GTAOptions(String expandedRangeUnit, String searchType, String compressedAreaResult,
			String searchunitInformation, String returnParsedInput, String fallbacktoWorld,
			String preferPOBoxOverStreet, String keyPostalCodeOverride, String addressCasing) {
		super();
		this.expandedRangeUnit = expandedRangeUnit;
		this.searchType = searchType;
		this.compressedAreaResult = compressedAreaResult;
		this.searchunitInformation = searchunitInformation;
		this.returnParsedInput = returnParsedInput;
		this.fallbacktoWorld = fallbacktoWorld;
		this.preferPOBoxOverStreet = preferPOBoxOverStreet;
		this.keyPostalCodeOverride = keyPostalCodeOverride;
		this.addressCasing = addressCasing;
	}

	public Map<String,String> toMap() {
		
		GTAOptions gtaOptions = new GTAOptions(expandedRangeUnit, searchType, compressedAreaResult, searchunitInformation, returnParsedInput, fallbacktoWorld, preferPOBoxOverStreet, keyPostalCodeOverride, addressCasing);
		HashMap<String,String> custom = new HashMap<>();
		
		
		 custom.put("EXPANDED_RANGE_UNIT", gtaOptions.getExpandedRangeUnit());
		 custom.put("SEARCH_TYPE", gtaOptions.getSearchType());
		 custom.put("COMPRESSED_AREA_RESULT", gtaOptions.getCompressedAreaResult());
		 custom.put("SEARCH_UNIT_INFORMATION", gtaOptions.getSearchunitInformation());
		 custom.put("RETURN_PARSED_INPUT", gtaOptions.getReturnParsedInput());
		 custom.put("FALLBACK_TO_WORLD", gtaOptions.getFallbacktoWorld());
		 custom.put("PREFER_POBOX_OVER_STREET", gtaOptions.getPreferPOBoxOverStreet());   
		 custom.put("KEY_POSTAL_CODE_OVERRIDE", gtaOptions.getKeyPostalCodeOverride());
		 custom.put("ADDRESS_CASING",  gtaOptions.getAddressCasing());		

		return custom;
	}

	public String getExpandedRangeUnit() {
		return expandedRangeUnit;
	}

	public void setExpandedRangeUnit(String expandedRangeUnit) {
		this.expandedRangeUnit = expandedRangeUnit;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getCompressedAreaResult() {
		return compressedAreaResult;
	}

	public void setCompressedAreaResult(String compressedAreaResult) {
		this.compressedAreaResult = compressedAreaResult;
	}

	public String getSearchunitInformation() {
		return searchunitInformation;
	}

	public void setSearchunitInformation(String searchunitInformation) {
		this.searchunitInformation = searchunitInformation;
	}

	public String getReturnParsedInput() {
		return returnParsedInput;
	}

	public void setReturnParsedInput(String returnParsedInput) {
		this.returnParsedInput = returnParsedInput;
	}

	public String getFallbacktoWorld() {
		return fallbacktoWorld;
	}

	public void setFallbacktoWorld(String fallbacktoWorld) {
		this.fallbacktoWorld = fallbacktoWorld;
	}

	public String getPreferPOBoxOverStreet() {
		return preferPOBoxOverStreet;
	}

	public void setPreferPOBoxOverStreet(String preferPOBoxOverStreet) {
		this.preferPOBoxOverStreet = preferPOBoxOverStreet;
	}

	public String getKeyPostalCodeOverride() {
		return keyPostalCodeOverride;
	}

	public void setKeyPostalCodeOverride(String keyPostalCodeOverride) {
		this.keyPostalCodeOverride = keyPostalCodeOverride;
	}

	public String getAddressCasing() {
		return addressCasing;
	}

	public void setAddressCasing(String addressCasing) {
		this.addressCasing = addressCasing;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressCasing, compressedAreaResult, expandedRangeUnit, fallbacktoWorld,
				keyPostalCodeOverride, preferPOBoxOverStreet, returnParsedInput, searchType, searchunitInformation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GTAOptions other = (GTAOptions) obj;
		return Objects.equals(addressCasing, other.addressCasing)
				&& Objects.equals(compressedAreaResult, other.compressedAreaResult)
				&& Objects.equals(expandedRangeUnit, other.expandedRangeUnit)
				&& Objects.equals(fallbacktoWorld, other.fallbacktoWorld)
				&& Objects.equals(keyPostalCodeOverride, other.keyPostalCodeOverride)
				&& Objects.equals(preferPOBoxOverStreet, other.preferPOBoxOverStreet)
				&& Objects.equals(returnParsedInput, other.returnParsedInput)
				&& Objects.equals(searchType, other.searchType)
				&& Objects.equals(searchunitInformation, other.searchunitInformation);
	}

	@Override
	public String toString() {
		return "GTAOptions [expandedRangeUnit=" + expandedRangeUnit + ", searchType=" + searchType
				+ ", compressedAreaResult=" + compressedAreaResult + ", searchunitInformation=" + searchunitInformation
				+ ", returnParsedInput=" + returnParsedInput + ", fallbacktoWorld=" + fallbacktoWorld
				+ ", preferPOBoxOverStreet=" + preferPOBoxOverStreet + ", keyPostalCodeOverride="
				+ keyPostalCodeOverride + ", addressCasing=" + addressCasing + "]";
	}

}
