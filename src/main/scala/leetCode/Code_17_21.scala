package leetCode

object Code_17_21 {
  def trap(height: Array[Int]): Int = height
    .scan(0)(_.max(_))
    .drop(1)
    .zip(height.scanRight(0)(_.max(_)))
    .map(Function.tupled(_.min(_)))
    .sum - height.sum
}
