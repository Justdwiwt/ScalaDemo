package leetCode._2900

object Solution_2814 {
  private val SOURCE = 'S'
  private val DESTINATION = 'D'
  private val STONE = 'X'
  private val FLOOD = '*'
  private val INFINITY = Int.MaxValue / 2
  private val dirs = List((-1, 0), (1, 0), (0, -1), (0, 1))

  def minimumSeconds(land: List[List[String]]): Int = {
    val floodSeconds = getFloodSeconds(land)
    val (sourceRow, sourceCol) = findPosition(land, SOURCE)
    val (destinationRow, destinationCol) = findPosition(land, DESTINATION)
    val pathSeconds = getPathSeconds(land, floodSeconds, sourceRow, sourceCol, destinationRow, destinationCol)
    if (pathSeconds(destinationRow)(destinationCol) != INFINITY) pathSeconds(destinationRow)(destinationCol) else -1
  }

  private def findPosition(land: List[List[String]], target: Char): (Int, Int) = land
    .indices
    .flatMap(i => land.head.indices.collect { case j if land(i)(j).head == target => (i, j) })
    .head

  private def getFloodSeconds(land: List[List[String]]): Array[Array[Int]] = {
    val n = land.length
    val m = land.head.length
    val floodSeconds = Array.fill(n, m)(INFINITY)
    val queue = collection.mutable.Queue.empty[(Int, Int)]

    land.indices.foreach(i => land.head.indices.foreach(j => if (land(i)(j).head == FLOOD) {
      floodSeconds(i)(j) = 0
      queue.enqueue((i, j))
    }))

    while (queue.nonEmpty) {
      val (row, col) = queue.dequeue()
      val seconds = floodSeconds(row)(col)
      val newSeconds = seconds + 1
      dirs.foreach { case (dx, dy) =>
        val newRow = row + dx
        val newCol = col + dy
        if (isValid(newRow, newCol, n, m) && land(newRow)(newCol).head != STONE && land(newRow)(newCol).head != DESTINATION && floodSeconds(newRow)(newCol) > newSeconds) {
          floodSeconds(newRow)(newCol) = newSeconds
          queue.enqueue((newRow, newCol))
        }
      }
    }
    floodSeconds
  }

  private def getPathSeconds(land: List[List[String]], floodSeconds: Array[Array[Int]], sourceRow: Int, sourceCol: Int, destinationRow: Int, destinationCol: Int): Array[Array[Int]] = {
    val n = land.length
    val m = land.head.length
    val pathSeconds = Array.fill(n, m)(INFINITY)
    pathSeconds(sourceRow)(sourceCol) = 0
    val queue = collection.mutable.Queue.empty[(Int, Int)]
    queue.enqueue((sourceRow, sourceCol))

    while (queue.nonEmpty && pathSeconds(destinationRow)(destinationCol) == INFINITY) {
      val (row, col) = queue.dequeue()
      val seconds = pathSeconds(row)(col)
      val newSeconds = seconds + 1
      dirs.foreach { case (dx, dy) =>
        val newRow = row + dx
        val newCol = col + dy
        if (isValid(newRow, newCol, n, m) && land(newRow)(newCol).head != STONE && pathSeconds(newRow)(newCol) > newSeconds && floodSeconds(newRow)(newCol) > newSeconds) {
          pathSeconds(newRow)(newCol) = newSeconds
          queue.enqueue((newRow, newCol))
        }
      }
    }
    pathSeconds
  }

  private def isValid(row: Int, col: Int, n: Int, m: Int): Boolean =
    row >= 0 && row < n && col >= 0 && col < m
}
