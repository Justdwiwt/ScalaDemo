package leetCode

object Solution_412 {
  def fizzBuzz(n: Int): List[String] = (1 to n).map(number => {
    (number % 3 == 0, number % 5 == 0) match {
      case (true, true) => "FizzBuzz"
      case (true, _) => "Fizz"
      case (_, true) => "Buzz"
      case _ => number.toString
    }
  }).toList
}
