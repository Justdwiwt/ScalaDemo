package leetCode._400

import scala.collection.mutable

object Solution_315 {
  def countSmaller(nums: Array[Int]): List[Int] = {

    case class KV(idx: Int, value: Int)
    implicit object KVOrdering extends Ordering[KV] {
      override def compare(x: KV, y: KV): Int = {
        val cmp = Integer.compare(x.value, y.value)
        if (cmp == 0) Integer.compare(x.idx, y.idx) else cmp
      }
    }
    nums
      .zipWithIndex
      .map({ case (value, idx) => KV(idx, value) })
      .:\((mutable.TreeSet.empty[KV], List.empty[Int]))((ele, acc) => {
        val (ts: mutable.TreeSet[KV], res: List[Int]) = acc
        val next = ts + ele
        val size = next.size - next.from(ele).size
        (next, size +: res)
      })._2
  }
}
