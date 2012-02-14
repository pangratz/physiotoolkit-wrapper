package at.jku.pervasive.ecg.wfdb;

import java.io.File;

import org.joda.time.LocalTime;

//-c          use CSV (comma-separated value) output format
// -f TIME     begin at specified time
// -h          print this usage summary
// -H          read multifrequency signals in high resolution mode
// -l INTERVAL truncate output after the specified time interval (hh:mm:ss)
// -p          print times and samples in physical units (default: raw units)
// -P          same as -p, but with greater precision
//              -p and -P may be followed by a character to choose a time
//              format;  choices are:
//  -pd (or -Pd)  print time of day and date if known
//  -pe (or -Pe)  print elapsed time as <hours>:<minutes>:<seconds>
//  -ph (or -Ph)  print elapsed time in hours
//  -pm (or -Pm)  print elapsed time in minutes
//  -ps (or -Ps)  print elapsed time in seconds
//  -pS (or -PS)  print elapsed time in sample intervals
// -s SIGNAL [SIGNAL ...]  print only the specified signal(s)
// -S SIGNAL   search for a valid sample of the specified SIGNAL at or after
//    the time specified with -f, and begin printing then
// -t TIME     stop at specified time
// -v          print column headings
// -X          output in WFDB-XML format
public class RdsampOptions {

  private File baseDirectory;
  private String physicalUnit;
  private final File record;
  private int[] signals;
  private LocalTime startTime, endTime;
  private boolean useCSV, highResolutionMode, usePhysicalUnits,
      printColumHeadings;

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

  public LocalTime getEndTime() {
    return endTime;
  }

  public String getPhysicalUnit() {
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

  public boolean isUsePhysicalUnits() {
    return usePhysicalUnits;
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

  public RdsampOptions setPhysicalUnit(String physicalUnit) {
    this.physicalUnit = physicalUnit;
    return this;
  }

  public RdsampOptions setPrintColumHeadings(boolean printColumHeadings) {
    this.printColumHeadings = printColumHeadings;
    return this;
  }

  public RdsampOptions setSignals(int[] signals) {
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

  public RdsampOptions setUsePhysicalUnits(boolean usePhysicalUnits) {
    this.usePhysicalUnits = usePhysicalUnits;
    return this;
  }

}
