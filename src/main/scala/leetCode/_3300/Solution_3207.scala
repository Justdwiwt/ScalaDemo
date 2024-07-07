package leetCode._3300

object Solution_3207 {
  def maximumPoints(enemyEnergies: Array[Int], currentEnergy: Int): Long = {
    val minEnergy = enemyEnergies.min
    val totalEnergy = enemyEnergies.map(_.toLong).sum
    if (currentEnergy < minEnergy) 0L
    else (currentEnergy.toLong + totalEnergy - minEnergy) / minEnergy
  }
}
