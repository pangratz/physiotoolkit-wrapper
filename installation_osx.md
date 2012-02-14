## Install WFDB

- download and unzip http://physionet.org/physiotools/wfdb.tar.gz
- cd into the unzipped folder
- mate conf/darwin*
	- remove all "-arch ppc"
- execute: "./configure --prefix=/usr/local/Cellar/wfdb/10.5.10 -m32"
- execute: "make install"
- execute: "make check" to see if tests pass
- add WFDB to path by "brew link wfdb"
    
## Install HRV Toolkit
    
- download and unzip http://physionet.org/tutorials/hrv-toolkit/HRV-i386-Darwin.tar.gz
- cd into unzipped folder
- execute "mkdir -p /usr/local/Cellar/hrv/1.0/bin"
- copy all files: "cp * /usr/local/Cellar/hrv/1.0/bin"
- add HRV to path by "brew link hrv"