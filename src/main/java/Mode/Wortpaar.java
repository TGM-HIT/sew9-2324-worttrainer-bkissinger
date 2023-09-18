package Mode;

public class Wortpaar {
    private String url;
    private String wort;

    public Wortpaar(String url, String wort) {
        this.url = url;
        this.wort = wort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }
}
