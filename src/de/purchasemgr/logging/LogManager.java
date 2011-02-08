package de.purchasemgr.logging;

import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import de.purchasemgr.i18n.Messages;

/**
 * This class is used to give the ability to log notes. There are two types of messages:<br>
 * <li>information</li><li>error</li><br>
 * both will have another output stream.
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public final class LogManager {

  /**
   * Hidden constructor, don't call it - utility class.
   * 
   * @author croesch
   * @since Date: 08.02.2011 16:55:02
   * @throws AssertionError on invocation
   */
  private LogManager() throws AssertionError {
    throw new AssertionError();
  }

  /** output stream for information messages */
  private static final PrintStream INFORMATION_STREAM = System.out;

  /** output stream for error messages */
  private static final PrintStream ERROR_STREAM = System.err;

  /**
   * Logs the given message to the info log stream
   * 
   * @param msg the message that should be logged.
   */
  public static void log(final String msg) {
    LogManager.log(msg, false);
  }

  /**
   * Logs the given message to the log stream. The parameter err defines whether the selected stream is the error stream
   * or the info stream.
   * 
   * @param msg the message that should be logged.
   * @param err whether the message is an error message
   */
  public static void log(final String msg, final boolean err) {
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.GERMAN);
    String date = df.format(new Date());
    if (err) {
      String txt = Messages.LOG_ERROR.text(date, msg);
      ERROR_STREAM.println(txt);
    } else {
      String txt = Messages.LOG_INFO.text(date, msg);
      INFORMATION_STREAM.println(txt);
    }
  }
}
