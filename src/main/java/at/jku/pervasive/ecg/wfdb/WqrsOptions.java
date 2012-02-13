package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.List;

public class WqrsOptions extends DetectQRSOptions {

  private boolean annotateJPoints, resample;
  private int powerLine = -1;

  public WqrsOptions(File record) {
    super(record);
    setCommand("wqrs");
  }

  @Override
  public List<String> getCommand() {
    List<String> cmd = super.getCommand();

    if (annotateJPoints) {
      cmd.add("-j");
    }

    if (resample) {
      cmd.add("-R");
    }

    if (powerLine != -1) {
      cmd.add("-p");
      cmd.add(Integer.toString(powerLine));
    }

    return cmd;
  }

  public int getPowerLine() {
    return powerLine;
  }

  public boolean isAnnotateJPoints() {
    return annotateJPoints;
  }

  public boolean isResample() {
    return resample;
  }

  public WqrsOptions setAnnotateJPoints(boolean annotateJPoints) {
    this.annotateJPoints = annotateJPoints;
    return this;
  }

  public WqrsOptions setPowerLine(int powerLine) {
    this.powerLine = powerLine;
    return this;
  }

  public WqrsOptions setResample(boolean resample) {
    this.resample = resample;
    return this;
  }

}
