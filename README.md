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
 
Download and put into _lib/_. Ant will search that directory for external libraries.

Usage
-----
 
 1. Run `ant` to compile project. Generated executable files will be at _bin/_ directory.
 2. Run `./bin/RayTracer.[sh|bat] <scene_file> [options]`.
 
For a list of options and example usage, type option `--help` or `-h`.

Scene Files
-----------

Example of scene files and format used can be found in _scenes/_ directory.