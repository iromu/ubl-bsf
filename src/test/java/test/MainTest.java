package test;

import irm.ubl2bsf.Batch;
import irm.ubl2bsf.Parser;

import java.io.File;

import org.junit.Test;

public class MainTest {

	private static final String ADAPTER_XSL = "ubl2bsf-adapter.xsl";

	@Test
	public final void testMain1() {
		Batch.main(new String[] { "-import", "in", "-export", "out" });
	}

	@Test
	public final void testMain2() {
		Batch.main(new String[] { "-import", "in/022008A20080005.xml",
				"-export", "out/022008A20080005.bsf.xml" });
	}

	@Test
	public final void test5() {
		final Parser main = new Parser(MainTest.ADAPTER_XSL);
		final File dir = new File("target/test-resources/");
		dir.mkdir();
		main.parse("src/test/resources/022008A20080005.xml",
				"target/test-resources/022008A20080005.bsf.xml");

	}

	@Test
	public final void test6() {
		final Parser main = new Parser(MainTest.ADAPTER_XSL);
		final File dir = new File("target/test-resources/");
		dir.mkdir();

		main.parse("src/test/resources/022008A20080006.xml",
				"target/test-resources/022008A20080006.bsf.xml");

	}

	@Test
	public final void test7() {
		final Parser main = new Parser(MainTest.ADAPTER_XSL);
		final File dir = new File("target/test-resources/");
		dir.mkdir();
		main.parse("src/test/resources/022008A20080007.xml",
				"target/test-resources/022008A20080007.bsf.xml");
	}
}
