package leetCode.offer

object XH_6_1 {

  class LCQueue() {

    private var l = List.empty[Int]

    def push(x: Int): Unit = l :+= x

    def pop(): Unit = l = l.tail

    def size(): Int = l.length

    def front(): Int = l.head

  }

}
