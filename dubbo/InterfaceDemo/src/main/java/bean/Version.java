package bean;

public enum Version {


    ;
    private long versionLong=1L;
    private String versionString="1.0.0";


    Version(long versionLong, String versionString) {
        this.versionLong = versionLong;
        this.versionString = versionString;
    }

    public long getVersionLong() {
        return versionLong;
    }

    public void setVersionLong(long versionLong) {
        this.versionLong = versionLong;
    }

    public String getVersionString() {
        return versionString;
    }

    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }
}
