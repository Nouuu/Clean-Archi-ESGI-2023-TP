package org.esgi.cleanarchi.kernel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String s) {
        String date = generateDateOfNowFormatted();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ok+]");
        stringBuilder.append("[" + date + "]");
        stringBuilder.append(" ");
        stringBuilder.append(s);
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void logError(String s) {
        String date = generateDateOfNowFormatted();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[err]");
        stringBuilder.append("[" + date + "]");
        stringBuilder.append(" ");
        stringBuilder.append(s);
        System.err.println(stringBuilder.toString());
    }

    private String generateDateOfNowFormatted(){
        Date date = new Date();
        DateFormat destinationFormat = new SimpleDateFormat("yyyy-MM-dd:HH'h'mm','ss");
        return destinationFormat.format(date);
    }
}
