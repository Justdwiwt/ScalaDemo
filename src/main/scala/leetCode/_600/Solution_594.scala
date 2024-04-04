package leetCode._600

object Solution_594 {
  def findLHS(nums: Array[Int]): Int = {
    case class Counter(i: Int, count: Int)
    case class Calculator(prevValue: Counter, max: Int)
    nums.sorted.foldLeft(List[Counter]())((counters, value) => (counters, value) match {
      case (Nil, value) => Counter(value, 1) :: Nil
      case (Counter(v, cnt) :: list, value) if v == value => Counter(v, cnt + 1) :: list
      case (list, value) => Counter(value, 1) :: list
    }).foldLeft(Calculator(Counter(Int.MinValue, 0), 0))((calc, value) => {
      val sum = if (calc.prevValue.i - 1 == value.i) calc.prevValue.count + value.count else 0
      Calculator(value, sum.max(calc.max))
    }).max
  }
}
