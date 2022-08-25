package leetCode

object Solution_2383 {
  def minNumberOfHours(initialEnergy: Int, initialExperience: Int, energy: Array[Int], experience: Array[Int]): Int = (energy.sum - initialEnergy + 1)
    .max(0) + experience
    ./:((initialExperience, 0)) { case ((currXp, gap), requiredXp) =>
      if (currXp > requiredXp) (currXp + requiredXp, gap)
      else (currXp + requiredXp + (requiredXp - currXp + 1), gap + (requiredXp - currXp + 1))
    }
    ._2
}
