package de.purchasemgr.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;

import de.purchasemgr.i18n.Strings;

/**
 * Utility class for Mnemonic operations
 * 
 * @author $Author: croesch $
 * @version $Revision: 1.1 $ ($Date: 2010/12/19 12:56:24 $)
 */
public class MnemonicUtil {

  /** Version number. */
  public static final String VER = "$Revision: 1.1 $"; //$NON-NLS-1$

  /**
   * Filters the mnemonic definition from the given string. If a mnemonic definition ([m]) is found, it will be set to
   * the given AbstractButton.
   * 
   * @param s the String that contains the mnemonic definition
   * @param b the AbstractButton that should get the mnemonic
   * @return the String without the [] of the definition
   */
  static String filterMnemonic(String s, AbstractButton b) {
    Matcher m = Pattern.compile(Strings.REGEX_MNEMONIC.text()).matcher(s);
    if (m.find()) {
      b.setMnemonic(m.group(1).charAt(0));
      s = m.replaceFirst(m.group(1));
    }
    return s;
  }

}
