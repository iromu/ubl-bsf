//      Copyright 2008 Ivan Rodriguez Murillo
//	
//	Licensed under the Apache License, Version 2.0 (the "License");
//	you may not use this file except in compliance with the License.
//	You may obtain a copy of the License at
//	
//	http://www.apache.org/licenses/LICENSE-2.0
//	
//	Unless required by applicable law or agreed to in writing, software
//	distributed under the License is distributed on an "AS IS" BASIS,
//	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//	See the License for the specific language governing permissions and
//	limitations under the License.
package irm.ubl2bsf.util;

import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;

public class Country {
	private static final String FAILED_TO_DECODE_COUNTRY = "FAILED_TO_DECODE_COUNTRY";

	private static final Logger log = Logger.getLogger(Country.class);

	public static final Map<String, String> decode = new Hashtable<String, String>();

	static {
		Country.decode.put("España".toUpperCase(), "ESP");
		Country.decode.put("Alemania".toUpperCase(), "DEU");
		Country.decode.put("Portugal".toUpperCase(), "PRT");
		Country.decode.put("Reino Unido".toUpperCase(), "GBR");
		Country.decode.put("Estados Unidos".toUpperCase(), "USA");
		Country.decode.put("Francia, Metropolitana".toUpperCase(), "FXX");
		Country.decode.put("Francia".toUpperCase(), "FXX");
		Country.log.debug(Country.decode);
	}

	public static String parse(final String origin) {
		final String key = origin.toUpperCase();
		if (Country.decode.containsKey(key)) {
			return Country.decode.get(key);
		}
		Country.log.error(Country.FAILED_TO_DECODE_COUNTRY + ": " + origin);
		return Country.FAILED_TO_DECODE_COUNTRY;
	}
}
