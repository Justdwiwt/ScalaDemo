package leetCode._100

object Solution_81 {
  def search(nums: Array[Int], target: Int): Boolean = {
    trait Status {
      def merge(y: Status): Status
    }
    case class Found(index: Int) extends Status {
      def merge(y: Status): Status = this
    }
    case class GetBreak(left: Int, right: Int) extends Status {
      def merge(y: Status): Status = y match {
        case Found(x) => Found(x)
        case GetBreak(l, r) => GetBreak(l, r)
        case _ => this
      }
    }
    case class Fruitless() extends Status {
      def merge(y: Status): Status = y
    }

    @scala.annotation.tailrec
    def linearSearch(i: Int, j: Int): Status = {
      if (i > j) Fruitless()
      else {
        val m = (i + j) / 2
        if (nums(m) == target) Found(m)
        else if (nums(m) < target) linearSearch(m + 1, j)
        else linearSearch(i, m - 1)
      }
    }

    def subSearch(i: Int = 0, j: Int = nums.length - 1): Status = {
      if (i > j) Fruitless()
      else {
        val dftStatus = if (nums(i) <= nums(j)) Fruitless() else GetBreak(i, j)
        val m = (i + j) / 2
        if (nums(m) == target) Found(m)
        else if (nums(i) < nums(j)) {
          if (nums(i) <= target && nums(j) >= target) linearSearch(i, j)
          else Fruitless()
        }
        else if (nums(i) > target && nums(j) < target) GetBreak(i, j)
        else subSearch(i, m - 1) match {
          case x: Found => x
          case x: GetBreak => x.merge(linearSearch(m + 1, j))
          case _ => dftStatus.merge(subSearch(m + 1, j))
        }
      }
    }

    subSearch() match {
      case _: Found => true
      case _ => false
    }
  }
}
