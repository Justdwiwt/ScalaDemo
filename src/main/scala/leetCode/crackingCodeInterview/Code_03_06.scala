package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_03_06 {

  class AnimalShelf {
    private val queue = mutable.Queue.empty[Array[Int]]

    def enqueue(animal: Array[Int]): Unit =
      queue.enqueue(animal)

    def dequeueAny(): Array[Int] =
      if (queue.isEmpty) Array(-1, -1)
      else queue.dequeue()

    def dequeueDog(): Array[Int] = {
      val index = queue.indexWhere(_(1) == 1)
      if (index != -1) {
        val animal = queue(index)
        queue.dequeueAll(_.sameElements(animal)) // Remove the first occurrence
        animal
      } else Array(-1, -1)
    }

    def dequeueCat(): Array[Int] = {
      val index = queue.indexWhere(_(1) == 0)
      if (index != -1) {
        val animal = queue(index)
        queue.dequeueAll(_.sameElements(animal)) // Remove the first occurrence
        animal
      } else Array(-1, -1)
    }
  }

}
