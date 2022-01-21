package task_2;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath path = xPathFactory.newXPath();

        XPathExpression expression = path.compile("//Gem/@id | //Gem/* | //Visual_parameters/* | //Value/@measure");

        File file = new File("C:\\Users\\user\\IdeaProjects\\Web_Services_3.2\\src\\task_2\\diamonds.xml");

        InputSource inputSource = new InputSource(new FileInputStream(file));

        Object result = expression.evaluate(inputSource, XPathConstants.NODESET);

        NodeList nodeList = (NodeList) result;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.print("Node name: " + node.getNodeName());
            System.out.print(" Node value: " + node.getFirstChild().getNodeValue());
            System.out.print("\n");
        }
    }
}
