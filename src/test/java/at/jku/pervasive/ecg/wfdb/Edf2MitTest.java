package at.jku.pervasive.ecg.wfdb;

import java.io.File;

public class Edf2MitTest extends PhysioToolkitTestCase {

  public void testEdf2Mit() throws Exception {
    File edfFile = copyFileToTemp(getFile("/20120206171956.EDF"));

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

}
