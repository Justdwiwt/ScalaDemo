package leetCode._1000

object Solution_930 {
  def numSubarraysWithSum(A: Array[Int], S: Int): Int = S match {
    case 0 => A.mkString.split('1').map(_.length).map(x => x * (x + 1) / 2).sum
    case _ => f(("#" + A.mkString("#") + "#").split("1").map(_.count(_ == '0')).map(_ + 1), S)
  }

  private def f(A: Array[Int], S: Int): Int =
    A.zip(A.slice(S, A.length)).map(x => x._1 * x._2).sum
}
