task :default => [:download_test_sources]

task :download_test_sources do
  dir = "src/test/resources"
  `wget -P #{dir} http://www.physionet.org/atm/chfdb/chf03/export/chf03.zip`
  `tar -xvzf #{dir}/chf03.zip -C #{dir}`
  `rm #{dir}/chf03.zip`
end