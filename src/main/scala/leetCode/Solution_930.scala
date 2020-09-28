package leetCode

object Solution_930 {
  def numSubarraysWithSum(A: Array[Int], S: Int): Int = S match {
    case 0 => A.mkString.split('1').map(_.length).map(x => x * (x + 1) / 2).sum
    case _ => f(("#" + A.mkString("#") + "#").split("1").map(x => x.count(_ == '0')).map(_ + 1), S)
  }

  def f(A: Array[Int], S: Int): Int = A.zip(A.slice(S, A.length)).map(x => x._1 * x._2).sum
}