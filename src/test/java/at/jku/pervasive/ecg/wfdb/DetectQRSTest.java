package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;

public class DetectQRSTest extends PhysioToolkitTestCase {

  private File tmpDir;

  public void testSqrs() throws URISyntaxException, IOException,
      InterruptedException {
    copyFileToTemp(getFile("/chf03.hea"));
    copyFileToTemp(getFile("/chf03.dat"));
    File testFile = new File(tmpDir, "chf03");

    DetectQRSOptions options = new DetectQRSOptions(testFile);
    physioToolkit.detectQRS(options);

    File qrsFile = new File(options.getBaseDirectory(), "chf03.qrs");
    assertTrue(qrsFile.exists());
  }

  public void testSqrs125() throws URISyntaxException, IOException,
      InterruptedException {
    copyFileToTemp(getFile("/chf03.hea"));
    copyFileToTemp(getFile("/chf03.dat"));
    File testFile = new File(tmpDir, "chf03");

    DetectQRSOptions options = new DetectQRSOptions(testFile);
    options.setCommand("sqrs125");
    physioToolkit.detectQRS(options);

    File qrsFile = new File(options.getBaseDirectory(), "chf03.qrs");
    assertTrue(qrsFile.exists());
  }

  public void testWqrs() throws URISyntaxException, IOException,
      InterruptedException {
    copyFileToTemp(getFile("/chf03.hea"));
    copyFileToTemp(getFile("/chf03.dat"));
    File testFile = new File(tmpDir, "chf03");

    DetectQRSOptions options = new WqrsOptions(testFile);
    physioToolkit.detectQRS(options);

    File qrsFile = new File(options.getBaseDirectory(), "chf03.wqrs");
    assertTrue(qrsFile.exists());
  }

  protected File copyFileToTemp(File f) throws IOException {
    FileUtils.copyFileToDirectory(f, tmpDir);
    return new File(tmpDir, f.getName());
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    tmpDir = Files.createTempDir();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();

    if (tmpDir != null) {
      tmpDir.delete();
    }
  }

}
