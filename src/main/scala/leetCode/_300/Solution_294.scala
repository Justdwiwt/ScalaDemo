package leetCode._300

object Solution_294 {
  def canWin(currentState: String): Boolean = {
    def f(state: String): Boolean = {
      val indices = state.indices.dropRight(1).filter(i => state(i) == state(i + 1) && state(i) == '+')
      val replaced = indices.map(i => state.substring(0, i) + "--" + state.substring(i + 2, state.length))
      replaced.exists(!f(_))
    }

    f(currentState)
  }
}
