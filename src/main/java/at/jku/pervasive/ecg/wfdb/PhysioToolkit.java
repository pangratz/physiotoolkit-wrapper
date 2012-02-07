package at.jku.pervasive.ecg.wfdb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.joda.time.LocalTime;

public class PhysioToolkit {

  public HRV hrv(File edf, String annotator, LocalTime startTime,
      LocalTime endTime, String... params) throws Exception {

    List<String> cmd = new ArrayList<String>();
    cmd.add("get_hrv");
    if (params != null && params.length > 0) {
      cmd.addAll(Arrays.asList(params));
    }
    cmd.add(edf.getName());
    cmd.add(annotator);

    if (startTime != null) {
      cmd.add(startTime.toString("HH:mm:ss"));
    }
    if (endTime != null) {
      cmd.add(endTime.toString("HH:mm:ss"));
    }

    ProcessBuilder pb = createProcessBuilder(cmd);
    pb.redirectErrorStream(true);
    pb.directory(edf.getParentFile());
    Process start = pb.start();
    start.waitFor();
    InputStream in = start.getInputStream();
    HRV hrvResult = new HRV(IOUtils.toString(in));
    IOUtils.closeQuietly(in);
    return hrvResult;
  }

  public HRV hrv(File edf, String annotator, String... params) throws Exception {
    return hrv(edf, annotator, null, null, params);
  }

  public HRV hrv(HRVOptions options) {
    throw new IllegalStateException();
  }

  public boolean isInstalled() throws IOException, InterruptedException {
    ProcessBuilder pb = createProcessBuilder("hash", "wfdbdesc");
    Process process = pb.start();
    return (process.waitFor() == 0);
  }

  public void rdsamp(File edf) {

  }

  public void sqrs(File testFile) throws IOException, InterruptedException {
    ProcessBuilder pb = createProcessBuilder("sqrs", "-r", testFile.getName());
    pb.redirectErrorStream(true);
    pb.directory(testFile.getParentFile());
    Process process = pb.start();
    process.waitFor();
    InputStream in = process.getInputStream();
    System.out.println(IOUtils.toString(in));
  }

  public void testLocale() throws Exception {
    ProcessBuilder pb = createProcessBuilder("locale");
    Process process = pb.start();
    process.waitFor();
    InputStream in = process.getInputStream();

    System.out.println(IOUtils.toString(in));
  }

  protected ProcessBuilder createProcessBuilder(List<String> command) {
    ProcessBuilder pb = new ProcessBuilder(command);
    setLocale(pb);
    return pb;
  }

  protected ProcessBuilder createProcessBuilder(String... command) {
    return createProcessBuilder(Arrays.asList(command));
  }

  private void setLocale(Map<String, String> env) {
    env.put("LC_ALL", "C");
    // env.put("LANG", "C");
    // env.put("LC_COLLATE", "C");
    // env.put("LC_CTYPE", "C");
    // env.put("LC_MESSAGES", "C");
    // env.put("LC_MONETARY", "C");
    // env.put("LC_NUMERIC", "C");
    // env.put("LC_TIME", "C");
  }

  private void setLocale(ProcessBuilder pb) {
    this.setLocale(pb.environment());
  }

}
