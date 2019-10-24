package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_412 {
  def fizzBuzz(n: Int): List[String] = {
    val res: ArrayBuffer[String] = new ArrayBuffer[String]()
    (1 to n).foreach(i =>
      if (i % 15 == 0) res += "FizzBuzz"
      else if (i % 3 == 0) res += "Fizz"
      else if (i % 5 == 0) res += "Buzz"
      else res += i.toString)
    res.toList
  }
}
