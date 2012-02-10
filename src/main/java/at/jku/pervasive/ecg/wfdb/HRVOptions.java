package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalTime;

public class HRVOptions {

  private File baseDirectory;
  private String file, annotation;
  private double filt, hwin;
  private String inputTimeFormat;
  private boolean isRR;
  private double lo1, hi1, lo2, hi2, lo3, hi3, lo4, hi4;
  private String nnDiff;
  private boolean outputMsec;
  private boolean rrInMSec;
  private boolean shortTermStats;
  private LocalTime start, end;

  public HRVOptions(File rrFile) {
    super();
    if (rrFile != null) {
      this.file = rrFile.getName();
      this.baseDirectory = rrFile.getParentFile();
      this.isRR = true;
    }
  }

  public HRVOptions(File recordFile, String annotation) {
    super();
    if (recordFile != null) {
      this.file = recordFile.getName();
      this.baseDirectory = recordFile.getParentFile();
    }
    this.annotation = annotation;
  }

  public HRVOptions(String file) {
    super();
    this.file = file;
    this.isRR = true;
  }

  public HRVOptions(String file, String annotation) {
    super();
    this.file = file;
    this.annotation = annotation;
  }

  public String getAnnotation() {
    return annotation;
  }

  public File getBaseDirectory() {
    return baseDirectory;
  }

  public List<String> getCommand() {
    List<String> cmd = new ArrayList<String>();
    cmd.add("get_hrv");
    if (outputMsec) {
      cmd.add("-M");
    }
    if (isRR) {
      if (rrInMSec) {
        cmd.add("-m");
      }
      cmd.add("-R");
      cmd.add(file);
    } else {
      cmd.add(file);
      cmd.add(annotation);
    }
    if (start != null) {
      cmd.add(start.toString("HH:mm:ss"));
    }
    if (end != null) {
      cmd.add(end.toString("HH:mm:ss"));
    }
    return cmd;
  }

  public LocalTime getEnd() {
    return end;
  }

  public String getFile() {
    return file;
  }

  public double getFilt() {
    return filt;
  }

  public double getHi1() {
    return hi1;
  }

  public double getHi2() {
    return hi2;
  }

  public double getHi3() {
    return hi3;
  }

  public double getHi4() {
    return hi4;
  }

  public double getHwin() {
    return hwin;
  }

  public String getInputTimeFormat() {
    return inputTimeFormat;
  }

  public double getLo1() {
    return lo1;
  }

  public double getLo2() {
    return lo2;
  }

  public double getLo3() {
    return lo3;
  }

  public double getLo4() {
    return lo4;
  }

  public String getNnDiff() {
    return nnDiff;
  }

  public LocalTime getStart() {
    return start;
  }

  public boolean isOutputMsec() {
    return outputMsec;
  }

  public boolean isRrInMSec() {
    return rrInMSec;
  }

  public boolean isShortTermStats() {
    return shortTermStats;
  }

  public HRVOptions setAnnotation(String annotation) {
    this.annotation = annotation;
    return this;
  }

  public HRVOptions setBaseDirectory(File baseDirectory) {
    this.baseDirectory = baseDirectory;
    return this;
  }

  public HRVOptions setEnd(int m, int s) {
    setEnd(new LocalTime(0, m, s));
    return this;
  }

  public HRVOptions setEnd(LocalTime end) {
    this.end = end;
    if (this.start == null) {
      this.start = new LocalTime(0, 0, 0);
    }
    return this;
  }

  public HRVOptions setFile(String file) {
    this.file = file;
    return this;
  }

  public HRVOptions setFilt(double filt) {
    this.filt = filt;
    return this;
  }

  public HRVOptions setHi1(double hi1) {
    this.hi1 = hi1;
    return this;
  }

  public HRVOptions setHi2(double hi2) {
    this.hi2 = hi2;
    return this;
  }

  public HRVOptions setHi3(double hi3) {
    this.hi3 = hi3;
    return this;
  }

  public HRVOptions setHi4(double hi4) {
    this.hi4 = hi4;
    return this;
  }

  public HRVOptions setHwin(double hwin) {
    this.hwin = hwin;
    return this;
  }

  public HRVOptions setInputTimeFormat(String inputTimeFormat) {
    this.inputTimeFormat = inputTimeFormat;
    return this;
  }

  public HRVOptions setLo1(double lo1) {
    this.lo1 = lo1;
    return this;
  }

  public HRVOptions setLo2(double lo2) {
    this.lo2 = lo2;
    return this;
  }

  public HRVOptions setLo3(double lo3) {
    this.lo3 = lo3;
    return this;
  }

  public HRVOptions setLo4(double lo4) {
    this.lo4 = lo4;
    return this;
  }

  public HRVOptions setNnDiff(String nnDiff) {
    this.nnDiff = nnDiff;
    return this;
  }

  public HRVOptions setOutputMsec(boolean outputMsec) {
    this.outputMsec = outputMsec;
    return this;
  }

  public HRVOptions setRrInMSec(boolean rrInMSec) {
    this.rrInMSec = rrInMSec;
    return this;
  }

  public HRVOptions setShortTermStats(boolean shortTermStats) {
    this.shortTermStats = shortTermStats;
    return this;
  }

  public HRVOptions setStart(int m, int s) {
    return setStart(new LocalTime(0, m, s));
  }

  public HRVOptions setStart(LocalTime start) {
    this.start = start;
    return this;
  }

  public HRVOptions startTime(LocalTime start) {
    this.start = start;
    return this;
  }

}
