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
package irm.ubl2bsf;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;

public class Parser {
	private final Logger log = Logger.getLogger(this.getClass());
	private javax.xml.transform.Transformer transformer;

	public Parser(String xsl) {
		javax.xml.transform.TransformerFactory tFactory = javax.xml.transform.TransformerFactory
				.newInstance();
		try {
			InputStream stream = this.getClass().getClassLoader()
					.getResourceAsStream(xsl);
			transformer = tFactory
					.newTransformer(new javax.xml.transform.stream.StreamSource(
							stream));
		} catch (TransformerConfigurationException e) {
			log.fatal(e, e);
		}
	}

	public void parse(String input, String output) {

		try {
			javax.xml.transform.stream.StreamSource streamSource = new javax.xml.transform.stream.StreamSource(
					input);
			javax.xml.transform.stream.StreamResult streamResult = new javax.xml.transform.stream.StreamResult(
					new java.io.FileOutputStream(output));
			transformer.transform(streamSource, streamResult);
		} catch (FileNotFoundException e) {
			log.fatal(e, e);
		} catch (TransformerException e) {
			log.fatal(e, e);
		}
	}
}
