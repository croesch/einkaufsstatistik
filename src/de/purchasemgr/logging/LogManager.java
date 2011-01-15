package de.purchasemgr.logging;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import de.purchasemgr.i18n.Messages;

/**
 * TODO Comment here
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public class LogManager {

  /**
   * Logs the given message to the info log stream
   * 
   * @param msg the message that should be logged.
   */
  public static void log(String msg) {
    LogManager.log(msg, false);
  }

  /**
   * Logs the given message to the log stream. The parameter err defines whether the selected stream is the error stream
   * or the info stream.
   * 
   * @param msg the message that should be logged.
   * @param err whether the message is an error message
   */
  public static void log(String msg, boolean err) {
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.GERMAN);
    String date = df.format(new Date());
    if (err) {
      String txt = Messages.LOG_ERROR.text(date, msg);
      System.err.println(txt);
    } else {
      String txt = Messages.LOG_INFO.text(date, msg);
      System.out.println(txt);
    }
  }
}
