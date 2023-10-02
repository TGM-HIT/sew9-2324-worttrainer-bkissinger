package Model;

import org.json.JSONObject;

public class Wortpaar {
    private String url;
    private String wort;

    public Wortpaar(String url, String wort) {
        this.url = url;
        this.wort = wort;
    }

    public String getUrl() {
        return this.url;
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

    public static Wortpaar fromJSON(JSONObject obj) {
        String url = obj.getString("url");
        String wort = obj.getString("wort");

        Wortpaar w = new Wortpaar(url, wort);
        return w;
    }
}
