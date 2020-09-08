package leetCode

object Solution_706 {

  class MyHashMap() {
    val capacity = 1000001
    private val arr = Array.fill(capacity)(-1)

    def put(key: Int, value: Int): Unit = {
      arr(key) = value
    }

    def get(key: Int): Int = arr(key)

    def remove(key: Int): Unit = {
      arr(key) = -1
    }

  }

}
