package leetCode

object Solution_1447 {
  def simplifiedFractions(n: Int): List[String] = {
    var res = List.empty[String]
    (2 to n).foreach(b => (1 until b).foreach(a => if (gcd(a, b) == 1) res :+= (a.toString + "/" + b.toString)))
    res
  }

  @scala.annotation.tailrec
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
}
