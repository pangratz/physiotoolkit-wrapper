package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import junit.framework.TestCase;

public class PhysioToolkitTestCase extends TestCase {

  protected PhysioToolkit physioToolkit;

  public void testIsPhysioToolkitInstalled() throws Exception {
    assertTrue(physioToolkit.isInstalled());
  }

  protected File getFile(String path) throws URISyntaxException {
    URL url = this.getClass().getResource(path);
    return new File(url.toURI());
  }

  @Override
  protected void setUp() throws Exception {
    physioToolkit = new PhysioToolkit();
  }

  @Override
  protected void tearDown() throws Exception {
    physioToolkit = null;
  }

}
