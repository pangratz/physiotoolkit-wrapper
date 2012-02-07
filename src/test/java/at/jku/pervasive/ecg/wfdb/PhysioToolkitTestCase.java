package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.commons.io.FilenameUtils;

public class PhysioToolkitTestCase extends TestCase {

  protected PhysioToolkit physioToolkit;

  public void testGetFile() throws Exception {
    File file = getFile("/chf03.dat");
    assertNotNull(file);
    assertEquals("chf03.dat", file.getName());
  }

  public void testGetWFDBFile() throws Exception {
    File wfdbFile = getWFDBFile("/chf03.dat");
    assertNotNull(wfdbFile);
    assertEquals("chf03", wfdbFile.getName());
  }

  public void testIsPhysioToolkitInstalled() throws Exception {
    assertTrue(physioToolkit.isInstalled());
  }

  protected File getFile(String path) throws URISyntaxException {
    URL url = this.getClass().getResource(path);
    return new File(url.toURI());
  }

  protected File getWFDBFile(String pathToDat) throws URISyntaxException {
    URL url = this.getClass().getResource(pathToDat);
    File datFile = new File(url.toURI());
    String wfdbFile = FilenameUtils.getBaseName(pathToDat);
    return new File(datFile.getParentFile(), wfdbFile);
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
