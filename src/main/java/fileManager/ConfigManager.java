package fileManager;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import gradeSystem.users.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigManager {
    public static List<User> getAllUsersFromFile(){
        String path = getPathToJsonFile();
        return null;
    }

    public static String getLogsDirectory(){
        return extractNodeContent("LogsDirectory");
    }

    public static String getPathToJsonFile(){
        return extractNodeContent("JSONFilePath");
    }

    private static String extractNodeContent(String nodeName){
        File fXmlFile = new File(System.getProperty("user.dir") + "/src/main/java/config.xml");
        String nodeContent = "";
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            nodeContent = doc.getDocumentElement().getElementsByTagName(nodeName).item(0).getTextContent();
            System.out.println();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nodeContent;
    }
}
