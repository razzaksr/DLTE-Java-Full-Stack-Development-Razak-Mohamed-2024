package parse.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Marshalling {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Insurance insurance=new Insurance("Max Life",3,1200,200000);
        JAXBContext context=JAXBContext.newInstance(Insurance.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(insurance,new FileOutputStream("scheme.xml"));
        System.out.println("XML has built");
    }
}
