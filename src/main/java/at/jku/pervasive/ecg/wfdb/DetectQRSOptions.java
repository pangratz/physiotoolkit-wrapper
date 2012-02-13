package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalTime;

public class SqrsOptions {

  private boolean highResolutionMode;
  private final File record;
  private int signal = -1, treshold = -1;
  private LocalTime startTime, endTime;

  public SqrsOptions(File record) {
    super();
    this.record = record;
  }

  public List<String> getCommand() {
    List<String> cmd = new LinkedList<String>();
    cmd.add("sqrs");
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

  public SqrsOptions setEndTime(LocalTime endTime) {
    this.endTime = endTime;
    return this;
  }

  public SqrsOptions setHighResolutionMode(boolean highResolutionMode) {
    this.highResolutionMode = highResolutionMode;
    return this;
  }

  public SqrsOptions setSignal(int signal) {
    this.signal = signal;
    return this;
  }

  public SqrsOptions setStartTime(LocalTime startTime) {
    this.startTime = startTime;
    return this;
  }

  public SqrsOptions setTreshold(int treshold) {
    this.treshold = treshold;
    return this;
  }

}
