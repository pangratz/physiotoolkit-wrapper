package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.List;

public class WqrsOptionsTest extends PhysioToolkitTestCase {

  public void testAnnotateJPoints() throws Exception {
    File record = getWFDBFile("/chf03.dat");
    WqrsOptions options = new WqrsOptions(record);
    options.setAnnotateJPoints(true);

    List<String> command = options.getCommand();
    assertEquals(4, command.size());
    assertTrue(command.contains("-j"));
    assertTrue(command.indexOf("-j") > command.indexOf("wqrs"));
  }

  public void testResample() throws Exception {
    File record = getWFDBFile("/chf03.dat");
    WqrsOptions options = new WqrsOptions(record);
    options.setResample(true);

    List<String> command = options.getCommand();
    assertEquals(4, command.size());
    assertTrue(command.contains("-R"));
    assertTrue(command.indexOf("-R") > command.indexOf("wqrs"));
  }

  public void testSpecifyPowerLine() throws Exception {
    File record = getWFDBFile("/chf03.dat");
    WqrsOptions options = new WqrsOptions(record);
    options.setPowerLine(100);

    List<String> command = options.getCommand();
    assertEquals(5, command.size());
    assertTrue(command.contains("-p"));
    int pIndex = command.indexOf("-p");
    assertTrue(pIndex > command.indexOf("wqrs"));
    assertTrue(pIndex + 1 == command.indexOf("100"));
  }

  public void testWqrs() throws Exception {
    File record = getWFDBFile("/chf03.dat");
    WqrsOptions options = new WqrsOptions(record);

    List<String> command = options.getCommand();
    assertEquals("wqrs", command.get(0));
    assertFalse(command.contains("sqrs"));
    assertFalse(command.contains("sqrs125"));
  }

}
