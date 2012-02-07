package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;

public class HRVOptionsTest extends PhysioToolkitTestCase {

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
      new HRVOptions(null, "");
    } catch (Exception e) {
      fail("should not throw an exception");
    }
  }

}
