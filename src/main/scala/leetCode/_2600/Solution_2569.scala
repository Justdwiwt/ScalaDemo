package leetCode._2600

import java.util
import scala.collection.mutable.ArrayBuffer

object Solution_2569 {
  def handleQuery(nums1: Array[Int], nums2: Array[Int], queries: Array[Array[Int]]): Array[Long] = {
    val bitSet = new util.BitSet(nums1.length)
    var sum: Long = nums2.map(_.toLong).sum
    val res = ArrayBuffer[Long]()
    nums1.indices.foreach(i => if (nums1(i) == 1) bitSet.set(i))
    queries.foreach {
      case Array(1, l, r) => bitSet.flip(l, r + 1)
      case Array(2, x, _) => sum += bitSet.cardinality().toLong * x
      case Array(3, _, _) => res.append(sum)
      case _ => ()
    }
    res.toArray
  }
}
