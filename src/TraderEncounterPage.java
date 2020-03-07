package src;

import javafx.stage.Stage;

public class TraderEncounterPage {
    /*
    * Option 1 - Buy Item:
    *   - itemSold = trader.getItemToSell()
    *   * check if the player has enough credit to purchase item(s)
    *   - push (itemSold, itemSold.getQuantity()) to player's inventory
    *   * I don't think the trader's inventory needs to be updated since it doesn't affect anything
    *
    * Option 2 - Ignore Trader:
    *   - continue to intended destination
    *
    * Option 3 - Rob trader:
    *   1. Determine the player's success by doing trader.determineSuccess(player.getFighterSkill)
    *       - if (success) -> player robs itemToSell
    *         * the rubric only says "some of trader's items are added to player inventory" so I guess it doesn't really
    *            matter which item/how many of them is stolen?
    *       - else -> player's ship health lowered, continues to intended destination
    * Option 4 - Negotiate price
    *   1. trader.determineSuccess(player.getMerchantSkill)
    *       - if (success) -> trader.decreasePrice()
    *       - else -> trader.increasePrice()
    *  2. get rid of option 4 since the player can negotiate for price only once
    *  */
    public TraderEncounterPage(Stage primaryStage, Region[] regions, Player p1, Trader trader) {}

}
