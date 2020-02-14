package leetCode

object Offer_20 {
  def isNumber(s: String): Boolean = s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?")
}
