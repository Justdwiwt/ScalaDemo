package leetCode._1100

object Solution_1007 {
  def minDominoRotations(A: Array[Int], B: Array[Int]): Int = {
    val seq = A.zip(B).map(x => Set(x._1, x._2)).reduce(_.intersect(_))
    if (seq.isEmpty) -1
    else (A.length - A.count(_ == seq.head)).min(B.length - B.count(_ == seq.head))
  }
}
