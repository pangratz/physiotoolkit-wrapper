package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import org.joda.time.LocalTime;

public class HRVOptionsTest extends PhysioToolkitTestCase {

  public void testEndTime() {
    HRVOptions opts = new HRVOptions("/rrfile.rr");
    opts.setStart(5, 42);
    opts.setEnd(10, 11);

    List<String> cmd = opts.getCommand();
    assertEquals(5, cmd.size());
    assertEquals("00:05:42", cmd.get(3));
    assertEquals("00:10:11", cmd.get(4));
  }

  public void testEndTimeWithoutStartTime() {
    HRVOptions opts = new HRVOptions("/rrfile.rr");
    opts.setEnd(10, 11);

    List<String> cmd = opts.getCommand();
    assertEquals(5, cmd.size());
    assertEquals("00:00:00", cmd.get(3));
    assertEquals("00:10:11", cmd.get(4));
  }

  public void testInvalidAnnotation() throws URISyntaxException {
    File testFile = getFile("/test.dat");
    testFile = new File(testFile.getParentFile(), "test");
    try {
      new HRVOptions(testFile, "");
    } catch (Exception e) {
      fail("should not throw an exception");
    }
  }

  public void testInvalidFile() throws Exception {
    File temporaryFile = File.createTempFile("tmpFile", "tmp");
    try {
      new HRVOptions(temporaryFile, "");
    } catch (Exception e) {
      fail("should not throw an exception");
    } finally {
      temporaryFile.delete();
    }
  }

  public void testNullAnnotation() throws URISyntaxException {
    File testFile = getFile("/test.dat");
    testFile = new File(testFile.getParentFile(), "test");
    try {
      new HRVOptions(testFile, null);
    } catch (Exception e) {
      fail("should not throw an exception");
    }
  }

  public void testNullFile() throws Exception {
    try {
      new HRVOptions((File) null, "");
    } catch (Exception e) {
      fail("should not throw an exception");
    }
  }

  public void testNullFileString() throws Exception {
    try {
      new HRVOptions((String) null, "");
    } catch (Exception e) {
      fail("should not throw an exception");
    }
  }

  public void testRecordFile() throws Exception {
    HRVOptions options = new HRVOptions("testFile", "qrs");

    List<String> cmd = options.getCommand();
    assertEquals(3, cmd.size());
    assertEquals("testFile", cmd.get(1));
    assertEquals("qrs", cmd.get(2));
  }

  public void testRecordFileWithStartAndEndTime() throws Exception {
    HRVOptions options = new HRVOptions("testFile", "qrs");
    options.setStart(10, 11);
    options.setEnd(new LocalTime(1, 10, 11));

    List<String> cmd = options.getCommand();
    assertEquals(5, cmd.size());
    assertEquals("testFile", cmd.get(1));
    assertEquals("qrs", cmd.get(2));
    assertEquals("00:10:11", cmd.get(3));
    assertEquals("01:10:11", cmd.get(4));
  }

  public void testRRFile() {
    HRVOptions opts = new HRVOptions("rrfile.rr");

    List<String> cmd = opts.getCommand();
    assertEquals(3, cmd.size());
    assertEquals("-R", cmd.get(1));
    assertEquals("rrfile.rr", cmd.get(2));
  }

  public void testStartTime() {
    HRVOptions opts = new HRVOptions("/rrfile.rr");
    opts.setStart(10, 11);

    List<String> cmd = opts.getCommand();
    assertEquals(4, cmd.size());
    assertEquals("00:10:11", cmd.get(3));
  }

}
