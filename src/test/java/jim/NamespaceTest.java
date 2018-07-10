package jim;
import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import jim.Lauchner;
import jim.debug.TraceHandler;

/**
 * 
 * Validate an XML file whith a namespace,
 * with Jing trough the JAXP API.
 * 
 * It should work.
 * 
 * Related to https://github.com/mojohaus/xml-maven-plugin/issues/21#issuecomment-381867691
 * 
 * @author jetevenard
 *
 */

public class NamespaceTest {
	
	private static final String XML_VALID = "test-valid.xml";
	private static final String XML_INVALID = "test-invalid.xml";
	private static final String RNG = "test.rng";
	
	@Test
	public void ValidateCorrect(){	
		try {
			File xml = resource(XML_VALID);
			File rng = resource(RNG);
			
			Lauchner.validate(xml, rng);		
		} catch (Exception e) {
			fail(e.getMessage());
		}	
	}
	
	
	@Test
	public void ValidateCorrectSax(){	
		try {
			File xml = resource(XML_VALID);
			File rng = resource(RNG);
			
			Lauchner.validateSax(xml, rng);		
		} catch (Exception e) {
			fail(e.getMessage());
		}	
	}
	

	@Test
	public void ValidateIncorrect(){	
		try {
			File xml = resource(XML_INVALID);
			File rng = resource(RNG);
			
			Lauchner.validate(xml, rng);
			
			fail();
		} catch (Exception e) {
			
		}	
	}
	
	
	@Test
	public void ValidateIncorrectSax(){	
		try {
			File xml = resource(XML_INVALID);
			File rng = resource(RNG);
			
			Lauchner.validateSax(xml, rng);	
			
			fail();
		} catch (Exception e) {
			
		}	
	}
	
	@Test
	public void ValidateIncorrectSaxAndTrace(){	
		try {
			File xml = resource(XML_INVALID);
			File rng = resource(RNG);
			
			Lauchner.validateSax(xml, rng, new TraceHandler());	
			
			
		} catch (Exception e) {}	
		// never fails, just trace...
	}
	
	private static File resource(String name) throws URISyntaxException {
		return new File(NamespaceTest.class.getClassLoader().getResource(name).toURI());
	}

}
