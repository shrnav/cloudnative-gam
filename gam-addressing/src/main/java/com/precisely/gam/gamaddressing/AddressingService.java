package com.precisely.gam.gamaddressing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.precisely.addressing.v1.Addressing;
import com.precisely.addressing.v1.AddressingException;
import com.precisely.addressing.v1.Preferences;
import com.precisely.addressing.v1.model.FactoryDescriptionBuilder;
import com.precisely.addressing.v1.model.PredictionResponse;
import com.precisely.addressing.v1.model.PredictionResult;
import com.precisely.addressing.v1.model.PreferencesBuilder;
import com.precisely.addressing.v1.model.RequestAddress;
import com.precisely.addressing.v1.model.Result;
import com.precisely.addressing.v1.model.Status;

@RestController
@RequestMapping
@PropertySource("classpath:application.properties")
public class AddressingService {
	private static final Logger log = LoggerFactory.getLogger(AddressingService.class);

	@Value("${ggs.resources.location:/var/lib/ggs/resources}")
	private String m_geocodingResourcesDir;

	@Value("${ggs.data.location:/mnt/ggs_data}")
	private String m_geocodingDataPath;

	@Value("${ggs.gta.data.location:/mnt/ggs_gta_data}")
	private String m_geocodingGTADataPath;

	@Value("${ggs.remote:false}")
	private String m_ggsRemote;

	@Value("${ggs.usa.pool.max.active:0}")
	private int m_usaPoolMaxActive;

	@Autowired
	private Environment environment;

	private com.precisely.addressing.v1.model.Response response;

	Map<String, String> allgtaOptions;

	@GetMapping(value = "/addressing/verify/country/{country}/input/{input}/city/{city}/sp/{sp}/postCode/{postCode}")

