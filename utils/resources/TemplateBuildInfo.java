
package __PACKAGE;

public class BuildInfo {
    private static final String branch = "__BRANCH";
    private static final String artifact = "__ARTIFACT";
    private static final String version = "__VERSION";
    private static final String buildTimestamp = "__BUILD_TIMESTAMP";

    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("branch: " + branch + "\n");
        buffer.append("artifact: " + artifact + "\n");
        buffer.append("version: " + version + "\n");
        buffer.append("build timestamp: " + buildTimestamp + "\n");

        return buffer.toString();
    }

    public static void main(String[] args) {
        BuildInfo buildInfo = new BuildInfo();
        System.out.println("TRACER : " + buildInfo.toString());
    }
}
