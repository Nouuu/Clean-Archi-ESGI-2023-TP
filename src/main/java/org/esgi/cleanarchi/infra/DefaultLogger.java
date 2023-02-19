package org.esgi.cleanarchi.infra;

import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.kernel.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultLogger implements Logger {
    private final Writer errorWriter;
    private final Writer writer;

    public DefaultLogger(Writer writer, Writer errorWriter) {
        this.writer = writer;
        this.errorWriter = errorWriter;
    }

    public DefaultLogger(Writer writer) {
        this.writer = writer;
        this.errorWriter = writer;
    }

    @Override
    public void log(String s) {
        String date = generateDateOfNowFormatted();
        String message = "[ok+]" +
                "[" + date + "]" +
                " " +
                s;
        writer.write(message);
    }

    @Override
    public void logError(String s) {
        String date = generateDateOfNowFormatted();
        String stringBuilder = "[err]" +
                "[" + date + "]" +
                " " +
                s;
        errorWriter.write(stringBuilder);
    }

    private String generateDateOfNowFormatted() {
        Date date = new Date();
        DateFormat destinationFormat = new SimpleDateFormat("yyyy-MM-dd:HH'h'mm','ss");
        return destinationFormat.format(date);
    }
}
