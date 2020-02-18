package entitys.rsscontent;

public class RssContent {
    private String tieuDe;
    private String urlRss;

    public RssContent() {
    }

    public RssContent(String tieuDe, String urlRss) {
        this.tieuDe = tieuDe;
        this.urlRss = urlRss;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getUrlRss() {
        return urlRss;
    }

    public void setUrlRss(String urlRss) {
        this.urlRss = urlRss;
    }


}
