package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.joda.time.LocalTime;

/**
 * Test assertions taken from http://www.physionet.org/tutorials/hrv-toolkit/
 */
public class HrvTest extends PhysioToolkitTestCase {

  private static final double DELTA = 0.00000D;

  public void testBaseDirectoryForRecord() throws Exception {
    File chf03 = getTestFile();
    HRVOptions options = new HRVOptions("chf03", "ecg");
    options.setBaseDirectory(chf03.getParentFile());
    HRV hrv = physioToolkit.hrv(options);

    assertNotNull(hrv);
    assertEquals(0.892769, hrv.getAVNN(), DELTA);
    assertEquals(0.0612485, hrv.getSDNN(), DELTA);
  }

  public void testLargeFile() throws Exception {
    File chf03 = getTestFile();
    HRV hrv = physioToolkit.hrv(chf03, "ecg");

    assertNotNull(hrv);
    assertEquals(0.892769, hrv.getAVNN(), DELTA);
    assertEquals(0.0612485, hrv.getSDNN(), DELTA);
  }

  public void testLargeFileHRVOptions() throws Exception {
    File chf03 = getTestFile();
    HRVOptions options = new HRVOptions(chf03, "ecg");
    HRV hrv = physioToolkit.hrv(options);

    assertNotNull(hrv);
    assertEquals(0.892769, hrv.getAVNN(), DELTA);
    assertEquals(0.0612485, hrv.getSDNN(), DELTA);
  }

  public void testLargeFileHRVOptionsWithOutlierDetection() throws Exception {
    File chf03 = getTestFile();
    HRVOptions options = new HRVOptions(chf03, "ecg");
    options.setFilter("0.2 20 -x 0.4 2.0");
    options.setNnDiff("20 50");
    HRV hrv = physioToolkit.hrv(options);

    assertNotNull(hrv);
    assertEquals(0.942899, hrv.getNNRR(), DELTA);
    assertEquals(0.054712, hrv.getSDNN(), DELTA);
    assertEquals(0.054712, hrv.getSDNN(), DELTA);
    assertEquals(0.0466773, hrv.getSDANN(), DELTA);
    assertEquals(0.0241124, hrv.getSDNNIDX(), DELTA);
    assertEquals(0.0177694, hrv.getrMSSD(), DELTA);
    assertEquals(0.0688698, hrv.getpNN20(), DELTA);
    assertEquals(0.0252389, hrv.getpNN50(), DELTA);
    assertEquals(0.0033882, hrv.getTOT_PWR(), DELTA);
    assertEquals(0.00270489, hrv.getULF_PWR(), DELTA);
    assertEquals(0.000124104, hrv.getLF_PWR(), DELTA);
    assertEquals(0.734226, hrv.getLFHF(), DELTA);
  }

  public void testLargeFileWithHRVOptionsAndOutlierDetectionAndStartAndEndTime()
      throws Exception {
    File chf03 = getTestFile();
    HRVOptions options = new HRVOptions(chf03, "ecg");
    options.setOutputMsec(true).setShortTermStats(true);
    options.setStart(0, 0).setEnd(new LocalTime(1, 0));
    options.setFilter("0.2 20 -x 0.4 2.0");
    options.setNnDiff("20 50");
    HRV hrv = physioToolkit.hrv(options);

    assertNotNull(hrv);
    assertEquals(0.90173, hrv.getNNRR(), DELTA);
    assertEquals(867.958, hrv.getAVNN(), DELTA);
    assertEquals(39.7191, hrv.getSDNN(), DELTA);
    assertEquals(20.8659, hrv.getrMSSD(), DELTA);
    assertEquals(6.26553, hrv.getpNN20(), DELTA);
    assertEquals(2.20811, hrv.getpNN50(), DELTA);
    assertEquals(1702.96, hrv.getTOT_PWR(), DELTA);
    assertEquals(1423.01, hrv.getVLF_PWR(), DELTA);
    assertEquals(103.941, hrv.getLF_PWR(), DELTA);
    assertEquals(176.008, hrv.getHF_PWR(), DELTA);
    assertEquals(0.590547, hrv.getLFHF(), DELTA);
  }

  public void testLargeFileWithOutlierDetection() throws Exception {
    File chf03 = getTestFile();
    HRV hrv = physioToolkit.hrv(chf03, "ecg", "-f 0.2 20 -x 0.4 2.0",
        "-p 20 50");

    assertNotNull(hrv);
    assertEquals(0.942899, hrv.getNNRR(), DELTA);
    assertEquals(0.054712, hrv.getSDNN(), DELTA);
    assertEquals(0.054712, hrv.getSDNN(), DELTA);
    assertEquals(0.0466773, hrv.getSDANN(), DELTA);
    assertEquals(0.0241124, hrv.getSDNNIDX(), DELTA);
    assertEquals(0.0177694, hrv.getrMSSD(), DELTA);
    assertEquals(0.0688698, hrv.getpNN20(), DELTA);
    assertEquals(0.0252389, hrv.getpNN50(), DELTA);
    assertEquals(0.0033882, hrv.getTOT_PWR(), DELTA);
    assertEquals(0.00270489, hrv.getULF_PWR(), DELTA);
    assertEquals(0.000124104, hrv.getLF_PWR(), DELTA);
    assertEquals(0.734226, hrv.getLFHF(), DELTA);
  }

  public void testLargeFileWithOutlierDetectionAndStartAndEndTime()
      throws Exception {
    File chf03 = getTestFile();
    HRV hrv = physioToolkit.hrv(chf03, "ecg", new LocalTime(0, 0),
        new LocalTime(1, 0), "-s", "-M", "-f 0.2 20 -x 0.4 2.0", "-p 20 50");

    assertNotNull(hrv);
    assertEquals(0.90173, hrv.getNNRR(), DELTA);
    assertEquals(867.958, hrv.getAVNN(), DELTA);
    assertEquals(39.7191, hrv.getSDNN(), DELTA);
    assertEquals(20.8659, hrv.getrMSSD(), DELTA);
    assertEquals(6.26553, hrv.getpNN20(), DELTA);
    assertEquals(2.20811, hrv.getpNN50(), DELTA);
    assertEquals(1702.96, hrv.getTOT_PWR(), DELTA);
    assertEquals(1423.01, hrv.getVLF_PWR(), DELTA);
    assertEquals(103.941, hrv.getLF_PWR(), DELTA);
    assertEquals(176.008, hrv.getHF_PWR(), DELTA);
    assertEquals(0.590547, hrv.getLFHF(), DELTA);
  }

  protected File getTestFile() throws URISyntaxException, IOException {
    copyFileToTemp(getFile("/chf03.ecg"));
    copyFileToTemp(getFile("/chf03.dat"));
    copyFileToTemp(getFile("/chf03.hea"));
    return new File(tmpDir, "chf03");
  }

}
