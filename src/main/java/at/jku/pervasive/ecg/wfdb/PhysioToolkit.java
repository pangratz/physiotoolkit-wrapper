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

  public HRV hrv(HRVOptions options) throws Exception {
    ProcessBuilder pb = createProcessBuilder(options.getCommand());
    pb.redirectErrorStream(true);
    File baseDirectory = options.getBaseDirectory();
    if (baseDirectory != null && baseDirectory.exists()) {
      pb.directory(baseDirectory);
    }
    Process start = pb.start();
    start.waitFor();
    InputStream in = start.getInputStream();
    HRV hrvResult = new HRV(IOUtils.toString(in));
    IOUtils.closeQuietly(in);
    return hrvResult;
  }

  public boolean isInstalled() throws IOException, InterruptedException {
    /**
     * Implementation: check if every needed command is available. This is done
     * by executing the hash command and looking at the exit code. The exit code
     * 0 indicates the command is installed correctly. Assuming every needed
     * command is available, he exit code sum up to 0.
     */
    int status = 0;
    status += execute("hash", "edf2mit");
    status += execute("hash", "get_hrv");
    status += execute("hash", "rdsamp");
    status += execute("hash", "sqrs");
    return (status == 0);
  }

  public void rdsamp(File edf) throws IOException, InterruptedException {
    ProcessBuilder pb = createProcessBuilder("rdsamp", edf.getName());
    pb.directory(edf.getParentFile());
    Process process = pb.start();
    process.waitFor();
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

  protected int execute(String... command) throws IOException,
      InterruptedException {
    ProcessBuilder pb = createProcessBuilder(command);
    Process process = pb.start();
    return process.waitFor();
  }

  private void setLocale(Map<String, String> env) {
    String lang = "en_US.UTF-8";
    env.put("LANG", lang);
    env.put("LC_COLLATE", lang);
    env.put("LC_CTYPE", lang);
    env.put("LC_MESSAGES", lang);
    env.put("LC_MONETARY", lang);
    env.put("LC_NUMERIC", lang);
    env.put("LC_TIME", lang);
    // env.put("LC_ALL", lang);
  }

  private void setLocale(ProcessBuilder pb) {
    this.setLocale(pb.environment());
  }

}
