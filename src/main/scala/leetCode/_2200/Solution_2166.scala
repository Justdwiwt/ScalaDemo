package leetCode._2200

import scala.collection.mutable

object Solution_2166 {
  class Bitset(_size: Int) {

    private var ones = mutable.HashSet.empty[Int]
    private var zeroes = mutable.HashSet[Int](0 until _size: _*)

    def fix(idx: Int): Unit = {
      ones.add(idx)
      zeroes.remove(idx)
    }

    def unfix(idx: Int): Unit = {
      ones.remove(idx)
      zeroes.add(idx)
    }

    def flip(): Unit = {
      val tmp = ones
      ones = zeroes
      zeroes = tmp
    }

    def all(): Boolean =
      ones.size == _size

    def one(): Boolean =
      ones.nonEmpty

    def count(): Int =
      ones.size

    override def toString: String =
      Array.tabulate(_size)(idx => if (ones.contains(idx)) 1 else 0).mkString
  }
}
