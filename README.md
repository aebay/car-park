# car-park

Library for controlling traffic flow in a car park.

## Assembly

Note: You must have SBT v1.1.1 or higher installed (or change the version in build.properties).

1.  Open a terminal and navigate to the project root directory
2.  Run the following to build the library JAR:
```
$ sbt clean cleanFiles assembly
```
3.  The resulting JAR can found in /target/scala-2.12

## Usage

There are two ways to use this library: batch mode or programmatically by instantiating the CarPark.scala class.
Examples of usage can be found in the tests.  A brief overview is provided below.

### Batch

Use the object and method *CarParkJob.run*.

Input: scala.collection.immutable.List of String instructions and the car park capacity.  Possible instruction options are:

| Instruction | Description |
| ----------- | ----------- |
| "PARK,\<REG\>" | Park a car in the first empty space.  \<REG\> is the 4-digit car registration. |
| "DEPART" | Remove the most recently parked car from the car park. |
| "SMALLEST" | Retrieve the smallest numerical registration from the current set of cars in the car park. |


### Programmatic

Instantiate the class *CarPark*, providing the initial capacity.

Methods for the batch instructions are publically available.
There are also two other options: *resize* and *occupancy*:

|Method|Description|
|------|-----------|
|resize| Integer sets the new car park capacity.  If there are more cars than the new capacity, the most recently parked ones depart.|
|occupancy|Returns an array of registrations of the currently parked cars.|

### Notes

It does not stop cars with identical registrations from being parked (the car park owners don't care if the drivers are using cloned plates...)