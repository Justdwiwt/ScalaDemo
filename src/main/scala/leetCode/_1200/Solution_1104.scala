package leetCode._1200

object Solution_1104 {
  def pathInZigZagTree(label: Int): List[Int] = {
    def f(label: Int): Int = label match {
      case 1 => 1
      case label => f(label / 2) + 1
    }

    def g(label: Int): Int = {
      val row = f(label)
      val sum = math.pow(2, row - 1) + math.pow(2, row) - 1
      (sum.toInt - label) / 2
    }

    label match {
      case 1 => List(1)
      case label =>
        val parent = g(label)
        pathInZigZagTree(parent) ++ List(label)
    }
  }
}
