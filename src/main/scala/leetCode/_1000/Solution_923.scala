package leetCode._1000

object Solution_923 {
  val M = 1000000007

  def threeSumMulti(A: Array[Int], target: Int): Int = {
    val data = A.groupBy(p => p).map(p => p._1 -> p._2.length.toLong)
    val sorted = data.keys.toArray.sorted
    val idL = bS(sorted, target / 3)
    val idR = bS(sorted, target)

    val start =
      if (target % 3 == 0) {
        val n = data.getOrElse(target / 3, 0L)
        ((n * (n - 1) % M) * (n - 2) / 6) % M
      }
      else 0L

    (idL until idR)./:(start)((s, id3) => {
      val x3 = sorted(id3)
      val n = data(x3)
      (s + n * (n - 1) * data.getOrElse(target - x3 * 2, 0L) / 2 + data(x3) * solveFor2(data, sorted, id3, target - x3)) % M
    }).toInt
  }

  def solveFor2(data: Map[Int, Long], vals: Array[Int], id3: Int, target: Int): Long = {
    val idL = bS(vals, target / 2)
    val idR = bS(vals, target).min(id3)

    val start =
      if ((target & 1) == 0) {
        val n = data.getOrElse(target / 2, 0L)
        (n * (n - 1) / 2) % M
      }
      else 0L

    (idL until idR)./:(start)((s, id2) => {
      val x2 = vals(id2)
      (s + (data(x2) * data.getOrElse(target - x2, 0L))) % M
    })
  }

  def bS(vals: Array[Int], v: Int): Int = {
    val id = java.util.Arrays.binarySearch(vals, v + 1)
    if (id < 0) -id - 1 else id
  }
}
