package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class DetectQRSTest extends PhysioToolkitTestCase {

  public void testSqrs() throws URISyntaxException, IOException,
      InterruptedException {
    File testFile = getTestFile();

    DetectQRSOptions options = new DetectQRSOptions(testFile);
    physioToolkit.detectQRS(options);

    File qrsFile = new File(options.getBaseDirectory(), "chf03.qrs");
    assertTrue(qrsFile.exists());
  }

  public void testSqrs125() throws URISyntaxException, IOException,
      InterruptedException {
    File testFile = getTestFile();

    DetectQRSOptions options = new DetectQRSOptions(testFile);
    options.setCommand("sqrs125");
    physioToolkit.detectQRS(options);

    File qrsFile = new File(options.getBaseDirectory(), "chf03.qrs");
    assertTrue(qrsFile.exists());
  }

  public void testWqrs() throws URISyntaxException, IOException,
      InterruptedException {
    File testFile = getTestFile();

    DetectQRSOptions options = new WqrsOptions(testFile);
    physioToolkit.detectQRS(options);

    File qrsFile = new File(options.getBaseDirectory(), "chf03.wqrs");
    assertTrue(qrsFile.exists());
  }

  protected File getTestFile() throws IOException, URISyntaxException {
    copyFileToTemp(getFile("/chf03.hea"));
    copyFileToTemp(getFile("/chf03.dat"));
    return new File(tmpDir, "chf03");
  }

}
