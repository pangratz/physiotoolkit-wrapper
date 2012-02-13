package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class Edf2MitOptionsTest extends PhysioToolkitTestCase {

  public void test() throws URISyntaxException {
    File edfFile = getFile("/20120206171956.EDF");
    Edf2MitOptions options = new Edf2MitOptions(edfFile);

    List<String> command = options.getCommand();
    System.out.println(command);
    assertNotNull(command);
    assertEquals(5, command.size());
    assertEquals("edf2mit", command.get(0));

    // test if edf file is available and directly after -i option
    assertTrue(command.contains("-i"));
    int iIndex = command.indexOf("-i");
    assertTrue(command.contains(edfFile.getName()));
    assertTrue(iIndex + 1 == command.indexOf(edfFile.getName()));

    // test if output file is available and directly after -r option
    assertTrue(command.contains("-r"));
    int rIndex = command.indexOf("-r");
    String outputName = options.getOutputName();
    assertNotNull(outputName);
    assertTrue(command.contains(outputName));
    assertTrue(rIndex + 1 == command.indexOf(outputName));
  }
}
