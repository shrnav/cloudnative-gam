package com.precisely.gam.gamaddressing;

import com.precisely.addressing.AddressingBuilder;
import com.precisely.addressing.configuration.AddressingConfiguration;
import com.precisely.addressing.configuration.AddressingConfigurationBuilder;
import com.precisely.addressing.configuration.datasources.FileDataSource;
import com.precisely.addressing.v1.Addressing;
import com.precisely.addressing.v1.AddressingException;

import java.nio.file.Paths;

public class GAVEngine {
	static Addressing gavAddressing = null;
	static Addressing gtaAddressing = null;

	public GAVEngine() {

	}

	public static Addressing getGAVInstance(String m_geocodingResourcesDir, String m_geocodingDataPath)
			throws AddressingException {

	//	if (null == gavAddressing  ) {
			System.out.println("m_geocodingDataPath=="+m_geocodingDataPath);
			AddressingConfigurationBuilder addressingConfigurationBuilder = new AddressingConfigurationBuilder();
			addressingConfigurationBuilder.withData(new FileDataSource(Paths.get(m_geocodingDataPath)));
			addressingConfigurationBuilder.withResources(Paths.get(m_geocodingResourcesDir));
//			addressingConfigurationBuilder.withRuntimeLib(Paths
//        .get("/gav_new_lib/lib"));
			AddressingConfiguration addressingConfiguration = addressingConfigurationBuilder.build();
			gavAddressing = new AddressingBuilder().withConfiguration(addressingConfiguration).build();
		//}
		return gavAddressing;
	}
	
	public static Addressing getGTAInstance(String m_geocodingResourcesDir,String m_geocodingGTADataPath)
			throws AddressingException {

		//if (null == gtaAddressing  ) {
			System.out.println("m_geocodingGTADataPath=="+m_geocodingGTADataPath);
			AddressingConfigurationBuilder addressingConfigurationBuilder = new AddressingConfigurationBuilder();
			addressingConfigurationBuilder.withData(new FileDataSource(Paths.get(m_geocodingGTADataPath)));
			addressingConfigurationBuilder.withResources(Paths.get(m_geocodingResourcesDir));
//			addressingConfigurationBuilder.withRuntimeLib(Paths
//        .get("/gav_new_lib/lib"));
			AddressingConfiguration addressingConfiguration = addressingConfigurationBuilder.build();
			gtaAddressing = new AddressingBuilder().withConfiguration(addressingConfiguration).build();
		//}
		return gtaAddressing;
	}
}
