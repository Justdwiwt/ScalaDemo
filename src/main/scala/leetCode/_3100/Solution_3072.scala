package leetCode._3100

import java.util

object Solution_3072 {
  def resultArray(nums: Array[Int]): Array[Int] = {
    val sorted = nums.sorted
    val n = nums.length

    var a = Array.empty[Int]
    var b = Array.empty[Int]
    a :+= nums.head
    b :+= nums(1)

    val t1 = Fenwick(n + 1)
    val t2 = Fenwick(n + 1)
    t1.add(util.Arrays.binarySearch(sorted, nums.head) + 1)
    t2.add(util.Arrays.binarySearch(sorted, nums(1)) + 1)

    nums.indices.drop(2).foreach(i => {
      var x = nums(i)
      val v = util.Arrays.binarySearch(sorted, x) + 1
      val gc1 = a.length - t1.pre(v)
      val gc2 = b.length - t2.pre(v)
      if (gc1 > gc2 || gc1 == gc2 && a.length <= b.length) {
        a :+= x
        t1.add(v)
      } else {
        b :+= x
        t2.add(v)
      }
    })
    a ++= b
    nums.indices.foreach(i => nums(i) = a(i))
    nums
  }

  private case class Fenwick(n: Int) {
    private val tree = Array.fill(n)(0)

    def add(_i: Int): Unit = {
      var i = _i
      while (i < tree.length) {
        tree(i) += 1
        i += i & -i
      }
    }

    def pre(_i: Int): Int = {
      var res = 0
      var i = _i
      while (i > 0) {
        res += tree(i)
        i &= i - 1
      }
      res
    }
  }
}
