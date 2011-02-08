package de.purchasemgr.i18n;

/**
 * Provides Strings not needed for i18n
 * 
 * @author croesch
 * @since Date: 2010/12/19 14:41:45
 */
@SuppressWarnings("nls")
public enum Strings {

  /** path to properties file of messages */
  MESSAGES_PROPERTIES_FILE ("messages"),

  /** path to properties file of keystrokes */
  KEYSTROKES_PROPERTIES_FILE ("config/keystrokes.properties"),

  /** the program version string */
  PROGRAM_VERSION ("@@VERSION@@"),

  /** constant for an empty string */
  EMPTY_STRING (""),

  /** the regular expression to find a mnemonic */
  REGEX_MNEMONIC ("\\[(.)\\]"),

  /** the string for the word right used for mig layout */
  RIGHT ("right");

  /** the value of this instance */
  private final String string;

  /**
   * Constructs an instance of this enum.
   * 
   * @author croesch
   * @since Date: 08.02.2011 19:14:27
   * @param s is the value of this instance
   */
  private Strings(final String s) {
    this.string = s;
  }

  @Override
  public String toString() {
    return text();
  }

  /**
   * String representation of this object
   * 
   * @return the String that represents the object
   */
  public String text() {
    return this.string;
  }
}
