package de.purchasemgr;

import de.purchasemgr.core.MainController;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.i18n.Strings;

/**
 * Einkaufsverwalter is a software to manage your purchases. It will give you statistics how much money you spend when, where and for what. */
/**
 * Copyright (C) 2010 Christian Rösch
 */
/**This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version. */
/**
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * @author croesch
 * @since Date: 2010/12/19 12:56:24
 */
public class Main {

  /** The version String for the whole program */
  public static final String VERSION = Strings.PROGRAM_VERSION.text();

  /** The name String for the whole program */
  public static final String NAME = Messages.PROGRAM_NAME + VERSION;

  /**
   * Starts the main program
   * 
   * @author croesch
   * @since 10.12.2009
   * @param args the array of arguments
   */
  public static void main(String[] args) {
    MainController controller = new MainController();
    controller.start();
  }

}
