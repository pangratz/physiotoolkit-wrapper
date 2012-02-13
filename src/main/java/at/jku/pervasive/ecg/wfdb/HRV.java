package at.jku.pervasive.ecg.wfdb;

import java.util.Scanner;

public class HRV {

  private double AVNN, SDNN, SDANN, SDNNIDX, NNRR, rMSSD, pNN20, pNN50,
      TOT_PWR, ULF_PWR, VLF_PWR, LF_PWR, HF_PWR, LFHF;

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

  public double getSDANN() {
    return SDANN;
  }

  public double getSDNN() {
    return SDNN;
  }

  public double getSDNNIDX() {
    return SDNNIDX;
  }

  public double getTOT_PWR() {
    return TOT_PWR;
  }

  public double getULF_PWR() {
    return ULF_PWR;
  }

  public double getVLF_PWR() {
    return VLF_PWR;
  }

  private void parse(String string) {
    Scanner s = new Scanner(string);
    while (s.hasNextLine()) {
      processLine(s.nextLine());
    }
  }

  private void processLine(String line) {
    Scanner s = new Scanner(line);
    s.useDelimiter(" = ");
    if (s.hasNext()) {
      String name = s.next().trim();
      if (s.hasNext()) {
        String valueStr = s.next().trim();
        double value = Double.parseDouble(valueStr);

        /**
         * next: beautiful String switch
         * 
         * we're using JDK6 and the String switch statement has been made
         * available in JDK7 - 16 years after requesting it:
         * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=1223179
         **/
        if ("AVNN".equals(name)) {
          this.AVNN = value;
        } else if ("SDNN".equals(name)) {
          this.SDNN = value;
        } else if ("SDANN".equals(name)) {
          this.SDANN = value;
        } else if ("SDNNIDX".equals(name)) {
          this.SDNNIDX = value;
        } else if ("NN/RR".equals(name)) {
          this.NNRR = value;
        } else if ("rMSSD".equals(name)) {
          this.rMSSD = value;
        } else if ("pNN20".equals(name)) {
          this.pNN20 = value;
        } else if ("pNN50".equals(name)) {
          this.pNN50 = value;
        } else if ("TOT PWR".equals(name)) {
          this.TOT_PWR = value;
        } else if ("ULF PWR".equals(name)) {
          this.ULF_PWR = value;
        } else if ("VLF PWR".equals(name)) {
          this.VLF_PWR = value;
        } else if ("LF PWR".equals(name)) {
          this.LF_PWR = value;
        } else if ("HF PWR".equals(name)) {
          this.HF_PWR = value;
        } else if ("LF/HF".equals(name)) {
          this.LFHF = value;
        }
      }
    }
  }
}
