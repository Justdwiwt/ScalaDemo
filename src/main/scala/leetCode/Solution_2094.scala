package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_2094 {
  def findEvenNumbers(digits: Array[Int]): Array[Int] = {
    val cnt = Array.fill(10)(0)
    val res = ArrayBuffer.empty[Int]
    digits.foreach(d => cnt(d) += 1)
    (1 to 9).foreach(i => (0 to 9).foreach(j => (0 to 9 by 2).foreach(k => {
      cnt(i) -= 1
      cnt(j) -= 1
      cnt(k) -= 1
      if (cnt(i) >= 0 && cnt(j) >= 0 && cnt(k) >= 0) res += i * 100 + j * 10 + k
      cnt(i) += 1
      cnt(j) += 1
      cnt(k) += 1
    })))
    res.toArray
  }
}
