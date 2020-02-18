package entitys.PostContent;

import org.jsoup.nodes.Element;

public class PostContent {
    private String tieuDe;
    private String content;

    public PostContent() {
    }

    public PostContent(String tieuDe, String content) {
        this.tieuDe = tieuDe;
        this.content = content;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
