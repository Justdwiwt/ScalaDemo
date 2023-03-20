package leetCode

object Solution_2591 {
  def distMoney(money: Int, children: Int): Int =
    if (money < children) -1
    else f(money, children)

  private def f(money: Int, children: Int): Int =
    if (money == 12 && children == 2) 0
    else if (children == 1) if (money == 8) 1 else 0
    else {
      val nMoney = money - 8
      val nChildren = children - 1
      if (nMoney < nChildren) 0
      else 1 + f(nMoney, nChildren)
    }
}
