package leetCode._2700

import scala.collection.mutable

object Solution_2601 {
  def primeSubOperation(nums: Array[Int]): Boolean = {
    val store = mutable.Stack[Int]()
    store.push(1001)
    var res = true
    var i = nums.length - 1
    while (i >= 0 && res) {
      if (nums(i) < store.top) store.push(nums(i))
      else {
        val delta = getPrime(nums(i), nums(i) - store.top + 1)
        if (delta == -1) res = false
        else store.push(nums(i) - delta)
      }
      i -= 1
    }
    res
  }

  private def isPrime(num: Int): Boolean =
    if (num == 1) false
    else !(2 to math.sqrt(num).toInt).exists(num % _ == 0)

  private def getPrime(upperLimit: Int, lowerLimit: Int): Int =
    (lowerLimit until upperLimit).find(isPrime).getOrElse(-1)
}
