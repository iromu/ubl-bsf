package test;

import irm.ubl2bsf.Parser;

import java.io.File;

import org.junit.Test;

public class MainTest {

	private static final String ADAPTER_XSL = "ubl2bsf-adapter.xsl";

	@Test
	public final void test5() {
		Parser main = new Parser(ADAPTER_XSL);
		try {
			File dir = new File("target/test-resources/");
			dir.mkdir();
			main.parse("src/test/resources/022008A20080005.xml",
					"target/test-resources/022008A20080005.bsf.xml");

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void test6() {
		Parser main = new Parser(ADAPTER_XSL);
		try {
			File dir = new File("target/test-resources/");
			dir.mkdir();

			main.parse("src/test/resources/022008A20080006.xml",
					"target/test-resources/022008A20080006.bsf.xml");

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void test7() {
		Parser main = new Parser(ADAPTER_XSL);
		try {
			File dir = new File("target/test-resources/");
			dir.mkdir();

			main.parse("src/test/resources/022008A20080007.xml",
					"target/test-resources/022008A20080007.bsf.xml");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
