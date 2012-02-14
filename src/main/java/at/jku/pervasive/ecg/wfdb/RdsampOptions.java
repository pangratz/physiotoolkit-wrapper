package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalTime;

public class RdsampOptions {

  private File baseDirectory;
  private PhysicalUnit physicalUnit;
  private final File record;
  private int[] signals;
  private LocalTime startTime, endTime;
  private boolean useCSV, highResolutionMode, printColumHeadings;

  public RdsampOptions(File record) {
    super();

    this.record = record;
    if (record != null) {
      this.baseDirectory = record.getParentFile();
    }
  }

  public File getBaseDirectory() {
    return baseDirectory;
  }

  // -s SIGNAL [SIGNAL ...] print only the specified signal(s)
  /**
   * TODO -l INTERVAL truncate output after the specified time interval
   * (hh:mm:ss) TODO -S SIGNAL search for a valid sample of the specified SIGNAL
   * at or after // the time specified with -f, and begin printing then
   */
  public List<String> getCommand() {
    List<String> cmd = new LinkedList<String>();
    cmd.add("rdsamp");
    cmd.add("-r");
    cmd.add(record.getName());

    if (useCSV) {
      cmd.add("-c");
    }
    if (printColumHeadings) {
      cmd.add("-v");
    }

    if (ArrayUtils.isNotEmpty(signals)) {
      cmd.add("-s");
      cmd.add(StringUtils.join(ArrayUtils.toObject(signals), " "));
    }

    if (highResolutionMode) {
      cmd.add("-H");
    }

    if (physicalUnit != null) {
      cmd.add(physicalUnit.getParameter());
    }

    if (startTime != null) {
      cmd.add("-f");
      cmd.add(startTime.toString("HH:mm:ss"));
    }
    if (endTime != null) {
      cmd.add("-t");
      cmd.add(endTime.toString("HH:mm:ss"));
    }

    return cmd;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public PhysicalUnit getPhysicalUnit() {
    return physicalUnit;
  }

  public File getRecord() {
    return record;
  }

  public int[] getSignals() {
    return signals;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public boolean isHighResolutionMode() {
    return highResolutionMode;
  }

  public boolean isPrintColumHeadings() {
    return printColumHeadings;
  }

  public boolean isUseCSV() {
    return useCSV;
  }

  public RdsampOptions setBaseDirectory(File baseDirectory) {
    this.baseDirectory = baseDirectory;
    return this;
  }

  public RdsampOptions setEndTime(LocalTime endTime) {
    this.endTime = endTime;
    return this;
  }

  public RdsampOptions setHighResolutionMode(boolean highResolutionMode) {
    this.highResolutionMode = highResolutionMode;
    return this;
  }

  public RdsampOptions setPhysicalUnit(PhysicalUnit physicalUnit) {
    this.physicalUnit = physicalUnit;
    return this;
  }

  public RdsampOptions setPrintColumHeadings(boolean printColumHeadings) {
    this.printColumHeadings = printColumHeadings;
    return this;
  }

  public RdsampOptions setSignals(int... signals) {
    this.signals = signals;
    return this;
  }

  public RdsampOptions setStartTime(LocalTime startTime) {
    this.startTime = startTime;
    return this;
  }

  public RdsampOptions setUseCSV(boolean useCSV) {
    this.useCSV = useCSV;
    return this;
  }

}
