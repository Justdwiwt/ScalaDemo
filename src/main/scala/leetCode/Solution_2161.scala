package leetCode

object Solution_2161 {
  def pivotArray(nums: Array[Int], pivot: Int): Array[Int] =
    nums.filter(_ < pivot) ++ Array.fill(nums.count(_ == pivot))(pivot) ++ nums.filter(_ > pivot)
}
