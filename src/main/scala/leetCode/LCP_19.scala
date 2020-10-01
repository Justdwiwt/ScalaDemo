package leetCode

object LCP_19 {
  def minimumOperations(leaves: String): Int = {
    if (leaves == null || leaves.length <= 1) return 0
    val states = Array.ofDim[Int](leaves.length, 3)
    states(0)(0) = if (leaves(0) == 'y') 1 else 0
    states(0)(1) = Int.MaxValue
    states(0)(2) = Int.MaxValue
    states(1)(2) = Int.MaxValue
    (1 until leaves.length).foreach(i => {
      val isYellow = if (leaves(i) == 'y') 1 else 0
      val isRed = if (leaves(i) == 'r') 1 else 0
      states(i)(0) = states(i - 1)(0) + isYellow
      states(i)(1) = states(i - 1)(1).min(states(i - 1)(0)) + isRed
      if (i >= 2)
        states(i)(2) = states(i - 1)(1).min(states(i - 1)(2)) + isYellow
    })
    states(leaves.length - 1)(2)
  }
}
