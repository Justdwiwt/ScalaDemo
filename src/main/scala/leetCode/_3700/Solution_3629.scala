package leetCode._3700

import scala.collection.mutable

object Solution_3629 {
  def minJumps(nums: Array[Int]): Int = {
    val n = nums.length

    def primeFactors(x: Int): List[Int] = {
      var num = x
      var p = 2
      var res = List.empty[Int]
      while (p * p <= num) {
        if (num % p == 0) {
          res ::= p
          while (num % p == 0) num /= p
        }
        p += 1
      }
      if (num > 1) res ::= num
      res
    }

    val groups = mutable.Map.empty[Int, mutable.ListBuffer[Int]]
    nums.indices.foreach(i => {
      val x = nums(i)
      if (x >= 2 && primeFactors(x).length == 1)
        groups.getOrElseUpdate(x, mutable.ListBuffer.empty) += i
    })

    val vis = Array.fill(n)(false)
    var cur = List(n - 1)
    vis(n - 1) = true

    def expand(i: Int): List[Int] = {
      val adj = List(i - 1, i + 1).filter(j => j >= 0 && j < n && !vis(j))

      val jump = primeFactors(nums(i)).flatMap(groups.get(_).toList.flatten.filter(!vis(_)))

      (adj ++ jump).distinct
    }

    var steps = 0

    while (cur.nonEmpty) {
      if (cur.contains(0)) return steps

      val next = cur.flatMap(expand).distinct
      next.foreach(vis(_) = true)

      cur.foreach(i => primeFactors(nums(i)).foreach(groups.remove))

      cur = next
      steps += 1
    }

    -1
  }
}
