package parse.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultipleXMLs {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        List<Insurance> insurances = Stream.of(
                new Insurance("LIC Jeevan Ananad",10,2000,400000),
                new Insurance("MyBank Accidental",1,10000,500000),
                new Insurance("LIC Jeevan Jyothi",20,3000,1000000),
                new Insurance("LIC Jeevan Umaang",20,12000,8000000)
        ).collect(Collectors.toList());

        MyPolicies myPolicies=new MyPolicies(insurances);

        JAXBContext context=JAXBContext.newInstance(MyPolicies.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
//        marshaller.marshal(myPolicies,new FileOutputStream("2024.xml"));
//        System.out.println("XML has built");

        Unmarshaller unmarshaller=context.createUnmarshaller();
        MyPolicies myLists = (MyPolicies) unmarshaller.unmarshal(new FileInputStream("2024.xml"));
        myLists.getMyBanks().forEach(System.out::println);
    }
}
