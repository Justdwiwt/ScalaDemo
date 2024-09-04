package leetCode._3300

object Solution_3273 {
  def minDamage(power: Int, D: Array[Int], H: Array[Int]): Long = {
    val damageRatios = D.indices.map(i => {
      val ratio = math.ceil(H(i).toDouble / power) / D(i).toDouble
      (i, ratio)
    })

    val sorted = damageRatios.sortBy(_._2).map(_._1)

    sorted.foldLeft((0L, 0L)) { case ((totalDamage, t), i) =>
      val newT = t + (H(i) + power - 1) / power
      val newTotalDamage = totalDamage + D(i) * newT
      (newTotalDamage, newT)
    }._1
  }
}
