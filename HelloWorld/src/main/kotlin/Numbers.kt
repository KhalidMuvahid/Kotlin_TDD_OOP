import java.lang.IllegalArgumentException

interface Numbers {
    fun sumInt():Int;
    fun dif():Int;
    fun divide(): Double
    fun isSumLong(): Boolean
    fun sumLong(): Long

    class Base(private val number1:Int,private val number2:Int):Numbers{

        var isSumLongCalled = false
        var isItSumLong = false

        override fun sumInt(): Int {
            if (isSumLongCalled){
                if (isItSumLong)
                    throw IllegalArgumentException("please use sumLong method")

                return number1+number2
            }
            throw IllegalAccessException("first you have to check it with method isSumLong")
        }

        override fun dif(): Int {
            return number1-number2
        }

        override fun divide(): Double {
            if(number2 == 0)
                throw IllegalArgumentException("can`t divide by zero")

            return number1.toDouble()/number2
        }

        override fun isSumLong(): Boolean {
            isSumLongCalled = true
            val temp = Int.MAX_VALUE - number2;
            val result = temp<number1
            isItSumLong = result
            return result
        }

        override fun sumLong(): Long {
            return number1.toLong()+number2;
        }
    }


}