package leetCode._3600

object Solution_3568 {
  def minMoves(classroom: Array[String], energy: Int): Int = {
    val m = classroom.length
    val n = classroom.head.length

    val idx = Array.ofDim[Int](m, n)
    var cntL = 0
    var sx, sy = 0

    classroom.indices.foreach(i => classroom.head.indices.foreach(j => classroom(i)(j) match {
      case 'L' =>
        idx(i)(j) = ~(1 << cntL)
        cntL += 1
      case 'S' =>
        sx = i
        sy = j
      case _ => idx(i)(j) = -1
    }))

    if (cntL == 0) return 0

    val fullMask = (1 << cntL) - 1
    val maxEnergy = Array.fill(m, n, 1 << cntL)(-1)
    maxEnergy(sx)(sy)(fullMask) = energy

    val queue = collection.mutable.Queue[(Int, Int, Int, Int)]()
    queue.enqueue((sx, sy, energy, fullMask))

    val DIRS = Array((-1, 0), (1, 0), (0, -1), (0, 1))

    var steps = 0
    var found = false
    var res = -1

    while (queue.nonEmpty && !found) {
      val size = queue.size
      (0 until size).withFilter(_ => !found).foreach(_ => {
        val (x, y, e, mask) = queue.dequeue()
        if (mask == 0) {
          found = true
          res = steps
        } else if (e > 0) {
          DIRS.foreach { case (dx, dy) =>
            val nx = x + dx
            val ny = y + dy
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && classroom(nx)(ny) != 'X') {
              val cell = classroom(nx)(ny)
              val newE = if (cell == 'R') energy else e - 1
              val newMask = if (cell == 'L') mask & idx(nx)(ny) else mask
              if (newE > maxEnergy(nx)(ny)(newMask)) {
                maxEnergy(nx)(ny)(newMask) = newE
                queue.enqueue((nx, ny, newE, newMask))
              }
            }
          }
        }
      })
      steps += 1
    }
    res
  }
}
