package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalTime;

public class DetectQRSOptions {

  private File baseDirectory;
  private String command;
  private boolean highResolutionMode;
  private final File record;
  private int signal = -1, treshold = -1;
  private LocalTime startTime, endTime;

  public DetectQRSOptions(File record) {
    super();
    this.command = "sqrs";
    this.record = record;
    if (record != null) {
      this.baseDirectory = record.getParentFile();
    }
  }

  public File getBaseDirectory() {
    return baseDirectory;
  }

  public List<String> getCommand() {
    List<String> cmd = new LinkedList<String>();
    cmd.add(command);
    cmd.add("-r");
    cmd.add(record.getName());

    if (startTime != null) {
      cmd.add("-f");
      cmd.add(startTime.toString("HH:mm:ss"));
    }

    if (endTime != null) {
      cmd.add("-t");
      cmd.add(endTime.toString("HH:mm:ss"));
    }

    if (highResolutionMode) {
      cmd.add("-H");
    }

    if (signal != -1) {
      cmd.add("-s");
      cmd.add(Integer.toString(signal));
    }

    if (treshold != -1) {
      cmd.add("-m");
      cmd.add(Integer.toString(treshold));
    }

    return cmd;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public File getRecord() {
    return record;
  }

  public int getSignal() {
    return signal;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public int getTreshold() {
    return treshold;
  }

  public boolean isHighResolutionMode() {
    return highResolutionMode;
  }

  public DetectQRSOptions setBaseDirectory(File baseDirectory) {
    this.baseDirectory = baseDirectory;
    return this;
  }

  public DetectQRSOptions setCommand(String command) {
    this.command = command;
    return this;
  }

  public DetectQRSOptions setEndTime(LocalTime endTime) {
    this.endTime = endTime;
    return this;
  }

  public DetectQRSOptions setHighResolutionMode(boolean highResolutionMode) {
    this.highResolutionMode = highResolutionMode;
    return this;
  }

  public DetectQRSOptions setSignal(int signal) {
    this.signal = signal;
    return this;
  }

  public DetectQRSOptions setStartTime(LocalTime startTime) {
    this.startTime = startTime;
    return this;
  }

  public DetectQRSOptions setTreshold(int treshold) {
    this.treshold = treshold;
    return this;
  }

}
