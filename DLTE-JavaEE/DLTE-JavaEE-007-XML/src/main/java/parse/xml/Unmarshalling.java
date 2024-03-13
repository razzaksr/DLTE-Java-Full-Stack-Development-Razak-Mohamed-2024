package parse.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Unmarshalling {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context=JAXBContext.newInstance(Insurance.class);
        Unmarshaller unmarshaller= context.createUnmarshaller();
        Insurance insurance = (Insurance) unmarshaller.unmarshal(new FileInputStream("mybank.xml"));
        insurance.setPolicyPeriod(insurance.getPolicyPeriod()+2);
        System.out.println(insurance);

    }
}
