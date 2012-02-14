package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Edf2MitOptions {

  private File baseDirectory;
  private final File edfFile;
  private boolean isBigEndian;
  private final String outputName;
  private int[] signals;

  public Edf2MitOptions(File edfFile) {
    super();
    this.outputName = UUID.randomUUID().toString();
    this.edfFile = edfFile;
    if (edfFile != null && edfFile.exists()) {
      this.baseDirectory = edfFile.getParentFile();
    }
  }

  public File getBaseDirectory() {
    return baseDirectory;
  }

  public List<String> getCommand() {
    List<String> command = new ArrayList<String>();
    command.add("edf2mit");
    if (edfFile != null) {
      command.add("-i");
      command.add(edfFile.getName());
    }

    command.add("-r");
    command.add(outputName);

    if (isBigEndian) {
      command.add("-b");
    }

    if (ArrayUtils.isNotEmpty(signals)) {
      command.add("-s");
      command.add(StringUtils.join(ArrayUtils.toObject(signals), " "));
    }

    return command;
  }

  public String getOutputName() {
    return outputName;
  }

  public boolean isBigEndian() {
    return isBigEndian;
  }

  public Edf2MitOptions setBaseDirectory(File baseDirectory) {
    this.baseDirectory = baseDirectory;
    return this;
  }

  public Edf2MitOptions setBigEndian(boolean isBigEndian) {
    this.isBigEndian = isBigEndian;
    return this;
  }

  public Edf2MitOptions setSignals(int... signals) {
    this.signals = signals;
    return this;
  }

}
