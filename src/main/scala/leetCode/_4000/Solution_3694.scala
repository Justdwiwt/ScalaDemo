package leetCode._4000

object Solution_3694 {
  def minLights(lights: Array[Int]): Int = {
    val n = lights.length
    val diff = Array.fill(n + 1)(0)

    lights.zipWithIndex.foreach {
      case (v, i) if v > 0 =>
        diff(math.max(i - v, 0)) += 1
        diff(math.min(i + v + 1, n)) -= 1
      case _ =>
    }

    lights.indices.foldLeft((0, 0)) {
      case ((ans, sum), i) =>
        val s = sum + diff(i)

        if (s > 0) (ans, s)
        else {
          diff(math.min(i + 3, n)) -= 1
          (ans + 1, 1)
        }
    }._1
  }
}
