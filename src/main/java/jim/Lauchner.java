package jim;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Lauchner {
	
	public static final String RELAX = "http://relaxng.org/ns/structure/1.0";

	public static void validateSax(File xml, File rng) throws IOException, SAXException  {
		
		SchemaFactory sf = SchemaFactory.newInstance(RELAX,"com.thaiopensource.relaxng.jaxp.XMLSyntaxSchemaFactory",Lauchner.class.getClassLoader());
		Schema schema = sf.newSchema(rng);
		
		ValidatorHandler valHandler = schema.newValidatorHandler();		
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(valHandler);
		reader.parse(new InputSource(xml.getAbsolutePath()));

	}

	public static void validate(File xml, File rng) throws SAXException, IOException{
		SchemaFactory sf = SchemaFactory.newInstance(RELAX,"com.thaiopensource.relaxng.jaxp.XMLSyntaxSchemaFactory",Lauchner.class.getClassLoader());
		Schema schema = sf.newSchema(rng);
		
		Validator val = schema.newValidator();
		val.validate(new StreamSource(xml));

	}

}
