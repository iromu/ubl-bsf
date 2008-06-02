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
	private static final Logger log = Logger.getLogger(Country.class);

	public static final Map<String, String> decode = new Hashtable<String, String>();
	
	static {
		decode.put("España".toUpperCase(), "ESP");
		decode.put("Alemania".toUpperCase(), "DEU");
		decode.put("Portugal".toUpperCase(), "PRT");
		decode.put("Reino Unido".toUpperCase(), "GBR");
		decode.put("Estados Unidos".toUpperCase(), "USA");
		decode.put("Francia, Metropolitana".toUpperCase(), "FXX");
		decode.put("Francia".toUpperCase(), "FXX");
		log.debug(decode);
	}

	public static String parse(final String origin) {
		final String key = origin.toUpperCase();
		if (Country.decode.containsKey(key))
			return decode.get(key);
		return "FAILED_TO_DECODE_COUNTRY";
	}
}
