package it.unicam.cs.opencity.entity.report;

public class SystemProblemReport extends Report {

    private String version;
    private String instructions;

    public SystemProblemReport(String version, String instructions) {
        this.version = version;
        this.instructions = instructions;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
