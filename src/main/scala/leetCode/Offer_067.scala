package leetCode

import scala.collection.mutable

object Offer_067 {
  def findMaximumXOR(nums: Array[Int]): Int = {
    var mx = 0
    val st = mutable.Set.empty[Int]
    ((nums.max.toBinaryString.length - 1) to(0, -1)).foreach(i => {
      st.clear()
      st ++= nums.map(_ >> i)
      mx = mx << 1
      val cur = mx | 1
      st.withFilter(p => st.contains(p ^ cur)).foreach(_ => mx = cur)
    })
    mx
  }
}
