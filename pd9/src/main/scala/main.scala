//Monads, wrapping up

object main {

  class Container[A](private var _content: A) {

    def getContent: A = _content

    def applyFunction[R](f: A => R): Container[R] = {
      new Container[R](f(_content))
    }
  }

  def toInt(x: String): Int = {
    try {
      x.toInt
    } catch {
      case _: Exception => 0
    }
  }

  def multiplyBy2(x: Int): Int = {
    x*2
  }

  trait Maybe[A]{
    def applyFunction[R](f: A => R): Maybe[R]
    def getOrElse[R >: A](default:R): R
  }

  class No[Nothing] extends Maybe[Nothing] {
    override def applyFunction[R](f: Nothing => R): Maybe[R] = {
      new No[R]
    }

    override def getOrElse[R >: Nothing](default:R): R = {
      default
    }
}

  class Yes[A](private var _content: A) extends Maybe[A] {
    override def applyFunction[R](f: A => R): Maybe[R] = {
      new Yes[R](f(_content))
    }

    override def getOrElse[R >: A](default:R): R = {
      _content
    }
}

  def main(args: Array[String]): Unit = {
    // 1.)
    println("1.)")
    val container = new Container("10")
    println(container.getContent + 10)
    val x = container.applyFunction(toInt).applyFunction(multiplyBy2).getContent
    println(x)

    // 2.)
    println("2.)")
    val no = new No[String]
    val yes = new Yes[String]("content")
    println(no.isInstanceOf[Maybe[String]])
    println(yes.isInstanceOf[Maybe[String]])

    // 3,4.)
    println("3,4.)")
    println(no.applyFunction(toInt).getOrElse("default value"))
    println(yes.applyFunction(toInt).getOrElse("default value"))
  }
}
