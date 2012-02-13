package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class Edf2MitOptionsTest extends PhysioToolkitTestCase {

  public void test() throws URISyntaxException {
    File edfFile = getFile("/20120206171956.EDF");
    Edf2MitOptions options = new Edf2MitOptions(edfFile);

    List<String> command = options.getCommand();
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

  public void testBigEndian() throws URISyntaxException {
    File edfFile = getFile("/20120206171956.EDF");
    Edf2MitOptions options = new Edf2MitOptions(edfFile);
    options.setBigEndian(true);

    List<String> command = options.getCommand();
    assertEquals(6, command.size());
    assertTrue(command.contains("-b"));
    assertTrue(command.indexOf("-b") > command.indexOf("edf2mit"));
  }

  public void testDefaultEndian() throws URISyntaxException {
    File edfFile = getFile("/20120206171956.EDF");
    Edf2MitOptions options = new Edf2MitOptions(edfFile);

    List<String> command = options.getCommand();
    assertEquals(5, command.size());
    assertFalse(command.contains("-b"));
  }

  public void testNoSignals() throws URISyntaxException {
    File edfFile = getFile("/20120206171956.EDF");
    Edf2MitOptions options = new Edf2MitOptions(edfFile);
    options.setSignals();

    List<String> command = options.getCommand();
    assertEquals(5, command.size());
    assertFalse(command.contains("-s"));
  }

  public void testSignals() throws URISyntaxException {
    File edfFile = getFile("/20120206171956.EDF");
    Edf2MitOptions options = new Edf2MitOptions(edfFile);
    options.setSignals(0, 1, 2);

    List<String> command = options.getCommand();
    assertEquals(7, command.size());
    assertTrue(command.contains("-s"));
    int sIndex = command.indexOf("-s");
    assertTrue(command.contains("0 1 2"));
    assertTrue(sIndex + 1 == command.indexOf("0 1 2"));
  }

}
