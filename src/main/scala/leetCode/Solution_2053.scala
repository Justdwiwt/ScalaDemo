package leetCode

object Solution_2053 {
  def kthDistinct(arr: Array[String], k: Int): String = {
    val map = arr.groupBy(identity).mapValues(_.length)
    val sound = arr.filter(x => map(x) == 1)
    if (k > sound.length) "" else sound(k - 1)
  }
}
