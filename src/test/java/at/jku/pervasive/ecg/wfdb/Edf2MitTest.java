package at.jku.pervasive.ecg.wfdb;

public class Edf2MitTest extends PhysioToolkitTestCase {

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
