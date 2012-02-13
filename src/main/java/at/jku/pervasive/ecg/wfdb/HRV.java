package at.jku.pervasive.ecg.wfdb;

import java.util.Scanner;

public class HRV {

  private double AVNN, SDNN, NNRR, rMSSD, pNN20, pNN50, TOT_PWR, VLF_PWR,
      LF_PWR, HF_PWR, LFHF;

  public HRV(String getHrvResult) {
    super();
    System.out.println(getHrvResult);
    parse(getHrvResult);
  }

  public double getAVNN() {
    return AVNN;
  }

  public double getHF_PWR() {
    return HF_PWR;
  }

  public double getLF_PWR() {
    return LF_PWR;
  }

  public double getLFHF() {
    return LFHF;
  }

  public double getNNRR() {
    return NNRR;
  }

  public double getpNN20() {
    return pNN20;
  }

  public double getpNN50() {
    return pNN50;
  }

  public double getrMSSD() {
    return rMSSD;
  }

  public double getSDNN() {
    return SDNN;
  }

  public double getTOT_PWR() {
    return TOT_PWR;
  }

  public double getVLF_PWR() {
    return VLF_PWR;
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
