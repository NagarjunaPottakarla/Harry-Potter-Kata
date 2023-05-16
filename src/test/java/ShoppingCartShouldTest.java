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

        Book harryPotterI = GivenAHarryPotterIBook();

        shoppingCart.Add(harryPotterI);

        assertThat(shoppingCart.getTotalPrice(), is(8.0));

    }
    @Test
    public void have_normal_price_when_buy_two_copies_of_the_same_book(){

        Book harryPotterI = GivenAHarryPotterIBook();

        shoppingCart.Add(harryPotterI);
        shoppingCart.Add(harryPotterI);

        assertThat(shoppingCart.getTotalPrice(), is(16.0));

    }

    @Test
    public void have_5_percent_of_discount_when_buy_two_different_copies(){

        Book harryPotterI = GivenAHarryPotterIBook();
        Book harryPotterII =GivenAHarryPotterIIBook();

        shoppingCart.Add(harryPotterI);
        shoppingCart.Add(harryPotterII);

        assertThat(shoppingCart.getTotalPrice(), is(15.20));

    }

    @Test
    public void have_10_percent_of_discount_when_buy_three_different_copies(){

        Book harryPotterI = Catalog.GivenAHarryPotterIBook();
        Book harryPotterII = Catalog.GivenAHarryPotterIIBook();
        Book harryPotterIII = Catalog.GivenAHarryPotterIIIBook();

        shoppingCart.Add(harryPotterI);
        shoppingCart.Add(harryPotterII);
        shoppingCart.Add(harryPotterIII);


        assertThat(shoppingCart.getTotalPrice(), is(21.60));

    }
}
