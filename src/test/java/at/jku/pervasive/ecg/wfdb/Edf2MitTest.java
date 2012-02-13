package at.jku.pervasive.ecg.wfdb;

import java.io.File;

import com.google.common.io.Files;

public class Edf2MitTest extends PhysioToolkitTestCase {

  private File tmpDir;

  public void testEdf2Mit() throws Exception {
    File first = getFile("/20120206171956.EDF");
    File edfFile = new File(tmpDir, "20120206171956.EDF");
    Files.copy(first, edfFile);

    Edf2MitOptions options = new Edf2MitOptions(edfFile);
    options.setBaseDirectory(tmpDir);
    System.out.println(options.getCommand());

    String name = physioToolkit.edf2mit(options);

    File datFile = new File(tmpDir, name + ".dat");
    assertTrue(datFile.exists());
    assertTrue(datFile.length() > 0L);

    File heaFile = new File(tmpDir, name + ".hea");
    assertTrue(heaFile.exists());
    assertTrue(heaFile.length() > 0L);
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
