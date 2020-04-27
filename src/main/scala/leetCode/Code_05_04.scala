package leetCode

import scala.util.control.Breaks._

object Code_05_04 {
  def findClosedNumbers(num: Int): Array[Int] = {
    val s = cnt(num)
    val res = Array(1, -1)
    breakable {
      (num + 1 to 2147483647).foreach(i => {
        if (cnt(i) == s) {
          res(0) = i
          break()
        }
      })
    }
    breakable {
      (num - 1 to 0 by (-1)).foreach(i => {
        if (cnt(i) == s) {
          res(1) = i
          break()
        }
      })
    }
    res
  }

  def cnt(num: Int): Int = (0 until 32).count(i => (num & (1 << i)) > 0)
}
