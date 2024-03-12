package leetCode._3100

object Solution_3024 {
  def triangleType(nums: Array[Int]): String = nums.sorted match {
    case Array(a, b, c) if a + b <= c => "none"
    case Array(a, b, c) if a == b && b == c => "equilateral"
    case Array(a, b, c) if a == b || b == c => "isosceles"
    case _ => "scalene"
  }
}
