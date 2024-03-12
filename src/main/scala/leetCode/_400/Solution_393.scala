package leetCode._400

object Solution_393 {
  def validUtf8(data: Array[Int]): Boolean = {
    solve(data.toList map int2bin)
  }

  def int2bin(n: Int): List[Int] = int2bin(n, Nil)

  @scala.annotation.tailrec
  def int2bin(n: Int, acc: List[Int] = Nil): List[Int] = n match {
    case 0 => List.fill(8 - acc.length)(0) ++ acc
    case _ => int2bin(n >> 1, (n & 1) :: acc)
  }

  @scala.annotation.tailrec
  def solve(l: List[List[Int]]): Boolean = l match {
    case Nil => true
    case (0 :: _) :: t => solve(t)
    case (1 :: 1 :: 0 :: _) :: (1 :: 0 :: _) :: t => solve(t)
    case (1 :: 1 :: 1 :: 0 :: _) :: (1 :: 0 :: _) :: (1 :: 0 :: _) :: t => solve(t)
    case (1 :: 1 :: 1 :: 1 :: 0 :: _) :: (1 :: 0 :: _) :: (1 :: 0 :: _) :: (1 :: 0 :: _) :: t => solve(t)
    case _ => false
  }
}
