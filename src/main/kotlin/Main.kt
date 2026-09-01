import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
 val strings = listOf("Hello World", "Hello Kenya", "Hello Rodriguez" )
 val nums = listOf(3,2,5,6,7,8,9,10)
 val filteredStrings = strings.myFilter { it.length > 14 }
 val filteredEvenNums = nums.myFilter { it % 2 == 0 }
 println(filteredStrings)
 println(filteredEvenNums)
println(greetCountry(Country.UNITED_STATES))
 for (
  country in Country.entries
 ){
  println(country.code)
 }
 val result = makeNetworkCall()
 println(result)
}
fun greetCountry ( country: Country): String {

  return when (country) {
   Country.UNITED_STATES -> "Good morning America"
   Country.UNITED_KINGDOM -> "Good morning Britain"
   Country.KENYA -> "Habari Kenya"
  }

}
abstract  class Shape {
 abstract val area: Float
 abstract val circumference: Float
}

//interface  Shape{
// val area: Float
// val circumference: Float
//}


data class Rectangle(val width: Float, val height: Float): Shape() {
 val diagonal = sqrt(width * width + height * height)
 override val circumference: Float
  get() = 2 *width + 2*height
 override val area: Float
 get() = width * height

}

data class Circle(val radius: Float):Shape(){
 override val circumference: Float
 get() = 2 * radius * PI.toFloat()
  override val area: Float
  get() = radius * PI.toFloat()
}

enum class Country(val code: String) {
 UNITED_STATES("US"), UNITED_KINGDOM("UK"), KENYA("KE");
}


fun <T> List<T>.myFilter(predicate: (T) -> Boolean): List<T>{
 val mutableList = mutableListOf<T>()
for (item in this) {
 if (predicate(item)) {
  mutableList.add(item)
 }
}
return mutableList
}

sealed class  Result<out S, out E>{
 data class Success<S>(val value: S): Result<S, Nothing>()
 data class Failure<E>(val error: E): Result<Nothing, E>()
}

fun makeNetworkCall(): Result<Int, String>{
 return Result.Failure("Error")
}