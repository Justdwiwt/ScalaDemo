package leetCode

import scala.collection.mutable

object Solution_2261 {
  def countDistinct(nums: Array[Int], k: Int, p: Int): Int = {
    var res = 0
    val st = mutable.Set.empty[List[Int]]
    nums.indices.foreach(i => {
      var list = List.empty[Int]
      var cnt = 0
      (i until nums.length).foreach(j => {
        list = nums(j) :: list
        if (nums(j) % p == 0) cnt += 1
        if (cnt <= k && !st.contains(list)) {
          st.add(list)
          res += 1
        }
      })
    })
    res
  }
}
