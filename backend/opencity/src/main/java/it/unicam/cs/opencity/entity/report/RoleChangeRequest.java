package it.unicam.cs.opencity.entity.report;

public class RoleChangeRequest extends Report {

    private String requiredRoleId;
    private String cityId;
    private String statusId;

    public RoleChangeRequest(String requiredRoleId, String cityId, String statusId) {
        this.requiredRoleId = requiredRoleId;
        this.cityId = cityId;
        this.statusId = statusId;
    }

    public String getRequiredRoleId() {
        return requiredRoleId;
    }

    public void setRequiredRoleId(String requiredRoleId) {
        this.requiredRoleId = requiredRoleId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }
}
