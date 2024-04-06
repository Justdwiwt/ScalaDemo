package leetCode._1800

import scala.collection.mutable.ArrayBuffer

object Solution_1735 {
  private val Modulus = 1000000007

  private val Primes = {
    def f(l: Stream[Int]): Stream[Int] =
      l.head #:: f(l.tail.filter(_ % l.head != 0))

    f(Stream.from(2))
  }

  private val Factorial = {
    val cache = ArrayBuffer[Int](1)
    (x: Int) => {
      (cache.size to x).foreach(cache += multiply(cache.last, _))
      cache(x)
    }
  }

  def waysToFillArray(queries: Array[Array[Int]]): Array[Int] = queries.map {
    case Array(n, k) => factors(k).valuesIterator.map(_ + n - 1).map(choose(_, n - 1)).fold(1)(multiply)
  }

  private def add(x: Int, y: Int): Int =
    (x + y) % Modulus

  private def choose(n: Int, k: Int): Int =
    multiply(multiply(Factorial(n), inverse(Factorial(k))), inverse(Factorial(n - k)))

  private def factors(x: Int): Map[Int, Int] = {
    var num = x
    val primes = Primes
    var factorsMap = Map[Int, Int]().withDefaultValue(0)

    primes.takeWhile(_ <= num).foreach(prime =>
      while (num % prime == 0) {
        factorsMap += prime -> (factorsMap(prime) + 1)
        num /= prime
      })

    if (num > 1) factorsMap += num -> (factorsMap(num) + 1)
    factorsMap
  }

  private def inverse(x: Int): Int =
    pow(x, Modulus - 2)

  private def multiply(x: Int, y: Int): Int =
    multiply(x, y, 0)

  @scala.annotation.tailrec
  private def multiply(x: Int, y: Int, sum: Int): Int = y match {
    case 0 => sum
    case y if y % 2 == 0 => multiply(2 * x % Modulus, y / 2, sum)
    case y => multiply(x, y - 1, add(sum, x))
  }

  private def pow(x: Int, y: Int): Int =
    pow(x, y, 1)

  @scala.annotation.tailrec
  private def pow(x: Int, y: Int, product: Int): Int = y match {
    case 0 => product
    case y if y % 2 == 0 => pow(multiply(x, x), y / 2, product)
    case y => pow(multiply(x, x), y / 2, multiply(product, x))
  }
}
