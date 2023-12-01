package leetCode

import scala.collection.mutable

object Solution_2935 {
  def maximumStrongPairXor(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val highBit = 31 - Integer.numberOfLeadingZeros(sorted(sorted.length - 1))
    var res = 0
    var mask = 0
    val m = mutable.HashMap.empty[Int, Int]
    (highBit to 0 by -1).foreach(i => {
      m.clear()
      mask |= 1 << i
      val newRes = res | (1 << i)
      sorted.foreach(y => {
        val maskY = y & mask
        if (m.contains(newRes ^ maskY) && m(newRes ^ maskY) * 2 >= y) res = newRes
        m(maskY) = y
      })
    })
    res
  }
}
