##Java Wrapper for [PhysioNet](http://www.physionet.org/)'s [PhysioToolkit](http://www.physionet.org/physiotools/)

### Prerequisites

- Installed [WFDB](http://www.physionet.org/physiotools/wfdb.shtml) software package
- Installed [HRV Toolkit](http://www.physionet.org/tutorials/hrv-toolkit/)
- [Maven](http://maven.apache.org/) for building
- Rake (to get the test files)

### Installation

```
git clone git@github.com:pangratz/physiotoolkit-wrapper.git
cd physiotoolkit-wrapper
```

#### Execute tests

Download the files needed for the tests via executing ```rake```. This has to be done once.

Run all tests via ```mvn clean test```

#### Create JAR

Run ````mvn package````