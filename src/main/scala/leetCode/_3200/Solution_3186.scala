package leetCode._3200

object Solution_3186 {
  def maximumTotalDamage(power: Array[Int]): Long = {
    val cnt = power.groupBy(identity).mapValues(_.length)
    val sorted = cnt.keys.toArray.sorted

    val arr = Array.fill[Long](sorted.length + 1)(0L)

    var j = 0
    sorted.indices.foreach(i => {
      while (j < i && sorted(j) < sorted(i) - 2) j += 1
      arr(i + 1) = arr(i).max(arr(j) + sorted(i).toLong * cnt(sorted(i)))
    })

    arr.last
  }
}