	@ResponseBody
	public List<Result> verify(@PathVariable String country, @PathVariable String input, @PathVariable String city,
			@PathVariable String sp, @PathVariable String postCode) throws AddressingException {

		Addressing addressing = null;
		System.out.println("************************Under verify method*********************"
				+ environment.getProperty("local.server.port"));

		try {
			addressing = GAVEngine.getGAVInstance(m_geocodingResourcesDir, m_geocodingDataPath);
		} catch (AddressingException e) {
			e.printStackTrace();
		}

		Map<String, String> custom = new HashMap<>();

		// custom.put("FIND_MATCH_CODE_EXTENDED", "true");
		// custom.put("AMAS_MODE", "false");
		// custom.put("REMOVE_ACCENT_MARKS", "true");
		// custom.put("RETURN_ALT_LANG_FIELDS", "true");

		// custom.put("CASS_Flag", "true");
		// custom.put("VM_DATABLOCK", "true");

		custom.put("SERP_MODE", "false");
//		 custom.put("ReturnPrecision", "true");
		custom.put("RETURN_PARSED_INPUT", "true");
		// custom.put("RETURN_FORMATTED_ADDRESS", "true");

		// PARSED_INPUT_GENERIC_FIELD_1
//		    custom.put("PREFER_POBOX_OVER_STREET",  "true");
//		    custom.put("KEY_POSTAL_CODE_OVERRIDE",  "true");
//		    custom.put("RESULT_CODE",  "true");
		// custom.put("FINALIST_LOG_LEVEL", validationPreferences.getLogLevel());
//		    custom.put("STAND_ALONE_UNIT",  "true");
//		    custom.put("STAND_ALONE_PMB",  "false");
		// custom.put("RETURN_SLK_SECONDARY", "false");
		// custom.put("RETURN_INPUT_FIRM", "false");
		// custom.put("RETURN_ALIAS_STREET_WITH_TYPE", "false");
//		    custom.put("REMOVE_NOISE_CHARS",  "true");
//		    custom.put("R777_DELIVERABLE",  "true");
//		    custom.put("MAILER_NAME",  "true");
//		    custom.put("MAILER_CITY_LINE",  "true");
//		    custom.put("MAILER_ADDRESS4",  "true");
//		    custom.put("MAILER_ADDRESS3", validationPreferences.getMailerAddress3());
//		    custom.put("MAILER_ADDRESS2", validationPreferences.getMailerAddress2());
//		    custom.put("MAILER_ADDRESS1", validationPreferences.getMailerAddress());
//		    custom.put("FIND_RDI", String.valueOf(validationPreferences.isResidentialDeliveryIndicator()));
//		    custom.put("EARLY_WARNING_SYSTEM", String.valueOf(validationPreferences.isEarlyWarningSystem()));
//		    custom.put("DPV_NDD",  "true");
//		    custom.put("DPV_NSL",  "true");
//		    custom.put("DPV_THROWBACK",  "true");
//		    custom.put("DPV_DNA",  "true");
//		    custom.put("DPV_VACANT",  "true");
//		    custom.put("DPV_TIE_BREAK",  "true");
//		    custom.put("DPV_NO_STAT",  "true");
//		    custom.put("DPV_PBSA",  "true");
//		    custom.put("DPV_CMRA",  "true");
		custom.put("ADDRESS_CASING", "LOWER");
		// custom.put("VM_DATA_BLOCK", "true");
//		    custom.put("FIND_SUITELINK", String.valueOf(validationPreferences.isSuiteLinkIndicator()));
//		    custom.put("FIND_LACSLINK", String.valueOf(validationPreferences.isLACSLinkIndicator()));
		// custom.put("FIND_DPV", "true");
//		    custom.put("ALLOW_UPDATE_DEPARTMENT", String.valueOf(validationPreferences.isAllowUpdateDepartment()));
//		    custom.put("ALLOW_UPDATE_PLACE_NAME", String.valueOf(validationPreferences.isAllowUpdatePlaceName()));
//		    custom.put("ALLOW_UPDATE_BUILDING", String.valueOf(validationPreferences.isAllowUpdateBuilding()));
//		    custom.put("ALLOW_UPDATE_SUB_BUILDING", String.valueOf(validationPreferences.isAllowUpdateSubBuilding()));
//		    custom.put("ALLOW_UPDATE_ADDRESS_NUMBER", String.valueOf(validationPreferences.isAllowUpdateAddressNumber()));
//		    custom.put("ALLOW_UPDATE_SUB_STREET", String.valueOf(validationPreferences.isAllowUpdateSubStreet()));
//		    custom.put("ALLOW_UPDATE_STREET_NAME", String.valueOf(validationPreferences.isAllowUpdateStreetName()));
//		    custom.put("ALLOW_UPDATE_POBOX", String.valueOf(validationPreferences.isAllowUpdatePoBox()));
//		    custom.put("ALLOW_UPDATE_NEIGHBORHOOD", String.valueOf(validationPreferences.isAllowUpdateNeighborhood()));
//		    custom.put("ALLOW_UPDATE_CITY", String.valueOf(validationPreferences.isAllowUpdateCity()));
//		    custom.put("ALLOW_UPDATE_ADMIN2", String.valueOf(validationPreferences.isAllowUpdateAdmin2()));
//		    custom.put("ALLOW_UPDATE_ADMIN1", String.valueOf(validationPreferences.isAllowUpdateAdmin1()));
//		    custom.put("ALLOW_UPDATE_PRINCIPALITY", String.valueOf(validationPreferences.isAllowUpdatePrincipality()));
//		    custom.put("ALLOW_UPDATE_POSTAL_CODE", String.valueOf(validationPreferences.isAllowUpdatePostalCode()));
//		    custom.put("ALLOW_UPDATE_POSTAL_CODE_EXT", String.valueOf(validationPreferences.isAllowUpdatePostalCodeExt()));
//		    custom.put("ALLOW_UPDATE_COUNTRY", String.valueOf(validationPreferences.isAllowUpdateCountry()));
//		    custom.put("CARRY_STANDARDISATION_CHANGES", String.valueOf(validationPreferences.isCarryStandardisationChanges()));
//		    custom.put("DEDUPE_COMMON_ERRORS", String.valueOf(validationPreferences.isDedupeCommonErrors()));
//		    custom.put("FIND_PRECISELY_ID", String.valueOf(validationPreferences.isAssignPreciselyId()));
//		    custom.put("FIND_RDI", String.valueOf(validationPreferences.isResidentialDeliveryIndicator()));
		RequestAddress address = new RequestAddress();

		List<String> list = new ArrayList<>();

		if (null != input)
			list.add(input);
		if (null != city)
			address.setCity(city);
		if (null != country)
			address.setCountry(country);
		if (null != list)
			address.setAddressLines(list);
		if (null != postCode)
			address.setPostalCode(postCode);
		if (null != sp)
			address.setAdmin1(sp);
//		

//		Set<String> set = new HashSet<>();
//		set.add("PB_KEY");
//		String[] strAr1=new String[] {"PB_KEY"}; 
		// Hit following URL to get the result.
		// http://localhost:8080/addressing/verify/usa?input=2507%20Ne%20Andresen%20%20Rd%20B&city=Vancouver&sp=WA&postcode=98861
		Preferences preferences = new PreferencesBuilder().withReturnAllInfo(true).withFallbackToPostal(true)

				.withMaxResults(10).withFallbackToGeographic(true)

				.withReturnOfAdditionalFields().withCustomPreferences(custom)

				.withMatchMode("RELAXED")

				.withFactoryDescription(new FactoryDescriptionBuilder().withLabel("ggs")
						// .withFeatureSpecific(new PreferencesBuilder()
						.build())
				.build();

		long startTime = System.currentTimeMillis();
		response = addressing.verify(address, preferences);
		long enfTime = System.currentTimeMillis();
		System.out.println("debug..1");
		log.info("Time taken==" + (enfTime - startTime));

		log.info("status" + response.getStatus());
		// System.out.println("==================="+response.getResults().get(0).getExplanation().getSource());
		if (response.getStatus() == Status.OK) {

			System.out.println("resp==" + response.getResults().size());

			return response.getResults();
		}

		return null;
	}

