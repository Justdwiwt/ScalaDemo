package leetCode._800

object Solution_747 {
  def dominantIndex(nums: Array[Int]): Int = {
    val (mx, idx) = nums.zipWithIndex.maxBy(_._1)
    nums.zipWithIndex.find({ case (num, i) => (i != idx) && (num * 2) > mx }) match {
      case Some(_) => -1
      case None => idx
    }
  }
}
