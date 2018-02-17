package org.aeb.uk.carpark

import org.aeb.uk.carpark.models.CarPark

object CarParkJob {

  /**
    * Parses the list of instructions and returns the end result (if any)
    *
    * @param instructions
    * @return
    */
  def run( instructions: List[String], capacity: Int ): String = {

    val carPark = new CarPark( capacity )

    def execute( rawInstruction: String ): Option[String] = {

      def actionWithParameter( action: String, parameter: String ): Option[String] = {

        action match {

          case "PARK" => carPark.park( parameter ); None
          case _ => throw new IllegalArgumentException( s"""Action: "$action" not recognised""" )

        }

      }

      def actionOnly( action: String ): Option[String] = {

        action match {

          case "DEPART" => carPark.depart(); None
          case "SMALLEST" => Some(carPark.smallest)
          case _ => throw new IllegalArgumentException( s"""Action: "$action" not recognised""" )

        }

      }

      val parsedInstruction = rawInstruction.split( "," )

      parsedInstruction match {

        case Array(action, parameter) => actionWithParameter( action.toUpperCase, parameter )
        case Array(action) => actionOnly( action.toUpperCase )
        case _ => throw new IllegalArgumentException( s"""Unexpected number of instruction arguments: "$parsedInstruction"""" )

      }

    }


    for ( i <- 0 until instructions.length - 1 )
      execute( instructions(i) )
    val output = execute( instructions.last )

    output match {
      case Some(text) => text
      case None => ""
    }

  }

}