	@GetMapping(value = "/addressing/predict/options/{gtaOptions}")
	@ResponseBody
	public Map<String, String> getGTAOptions(@PathVariable Map<String, String> gtaOptions) {
		allgtaOptions = new HashMap<>();
		allgtaOptions = gtaOptions;
		allgtaOptions = convertStringIntoMap(allgtaOptions.get("gtaOptions"));

		return allgtaOptions;
	}

	private Map<String, String> convertStringIntoMap(String input) {
		Map<String, String> result = new HashMap<>();
		String[] pairs = input.split(","); // Split by comma to get key-value pairs

		for (String pair : pairs) {
			String[] keyValue = pair.split("=", 2); // Split each pair by '='
			if (keyValue.length == 2) { // Ensure valid key-value pair
				result.put(keyValue[0].trim(), keyValue[1].trim());
			}
		}

		// Print the resulting map
		System.out.println(result);
		return result;
	}

	@GetMapping(value = "/addressing/predict/country/{country}/input/{input}/city/{city}/sp/{sp}/postCode/{postCode}")
	@ResponseBody
	public List<PredictionResult> predict(@PathVariable String country, @PathVariable String input,
			@PathVariable String city, @PathVariable String sp, @PathVariable String postCode)
			throws AddressingException {

		Addressing addressing = null;
		System.out.println("************************Under predict method*********************"
				+ environment.getProperty("local.server.port"));

		try {
			addressing = GAVEngine.getGTAInstance(m_geocodingResourcesDir, m_geocodingGTADataPath);
		} catch (AddressingException e) {
			e.printStackTrace();
		}
		Map<String, String> custom = new HashMap<>();
		// custom = allgtaOptions;
		if (null != allgtaOptions) {
			custom.putAll(allgtaOptions);
			System.out.println("custom.get(\"ADDRESS_CASING\")===" + allgtaOptions.get("ADDRESS_CASING"));
		} else {
			custom.put("EXPANDED_RANGE_UNIT", "true");
			custom.put("SEARCH_TYPE", "ADDRESS_COMPLETION");
			custom.put("COMPRESSED_AREA_RESULT", "false");
			custom.put("SEARCH_UNIT_INFORMATION", "true");
			custom.put("RETURN_PARSED_INPUT", "true");
			custom.put("FALLBACK_TO_WORLD", "true");
			custom.put("PREFER_POBOX_OVER_STREET", "false");
			custom.put("KEY_POSTAL_CODE_OVERRIDE", "false");
			custom.put("ADDRESS_CASING", "UPPER");
		}

		RequestAddress address = new RequestAddress();

		List<String> list = new ArrayList<>();

		if (null != input) {
			list.add(input);
			address.setAddressLines(list);
		}
		// list.add("NE12 9RF");
		if (null != city)
			address.setCity(city);
		if (null != country)
			address.setCountry(country);

		Preferences preferences = new PreferencesBuilder().withReturnAllInfo(true).withMaxResults(5)
				// .withFallbackToGeographic(true)
				.withReturnOfAdditionalFields().withCustomPreferences(custom).withMatchMode("RELAXED")
				.withReturnAllInfo(true).withFactoryDescription(new FactoryDescriptionBuilder().withLabel("ggs")
						// .withFeatureSpecific(new PreferencesBuilder()
						.build())
				.build();

		long startTime = System.currentTimeMillis();
		PredictionResponse response = addressing.predict(address, preferences);
		long enfTime = System.currentTimeMillis();
		log.info("Time taken==" + (enfTime - startTime));

		log.info("status" + response.getStatus());
		if (response.getStatus() == Status.OK) {

			System.out.println("==" + response.getPredictions().size());

			return response.getPredictions();
		}

		try {
			addressing.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// Docker push comnad
	// docker push
	// registry.gitlab.com/navneet.shrivastava/test/registry.gitlab.com/navneet.shrivastava/test/gav-api-poc:2021-12-19_093822793
//Docker command to run the image
	// docker run -p 8080:8080 -v
	// C:\Office_Work\GAV_LATEST_SPD\GAV_US_NON_DOM_082021:/mnt/ggs_data -v
	// C:\Office_Work\cloudnative-geocoding-release\docker\geocoding-custom\target\dependencies\modules\GlobalAddressValidation\resources:/var/lib/ggs/resources
	// registry.gitlab.com/navneet.shrivastava/test/gav-api-poc:2021-12-19_095954431
//  @JsonComponent
//  private static class CandidateJsonSerializer extends JsonSerializer<Result> {
//	  //String port = environment.getProperty("server.port");
//		//currencyExchange.setEnvironment(port);
//	 @Autowired
//	 Environment enviorenment;
//  	@Override
//  	public void serialize(Result value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//  		// output a limited set of data from the candidate
//  		gen.writeStartObject();
//  		//gen.writeString(value.getAddress().toString());
//  		gen.writeStringField("FormattedAddress", value.getAddress().getFormattedAddress());
//  		gen.writeStringField("formattedStreetAddress", value.getAddress().getFormattedStreetAddress());
//  		gen.writeStringField("FormattedLocationAddress", value.getAddress().getFormattedLocationAddress());
//  		gen.writeStringField("AreaName1", value.getAddress().getAdmin1()!=null?value.getAddress().getAdmin1().getLongName():"");
//  		gen.writeStringField("AreaName2", value.getAddress().getAdmin2()!=null?value.getAddress().getAdmin2().getLongName():"");
//  		gen.writeStringField("Confidence", value.getScore()!=null?value.getScore().toString():"");
//  		gen.writeStringField("Port",enviorenment.getProperty("local.server.port") );
//  		gen.writeEndObject();
//  	}
//  }

	@GetMapping("/hello/{country}")
	public String hello(@PathVariable String country) {
		return country;
	}

}
