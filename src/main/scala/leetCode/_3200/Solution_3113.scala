package leetCode._3200

import scala.collection.mutable

object Solution_3113 {
  // fixme: case 888/889 data overflow
  def numberOfSubarrays(nums: Array[Int]): Int = {
    var res = BigInt(nums.length)
    val st = mutable.Stack[(Int, BigInt)]((Int.MaxValue, 0))
    nums.foreach(x => {
      while (x > st.top._1) st.pop()
      if (x == st.top._1) {
        val (value, count) = st.pop()
        res += count
        st.push((value, count + 1))
      } else st.push((x, 1))
    })
    res.toInt
  }
}
