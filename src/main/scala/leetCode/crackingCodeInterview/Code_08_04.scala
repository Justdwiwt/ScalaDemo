package leetCode.crackingCodeInterview

object Code_08_04 {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    var res = List.empty[List[Int]]
    val bmp = math.pow(2, nums.length).toInt
    (0 until bmp).foreach(i => {
      var t = List.empty[Int]
      nums.indices.foreach(j => if ((i >>> j & 1) == 1) t :+= nums(j))
      res :+= t
    })
    res
  }
}
