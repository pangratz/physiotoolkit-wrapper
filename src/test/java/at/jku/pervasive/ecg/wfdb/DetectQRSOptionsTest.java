package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import org.joda.time.LocalTime;

public class SqrsOptionsTest extends PhysioToolkitTestCase {

  public void testEndTime() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    SqrsOptions options = new SqrsOptions(record);
    options.setEndTime(new LocalTime(3, 4, 5));

    List<String> command = options.getCommand();
    assertEquals(5, command.size());
    assertTrue(command.contains("-t"));
    int tIndex = command.indexOf("-t");
    assertTrue(tIndex > command.indexOf("sqrs"));
    assertTrue(tIndex + 1 == command.indexOf("03:04:05"));
  }

  public void testFile() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    SqrsOptions options = new SqrsOptions(record);

    List<String> command = options.getCommand();
    assertNotNull(command);
    assertEquals(3, command.size());
    assertEquals("sqrs", command.get(0));
    assertEquals("-r", command.get(1));
    assertEquals(record.getName(), command.get(2));
  }

  public void testHighResolutionMode() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    SqrsOptions options = new SqrsOptions(record);
    options.setHighResolutionMode(true);

    List<String> command = options.getCommand();
    assertTrue(command.contains("-H"));
    assertTrue(command.indexOf("-H") > command.indexOf("sqrs"));
  }

  public void testSignal() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    SqrsOptions options = new SqrsOptions(record);
    options.setSignal(1);

    List<String> command = options.getCommand();
    assertEquals(5, command.size());
    assertTrue(command.contains("-s"));
    int sIndex = command.indexOf("-s");
    assertTrue(sIndex > command.indexOf("sqrs"));
    assertTrue(sIndex + 1 == command.indexOf("1"));
  }

  public void testStartTime() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    SqrsOptions options = new SqrsOptions(record);
    options.setStartTime(new LocalTime(1, 2, 3));

    List<String> command = options.getCommand();
    assertEquals(5, command.size());
    assertTrue(command.contains("-f"));
    int fIndex = command.indexOf("-f");
    assertTrue(fIndex > command.indexOf("sqrs"));
    assertTrue(fIndex + 1 == command.indexOf("01:02:03"));
  }

  public void testTreshold() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    SqrsOptions options = new SqrsOptions(record);
    options.setTreshold(123);

    List<String> command = options.getCommand();
    assertEquals(5, command.size());
    assertTrue(command.contains("-m"));
    int mIndex = command.indexOf("-m");
    assertTrue(mIndex > command.indexOf("sqrs"));
    assertTrue(mIndex + 1 == command.indexOf("123"));
  }

}
