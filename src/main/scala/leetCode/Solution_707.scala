package leetCode

object Solution_707 {
  class MyLinkedList() {

    trait List[+A]

    case object Nil extends List[Nothing]

    case class Cons[A](hd: A, tl: List[A]) extends List[A]

    private var head: List[Int] = Nil

    def get(index: Int): Int = {
      @scala.annotation.tailrec
      def iter(hd: List[Int], index: Int): Int = hd match {
        case Nil => -1
        case Cons(h, t) => if (index == 0) h else iter(t, index - 1)
      }

      iter(head, index)
    }

    def addAtHead(`val`: Int): Unit =
      head = Cons(`val`, head)

    def addAtTail(`val`: Int): Unit = {
      def iter(hd: List[Int], v: Int): List[Int] = hd match {
        case Nil => Cons(v, Nil)
        case Cons(h, t) => Cons(h, iter(t, v))
      }

      head = iter(head, `val`)
    }

    def addAtIndex(index: Int, `val`: Int): Unit = {
      def iter(hd: List[Int], index: Int, `val`: Int): List[Int] = (hd, index) match {
        case (Nil, i) => if (i == 0) Cons(`val`, Nil) else Nil
        case (Cons(h, d), 1) => Cons(h, Cons(`val`, d))
        case (Cons(h, d), i) => Cons(h, iter(d, i - 1, `val`))
      }

      head = iter(head, index, `val`)
    }

    def deleteAtIndex(index: Int): Unit = {
      def iter(hd: List[Int], index: Int): List[Int] = (hd, index) match {
        case (Nil, _) => Nil
        case (Cons(_, t), 0) => t
        case (Cons(h, Cons(_, d2)), 1) => Cons(h, d2)
        case (Cons(h, d), k) => Cons(h, iter(d, k - 1))
      }

      head = iter(head, index)
    }

  }
}
