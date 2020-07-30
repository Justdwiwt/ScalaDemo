package leetCode

object XH_1_1 {
  def find_left_repeat_num(nums: Array[Int]): Array[Int] = {
    var res = Array.emptyIntArray
    var arr = Array.emptyIntArray
    nums.indices.foreach(i => {
      if (!arr.contains(nums(i))) {
        res :+= -1
        arr :+= nums(i)
      } else {
        res :+= nums.indexOf(nums(i))
        arr :+= nums(i)
      }
    })
    res
  }
}
