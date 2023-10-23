package Model;

import org.json.JSONObject;

public class Wortpaar {
    private String url;
    private String wort;

    /**
     * Wortpaar besteht aus url und Wort
     * @param url URL
     * @param wort Wort
     */
    public Wortpaar(String url, String wort) {
        this.url = url;
        this.wort = wort;
    }

    /**
     * Gibt die Url zurück
     * @return url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Url setzen
     * @param url url
     */
    public void setUrl(String url) {
        if (url != null) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("Answer is null!");
        }
    }

    /**
     * Returned das Wort
     * @return Wort
     */
    public String getWort() {
        return wort;
    }

    /**
     * Setzt das Wort
     * @param wort wort
     */
    public void setWort(String wort) {
        this.wort = wort;
    }

    /**
     * Erstellt ein Wortpaar aus JSON
     * @param obj JSON
     * @return Wortpaar
     */
    public static Wortpaar fromJSON(JSONObject obj) {
        String url = obj.getString("url");
        String wort = obj.getString("wort");

        Wortpaar w = new Wortpaar(url, wort);
        return w;
    }
}
