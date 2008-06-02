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

import java.io.File;

/**
 * @author wantez
 * 
 */
public class Batch {

	private static final String ADAPTER_XSL = "ubl2bsf-adapter.xsl";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (args == null || args.length == 0) {
				System.err.println("BAD PARAMETERS");
				System.exit(-1);
			}
			String importdir;
			String exportdir;
			importdir = args[1];
			exportdir = args[3];
			final Batch batch = new Batch();
			batch.run(ADAPTER_XSL, importdir, exportdir);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void run(String style, String input, String output) {
		final Parser parser = new Parser(style);
		final File in = new File(input);
		final File out = new File(output);
		final boolean isInDir = in.isDirectory();
		final boolean isOutDir = out.isDirectory();
		if (isInDir && isOutDir) {
			final String[] children = in.list();
			for (int i = 0; i < children.length; i++) {
				parser.parse(new File(in, children[i]).getAbsolutePath(),
						new File(out, children[i]).getAbsolutePath());
			}
		} else if (!isInDir && !isOutDir) {
			parser.parse(input, output);
		} else {
			System.err.println("BAD PARAMETERS");
		}
	}

}
