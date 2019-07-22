package fileManager;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import users.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadFile {
    public static List<User> getAllUsersFromFile(){
        String path = getPathToFile();
        return null;
    }

    private static String getPathToFile(){
        File fXmlFile = new File(System.getProperty("user.dir") + "/src/main/java/config.xml");
        String path = "";
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            path = doc.getDocumentElement().getElementsByTagName("JSONFilePath").item(0).getTextContent();

            System.out.println();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
