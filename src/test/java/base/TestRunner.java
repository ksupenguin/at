package base;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        TestNG tng = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("trigonometry");

        List<String> files = new ArrayList<>(new ArrayList<String>() {{
            add("./src/test/resources/testng.xml");
        }});

        suite.setSuiteFiles(files);
        suite.setParallel(XmlSuite.ParallelMode.METHODS);
        suite.setThreadCount(2);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);
        tng.run();
    }
}
