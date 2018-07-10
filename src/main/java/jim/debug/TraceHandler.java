package jim.debug;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class TraceHandler implements  ErrorHandler {
	
	public TraceHandler() {
		Tracer.trace("new TraceHandler");
	}
	


	@Override
	public void warning(SAXParseException exception) throws SAXException {
		Tracer.trace("EH Warning");
		
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		Tracer.trace("EH error", exception.getMessage());
		
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		Tracer.trace("EH fatal");
		
	}
	
	

}
