package leetCode._1200

import scala.collection.mutable

object Solution_1144 {
  def movesToMakeZigzag(nums: Array[Int]): Int = {
    if (nums.length <= 1) return 0
    val evenArray = nums.indices.flatMap(i => {
      val arr = mutable.ArrayBuffer[Int]()
      if (i % 2 != 0) {
        if (i > 0) arr.append(nums(i) - nums(i - 1))
        if (i < nums.length - 1) arr.append(nums(i) - nums(i + 1))
      }
      arr.toList
    })
    val oddArray = nums.indices.flatMap(i => {
      val arr = mutable.ArrayBuffer[Int]()
      if (i % 2 == 0) {
        if (i > 0) arr.append(nums(i) - nums(i - 1))
        if (i < nums.length - 1) arr.append(nums(i) - nums(i + 1))
      }
      arr.toList
    })
    val evenSteps = cal(evenArray.toArray, 0)
    val oddSteps = cal(oddArray.toArray, 1)
    evenSteps.min(oddSteps)
  }

  def cal(arr: Array[Int], even: Int): Int = {
    var step = 0
    arr.indices.foreach(i => {
      if (arr(i) < 0) arr(i)
      else {
        val dec = 1 + arr(i)
        step += (1 + arr(i))
        arr.update(i, -1)
        if (i % 2 == even)
          if (i < arr.length - 1)
            arr.update(i + 1, arr(i + 1) - dec)
      }
    })
    step
  }
}
