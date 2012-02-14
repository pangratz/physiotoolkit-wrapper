package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import org.joda.time.LocalTime;

public class RdsampOptionsTest extends PhysioToolkitTestCase {

  public void test() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);

    List<String> cmd = options.getCommand();
    assertNotNull(cmd);
    assertEquals(3, cmd.size());
    assertEquals("rdsamp", cmd.get(0));
    assertEquals("-r", cmd.get(1));
    assertEquals(record.getName(), cmd.get(2));
  }

  public void testCSV() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setUseCSV(true);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-c"));
    assertTrue(cmd.indexOf("-c") > cmd.indexOf("rdsamp"));
  }

  public void testEndTime() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setEndTime(new LocalTime(1, 2, 3));

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-t"));
    assertTrue(cmd.indexOf("-t") > cmd.indexOf("rdsamp"));
    assertTrue(cmd.contains("01:02:03"));
    int tIndex = cmd.indexOf("-t");
    assertTrue(tIndex + 1 == cmd.indexOf("01:02:03"));
  }

  public void testHighResolutionMode() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setHighResolutionMode(true);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-H"));
    assertTrue(cmd.indexOf("-H") > cmd.indexOf("rdsamp"));
  }

  public void testNullPhysicalUnits() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(null);

    List<String> cmd = options.getCommand();
    for (PhysicalUnit pu : PhysicalUnit.values()) {
      assertFalse(cmd.contains(pu.getParameter()));
    }
  }

  public void testNullSignals() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setSignals(null);

    List<String> cmd = options.getCommand();
    assertFalse(cmd.contains("-s"));
  }

  public void testPhysicalUnits() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.p);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-p"));
    assertTrue(cmd.indexOf("-p") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsElapsedHours() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.ph);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-ph"));
    assertTrue(cmd.indexOf("-ph") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsElapsedHoursMinutesSeconds()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.pe);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-pe"));
    assertTrue(cmd.indexOf("-pe") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsElapsedMinutes() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.pm);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-pm"));
    assertTrue(cmd.indexOf("-pm") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsElapsedSampleIntervals()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.pS);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-pS"));
    assertTrue(cmd.indexOf("-pS") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsElapsedSeconds() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.ps);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-ps"));
    assertTrue(cmd.indexOf("-ps") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsHigherPrecision() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.P);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-P"));
    assertTrue(cmd.indexOf("-P") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsHigherPrecisionElapsedHours()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.Ph);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-Ph"));
    assertTrue(cmd.indexOf("-Ph") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsHigherPrecisionElapsedHoursMinutesSeconds()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.Pe);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-Pe"));
    assertTrue(cmd.indexOf("-Pe") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsHigherPrecisionElapsedMinutes()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.Pm);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-Pm"));
    assertTrue(cmd.indexOf("-Pm") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsHigherPrecisionElapsedSampleIntervals()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.PS);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-PS"));
    assertTrue(cmd.indexOf("-PS") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsHigherPrecisionElapsedSeconds()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.Ps);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-Ps"));
    assertTrue(cmd.indexOf("-Ps") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsHigherPrecisionTimeOfDayAndDate()
      throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.Pd);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-Pd"));
    assertTrue(cmd.indexOf("-Pd") > cmd.indexOf("rdsamp"));
  }

  public void testPhysicalUnitsTimeOfDayAndDate() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPhysicalUnit(PhysicalUnit.pd);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-pd"));
    assertTrue(cmd.indexOf("-pd") > cmd.indexOf("rdsamp"));
  }

  public void testPrintColumnHeadings() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setPrintColumHeadings(true);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-v"));
    assertTrue(cmd.indexOf("-v") > cmd.indexOf("rdsamp"));
  }

  public void testSignals() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setSignals(0, 1, 2);

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-s"));
    int sIndex = cmd.indexOf("-s");
    assertEquals("0 1 2", cmd.get(sIndex + 1));
  }

  public void testStartTime() throws URISyntaxException {
    File record = getWFDBFile("/chf03.dat");
    RdsampOptions options = new RdsampOptions(record);
    options.setStartTime(new LocalTime(1, 2, 3));

    List<String> cmd = options.getCommand();
    assertTrue(cmd.contains("-f"));
    assertTrue(cmd.indexOf("-f") > cmd.indexOf("rdsamp"));
    assertTrue(cmd.contains("01:02:03"));
    int fIndex = cmd.indexOf("-f");
    assertTrue(fIndex + 1 == cmd.indexOf("01:02:03"));
  }

}
