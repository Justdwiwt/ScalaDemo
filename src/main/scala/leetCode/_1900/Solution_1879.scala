package leetCode._1900

import scala.collection.mutable

object Solution_1879 {
  def minimumXORSum(n1: Array[Int], n2: Array[Int]): Int = {
    lazy val m = mutable.HashMap.empty[String, Int]

    def f(idx: Int = 0, mem: Int = 0): Int =
      if (idx == n1.length) 0
      else {
        val key = idx + "#" + mem
        m.getOrElse(
          key, {
            m +=
              key -> n1
                .indices
                .filter(i => (mem & (1 << i)) == 0)
                .map(i => (n1(idx) ^ n2(i)) + f(idx + 1, mem | (1 << i)))
                .min
            m(key)
          }
        )
      }

    f()
  }
}
