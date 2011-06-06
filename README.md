Distributed RayTracing
======================

Introduction
------------

Implementation of a Distributed RayTracer in Java.

Requirements
------------

Requires the following libraries/frameworks:
 
 * GridGain [http://www.gridgain.com/](http://www.gridgain.com/)
 * JDOM [http://www.jdom.org/](http://www.jdom.org/)
 
Download and put into _lib_. Ant will search that directory for external libraries.

Usage
-----
 
 1. Run `ant` to compile project. Generated jar file will be at _build/jar_ directory.
 2. Run `java -jar RayTracer.java <scene_file> [options]`.
 
For a list of options and example usage, type option `--help` or `-h`.

Scene Files
-----------

Example of scene files and format used can be found in _scenes_ directory.