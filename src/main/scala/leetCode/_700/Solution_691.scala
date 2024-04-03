package leetCode._700

import scala.collection.mutable

object Solution_691 {
  def f(x: (Int, Int)): (Int, Int) = x

  def minStickers(stickers: Array[String], target: String): Int = {
    def mem[K, V](f: K => V): mutable.HashMap[K, V] = new mutable.HashMap[K, V]() {
      override def apply(key: K): V = getOrElseUpdate(key, f(key))
    }

    def getRidOf(bits: Int, str: String): Int = str.foldLeft(bits) { case (b, c) => target
      .indices
      .find(i => target(i) == c && ((1 << i) & b) != 0)
      .map(i => ~(1 << i) & b).getOrElse(b)
    }

    lazy val dp: ((Int, Int)) => Int = mem {
      case (-1, bits) => if (bits == 0) 0 else Int.MaxValue / 2
      case (i, bits) => Stream
        .iterate((-1, bits, 0)) { case (_, b, cost) => (b, getRidOf(b, stickers(i)), cost + 1) }
        .takeWhile(t => t._1 != t._2)
        .map { case (_, b, cost) => dp(i - 1, b) + cost }
        .min
    }

    val res = dp(stickers.length - 1, (1 << target.length) - 1)
    if (res >= Int.MaxValue / 2) -1 else res
  }
}
