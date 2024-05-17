package leetCode.LCP

object LCP_62 {
  def transportationHub(path: Array[Array[Int]]): Int = {
    val map = path.foldLeft(Map.empty[Int, Int].withDefaultValue(0)) {
      case (acc, Array(i, j)) => acc + (i -> -2001) + (j -> (acc(j) + 1))
    }
    val n = map.size - 1
    map.find { case (_, v) => v == n }.map { case (k, _) => k }.getOrElse(-1)
  }
}
