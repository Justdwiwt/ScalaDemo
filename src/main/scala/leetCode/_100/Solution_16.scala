package leetCode._100

object Solution_16 {
  def threeSumClosest(nums: Array[Int], target: Int): Int =
    find(nums, target)

  @scala.annotation.tailrec
  def find(nums: Array[Int], target: Int, idx: Int = 0, checked: Set[Int] = Set(), closest: Int = Int.MaxValue): Int =
    if (idx >= nums.length - 1) closest
    else {
      val item = nums(idx)
      if (checked.contains(item)) find(nums, target, idx + 1, checked, closest)
      else {
        val newClosest = checkTail(item, nums, target, closest, idx + 1)
        find(nums, target, idx + 1, checked + item, newClosest)
      }
    }

  @scala.annotation.tailrec
  def checkTail(item: Int, nums: Array[Int], target: Int, closest: Int, idx: Int): Int =
    if (idx >= nums.length) closest
    else {
      val next = nums(idx)
      val foundClosest = checkInArray(item + next, nums, target, closest, idx + 1)
      checkTail(item, nums, target, foundClosest, idx + 1)
    }

  @scala.annotation.tailrec
  def checkInArray(sumPart: Int, array: Array[Int], target: Int, closest: Int, idx: Int): Int = {
    if (idx >= array.length) closest
    else if ((target - (sumPart + array(idx))).abs < (target - closest).abs || closest == Int.MaxValue) checkInArray(sumPart, array, target, sumPart + array(idx), idx + 1)
    else checkInArray(sumPart, array, target, closest, idx + 1)
  }
}
