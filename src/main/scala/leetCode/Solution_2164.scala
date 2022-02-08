package leetCode

object Solution_2164 {
  def sortEvenOdd(nums: Array[Int]): Array[Int] = {
    val (l, r) = nums.zipWithIndex.partition(_._2 % 2 == 0)
    val opt = if (r.length < l.length) Some(l.maxBy(_._1)._1) else None
    r
      .map(_._1)
      .sorted
      .reverse
      .zip(l.map(_._1).sorted)
      .flatMap({ case (a, b) => Seq(b, a) }) ++ Seq(opt)
      .flatten
  }
}
