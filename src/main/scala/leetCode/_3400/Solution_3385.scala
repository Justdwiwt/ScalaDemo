package leetCode._3400

object Solution_3385 {
  def findMinimumTime(strength: Array[Int]): Int = {
    val n = strength.length
    val cost = Array.ofDim[Int](n, n)

    strength.indices.foreach(i => strength.indices.foreach(j => {
      val a = strength(i)
      val b = j + 1
      cost(i)(j) = (a + b - 1) / b
    }))

    def hungarianAlgorithm(cost: Array[Array[Int]]): Array[Int] = {
      val n = cost.length
      val u = Array.fill(n)(0)
      val v = Array.fill(n)(0)
      val p = Array.fill(n)(-1)

      cost.indices.foreach(i => {
        val links = Array.fill(n)(-1)
        val mins = Array.fill(n)(Int.MaxValue)
        val visited = Array.fill(n)(false)

        var markedI = i
        var markedJ = -1
        var j = 0

        while (markedI != -1) {
          j = -1
          cost
            .indices
            .withFilter(!visited(_))
            .foreach(k => {
              val cur = cost(markedI)(k) - u(markedI) - v(k)
              if (cur < mins(k)) {
                mins(k) = cur
                links(k) = markedJ
              }
              if (j == -1 || mins(k) < mins(j)) j = k
            })

          val delta = mins(j)
          cost
            .indices
            .withFilter(visited(_))
            .foreach(k => {
              u(p(k)) += delta
              v(k) -= delta
            })
          cost
            .indices
            .withFilter(!visited(_))
            .foreach(mins(_) -= delta)
          u(i) += delta

          visited(j) = true
          markedJ = j
          markedI = p(j)
        }

        while (links(j) != -1) {
          p(j) = p(links(j))
          j = links(j)
        }
        p(j) = i
      })

      val res = Array.fill(n)(-1)
      cost.indices.foreach(j => res(p(j)) = j)
      res
    }

    val assignment = hungarianAlgorithm(cost)
    assignment.indices.map(i => cost(i)(assignment(i))).sum
  }
}
