package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Edf2MitOptions {

  private final File edfFile;

  public Edf2MitOptions(File edfFile) {
    super();
    this.edfFile = edfFile;
  }

  public List<String> getCommand() {
    List<String> command = new ArrayList<String>();
    command.add("edf2mit");
    if (edfFile != null) {
      command.add("-i");
      command.add(edfFile.getName());
    }
    return command;
  }

}
