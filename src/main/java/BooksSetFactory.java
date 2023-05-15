import java.util.List;


public class BooksSetFactory {
	List<BooksSetDiscount> discounts;

    public BooksSetFactory(List<BooksSetDiscount> discounts){
        this.discounts = discounts;
    }
    
    public List<BooksSet> getDifferentBooksSetsWithMaxTotalDiscount(List<ShoppingCartItem> shoppingCartItems) {

        List<BooksSet> optimizeSetList=null;

        //optimizeSetList = getBestCombinationBooksSets(shoppingCartItems);

        return optimizeSetList;
    }
    

}
