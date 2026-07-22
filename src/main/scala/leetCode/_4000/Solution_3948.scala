package leetCode._4000

import scala.collection.mutable

object Solution_3948 {
  def maximumMEX(nums: Array[Int]): Array[Int] = {
    val cnt = mutable.HashMap[Int, Int]()

    nums.foreach(x => cnt(x) = cnt.getOrElse(x, 0) + 1)

    val ans = mutable.ArrayBuffer[Int]()

    var i = 0

    while (i < nums.length) {
      var mex = 0
      while (cnt.getOrElse(mex, 0) > 0)
        mex += 1

      if (mex == 0) {
        ans ++= Array.fill(nums.length - i)(0)
        i = nums.length
      } else {
        val need = mutable.HashSet(0 until mex: _*)

        while (need.nonEmpty) {
          val x = nums(i)

          cnt(x) -= 1
          need -= x

          i += 1
        }

        ans += mex
      }
    }

    ans.toArray
  }
}
