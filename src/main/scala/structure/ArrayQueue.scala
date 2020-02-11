package structure

object ArrayQueue extends App {

  var q = new ArrayQueue(5)
  q.add(1)
  q.showQueue()

}

class ArrayQueue(_maxSize: Int) {
  val maxSize: Int = _maxSize
  val arr = new Array[Int](maxSize)
  var front: Int = -1
  var rear: Int = -1

  def isFull: Boolean = rear == maxSize - 1

  def isEmpty: Boolean = front == rear

  def showQueue(): Unit = {
    if (isEmpty) {
      println("is empty ...")
      return
    }
    (front + 1 to rear).foreach(i => printf("arr[%d] = %d ", i, arr(i)))
  }

  def add(n: Int): Unit = {
    if (isFull) {
      println("is full ...")
      return
    }
    rear += 1
    arr(rear) = n
  }

  def getQueue: Any = {
    if (isEmpty) return new Exception("is empty ...")
    front += 1
    arr(front)
  }

  def headQueue(): Any = {
    if (isEmpty) return new Exception("is empty ...")
    arr(front + 1)
  }
}
