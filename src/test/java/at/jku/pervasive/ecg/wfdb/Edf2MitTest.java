package at.jku.pervasive.ecg.wfdb;

import java.io.File;

public class Edf2MitTest extends PhysioToolkitTestCase {

  public void testEdf2Mit() throws Exception {
    File edfFile = getFile("/20120206171956.EDF");
    Edf2MitOptions options = new Edf2MitOptions(edfFile);
    physioToolkit.edf2mit(edfFile);
  }

  public void testEdf2MitWithNullParameter() {
    try {
      physioToolkit.edf2mit(null);
      fail("should throw an exception");
    } catch (IllegalArgumentException e) {
    } catch (Exception e) {
      fail("should throw an IllegalArgumentException");
    }
  }

}
