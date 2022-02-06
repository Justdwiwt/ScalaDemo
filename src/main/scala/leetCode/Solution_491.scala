package leetCode

object Solution_491 {
  def findSubsequences(nums: Array[Int]): List[List[Int]] = {
    def f(nums: Array[Int]): List[List[Int]] =
      if (nums.length == 1) List(List(nums.head))
      else f(nums.dropRight(1)).flatMap(l => {
        if (l.last <= nums.last) List(l, l :+ nums.last)
        else List(l)
      }) :+ List(nums.last)

    f(nums).filter(_.length != 1).distinct
  }
}
