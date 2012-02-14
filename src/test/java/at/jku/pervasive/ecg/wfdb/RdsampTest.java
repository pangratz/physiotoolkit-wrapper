package at.jku.pervasive.ecg.wfdb;

import java.io.File;

public class RdsampTest extends PhysioToolkitTestCase {

  public void testRdsamp() throws Exception {
    copyFileToTemp(getFile("/f1o01.hea"));
    File datFile = copyFileToTemp(getFile("/f1o01.dat"));

    File record = new File(datFile.getParentFile(), "f1o01");
    RdsampOptions options = new RdsampOptions(record);

    File outputFile = physioToolkit.rdsamp(options);
    assertNotNull(outputFile);
    assertTrue(outputFile.exists());
  }
}
