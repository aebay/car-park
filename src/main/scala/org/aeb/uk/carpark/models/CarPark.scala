package org.aeb.uk.carpark.models

import org.apache.logging.log4j.scala.Logging

import scala.collection.mutable

class CarPark( private var capacity: Int = 0 ) extends Logging {

  // could be a val, but would require resize() to pop each element which might be inefficient for large arrays
  private var occupants = mutable.ArrayStack[String]()

  def park( registration: String ): Unit = {

    val pattern = """^\d{4}$""".r

    if ( pattern.findFirstIn( registration ).isEmpty ) logger.warn( s"Registration ($registration) does not have 4 digits - cannot park car" )

    else {

      if ( occupants.length < capacity ) occupants.push( registration )
      else logger.warn( "Car park full, cannot park car" )

    }

  }

  def depart(): Unit = occupants.pop()

  def smallest: String = occupants.min

  def resize( capacity: Int ): Unit = {

    this.capacity = capacity
    if ( capacity < occupants.length ) {

      occupants = occupants.slice( occupants.length - capacity, occupants.length )

      logger.warn( "Car park capacity reduced below current occupancy, most recently parked cars have left" )

    }

  }

  def occupancy = occupants.clone()

}