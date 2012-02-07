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

  public HRVOptions(File file, String annotation) {
    super();
    if (file != null) {
      this.file = file.getAbsolutePath();
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

  public void setAnnotation(String annotation) {
    this.annotation = annotation;
  }

  public void setBaseDirectory(File baseDirectory) {
    this.baseDirectory = baseDirectory;
  }

  public void setEnd(int m, int s) {
    setEnd(new LocalTime(0, m, s));
  }

  public void setEnd(LocalTime end) {
    this.end = end;
    if (this.start == null) {
      this.start = new LocalTime(0, 0, 0);
    }
  }

  public void setFile(String file) {
    this.file = file;
  }

  public void setFilt(double filt) {
    this.filt = filt;
  }

  public void setHi1(double hi1) {
    this.hi1 = hi1;
  }

  public void setHi2(double hi2) {
    this.hi2 = hi2;
  }

  public void setHi3(double hi3) {
    this.hi3 = hi3;
  }

  public void setHi4(double hi4) {
    this.hi4 = hi4;
  }

  public void setHwin(double hwin) {
    this.hwin = hwin;
  }

  public void setInputTimeFormat(String inputTimeFormat) {
    this.inputTimeFormat = inputTimeFormat;
  }

  public void setLo1(double lo1) {
    this.lo1 = lo1;
  }

  public void setLo2(double lo2) {
    this.lo2 = lo2;
  }

  public void setLo3(double lo3) {
    this.lo3 = lo3;
  }

  public void setLo4(double lo4) {
    this.lo4 = lo4;
  }

  public void setNnDiff(String nnDiff) {
    this.nnDiff = nnDiff;
  }

  public void setOutputMsec(boolean outputMsec) {
    this.outputMsec = outputMsec;
  }

  public void setRrInMSec(boolean rrInMSec) {
    this.rrInMSec = rrInMSec;
  }

  public void setShortTermStats(boolean shortTermStats) {
    this.shortTermStats = shortTermStats;
  }

  public void setStart(int m, int s) {
    setStart(new LocalTime(0, m, s));
  }

  public void setStart(LocalTime start) {
    this.start = start;
  }

  public HRVOptions startTime(LocalTime start) {
    this.start = start;
    return this;
  }

}
