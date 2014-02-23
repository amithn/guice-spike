package com.ssda.logger;

public class LoggerUtil {

    public static String getClassname(String fqname) {
        String[] splitDots = getSplits(fqname);
        return splitDots[splitDots.length - 2];
    }

    private static String[] getSplits(String fqname) {
        String[] splits = fqname.split(" ");
        String last = splits[splits.length -1];
        last = last.split("\\(")[0];
        String[] splitDots = last.split("\\.");
        return splitDots;
    }
}
