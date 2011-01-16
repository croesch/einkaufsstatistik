package de.purchasemgr.core;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.crhcomponents.components.CMenu;
import de.crhcomponents.components.CMenuItem;
import de.purchasemgr.ActionPool;
import de.purchasemgr.i18n.KeyStrokes;
import de.purchasemgr.i18n.Messages;

/**
 * Menu bar for the main program
 * 
 * @author croesch
 * @since Date: 16.01.2011 16:16:09
 */
public class MainMenuBar extends JMenuBar {

  /** generated serial version UID */
  private static final long serialVersionUID = -580701349212930525L;

  /**
   * Constructs the menu bar for the main program
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:18:13
   */
  public MainMenuBar() {
    JMenuBar mb = new JMenuBar();
    JMenu menu, edit, stat, help, statPurchase, statExpenses;
    JMenuItem newFile, save, open, exit, items, shops, general;
    JMenuItem purchaseShop, purchaseWDay, purchaseMonth, purchaseYear, purchaseItems, expensesShop;
    JMenuItem expensesWDay, expensesMonth, expensesYear, expensesItems, options, about, version;
    JMenuItem newShop;

    menu = new CMenu(Messages.MB_MENU.text());
    edit = new CMenu(Messages.MB_EDIT.text());
    stat = new CMenu(Messages.MB_STAT.text());
    help = new CMenu(Messages.MB_HELP.text());
    statPurchase = new CMenu(Messages.MB_STAT_PURCHASE.text());
    statExpenses = new CMenu(Messages.MB_STAT_EXPENSES.text());

    // Menu - Items
    newFile = new CMenuItem(ActionPool.FILE_NEW.getAction());
    save = new CMenuItem(ActionPool.FILE_SAVE.getAction());
    open = new CMenuItem(ActionPool.FILE_OPEN.getAction());
    exit = new CMenuItem(ActionPool.EXIT.getAction());

    // Menu - Items - Keys
    newFile.setAccelerator(KeyStrokes.FILE_NEW.stroke());
    save.setAccelerator(KeyStrokes.FILE_SAVE.stroke());
    open.setAccelerator(KeyStrokes.FILE_OPEN.stroke());
    exit.setAccelerator(KeyStrokes.PROGRAM_EXIT.stroke());

    // Menu - add Items
    menu.add(newFile);
    menu.add(open);
    menu.addSeparator();
    menu.add(save);
    menu.addSeparator();
    menu.add(exit);

    //edit - Items
    items = new CMenuItem(ActionPool.EDIT_ITEMS.getAction());
    shops = new CMenuItem(ActionPool.EDIT_SHOPS.getAction());
    newShop = new CMenuItem(ActionPool.NEW_SHOP.getAction());

    //edit - items - keys
    items.setAccelerator(KeyStrokes.EDIT_ITEMS.stroke());
    newShop.setAccelerator(KeyStrokes.NEW_SHOP.stroke());
    shops.setAccelerator(KeyStrokes.EDIT_SHOPS.stroke());

    //edit - add items
    edit.add(items);
    edit.add(newShop);
    edit.add(shops);

    //statistic - expenses - items
    expensesItems = new CMenuItem(ActionPool.STAT_EXPENSES_ITEM.getAction());
    expensesShop = new CMenuItem(ActionPool.STAT_EXPENSES_SHOP.getAction());
    expensesWDay = new CMenuItem(ActionPool.STAT_EXPENSES_WDAY.getAction());
    expensesMonth = new CMenuItem(ActionPool.STAT_EXPENSES_MONT.getAction());
    expensesYear = new CMenuItem(ActionPool.STAT_EXPENSES_YEAR.getAction());

    //statistic - expenses - keys
    expensesItems.setAccelerator(KeyStrokes.STAT_EXPENSES_ITEM.stroke());
    expensesShop.setAccelerator(KeyStrokes.STAT_EXPENSES_SHOP.stroke());
    expensesWDay.setAccelerator(KeyStrokes.STAT_EXPENSES_WDAY.stroke());
    expensesMonth.setAccelerator(KeyStrokes.STAT_EXPENSES_MONT.stroke());
    expensesYear.setAccelerator(KeyStrokes.STAT_EXPENSES_YEAR.stroke());

    //statistic - expenses - add items
    statExpenses.add(expensesShop);
    statExpenses.add(expensesWDay);
    statExpenses.add(expensesMonth);
    statExpenses.add(expensesYear);
    statExpenses.add(expensesItems);

    //statistic - purchases - items
    purchaseItems = new CMenuItem(ActionPool.STAT_PURCHASE_ITEM.getAction());
    purchaseShop = new CMenuItem(ActionPool.STAT_PURCHASE_SHOP.getAction());
    purchaseWDay = new CMenuItem(ActionPool.STAT_PURCHASE_WDAY.getAction());
    purchaseMonth = new CMenuItem(ActionPool.STAT_PURCHASE_MONT.getAction());
    purchaseYear = new CMenuItem(ActionPool.STAT_PURCHASE_YEAR.getAction());

    //statistic - purchases - keys
    purchaseItems.setAccelerator(KeyStrokes.STAT_PURCHASE_ITEM.stroke());
    purchaseShop.setAccelerator(KeyStrokes.STAT_PURCHASE_SHOP.stroke());
    purchaseWDay.setAccelerator(KeyStrokes.STAT_PURCHASE_WDAY.stroke());
    purchaseMonth.setAccelerator(KeyStrokes.STAT_PURCHASE_MONT.stroke());
    purchaseYear.setAccelerator(KeyStrokes.STAT_PURCHASE_YEAR.stroke());

    //statistic - purchases - add items
    statPurchase.add(purchaseShop);
    statPurchase.add(purchaseWDay);
    statPurchase.add(purchaseMonth);
    statPurchase.add(purchaseYear);
    statPurchase.add(purchaseItems);

    //statistic - items
    general = new CMenuItem(ActionPool.STAT_GENERAL.getAction());

    //statistic - keys
    general.setAccelerator(KeyStrokes.STAT_GENERAL.stroke());

    //statistic - add items
    stat.add(general);
    stat.addSeparator();
    stat.add(statPurchase);
    stat.add(statExpenses);

    //help - items
    options = new CMenuItem(ActionPool.OPTIONS.getAction());
    version = new CMenuItem(ActionPool.VERSION_INFO.getAction());
    about = new CMenuItem(ActionPool.ABOUT.getAction());

    //help - keys
    options.setAccelerator(KeyStrokes.HELP_OPTIONS.stroke());
    version.setAccelerator(KeyStrokes.HELP_VERSION.stroke());
    about.setAccelerator(KeyStrokes.HELP_ABOUT.stroke());

    //help - add items
    help.add(options);
    help.addSeparator();
    help.add(version);
    help.addSeparator();
    help.add(about);

    mb.add(menu);
    mb.add(edit);
    mb.add(stat);
    mb.add(help);
  }
}
