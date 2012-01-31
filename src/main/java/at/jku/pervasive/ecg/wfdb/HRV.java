package at.jku.pervasive.ecg.wfdb;

import java.util.Scanner;

public class HRV {

  private double AVNN;
  private double SDNN;

  public HRV(String getHrvResult) {
    super();
    System.out.println(getHrvResult);
    parse(getHrvResult);
  }

  public double getAVNN() {
    return AVNN;
  }

  public double getSDNN() {
    return SDNN;
  }

  private void parse(String string) {
    Scanner s = new Scanner(string);
    while (s.hasNextLine()) {
      String l = s.nextLine();
      String[] split = l.split(" = ");
      if (split[0].trim().equals("SDNN")) {
        String dS = split[1];
        this.SDNN = Double.parseDouble(dS);
      } else if (split[0].trim().equals("AVNN")) {
        this.AVNN = Double.parseDouble(split[1]);
      }
    }
  }

}
