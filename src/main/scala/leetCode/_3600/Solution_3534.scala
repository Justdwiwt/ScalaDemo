package leetCode._3600

object Solution_3534 {
  def pathExistenceQueries(n: Int, nums: Array[Int], maxDiff: Int, queries: Array[Array[Int]]): Array[Int] = {
    val sorted = nums.indices.sortBy(nums)

    val rank = Array.ofDim[Int](n)
    sorted.zipWithIndex.foreach { case (node, i) => rank(node) = i }

    val mx = 32 - Integer.numberOfLeadingZeros(n)

    val pa0 = {
      @scala.annotation.tailrec
      def loop(i: Int, left: Int, acc: Vector[Int]): Vector[Int] =
        if (i >= n) acc
        else {
          val j = sorted(i)
          val newLeft = Iterator
            .iterate(left)(_ + 1)
            .dropWhile(l => l < n && nums(j) - nums(sorted(l)) > maxDiff)
            .next()

          loop(i + 1, newLeft, acc.updated(i, newLeft))
        }

      loop(0, 0, Vector.fill(n)(0))
    }

    val pa: Vector[Vector[Int]] = (1 until mx).foldLeft(Vector.tabulate(n)(i => Vector(pa0(i)))) {
      case (acc, k) =>
        acc.zipWithIndex.map { case (row, x) =>
          val prev = row.last
          row :+ acc(prev).lift(k - 1).getOrElse(0)
        }
    }

    queries.map {
      case Array(a, b) =>
        if (a == b) 0
        else {
          var (l, r) = (rank(a), rank(b))
          if (l > r) {
            val tmp = l
            l = r
            r = tmp
          }

          var res = 0
          var cur = r
          (mx - 1 to 0 by -1)
            .withFilter(pa(cur)(_) > l)
            .foreach(k => {
              res |= 1 << k
              cur = pa(cur)(k)
            })

          if (pa(cur).head > l) -1 else res + 1
        }
    }
  }
}
