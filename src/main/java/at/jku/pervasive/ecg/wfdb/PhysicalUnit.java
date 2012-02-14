package at.jku.pervasive.ecg.wfdb;

public enum PhysicalUnit {
  p, P, pd, Pd, pe, Pe, ph, Ph, pm, Pm, ps, pS, Ps, PS;

  public String getParameter() {
    return "-" + name();
  }

}
