#!/bin/bash
java -Xmx512m -ea "-javaagent:/home/esteban/workspace/DistributedRayTracing/lib/gridgain-3.0.9e-nix/libs/aspectjweaver-1.6.8.jar" -jar ./RayTracer.jar $@
    	