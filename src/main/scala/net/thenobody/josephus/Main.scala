package net.thenobody.josephus

import net.thenobody.josephus.solver.{IterativeMode, RecursiveMode}
import org.slf4j.LoggerFactory

/**
  * Created by antonvanco on 29/10/2016.
  */
object Main {
  val logger = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]): Unit = {
    val config = Config(args)
    val solver = config.mode match {
      case IterativeMode =>
        logger.info(s"Using ${IterativeMode.ModeName} mode")
        container.iterativeProblemSolverInstance
      case RecursiveMode =>
        logger.info(s"Using ${RecursiveMode.ModeName} mode")
        container.recursiveProblemSolverInstance
    }

    val result = solver.solve(config.count, config.step)
    logger.info(s"Result: $result")
  }

}
