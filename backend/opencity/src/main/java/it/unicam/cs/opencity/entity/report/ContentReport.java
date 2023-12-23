package it.unicam.cs.opencity.entity.report;

public class ContentReport extends Report {

    private Integer contentId;

    public ContentReport(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }
}
