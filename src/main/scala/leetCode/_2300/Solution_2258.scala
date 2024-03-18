package leetCode._2300

import leetCode.Common.neighbours

import scala.collection.mutable

object Solution_2258 {
  private val M = 1000000000

  def maximumMinutes(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)

    def bfs(start: Seq[(Int, Int)], timeGrid: Array[Array[Int]]): Array[Array[Int]] = {
      val toVisit = mutable.Queue(start.map { case (x, y) => (x, y, 0) }: _*)
      while (toVisit.nonEmpty) {
        val (x, y, time) = toVisit.dequeue()
        timeGrid(x)(y) = time
        neighbours(x, y, grid).foreach { case (nx, ny) =>
          if (grid(nx)(ny) == 0 && timeGrid(nx)(ny) == -1) toVisit.enqueue((nx, ny, time + 1))
        }
      }
      timeGrid
    }

    val timeGridSelf = bfs(Seq((0, 0)), timeGrid = Array.fill[Int](m, n)(-1))
    val fires = grid.indices.flatMap(x => grid.head.indices.collect { case y if grid(x)(y) == 1 => (x, y) })
    val timeGridFire = bfs(fires, Array.fill[Int](m, n)(-1))

    val timeToArriveSelf = timeGridSelf(m - 1)(n - 1)
    val timeToArriveFire = timeGridFire(m - 1)(n - 1)

    if (timeToArriveSelf == -1) -1
    else if (timeToArriveFire == -1) M
    else if (timeToArriveFire < timeToArriveSelf) -1
    else {
      val diff = timeToArriveFire - timeToArriveSelf
      val (self1, self2) = (timeGridSelf(m - 1)(n - 2), timeGridSelf(m - 2)(n - 1))
      val (fire1, fire2) = (timeGridFire(m - 1)(n - 2), timeGridFire(m - 2)(n - 1))
      if (self1 > -1 && self2 > -1 && (fire1 - self1 > diff || fire2 - self2 > diff)) diff else diff - 1
    }
  }
}
