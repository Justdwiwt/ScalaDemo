package leetCode

object Solution_2116 {
  def canBeValid(s: String, locked: String): Boolean = {
    def f(s: String, locked: String, p: Char): Boolean = {
      val (required, budget) = s.zip(locked)./:(0, 0) { case ((required, budget), (char, lock)) =>
        val newRequired = required + (if (lock == '0') 0 else if (char == p) 1 else -1)
        val newBudget = budget + (if (lock == '0') 1 else 0)
        if (newRequired + newBudget < 0) return false
        (newRequired, newBudget)
      }
      required <= budget
    }

    s.length % 2 == 0 && f(s, locked, '(') && f(s.reverse, locked.reverse, ')')
  }
}
