package leetCode._3000

import scala.collection.mutable

object Solution_2964 {
  def divisibleTripletCount(nums: Array[Int], d: Int): Int = {
    var triplets = 0
    val m = mutable.Map.empty[Int, Int]

    nums.indices.foreach(i => {
      val remainder = nums(i) % d
      val prevRemainder = (d - remainder) % d
      triplets += m.getOrElse(prevRemainder, 0)

      (0 until i).foreach(j => {
        val sum = (nums(j) + nums(i)) % d
        m(sum) = m.getOrElse(sum, 0) + 1
      })
    })

    triplets
  }
}
