package net.thenobody.josephus

import net.thenobody.josephus.solver.{RecursiveMode, SolverMode}

/**
  * Created by antonvanco on 29/10/2016.
  */
case class Config(
  count: Int = -1,
  step: Int = -1,
  mode: SolverMode = RecursiveMode
)

object Config {
  val parser = new scopt.OptionParser[Config]("sbt run") {
    head("Josephus Problem Solver")
    opt[String]("mode").text(s"one of: ${SolverMode.modes.keys.mkString(", ")}").optional().action { case (mode, config) =>
      config.copy(mode = SolverMode(mode))
    }
    arg[Int]("<n>").text("count - the total number of \"participants\"").required().action { case (count, config) =>
      config.copy(count = count)
    }
    arg[Int]("<k>").text("step - the elimination increment").required().action { case (step, config) =>
      config.copy(step = step)
    }
    help("help").text("prints this usage text")
  }

  def apply(args: Array[String]): Config = parser.parse(args, Config()).getOrElse {
    throw new IllegalArgumentException("Invalid parameters, check output for parameter list")
  }
}
