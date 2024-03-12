package leetCode.offer

object Offer_21 {
  def exchange(nums: Array[Int]): Array[Int] = {
    var odd = Array.empty[Int]
    var even = Array.empty[Int]
    nums.foreach(i => if (i % 2 == 0) even :+= i else odd :+= i)
    odd ++ even
  }
}
