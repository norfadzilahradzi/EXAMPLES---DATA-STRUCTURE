/**
 * A class that maintains a shopping cart for an online store.
 */
package OnlineShopping;

public class OnlineShopping {
    
    public static void main (String[] args) {
        Item[] item = {new Item ("Bird feeder", 2050),
                        new Item ("Squirrel guard", 1547),
                        new Item ("Bird bath", 4499),
                        new Item ("Sunflower seeds", 1295)};
        
        BagInterface<Item> shoppingCart = new ArrayBag<>();
        int totalCost = 0;
        
        //STATEMENT THAT ADD SELECTED ITEMS TO THE SHOPPING CART
        for (int i = 0; i < item.length; i++) {
            Item nextItem = item[i];    //GETTING ITEM FROM SHOPPER
            shoppingCart.add(nextItem);
            totalCost = totalCost = nextItem.getPrice();
        }
        
        while (!(shoppingCart.isEmpty())) {
            System.out.println(shoppingCart.remove());
        }
        System.out.println("Total cost : " + "\t$" + totalCost/100 + "." + totalCost%100);
        
        //END ONLINE SHOPPING
    }
}
