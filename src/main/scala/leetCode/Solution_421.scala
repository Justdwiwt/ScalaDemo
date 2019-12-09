package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_421 {
  def findMaximumXOR(nums: Array[Int]): Int = {
    var res = 0
    var mask = 0
    (31 to 0 by -1).foreach(i => {
      mask |= (1 << i)
      val s = new mutable.HashSet[Int]()
      nums.foreach(v => s.add(v & mask))
      val t = res | (1 << i)
      breakable {
        s.foreach(pre => {
          if (s.contains(t ^ pre)) {
            res = t
            break
          }
        })
      }
    })
    res
  }
}
