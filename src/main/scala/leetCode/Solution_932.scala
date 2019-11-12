package leetCode

object Solution_932 {
  def beautifulArray(N: Int): Array[Int] = N match {
    case 1 => Array(1)
    case _ => beautifulArray((N + 1) / 2).map(_ * 2 - 1) ++ beautifulArray(N / 2).map(_ * 2)
  }
}
