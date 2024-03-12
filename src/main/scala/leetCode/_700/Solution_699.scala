package leetCode._700

object Solution_699 {
  def fallingSquares(positions: Array[Array[Int]]): List[Int] = {
    val res = Array.fill(positions.length)(0)
    positions.indices.foreach(i => {
      val left = positions(i)(0)
      val size = positions(i)(1)
      val right = left + size

      {
        res(i) += size
        (i + 1 to positions.indices.last).map({ j =>
          val left2 = positions(j)(0)
          val size2 = positions(j)(1)
          val right2 = left2 + size2
          (j, left2, size2, right2)
        }).withFilter({ case (_, left2, _, right2) => left2 < right && left < right2 })
          .foreach({ case (j, _, _, _) => res(j) = res(i).max(res(j)) })
      }

    })
    var max_height = 0
    res.map(x => {
      max_height = max_height.max(x)
      max_height
    }).toList
  }
}
