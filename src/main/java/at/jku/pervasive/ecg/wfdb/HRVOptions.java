package at.jku.pervasive.ecg.wfdb;

import java.io.File;

import org.joda.time.LocalTime;

public class HRVOptions {

  private final String annotation;
  private final File file;
  private LocalTime start;

  public HRVOptions(File file, String annotation) {
    super();
    this.file = file;
    this.annotation = annotation;
  }

  public HRVOptions startTime(LocalTime start) {
    this.start = start;
    return this;
  }

}
