package leetCode

object Solution_65 {
  def isNumber(s: String): Boolean = {
    s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?")
  }
}
