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

import org.apache.log4j.Logger;

public class Payment {

	private static final String CONFIRMING = "Confirming";
	private static final String FAILED_TO_DECODE_PAYMENT_MEAN = "FAILED_TO_DECODE_PAYMENT_MEAN";
	private static final Logger log = Logger.getLogger(Payment.class);

	public static String parseMean(final String origin) {

		if (origin.contains(Payment.CONFIRMING)) {
			return Payment.CONFIRMING;
		}
		Payment.log.error(Payment.FAILED_TO_DECODE_PAYMENT_MEAN);
		return Payment.FAILED_TO_DECODE_PAYMENT_MEAN;
	}
}
