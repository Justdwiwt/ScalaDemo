package leetCode._600

object Solution_556 {
  def nextGreaterElement(n: Int): Int = {
    val l = n.toString.length
    val arr = new Array[Int](l)
    n.toString.zipWithIndex.foreach { case (c, index) => arr(index) = c.toString.toInt }
    var index1 = Int.MaxValue
    (l - 1 until 0 by -1)
      .withFilter(_ => index1 == Int.MaxValue)
      .foreach(i => if (arr(i - 1) < arr(i)) index1 = i - 1)
    if (index1 == Int.MaxValue) return -1
    val arr1 = arr.take(index1)
    val (nextMinValue, nextMinIndex) = arr.zipWithIndex.drop(index1 + 1).filter { case (value, _) => value > arr(index1) }.minBy(_._1)
    arr(nextMinIndex) = arr(index1)
    val arr2 = arr.drop(index1 + 1).sorted
    scala.util.Try((arr1 ++ Array(nextMinValue) ++ arr2).mkString("").toInt).getOrElse(-1)
  }
}
