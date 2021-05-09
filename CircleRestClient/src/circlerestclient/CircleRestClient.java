/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlerestclient;

import java.io.StringReader;
import javax.xml.bind.JAXB;
import model.Result;
import util.CircleClient;

/**
 *
 * @author luksorn
 */
public class CircleRestClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircleClient client = new CircleClient();
        String xml = client.getXml("3");
        //System.out.println(xml);
        Result res = JAXB.unmarshal(new StringReader(xml), Result.class);
        System.out.println(res.getArea());
        System.out.println(res.getCircum());
    }
    
}
