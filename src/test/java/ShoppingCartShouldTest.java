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

        Book harryPotterI = GivenAHarryPotterIBook();
        Book harryPotterII = GivenAHarryPotterIIBook();
        Book harryPotterIII =GivenAHarryPotterIIIBook();

        shoppingCart.Add(harryPotterI);
        shoppingCart.Add(harryPotterII);
        shoppingCart.Add(harryPotterIII);


        assertThat(shoppingCart.getTotalPrice(), is(21.60));

    }
    @Test
    public void have_20_percent_of_discount_when_buy_four_different_copies(){

        Book harryPotterI = GivenAHarryPotterIBook();
        Book harryPotterII = GivenAHarryPotterIIBook();
        Book harryPotterIII = GivenAHarryPotterIIIBook();
        Book harryPotterIV = GivenAHarryPotterIVBook();

        shoppingCart.Add(harryPotterI);
        shoppingCart.Add(harryPotterII);
        shoppingCart.Add(harryPotterIII);
        shoppingCart.Add(harryPotterIV);

        assertThat(shoppingCart.getTotalPrice(), is(25.60));

    }
    @Test
    public void have_25_percent_of_discount_when_buy_five_different_copies(){

        Book harryPotterI = GivenAHarryPotterIBook();
        Book harryPotterII =GivenAHarryPotterIIBook();
        Book harryPotterIII =GivenAHarryPotterIIIBook();
        Book harryPotterIV = GivenAHarryPotterIVBook();
        Book harryPotterV = GivenAHarryPotterVBook();

        shoppingCart.Add(harryPotterI);
        shoppingCart.Add(harryPotterII);
        shoppingCart.Add(harryPotterIII);
        shoppingCart.Add(harryPotterIV);
        shoppingCart.Add(harryPotterV);

        assertThat(shoppingCart.getTotalPrice(), is(30.00));
    }

    @Test
    public void have_10_percent_of_discount_when_buy_4_copies_and_three_are_different(){

        Book harryPotterI = GivenAHarryPotterIBook();
        Book anotherHarryPotterI = GivenAHarryPotterIBook();
        Book harryPotterII = GivenAHarryPotterIIBook();
        Book harryPotterIII = GivenAHarryPotterIIIBook();

        shoppingCart.Add(harryPotterI);
        shoppingCart.Add(anotherHarryPotterI);
        shoppingCart.Add(harryPotterII);
        shoppingCart.Add(harryPotterIII);

        assertThat(shoppingCart.getTotalPrice(), is(29.6));

    }

}
