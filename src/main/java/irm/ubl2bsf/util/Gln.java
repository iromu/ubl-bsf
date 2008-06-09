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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Gln {

	private static final String FAILED_TO_DECODE_GLN = "FAILED_TO_DECODE_GLN";
	private static final Logger log = Logger.getLogger(Gln.class);
	private static final Pattern p = Pattern.compile("\\d{7,13}",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);

	public static String parse(final String origin) {
		Gln.log.debug("Input: " + origin);

		final Matcher m = Gln.p.matcher(origin);
		if (m.find()) {
			final String group = m.group(0);
			Gln.log.debug("Output: " + group);
			return group;
		}
		Gln.log.error(Gln.FAILED_TO_DECODE_GLN);
		return Gln.FAILED_TO_DECODE_GLN;
	}
}
