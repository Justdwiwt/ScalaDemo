package leetCode

object Solution_1019 {

  case class Layer(x: Int, curMax: Int, bl: List[Int])

  def nextLargerNodes(head: ListNode): Array[Int] = {
    var p = head
    var s = List[Int]()
    while (p != null) {
      s ::= p.x
      p = p.next
    }
    g(s.reverse)
  }

  @scala.annotation.tailrec
  def solver(l: List[Layer])(nums: List[Int], acc: List[Int]): List[Int] = nums match {
    case Nil => acc
    case h :: t => solver(update(l, h, Layer(h, h, Nil)) :: l)(t, find(l)(h) :: acc)
  }

  @scala.annotation.tailrec
  def update(l: List[Layer], x: Int, acc: Layer): Layer = l match {
    case Nil => acc
    case h :: t =>
      if (x >= h.curMax) Layer(x, acc.curMax, acc.bl)
      else if (x < h.x) update(t, x, Layer(x, h.curMax.max(acc.curMax), acc.bl :+ h.x))
      else Layer(x, acc.curMax.max(h.curMax), acc.bl ++ h.bl.filter(_ > x))
  }

  def find(l: List[Layer])(x: Int): Int = l match {
    case Nil => 0
    case h :: _ => if (h.x > x) h.x else if (x >= h.curMax) 0 else h.bl.find(_ > x).getOrElse(0)
  }

  @scala.annotation.tailrec
  def getNums(head: ListNode, acc: List[Int]): List[Int] = head match {
    case null => acc
    case _ => getNums(head.next, head.x :: acc)
  }

  def g(nums: List[Int]): Array[Int] = {
    val res = Array.fill(nums.length)(0)
    var l = List[(Int, Int)]()
    nums.zipWithIndex.foreach(x => {
      while (l.nonEmpty && x._1 > l.head._1) {
        res(l.head._2) = x._1
        l = l.tail
      }
      l ::= x
    })
    res
  }

}
