package parse.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="policies")
public class MyPolicies {

    private List<Insurance> myBanks;

    public MyPolicies(List<Insurance> myBanks) {
        this.myBanks = myBanks;
    }

    @XmlElement(name = "policy")
    public List<Insurance> getMyBanks() {
        return myBanks;
    }

    public void setMyBanks(List<Insurance> myBanks) {
        this.myBanks = myBanks;
    }

    public MyPolicies() {
    }


}
