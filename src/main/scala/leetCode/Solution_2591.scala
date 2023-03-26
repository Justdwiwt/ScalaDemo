package leetCode

object Solution_2591 {
  def distMoney(money: Int, children: Int): Int = money - children match {
    case cur if cur < 0 => -1
    case cur if cur / 7 == children && cur % 7 == 0 => children
    case cur if cur / 7 == children - 1 && cur % 7 == 3 => children - 2
    case cur => (children - 1).min(cur / 7)
  }
}
