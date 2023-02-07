import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

internal class NumbersTest{
//    @Test
//    fun sum_test(){
//        val numbers = Numbers.Base(12, 4)
//        val actual = numbers.sum()
//        val expected = 16
//        assertEquals(expected, actual)
//    }

    @Test
    fun max_sum_int_test(){
        val numbers = Numbers.Base(2_000_000_000, 147483647)
        val isSumLong = numbers.isSumLong();
        val expected0 = false
        assertEquals(expected0,isSumLong)
        val actual = numbers.sumInt()
        val expected = Int.MAX_VALUE
        assertEquals(expected,actual)
    }

    @Test
    fun max_sum_long_test(){
        val numbers = Numbers.Base(2_000_000_000, 147483648)
        val isSumLong = numbers.isSumLong();
        val expected0 = true
        assertEquals(expected0,isSumLong)
        val actual = numbers.sumLong()
        val expected = Int.MAX_VALUE+1L
        assertEquals(expected,actual)
    }

    @Test(expected = IllegalAccessException::class)
    fun sum_int_no_checked_test(){
        val numbers = Numbers.Base(2_000_000_000, 147483648)
        numbers.sumInt()
    }

    @Test(expected = IllegalArgumentException::class)
    fun sum_int_called_for_long_sum(){
        val numbers = Numbers.Base(2_000_000_000, 147483648)
        val isSumLong = numbers.isSumLong();
        val expected0 = true
        assertEquals(expected0,isSumLong)
        numbers.sumInt()
    }


    @Test
    fun difference_test(){
        val numbers = Numbers.Base(10,5)
        val actual = numbers.dif()
        val expected = 5;
        assertEquals(expected,actual)
    }

    @Test
    fun divide_test(){
        val numbers:Numbers = Numbers.Base(12,4)
        val actual = numbers.divide()
        val expected = 3.0
        assertEquals(expected,actual)
    }

    @Test
    fun divide_double_test(){
        val numbers:Numbers = Numbers.Base(10,4)
        val actual = numbers.divide()
        val expected = 2.5
        assertEquals(expected,actual)
    }

    //val expected:Double = Double.POSITIVE_INFINITY
    @Test(expected = IllegalArgumentException::class)
    fun divide_zero_test(){
        val numbers:Numbers = Numbers.Base(10,0)
        val actual = numbers.divide()
    }
}