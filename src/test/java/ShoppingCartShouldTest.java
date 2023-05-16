import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cart.Book;
import cart.ShoppingCart;
import price.BooksSetDiscount;
import price.BooksSetFactory;
import price.PriceCalculatorByBooksSetDiscount;

public class ShoppingCartShouldTest {
	ShoppingCart shoppingCart;

    @Before
    public void setup(){
        List<BooksSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();

        byDifferentCopiesDiscountList.add(new BooksSetDiscount(2,5));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(3,10));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(4,20));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(5,25));

        BooksSetFactory booksSetFactory = new BooksSetFactory(byDifferentCopiesDiscountList);
        shoppingCart = new ShoppingCart(new PriceCalculatorByBooksSetDiscount(booksSetFactory));
    }
    @Test
    public void have_normal_price_when_buy_one_copy(){

        Book harryPotterI = Catalog.GivenAHarryPotterIBook();

        shoppingCart.Add(harryPotterI);

        assertThat(shoppingCart.getTotalPrice(), is(8.0));

    }
}
