package leetCode

object Solution_1108 {
  def defangIPaddr(address: String): String = address.replaceAll("\\.", "[.]")
}
